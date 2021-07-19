package com.dlhjw.website.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author dlhjw
 * @version 1.0
 * @date 2021/7/3 16:39
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {

    @Value("${my-config.contact.mask-url-download}")
    private String filePathDownload;


    @Value("${my-config.contact.mask-url.relative}")
    private String fileRelativePath;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(fileRelativePath).
                addResourceLocations("file:" + filePathDownload);
    }
}

