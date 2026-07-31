package com.lsz.willowbranchcarpetaddition.loggers;

import carpet.logging.LoggerRegistry;

public class Loggers {

    public static boolean __realPlayerCount = false;


    public static void registerLoggers() {
        LoggerRegistry.registerLogger(
                RealPlayerCountLogger.INSTANCE.NAME,
                RealPlayerCountLogger.INSTANCE
        );
    }
}