package net.fabricmc.notifyme.mixin;


import com.mojang.authlib.GameProfile;
import net.fabricmc.notifyme.Main;
import net.fabricmc.notifyme.Helper;
import net.minecraft.client.network.message.MessageHandler;
import net.minecraft.network.message.MessageType;
import net.minecraft.network.message.SignedMessage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;



@Mixin(MessageHandler.class)
public class ChatMessageMixin {
	@Inject(method = "onChatMessage", at = @At("RETURN"))
	public void onGameMessage(SignedMessage message, GameProfile sender, MessageType.Parameters params, CallbackInfo ci) {
		String msg = message.getSignedContent().toLowerCase();
		if (Main.notify) {
			if (Helper.checkNotifyList(msg)) {
				Helper.PlaySound();
			}
		}
	}
}

