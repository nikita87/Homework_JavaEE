package com.tms.config;

import com.tms.config.security.AppSecurityConfig;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Nullable
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppSecurityConfig.class};
    }

    @Nullable
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
