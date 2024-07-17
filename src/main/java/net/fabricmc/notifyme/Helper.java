package net.fabricmc.notifyme;

import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import org.apache.commons.lang3.StringUtils;

import static net.fabricmc.notifyme.Main.CONFIG;
import java.util.Arrays;

public class Helper {

    public static void PlaySound(){
        MinecraftClient client = MinecraftClient.getInstance();
        PositionedSoundInstance sound = new PositionedSoundInstance(SoundEvents.BLOCK_NOTE_BLOCK_PLING.value().getId(), SoundCategory.PLAYERS, 2f, 1f, SoundInstance.createRandom(), false, 0, SoundInstance.AttenuationType.NONE, 0, 0, 0, true);
        client.getSoundManager().play(sound);
    }

    public static boolean checkNotifyList(String msg) {
        if (CONFIG.notifyList().stream().anyMatch(msg::contains)){
            return true;
        }
        return false;
    }

    public static int Notify(CommandContext<FabricClientCommandSource> context) {
        Main.notify = !Main.notify;
        context.getSource().sendFeedback(Text.literal("notify = " + Main.notify));

        return 0;
    }

}