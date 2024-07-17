package net.fabricmc.notifyme;

import io.wispforest.owo.config.annotation.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.Item;
import net.minecraft.registry.Registerable;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Modmenu(modId = "notifyme")
@Config(name = "config", wrapperName = "MyConfig")
public class MyConfigModel {


    @Expanded
    @PredicateConstraint("predicateFunction")
    public List<String> notifyList = new ArrayList<>(List.of(Main.playername));


    public static boolean predicateFunction(List<String> list) {
        return list.size() < 100;
    }

}

