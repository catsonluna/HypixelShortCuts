package com.pinkulu;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;

public class help extends CommandBase {
    @Override
    public String getCommandName() {
        return "HypixelShortCuts";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return null;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] strings) throws CommandException {
        EntityPlayer player = (EntityPlayer) sender;
        ChatStyle style = new ChatStyle();
        //hoverable text
        style.setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ChatComponentText(
                        "§3Help: " +
                        "\n §bGo into setting " +
                        "\n §bAnd change the KeyBinds" +
                        "\n §5Mod made by:" +
                        "\n §dPinkulu" )));
        //what shows in chat and than the hoverable text is registered
        IChatComponent text = new ChatComponentText( "§e " + HypixelShortCuts.NAME +" " + HypixelShortCuts.VERSION + " §7(hoverable text)").setChatStyle(style);
        //ads to chat
        player.addChatMessage(text);
    }
    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }
}
