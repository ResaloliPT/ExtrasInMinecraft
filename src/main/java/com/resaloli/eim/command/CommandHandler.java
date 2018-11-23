package com.resaloli.eim.command;

import com.resaloli.eim.ModConfigs;
import com.resaloli.eim.command.commandactions.HungryAction;
import com.resaloli.eim.command.commandactions.ICommand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class CommandHandler {

    public static ICommand handleCommand(EntityPlayer sender, MinecraftServer server, String[] args) {

        if (args.length <= 0) {
            return null;
        }

        CommandMapper mappedCommand = CommandMapper.getMapper(args[0]);

        if (mappedCommand == null) {
            return null;
        }

        switch (mappedCommand) {
            case SET_HUNGRY:
                return new HungryAction(sender, server, args);
        }

        return null;
    }

    public static String getUsages() {
        StringBuilder sb = new StringBuilder();
        sb.append(ModConfigs.COMMAND_PREFIX + "  <text>\n");

        for (CommandMapper mapper : CommandMapper.values()) {
            sb.append(mapper.command + " -- " + mapper.help);
        }

        return sb.toString();
    }

    private enum CommandMapper {
        SET_HUNGRY("setHungry", "Sets Food and Saturation to 0");

        private final String command;
        private final String help;

        CommandMapper(String command, String help) {

            this.command = command;
            this.help = help;
        }

        private static CommandMapper getMapper(String command) {
            for (CommandMapper mapper : CommandMapper.values()) {
                if (mapper.getCommand().equals(command)) {
                    return mapper;
                }
            }

            return null;
        }

        public String getCommand() {
            return command;
        }
    }
}
