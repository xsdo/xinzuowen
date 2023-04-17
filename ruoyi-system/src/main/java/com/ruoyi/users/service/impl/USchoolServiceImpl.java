package com.ruoyi.users.service.impl;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.config.OssProperties;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.OssUtil;
import com.ruoyi.common.utils.QRCodeUtil;
import com.ruoyi.common.utils.QRCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.users.mapper.USchoolMapper;
import com.ruoyi.users.domain.USchool;
import com.ruoyi.users.service.IUSchoolService;

import javax.imageio.ImageIO;

/**
 * 用户学校Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class USchoolServiceImpl implements IUSchoolService 
{
    @Autowired
    private USchoolMapper uSchoolMapper;

    /**
     * 查询用户学校
     * 
     * @param id 用户学校主键
     * @return 用户学校
     */
    @Override
    public USchool selectUSchoolById(Long id)
    {
        return uSchoolMapper.selectUSchoolById(id);
    }

    @Override
    public USchool schoolQRCode(Long schoolId) {
        USchool uSchool=this.selectUSchoolById(schoolId);
        if (uSchool != null) {
            try{
                // 存放在二维码中的内容
                // 二维码中的内容可以是文字，可以是链接等
                String text = "https://xzw.aace.com.cn/school/?schoolId="+schoolId;
                // 生成的二维码的路径及名称
                String name=System.currentTimeMillis()+"";
                String destPath = RuoYiConfig.getNewsPath()+"/"+ name + ".jpg";

                //生成二维码
                QRCodeUtil.encode(text, null, destPath, true);
                // 解析二维码 部分二维码错误 略去解析步骤
//                String str = QRCodeUtil.decode(destPath);
//                System.out.println(str);

                String codePath="/Resource/News/"+name + ".jpg";
                uSchool.setQrCode(codePath);
                this.updateUSchool(uSchool);
            }catch (Exception e) {

            }
        }
        return this.selectUSchoolById(schoolId);
    }
    @Override
    public USchool schoolQRCodePress(Long schoolId) {
        /**
         * 获取oss的属性
         */
        String endpoint = OssProperties.getEndpoint();
        String accessKeyId = OssProperties.getKeyId();
        String accessKeySecret = OssProperties.getKeySecret();
        String bucketName = OssProperties.getBucketName();
        USchool uSchool=this.selectUSchoolById(schoolId);
        if (uSchool != null) {
            try{
                // 存放在二维码中的内容
                BufferedImage image = null;
                File uploadFile = null;
                // 存放在二维码中的内容
                // 二维码中的内容可以是文字，可以是链接等
                String text = "https://xzw.aace.com.cn/school/?schoolId="+schoolId;
                image = QRCodeUtils.createQRCode(text);
                image=QRCodeUtils.pressText(image,null, Color.BLACK,uSchool.getsName());
                String imgPath =RuoYiConfig.getNewsPath()+"/"+"logo.png";
                image=QRCodeUtils.insertLogo(image,imgPath,true);
                // 生成的二维码的路径及名称
                String name=System.currentTimeMillis()+"";
                String destPath = RuoYiConfig.getNewsPath()+"/"+ name + ".jpg";

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
                uSchool.setQrCode(codePath);
                this.updateUSchool(uSchool);
            }catch (Exception e) {

            }
        }
        return this.selectUSchoolById(schoolId);
    }

    /**
     * 查询用户学校列表
     * 
     * @param uSchool 用户学校
     * @return 用户学校
     */
    @Override
    public List<USchool> selectUSchoolList(USchool uSchool)
    {
        return uSchoolMapper.selectUSchoolList(uSchool);
    }

    /**
     * 新增用户学校
     * 
     * @param uSchool 用户学校
     * @return 结果
     */
    @Override
    public int insertUSchool(USchool uSchool)
    {
        uSchool.setCreateTime(DateUtils.getNowDate());
        return uSchoolMapper.insertUSchool(uSchool);
    }

    /**
     * 修改用户学校
     * 
     * @param uSchool 用户学校
     * @return 结果
     */
    @Override
    public int updateUSchool(USchool uSchool)
    {
        uSchool.setUpdateTime(DateUtils.getNowDate());
        return uSchoolMapper.updateUSchool(uSchool);
    }

    /**
     * 批量删除用户学校
     * 
     * @param ids 需要删除的用户学校主键
     * @return 结果
     */
    @Override
    public int deleteUSchoolByIds(Long[] ids)
    {
        return uSchoolMapper.deleteUSchoolByIds(ids);
    }

    /**
     * 删除用户学校信息
     * 
     * @param id 用户学校主键
     * @return 结果
     */
    @Override
    public int deleteUSchoolById(Long id)
    {
        return uSchoolMapper.deleteUSchoolById(id);
    }
}
