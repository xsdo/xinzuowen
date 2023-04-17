package com.ruoyi.resources.service.impl;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.common.config.OssProperties;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.OssUtil;
import com.ruoyi.common.utils.QRCodeUtil;
import com.ruoyi.common.utils.QRCodeUtils;
import com.ruoyi.resources.domain.CVideos;
import com.ruoyi.resources.domain.CVoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.CompositionMapper;
import com.ruoyi.resources.domain.Composition;
import com.ruoyi.resources.service.ICompositionService;

import javax.imageio.ImageIO;

/**
 * 作文Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class CompositionServiceImpl implements ICompositionService 
{
    @Autowired
    private CompositionMapper compositionMapper;

    @Autowired
    private CVoiceServiceImpl cvoiceService;
    /**
     * 查询作文
     * 
     * @param id 作文主键
     * @return 作文
     */
    @Override
    public Composition selectCompositionById(Long id)
    {
        return compositionMapper.selectCompositionById(id);
    }

    @Override
    public Composition compositionQRCode(Long compositionId) {
        Composition composition=this.selectCompositionById(compositionId);
        if (!ObjectUtil.isEmpty(composition)) {
            try{
                // 存放在二维码中的内容
                // 二维码中的内容可以是文字，可以是链接等
                String text = "https://xzw.aace.com.cn/composition/?compositionId="+compositionId;
                // 生成的二维码的路径及名称
                String name=System.currentTimeMillis()+"";
                String destPath = RuoYiConfig.getNewsPath()+"/"+ name + ".jpg";
                System.out.println(destPath);
                //生成二维码
                QRCodeUtil.encode(text, null, destPath, true);
                // 解析二维码 部分二维码错误 略去解析步骤
//                String str = QRCodeUtil.decode(destPath);
//                System.out.println(str);

                String codePath="/Resource/News/"+name + ".jpg";
                System.out.println(codePath);
                composition.setcSynopsis(codePath);
                this.updateComposition(composition);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return this.selectCompositionById(compositionId);
    }
    @Override
    public Composition compositionQRCodePress(Long compositionId) {
        /**
         * 获取oss的属性
         */
        String endpoint = OssProperties.getEndpoint();
        String accessKeyId = OssProperties.getKeyId();
        String accessKeySecret = OssProperties.getKeySecret();
        String bucketName = OssProperties.getBucketName();
        Composition composition=this.selectCompositionById(compositionId);
        if (!ObjectUtil.isEmpty(composition)) {
            try{
                // 存放在二维码中的内容
                BufferedImage image = null;
                File uploadFile = null;
                // 存放在二维码中的内容
                // 二维码中的内容可以是文字，可以是链接等
                String text = "https://xzw.aace.com.cn/composition/?compositionId="+compositionId;
                image = QRCodeUtils.createQRCode(text);
                image=QRCodeUtils.pressText(image,null, Color.BLACK,composition.getcTitle());
                String imgPath =RuoYiConfig.getNewsPath()+"/"+"logo.png";
                image=QRCodeUtils.insertLogo(image,imgPath,true);
                // 生成的二维码的路径及名称
                String name=System.currentTimeMillis()+"";
                String destPath = RuoYiConfig.getNewsPath()+"/"+ name + ".jpg";
                System.out.println(destPath);
                //生成二维码
//                QRCodeUtil.encode(text, null, destPath, true);
                //上传oss
                File file = new File(name + ".jpg");
                ImageIO.write(image, "jpg",file);
                Map<String, String> map = new HashMap<>();
                map= OssUtil.uploadOssFile(endpoint, accessKeyId ,accessKeySecret,bucketName,file,"Resource/News/",name + ".jpg");
                String fileUrlOss=map.get("fileUrl");
                System.out.println(fileUrlOss);
                file.delete();

                QRCodeUtils.writeToLocalByPath(image, "jpg", destPath);
                // 解析二维码 部分二维码错误 略去解析步骤
//                String str = QRCodeUtil.decode(destPath);
//                System.out.println(str);

                String codePath="/Resource/News/"+name + ".jpg";
                System.out.println(codePath);
                composition.setcSynopsis(codePath);
                this.updateComposition(composition);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return this.selectCompositionById(compositionId);
    }

    /**
     * 查询作文列表 开发
     * 
     * @param composition 作文
     * @return 作文
     */
    @Override
    public List<Composition> selectCompositionList(Composition composition)
    {
        return compositionMapper.selectCompositionList(composition);
    }

    /**
     * 新增作文
     * 
     * @param composition 作文
     * @return 结果
     */
    @Override
    public int insertComposition(Composition composition)
    {
        composition.setCreateTime(DateUtils.getNowDate());
        compositionMapper.insertComposition(composition);
        if(composition.getRemarks() != null){
            CVoice cvoice=new CVoice();
            cvoice.setId(composition.getId());
            cvoice.setIsUsed(0L);
            cvoice.setvName(composition.getcTitle());
            cvoice.setvVoice(composition.getRemarks());
            cvoiceService.insertCVoice(cvoice);
            composition.setcVoice(cvoice.getId());
            compositionMapper.updateComposition(composition);
        }

        return composition.getId().intValue();
    }

    /**
     * 修改作文
     * 
     * @param composition 作文
     * @return 结果
     */
    @Override
    public int updateComposition(Composition composition)
    {
        composition.setUpdateTime(DateUtils.getNowDate());
        return compositionMapper.updateComposition(composition);
    }

    /**
     * 批量删除作文
     * 
     * @param ids 需要删除的作文主键
     * @return 结果
     */
    @Override
    public int deleteCompositionByIds(Long[] ids)
    {
        return compositionMapper.deleteCompositionByIds(ids);
    }

    /**
     * 删除作文信息
     * 
     * @param id 作文主键
     * @return 结果
     */
    @Override
    public int deleteCompositionById(Long id)
    {
        return compositionMapper.deleteCompositionById(id);
    }
}
