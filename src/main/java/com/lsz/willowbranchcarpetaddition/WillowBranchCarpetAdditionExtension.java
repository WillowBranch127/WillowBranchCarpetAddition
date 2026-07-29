package com.lsz.willowbranchcarpetaddition;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.api.settings.CarpetRule;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;


public class WillowBranchCarpetAdditionExtension
        implements CarpetExtension {



    private void onRuleChanged(
            CommandSourceStack source,
            CarpetRule<?> rule,
            String userInput
    ) {
        String name = rule.name();

        if (       !name.equals("seedCommandPermission")
                && !name.equals("locateCommandPermission")
                && !name.equals("tickCommandPermission")
                && !name.equals("dataCommandPermission")) {
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
    public Map<String, String> canHasTranslations(String lang) {
        try (InputStream is = getClass().getClassLoader()
                .getResourceAsStream("assets/willowbranch-carpet-addition/lang/" + lang + ".json")) {
            if (is == null) {
                return Map.of();
            }
            Gson gson = new GsonBuilder().setLenient().create();
            return gson.fromJson(
                    new InputStreamReader(is, StandardCharsets.UTF_8),
                    new TypeToken<Map<String, String>>() {}.getType()
            );
        } catch (Exception e) {
            return Map.of();
        }
    }


}
