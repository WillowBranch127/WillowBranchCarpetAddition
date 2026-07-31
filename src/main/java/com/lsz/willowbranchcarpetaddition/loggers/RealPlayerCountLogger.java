package com.lsz.willowbranchcarpetaddition.loggers;

import carpet.CarpetServer;
import carpet.logging.HUDController;
import carpet.logging.LoggerRegistry;
import carpet.patches.EntityPlayerMPFake;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;

import java.lang.reflect.Field;

public class RealPlayerCountLogger extends WillowHUDLogger {

    public static final RealPlayerCountLogger INSTANCE;

    static {
        try {
            INSTANCE = new RealPlayerCountLogger(
                    Loggers.class.getField("__realPlayerCount"),
                    "realPlayerCount",
                    null,
                    null,
                    false
            );
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }


    protected RealPlayerCountLogger(
            Field field,
            String name,
            String def,
            String[] options,
            boolean strict
    ) {
        super(field, name, def, options, strict);

        HUDController.register(this::updateHUD);
    }


    @Override
    public void updateHUD(MinecraftServer server) {

        if (!Loggers.__realPlayerCount) {
            return;
        }

        LoggerRegistry
                .getLogger(NAME)
                .log(this::getPlayerCount);

    }


    private Component[] getPlayerCount(String option) {

        MinecraftServer server =
                CarpetServer.minecraft_server;

        long count =
                server.getPlayerList()
                        .getPlayers()
                        .stream()
                        .filter(player ->
                                !(player instanceof EntityPlayerMPFake)
                        )
                        .count();


        return new Component[]{
                Component.literal(
                        "Real Players: " + count
                )
        };
    }
}