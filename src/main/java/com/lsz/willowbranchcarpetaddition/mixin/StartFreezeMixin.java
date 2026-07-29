package com.lsz.willowbranchcarpetaddition.mixin;

import com.lsz.willowbranchcarpetaddition.WillowBranchCarpetAdditionSettings;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class StartFreezeMixin {
	@Inject(at = @At("HEAD"), method = "loadLevel")
	private void init(CallbackInfo info) {
		System.out.println("loadLevel finished");
		MinecraftServer server = (MinecraftServer) (Object) this;
		if (WillowBranchCarpetAdditionSettings.startFreeze) {
			server.tickRateManager().setFrozen(true);
		}
	}


}
