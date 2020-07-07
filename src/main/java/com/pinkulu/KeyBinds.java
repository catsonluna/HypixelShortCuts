package com.pinkulu;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.world.storage.IPlayerFileData;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class KeyBinds {
    public static KeyBinding guild;
    public static KeyBinding party;
    public static KeyBinding friend;


    public static void register() {
        guild = new KeyBinding("Invite to guild", Keyboard.KEY_G, "HypixelShortCuts");

        ClientRegistry.registerKeyBinding(guild);

        party = new KeyBinding("Invite to party", Keyboard.KEY_P, "HypixelShortCuts");

        ClientRegistry.registerKeyBinding(party);

        friend = new KeyBinding("send a friend request", Keyboard.KEY_F, "HypixelShortCuts");

        ClientRegistry.registerKeyBinding(friend);

    }
}