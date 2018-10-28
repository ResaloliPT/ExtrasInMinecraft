package com.resaloli.eim;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

public class CheatCommand extends CommandBase {

	public final String commandName =  "EIMDebug";
    public String usage = commandName +"  <text>\n"+
            "setHungry -- Sets Food and Saturation to 0";
	private final List<String> autoComplete = Arrays.asList("setHungry");


	public CheatCommand()
	{
	}

	public String getName() {
		return commandName;
	}

	public String getUsage(ICommandSender sender) {
	    return usage;
	}

	public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
		if(sender instanceof EntityPlayer)
		{
           	if(args.length != 0){
				switch (args[0]){
					case "setHungry":
						((EntityPlayer) sender).getFoodStats().setFoodLevel(0);
						break;
					default:
						sender.sendMessage(new TextComponentString(usage));
				}
            } else {
                sender.sendMessage(new TextComponentString(usage));
            }
		}
	}

	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos)
	{
		return autoComplete;
	}
}