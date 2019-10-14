package com.xwc.open.esbatis;

import com.xwc.open.esbatis.assistant.EasyBatisMapperAnnotationBuilder;
import com.xwc.open.esbatis.assistant.Reflection;
import com.xwc.open.esbatis.plugin.ParameterizePlugin;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Collection;

/**
 * 创建人：徐卫超
 * 创建时间：2019/4/2  11:11
 * 业务：
 * 功能：
 */
@org.springframework.context.annotation.Configuration
@EnableConfigurationProperties
public class EasybatisGenerator implements ApplicationContextAware, ApplicationListener<ContextRefreshedEvent> {
     private static final Logger logger = LoggerFactory.getLogger(EasybatisGenerator.class);


    private ApplicationContext applicationContext;
    private Configuration configuration;


    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.configuration = applicationContext.getBean(SqlSessionFactory.class).getConfiguration();
        Collection<Class<?>> mappers = configuration.getMapperRegistry().getMappers();
        for (Class<?> clazz : mappers) {
            Class<?> ec = Reflection.getEntityClass(clazz);
            EasyBatisMapperAnnotationBuilder parser = new EasyBatisMapperAnnotationBuilder(configuration, clazz, ec);
            parser.parse();
        }
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setUseActualParamName(true);
         configuration.addInterceptor(new ParameterizePlugin());
        logger.info("Spring 容器启动");
    }
}