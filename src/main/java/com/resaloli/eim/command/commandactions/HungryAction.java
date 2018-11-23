package com.resaloli.eim.command.commandactions;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class HungryAction extends AbstractCommand {

    public HungryAction(EntityPlayer player, MinecraftServer server, String[] command) {
        super(player, server, command);
    }

    @Override
    public void execute() {
        player.getFoodStats().setFoodLevel(0);
    }
}
