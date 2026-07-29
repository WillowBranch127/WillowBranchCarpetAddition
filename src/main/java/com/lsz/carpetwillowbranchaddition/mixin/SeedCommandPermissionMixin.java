package com.lsz.carpetwillowbranchaddition.mixin;


import com.lsz.carpetwillowbranchaddition.CarpetWillowBranchAdditionSettings;
import com.lsz.carpetwillowbranchaddition.utils.CarpetRulePermissionCheck;
import com.lsz.carpetwillowbranchaddition.utils.PermissionHelper;
import net.minecraft.server.commands.SeedCommand;
import net.minecraft.server.permissions.PermissionCheck;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(SeedCommand.class)
public class SeedCommandPermissionMixin {

    @ModifyArg(
            method = "register",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/commands/Commands;hasPermission(Lnet/minecraft/server/permissions/PermissionCheck;)Lnet/minecraft/server/permissions/PermissionProviderCheck;"
            ),
            index = 0
    )
    private static PermissionCheck modifySeedPermission(PermissionCheck original) {

        return new CarpetRulePermissionCheck(original);
        //return PermissionCheck.AlwaysPass.INSTANCE;
    }
}
