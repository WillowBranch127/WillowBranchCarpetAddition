package com.lsz.carpetwillowbranchaddition;

import carpet.CarpetExtension;
import carpet.CarpetServer;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class CarpetWillowBranchAdditionExtension
        implements CarpetExtension {

    @Override
    public void onGameStarted() {
        CarpetServer.settingsManager.parseSettingsClass(
                CarpetWillowBranchAdditionSettings.class
        );
    }

    @Override
    public Map<String, String> canHasTranslations(String lang) {
        try (InputStream is = getClass().getClassLoader()
                .getResourceAsStream("assets/carpet-willowbranch-addition/lang/" + lang + ".json")) {
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
