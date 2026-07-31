package com.lsz.willowbranchcarpetaddition;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.api.settings.CarpetRule;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import com.lsz.willowbranchcarpetaddition.loggers.Loggers;


public class WillowBranchCarpetAdditionExtension
        implements CarpetExtension {


    private void onRuleChanged(
            CommandSourceStack source,
            CarpetRule<?> rule,
            String userInput
    ) {
        String name = rule.name();

        if (!name.equals("seedCommandPermissionLevel")
                && !name.equals("locateCommandPermissionLevel")
                && !name.equals("tickCommandPermissionLevel")
                && !name.equals("dataCommandPermissionLevel")) {
            return;
        }

        MinecraftServer server = CarpetServer.minecraft_server;

        if (server == null) {
            return;
        }

        for (ServerPlayer player : server.getPlayerList().getPlayers()) {
            server.getCommands().sendCommands(player);
        }
    }


    @Override
    public void onGameStarted() {
        CarpetServer.settingsManager.parseSettingsClass(
                WillowBranchCarpetAdditionSettings.class
        );

        CarpetServer.settingsManager.registerRuleObserver(
                this::onRuleChanged
        );
    }

    @Override
    public void registerLoggers() {
        Loggers.registerLoggers();
    }


    @Override
    public Map<String, String> canHasTranslations(String lang) {
        try (InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream(
                        "assets/willowbranch-carpet-addition/lang/"
                                + lang
                                + ".json"
                )) {

            if (is == null) {
                return Map.of();
            }

            JsonObject json = JsonParser.parseReader(
                    new InputStreamReader(
                            is,
                            StandardCharsets.UTF_8
                    )
            ).getAsJsonObject();


            Map<String, String> translations = new HashMap<>();

            for (String key : json.keySet()) {
                translations.put(
                        key,
                        json.get(key).getAsString()
                );
            }

            return translations;

        } catch (Exception e) {
            return Map.of();
        }
    }
}