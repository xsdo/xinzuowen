package com.ruoyi.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * oss配置信息
 */
@Component
@ConfigurationProperties(prefix ="aliyun.oss")
public class OssProperties {
    /**
     * 填写Bucket所在地域对应的Endpoint
     */
    private static String endpoint;
    /**
     * AccessKey的id
     */
    private static String keyId;
    /**
     * AccessKey的密钥
     */
    private static String keySecret;
    /**
     * 阿里云储存文件的Bucket名称
     */
    private static String bucketName;

    public static String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        OssProperties.endpoint = endpoint;
    }

    public static String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        OssProperties.keyId = keyId;
    }

    public static String getKeySecret() {
        return keySecret;
    }

    public void setKeySecret(String keySecret) {
        OssProperties.keySecret = keySecret;
    }

    public static String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        OssProperties.bucketName = bucketName;
    }
}

