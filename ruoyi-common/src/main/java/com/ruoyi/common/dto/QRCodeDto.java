package com.ruoyi.common.dto;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

public class QRCodeDto {


    @NotBlank(message = "二维码内容不能为空")
    private String content;

    private MultipartFile logoFile;

    private String pressText;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MultipartFile getLogoFile() {
        return logoFile;
    }

    public void setLogoFile(MultipartFile logoFile) {
        this.logoFile = logoFile;
    }

    public String getPressText() {
        return pressText;
    }

    public void setPressText(String pressText) {
        this.pressText = pressText;
    }
}
