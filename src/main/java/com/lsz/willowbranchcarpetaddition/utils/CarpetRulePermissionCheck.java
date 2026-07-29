package com.lsz.willowbranchcarpetaddition.utils;

import com.mojang.serialization.MapCodec;
import net.minecraft.server.permissions.PermissionCheck;
import net.minecraft.server.permissions.PermissionSet;

import java.util.function.IntSupplier;

public class CarpetRulePermissionCheck implements PermissionCheck {

    private final PermissionCheck vanilla;
    private final IntSupplier permissionSupplier;

    public CarpetRulePermissionCheck(
            PermissionCheck vanilla,
            IntSupplier permissionSupplier
    ) {
        this.vanilla = vanilla;
        this.permissionSupplier = permissionSupplier;
    }

    @Override
    public boolean check(PermissionSet permissionSet) {

        return PermissionHelper.createPermissionCheck(
                permissionSupplier.getAsInt(),
                vanilla
        ).check(permissionSet);
    }

    @Override
    public MapCodec<? extends PermissionCheck> codec() {
        return vanilla.codec();
    }
}