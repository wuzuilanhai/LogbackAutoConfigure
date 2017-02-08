package com.fp.system;

import ch.qos.logback.classic.Logger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by haibiao.zhang on 16/12/28.
 */
@Configuration
@ConditionalOnClass(Logger.class)
@EnableConfigurationProperties(LogbackProperties.class)
public class LogbackAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(LogbackOperator.class)
    public LogbackOperator logbackOperator() {
        return new LogbackOperator();
    }

}
