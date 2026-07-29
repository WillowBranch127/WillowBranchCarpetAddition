package com.lsz.willowbranchcarpetaddition.mixin;


import com.lsz.willowbranchcarpetaddition.WillowBranchCarpetAdditionSettings;
import com.lsz.willowbranchcarpetaddition.utils.CarpetRulePermissionCheck;
import net.minecraft.server.commands.LocateCommand;
import net.minecraft.server.permissions.PermissionCheck;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(LocateCommand.class)
public class LocateCommandPermissionMixin {

    @ModifyArg(
            method = "register",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/commands/Commands;hasPermission(Lnet/minecraft/server/permissions/PermissionCheck;)Lnet/minecraft/server/permissions/PermissionProviderCheck;"
            ),
            index = 0
    )
    private static PermissionCheck modifySeedPermission(PermissionCheck original) {

        return new CarpetRulePermissionCheck(
                original,
                () -> WillowBranchCarpetAdditionSettings.locateCommandPermissionLevel
        );
    }
}
