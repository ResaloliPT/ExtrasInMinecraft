package com.resaloli.eim.command.commandactions;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public abstract class AbstractCommand implements ICommand {

    protected EntityPlayer player;
    protected MinecraftServer server;
    protected String[] command;

    protected AbstractCommand(EntityPlayer player, MinecraftServer server, String[] command) {
        this.player = player;
        this.server = server;
        this.command = command;
    }
}
