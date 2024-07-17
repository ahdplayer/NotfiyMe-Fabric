package net.fabricmc.notifyme;

import io.wispforest.owo.config.annotation.Config;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;

public class Main implements ModInitializer {
	public static boolean notify = true;
	public static String playername = MinecraftClient.getInstance().getSession().getUsername().toLowerCase();
	public static final net.fabricmc.notifyme.MyConfig CONFIG = net.fabricmc.notifyme.MyConfig.createAndLoad();


	@Override
	public void onInitialize() {
		net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
			dispatcher.register(net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal("notifyme").executes(Helper::Notify));
		});

	}

}

