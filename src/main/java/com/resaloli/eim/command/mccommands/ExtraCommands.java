package com.resaloli.eim.command.mccommands;

import com.resaloli.eim.ModConfigs;
import com.resaloli.eim.command.CommandHandler;
import com.resaloli.eim.command.commandactions.ICommand;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nullable;
import java.util.LinkedList;
import java.util.List;

public class ExtraCommands extends CommandBase {

    private final List<String> autoComplete;

    public ExtraCommands() {
        autoComplete = new LinkedList<>();
        autoComplete.add("setHungry");
    }

    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        if (!(sender instanceof EntityPlayer)) {
            return;
        }

        ICommand command = CommandHandler.handleCommand((EntityPlayer) sender, server, args);

        if (command == null) {
            sender.sendMessage(new TextComponentString(getUsage(sender)));
            return;
        }

        command.execute();
    }

    public String getName() {
        return ModConfigs.COMMAND_PREFIX;
    }

    public String getUsage(ICommandSender sender) {
        return CommandHandler.getUsages();
    }

    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return autoComplete;
    }
}