package cn.lfe.football.club.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * @author ChenYue
 * @date 2021/6/30 18:07
 */
@Configuration
public class WebConfig extends DelegatingWebMvcConfiguration {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PageParamInterceptor());
    }
}
