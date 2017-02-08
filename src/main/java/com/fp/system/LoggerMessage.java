package com.fp.system;

/**
 * Created by haibiao.zhang on 16/12/28.
 */
public class LoggerMessage {

    /**
     * 包名
     */
    private String packageName;

    /**
     * 日志级别
     */
    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
