package org.example.mespringgeo.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin")
                .setViewName("redirect:/admin/");
        registry.addViewController("/admin/")
                .setViewName("forward:/admin/index.html");
    }
}
