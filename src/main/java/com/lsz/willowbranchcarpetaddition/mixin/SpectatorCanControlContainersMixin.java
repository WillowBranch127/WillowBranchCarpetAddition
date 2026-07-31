package com.lsz.willowbranchcarpetaddition.mixin;

import com.lsz.willowbranchcarpetaddition.WillowBranchCarpetAdditionSettings;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.spongepowered.asm.mixin.Mixin;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ServerGamePacketListenerImpl.class)
public class SpectatorCanControlContainersMixin {

    @ModifyExpressionValue(
            method = "handleContainerClick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/level/ServerPlayer;isSpectator()Z"
            )
    )
    private boolean modifySpectatorCheck(boolean original) {

        if (WillowBranchCarpetAdditionSettings.spectatorCanControlContainers) {
            return false;
        }

        return original;
    }
}