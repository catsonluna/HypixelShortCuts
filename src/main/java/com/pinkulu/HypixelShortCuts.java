package com.pinkulu;


import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import javax.swing.text.JTextComponent;


@Mod(modid = HypixelShortCuts.MODID, version = HypixelShortCuts.VERSION, name = HypixelShortCuts.NAME)
public class HypixelShortCuts {

    static final String MODID = "HypixelShortCuts";
    public static final String VERSION = "1.0";
    public static final String NAME = "HypixelShortCuts";
    private final PlayerInFront playerInFront = new PlayerInFront();

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event)
    {
        KeyBinds.register();
    }
    @Mod.EventHandler
    public void onInitialization(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(playerInFront);
        MinecraftForge.EVENT_BUS.register(this);
        ClientCommandHandler.instance.registerCommand(new help());
    }
}
