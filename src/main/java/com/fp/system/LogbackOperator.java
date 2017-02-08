package com.fp.system;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.logback.LogbackLoggingSystem;

import java.util.*;

/**
 * 日志操作类
 * <p>
 * Created by haibiao.zhang on 16/12/28.
 */
public class LogbackOperator {

    /**
     * 获取日志所有的级别
     */
    public List<LogLevel> getAllLogLevels() {
        LogLevel[] levels = LogLevel.values();
        return Arrays.asList(levels);
    }

    /**
     * 获取系统中所有的logger
     *
     * @return
     */
    public List<LoggerMessage> getAllLoggers() {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        List<Logger> loggerList = context.getLoggerList();
        List<LoggerMessage> loggerDtoList = new ArrayList<>();
        for (Logger logger : loggerList) {
            if (logger.getLevel() != null) {
                LoggerMessage loggerDto = new LoggerMessage();
                loggerDto.setPackageName(logger.getName());
                loggerDto.setLevel(logger.getLevel().toString());
                loggerDtoList.add(loggerDto);
            }
        }
        return loggerDtoList;
    }

    /**
     * 动态修改指定类的日志级别
     *
     * @param packageName
     * @param level
     * @return
     */
    public Object changeLogLevel(String packageName, LogLevel level) {
        Map<String, String> result = new HashMap<>();
        boolean success = true;
        try {
            LogbackLoggingSystem logbackLoggingSystem = new LogbackLoggingSystem(this.getClass().getClassLoader());
            logbackLoggingSystem.setLogLevel(packageName, level);
        } catch (Exception e) {
            success = false;
        }
        result.put("success", String.valueOf(success));
        return result;
    }

    /**
     * 动态修改系统全部日志级别
     *
     * @param level
     * @return
     */
    public Object changeAllLogLevel(LogLevel level) {
        Map<String, String> result = new HashMap<>();
        boolean success = true;
        try {
            LogbackLoggingSystem logbackLoggingSystem = new LogbackLoggingSystem(this.getClass().getClassLoader());
            LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
            for (Logger logger : context.getLoggerList()) {
                if (logger.getLevel() != null) {
                    logbackLoggingSystem.setLogLevel(logger.getName(), level);
                }
            }
        } catch (Exception e) {
            success = false;
        }
        result.put("success", String.valueOf(success));
        return result;
    }

}
