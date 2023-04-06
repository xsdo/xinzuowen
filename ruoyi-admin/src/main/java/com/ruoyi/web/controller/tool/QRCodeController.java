package com.ruoyi.web.controller.tool;

import com.ruoyi.common.dto.QRCodeDto;
import com.ruoyi.common.utils.QRCodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

@RestController
@RequestMapping("qRCode/")
@Api(tags = "二维码测试")
public class QRCodeController {

    /**
     * 由于有MultipartFile,此处不能使用@RequestBody
     * @param dto
     * @param response
     * @throws Exception
     */
    @ApiOperation("生成二维码")
    @PostMapping(value = "generateQRCode")
    public void generateQRCode(@Validated QRCodeDto dto, HttpServletResponse response){
        // 存放在二维码中的内容
        String content = dto.getContent();
        BufferedImage image = null;
        File uploadFile = null;
        try {
            image = QRCodeUtils.createQRCode(content);
            uploadFile =getUploadFile(dto.getLogoFile());
            image=QRCodeUtils.pressText(image,null, Color.BLACK,dto.getPressText());
            image=QRCodeUtils.insertLogo(image,uploadFile.getPath(),true);
            QRCodeUtils.writeToStream(image, "jpg", response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if (uploadFile != null) {
                //删除临时文件
                uploadFile.delete();
            }
        }
    }

    @ApiOperation("二维码解析")
    @PostMapping("parseQRCode")
    public String parseQRCode(@RequestParam(value = "file") MultipartFile file)  {
        File uploadFile = null;
        try {
            uploadFile = getUploadFile(file);
            String decode = QRCodeUtils.decode(uploadFile);
            return decode;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if (uploadFile != null) {
                //删除临时文件
                uploadFile.delete();
            }
        }
    }

    /**
     * 获取上传的文件
     * @param file
     * @return
     * @throws Exception
     */
    private static File getUploadFile(MultipartFile file) throws Exception {
        if (file ==null) {
            throw new Exception("上传文件不能为空");
        }
        String filename = file.getOriginalFilename();
        String suffixName = filename.substring(filename.lastIndexOf("."));
        String filePath ="D:\\temp\\";
        long l = System.currentTimeMillis();
        File file1=new File(filePath+l+suffixName);
        if (!file1.exists() && !file1.isDirectory()) {
            file1.mkdirs();
        }
        file.transferTo(file1);
        return file1;
    }
}
