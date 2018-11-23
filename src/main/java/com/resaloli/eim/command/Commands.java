package com.resaloli.eim.command;

import com.resaloli.eim.command.mccommands.ExtraCommands;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class Commands {

    private static ICommand[] commands = {
            new ExtraCommands()
    };

    public static void initCommands(FMLServerStartingEvent event) {
        MinecraftServer server = event.getServer();
        ICommandManager commandManager = server.getCommandManager();
        ServerCommandManager manager = (ServerCommandManager) commandManager;

        for (ICommand command : commands) {
            manager.registerCommand(command);
        }
    }
}