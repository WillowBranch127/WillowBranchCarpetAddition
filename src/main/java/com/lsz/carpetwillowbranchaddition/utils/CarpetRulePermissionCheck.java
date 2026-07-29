package com.lsz.carpetwillowbranchaddition.utils;

import com.lsz.carpetwillowbranchaddition.CarpetWillowBranchAdditionSettings;
import com.mojang.serialization.MapCodec;
import net.minecraft.server.permissions.PermissionCheck;
import net.minecraft.server.permissions.PermissionSet;

public class CarpetRulePermissionCheck implements PermissionCheck {

    private final PermissionCheck vanilla;

    public CarpetRulePermissionCheck(PermissionCheck vanilla) {
        this.vanilla = vanilla;
    }

    @Override
    public boolean check(PermissionSet permissionSet) {
        System.out.println(
                "checking seed permission, rule="
                        + CarpetWillowBranchAdditionSettings.seedcommandpermission
        );
        return PermissionHelper.createPermissionCheck(
                CarpetWillowBranchAdditionSettings.seedcommandpermission,
                vanilla
        ).check(permissionSet);
    }

    @Override
    public MapCodec<? extends PermissionCheck> codec() {
        return vanilla.codec();
    }
}