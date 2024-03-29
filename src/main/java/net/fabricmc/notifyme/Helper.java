package net.fabricmc.notifyme;

import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;

public class Helper {

    public static void PlaySound(){
        MinecraftClient client = MinecraftClient.getInstance();
        PositionedSoundInstance sound = new PositionedSoundInstance(SoundEvents.ENTITY_ITEM_PICKUP.getId(), SoundCategory.PLAYERS, 0.6f, 0.3f, SoundInstance.createRandom(), false, 0, SoundInstance.AttenuationType.NONE, 0, 0, 0, true);
        client.getSoundManager().play(sound);
    }



    public static int Notify(CommandContext<FabricClientCommandSource> context) {
        Main.notify = !Main.notify;
        context.getSource().sendFeedback(Text.literal("notify = " + Main.notify));

        return 0;
    }

}