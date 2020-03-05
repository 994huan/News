package com.fafu.config;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Value("${device.img.path}")
    private  String imgpath;
    @Value("${device.water.path}")
    private String waterpath;
    @Value("${device.soil.path}")
    private String soilpath;
    @Value("${device.wetland.path}")
    private String wetlandpath;
    @Value("${device.forest.path}")
    private String forestpath;
    @Value("${device.outcome.path}")
    private String outcomepath;
    @Value("${device.balance_sheet.path}")
    private String balance_sheet_path;
    @Value("${device.zip.path}")
    private String zippath;
    @Value("${device.notice_file.path}")
    private String notice_file_path;
    @Value("${device.standard_file.path}")
    private String standard_file_path;
    @Value("${device.industry_standard.path}")
    private String industry_standard_path;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST","GET","PUT","OPTION","DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("47.94.159.133:80/img/**").addResourceLocations("file:"+imgpath);
        registry.addResourceHandler("47.94.159.133:80/water/**").addResourceLocations("file:"+waterpath);
        registry.addResourceHandler("47.94.159.133:80/soil/**").addResourceLocations("file:"+soilpath);
        registry.addResourceHandler("47.94.159.133:80/wetland/**").addResourceLocations("file:"+waterpath);
        registry.addResourceHandler("47.94.159.133:80/forest/**").addResourceLocations("file:"+forestpath);
        registry.addResourceHandler("47.94.159.133:80/outcome/**").addResourceLocations("file:"+outcomepath);
        registry.addResourceHandler("47.94.159.133:80/balance_sheet/**").addResourceLocations("file:"+balance_sheet_path);
        registry.addResourceHandler("47.94.159.133:80/zip/**").addResourceLocations("file:"+zippath);
        registry.addResourceHandler("47.94.159.133:80/notice_file/**").addResourceLocations("file:"+notice_file_path);
        registry.addResourceHandler("47.94.159.133:80/standard_file/**").addResourceLocations("file:"+standard_file_path);
        registry.addResourceHandler("47.94.159.133:80/industry_standard/**").addResourceLocations("file:"+industry_standard_path);
    }
}
