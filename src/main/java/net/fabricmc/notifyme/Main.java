package net.fabricmc.notifyme;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("notifyme");
	public static boolean notify = true;
	public static String playername = MinecraftClient.getInstance().getSession().getUsername();


	@Override
	public void onInitialize() {
		LOGGER.info("AFK reply Loaded");
		net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {

			dispatcher.register(net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal("notifyme").executes(Helper::Notify));
		});
	}

}

