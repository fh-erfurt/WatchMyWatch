package de.watchmywatch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/webjars/**",
                "/img/**",
                "/css/**",
                "/js/**")
                .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/static/images/",
                        "classpath:/static/css/",
                        "classpath:/static/js/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/error403").setViewName("error403");
        registry.addViewController("/greeting").setViewName("greeting");
        registry.addViewController("/shoppingcart").setViewName("shoppingcart");
        registry.addViewController("/checkout").setViewName("checkout");
        registry.addViewController("/order").setViewName("order");
        registry.addViewController("/profile").setViewName("profile");
        registry.addViewController("/updateUser").setViewName("updateUser");
    }
}
