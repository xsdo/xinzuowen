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
import com.ruoyi.users.mapper.UTeacherMapper;
import com.ruoyi.users.domain.UTeacher;
import com.ruoyi.users.service.IUTeacherService;

import javax.imageio.ImageIO;

/**
 * 教师班级Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class UTeacherServiceImpl implements IUTeacherService 
{
    @Autowired
    private UTeacherMapper uTeacherMapper;

    /**
     * 查询教师班级
     * 
     * @param id 教师班级主键
     * @return 教师班级
     */
    @Override
    public UTeacher selectUTeacherById(Long id)
    {
        return uTeacherMapper.selectUTeacherById(id);
    }

    @Override
    public UTeacher teacherQRCode(Long teacherId) {
        UTeacher uteacher=this.selectUTeacherById(teacherId);
        if (uteacher != null) {
            try{
                // 存放在二维码中的内容
                // 二维码中的内容可以是文字，可以是链接等
                String text = "https://xzw.aace.com.cn/teacher/?teacherId="+teacherId;
                // 生成的二维码的路径及名称
                String name=System.currentTimeMillis()+"";
                String destPath = RuoYiConfig.getNewsPath()+"/"+ name + ".jpg";

                //生成二维码
                QRCodeUtil.encode(text, null, destPath, true);
                // 解析二维码 部分二维码错误 略去解析步骤
//                String str = QRCodeUtil.decode(destPath);
//                System.out.println(str);

                String codePath="/Resource/News/"+name + ".jpg";
                uteacher.setQrCode(codePath);
                this.updateUTeacher(uteacher);
            }catch (Exception e) {

            }
        }
        return this.selectUTeacherById(teacherId);
    }

    @Override
    public UTeacher teacherQRCodePress(Long teacherId) {
        /**
         * 获取oss的属性
         */
        String endpoint = OssProperties.getEndpoint();
        String accessKeyId = OssProperties.getKeyId();
        String accessKeySecret = OssProperties.getKeySecret();
        String bucketName = OssProperties.getBucketName();

        UTeacher uteacher=this.selectUTeacherById(teacherId);
        if (uteacher != null) {
            try{
                // 存放在二维码中的内容
                BufferedImage image = null;
                File uploadFile = null;
                // 存放在二维码中的内容
                // 二维码中的内容可以是文字，可以是链接等
                String text = "https://xzw.aace.com.cn/teacher/?teacherId="+teacherId;
                image = QRCodeUtils.createQRCode(text);
                image=QRCodeUtils.pressText(image,null, Color.BLACK,"微信扫一扫，加入班级");
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
                uteacher.setQrCode(codePath);
                this.updateUTeacher(uteacher);
            }catch (Exception e) {

            }
        }
        return this.selectUTeacherById(teacherId);
    }
    /**
     * 查询教师班级列表
     * 
     * @param uTeacher 教师班级
     * @return 教师班级
     */
    @Override
    public List<UTeacher> selectUTeacherList(UTeacher uTeacher)
    {
        return uTeacherMapper.selectUTeacherList(uTeacher);
    }

    /**
     * 新增教师班级
     * 
     * @param uTeacher 教师班级
     * @return 结果
     */
    @Override
    public int insertUTeacher(UTeacher uTeacher)
    {
        uTeacher.setCreateTime(DateUtils.getNowDate());
        return uTeacherMapper.insertUTeacher(uTeacher);
    }

    /**
     * 修改教师班级
     * 
     * @param uTeacher 教师班级
     * @return 结果
     */
    @Override
    public int updateUTeacher(UTeacher uTeacher)
    {
        uTeacher.setUpdateTime(DateUtils.getNowDate());
        return uTeacherMapper.updateUTeacher(uTeacher);
    }

    /**
     * 批量删除教师班级
     * 
     * @param ids 需要删除的教师班级主键
     * @return 结果
     */
    @Override
    public int deleteUTeacherByIds(Long[] ids)
    {
        return uTeacherMapper.deleteUTeacherByIds(ids);
    }

    /**
     * 删除教师班级信息
     * 
     * @param id 教师班级主键
     * @return 结果
     */
    @Override
    public int deleteUTeacherById(Long id)
    {
        return uTeacherMapper.deleteUTeacherById(id);
    }
}
