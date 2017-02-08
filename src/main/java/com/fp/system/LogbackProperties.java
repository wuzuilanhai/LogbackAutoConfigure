package com.fp.system;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by haibiao.zhang on 16/12/28.
 */
@ConfigurationProperties(
        prefix = "logback"
)
public class LogbackProperties {

    private static final String DEFAULT_DIRECTORY = "/data/logs/FPos";

    private static final String DEFAULT_LOG_LEVEL = "INFO";

    private String dir = DEFAULT_DIRECTORY;

    private String level = DEFAULT_LOG_LEVEL;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
