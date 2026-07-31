package com.lsz.willowbranchcarpetaddition.loggers;

import carpet.logging.HUDLogger;
import net.minecraft.server.MinecraftServer;

import java.lang.reflect.Field;

public abstract class WillowHUDLogger extends HUDLogger {

    public final String NAME;

    protected WillowHUDLogger(
            Field field,
            String name,
            String def,
            String[] options,
            boolean strict
    ) {
        super(field, name, def, options, strict);
        this.NAME = name;
    }

    public abstract void updateHUD(MinecraftServer server);
}