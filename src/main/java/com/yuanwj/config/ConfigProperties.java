package com.yuanwj.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by bmk on 17-8-17.
 */
@ConfigurationProperties(prefix = "yuanwj")
@Component
@Data
public class ConfigProperties {

    private String randomString;

    private final Swagger swagger=new Swagger();

    public String getRandomString() {
        return randomString;
    }

    public Swagger getSwagger() {
        return swagger;
    }

    @Data
    public static class Swagger {
        private String title;
        private String description;
        private String contactName;
        private String contactEmail;
        private String version;
        private String license;
        private String licenseUrl;
        private String termsOfServiceUrl;
    }
}
