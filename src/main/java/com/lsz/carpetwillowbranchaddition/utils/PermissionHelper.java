package com.lsz.carpetwillowbranchaddition.utils;

import net.minecraft.commands.Commands;
import net.minecraft.server.permissions.PermissionCheck;

public class PermissionHelper {

    public static PermissionCheck createPermissionCheck(
            int ruleValue,
            PermissionCheck vanilla
    ) {
        if (ruleValue == -1) {
            return vanilla;
        }

        return switch (ruleValue) {
            case 0 -> Commands.LEVEL_ALL;
            case 1 -> Commands.LEVEL_MODERATORS;
            case 2 -> Commands.LEVEL_GAMEMASTERS;
            case 3 -> Commands.LEVEL_ADMINS;
            case 4 -> Commands.LEVEL_OWNERS;
            default -> vanilla;
        };
    }
}