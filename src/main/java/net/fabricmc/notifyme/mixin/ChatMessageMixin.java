package net.fabricmc.notifyme.mixin;



import net.fabricmc.notifyme.Main;
import net.fabricmc.notifyme.Helper;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.network.packet.s2c.play.ChatMessageS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(ChatMessageS2CPacket.class)
public class ChatMessageMixin {
	@Inject(at = @At("RETURN"), method = "message")
	private void onGetMessage(CallbackInfoReturnable<SignedMessage> cir) {
		String message = cir.getReturnValue().getContent().toString();
		Main.LOGGER.info(message);
		if (Main.notify) {
				if (message.contains(Main.playername)) {
					Helper.PlaySound();
				}

		}
	}
}
