package org.generation.SpringBootAssessment.security;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.*;

import java.nio.file.*;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    //to configure Spring MVC and set up view controllers to expose these templates
    //HTMLs, CSS/Images/JS folders

    @Value("${image.folder}")
    private String imageFolder;
    public void addViewControllers(ViewControllerRegistry registry) {
        //Map the browser's URL to a specific View (HTML) inside resources/templates directory
        registry.addViewController("/").setViewName("mytodolist");

        registry.addViewController("/mytodolist").setViewName("mytodolist");
        registry.addViewController("/addtodolist").setViewName("addtodolist");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(0);

       exposeDirectory(registry);
    }


    private void exposeDirectory(ResourceHandlerRegistry registry) {

      Path uploadDir = Paths.get(imageFolder);
        String uploadPath = uploadDir.toFile().getAbsolutePath();
        System.out.println(uploadPath);

        registry.addResourceHandler("/" + imageFolder + "/**")
                .addResourceLocations("file:" + uploadPath + "/")
                .setCachePeriod(0)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }
}