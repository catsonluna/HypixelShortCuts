package com.pinkulu;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class PlayerInFront {
    static Minecraft mc;

    public static boolean isFacingPlayer() {
        return mc.objectMouseOver.entityHit instanceof EntityPlayer;
    }

    public static String getFacingPlayerName() {
        if (mc.objectMouseOver.entityHit instanceof EntityPlayer) {
            final EntityPlayer facingPlayer = (EntityPlayer) PlayerInFront.mc.objectMouseOver.entityHit;
            return facingPlayer.getDisplayNameString();
        }
        return null;
    }

    static {
        PlayerInFront.mc = Minecraft.getMinecraft();
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (KeyBinds.guild.isPressed()) {
            if (isFacingPlayer()) {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§b[§dHypixelShortCuts§b]§a Sending a guild invite to §e" + getFacingPlayerName()));
                Minecraft.getMinecraft().thePlayer.sendChatMessage("/g invite " + getFacingPlayerName());
            }
            else {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§b[§dHypixelShortCuts§b]§cYou are not looking at anyone"));
            }
        }
        if (KeyBinds.friend.isPressed()) {
            if (isFacingPlayer()) {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§b[§dHypixelShortCuts§b]§a Sending a friend request to §e" + getFacingPlayerName()));
                Minecraft.getMinecraft().thePlayer.sendChatMessage("/f invite " + getFacingPlayerName());
            }
            else {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§b[§dHypixelShortCuts§b]§cYou are not looking at anyone"));
            }
        }
        if (KeyBinds.party.isPressed()) {
            if (isFacingPlayer()) {
                Minecraft.getMinecraft().thePlayer.sendChatMessage("/p invite " + getFacingPlayerName());
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§b[§dHypixelShortCuts§b]§a Sending a party invite to §e" + getFacingPlayerName()));
            }
            else {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§b[§dHypixelShortCuts§b]§cYou are not looking at anyone"));
            }
        }
    }
}