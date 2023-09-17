package net.fabricmc.notifyme;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;

public class Main implements ModInitializer {
	public static boolean notify = true;
	public static String playername = MinecraftClient.getInstance().getSession().getUsername().toLowerCase();


	@Override
	public void onInitialize() {
		net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
			dispatcher.register(net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal("notifyme").executes(Helper::Notify));
		});
	}

}

