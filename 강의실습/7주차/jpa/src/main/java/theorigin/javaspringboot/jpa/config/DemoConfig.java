package theorigin.javaspringboot.jpa.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import theorigin.javaspringboot.jpa.interceptor.HeaderLoggingInterceptor;

@Configuration
public class DemoConfig implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(DemoConfig.class);
    private final HeaderLoggingInterceptor headerLoggingInterceptor;

    public DemoConfig(@Autowired HeaderLoggingInterceptor headerLoggingInterceptor) {
        this.headerLoggingInterceptor = headerLoggingInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(headerLoggingInterceptor)
                .addPathPatterns("/post/**")
                .excludePathPatterns("/except/**");
    }
}
