package com.resaloli.eim;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nullable;

public class CheatCommand implements ICommand{
	ArrayList<String> aliases = new ArrayList<String>(); 
	
	public CheatCommand() 
    {
        aliases.add("EIMCheatSword");
    }

	@Override
	public String getName() {
		return null;
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return null;
	}

	@Override
	public List<String> getAliases() {
		return null;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(sender instanceof EntityPlayer)
		{
			sender.sendMessage(new TextComponentString("You Little Cheater! >:D"));
			String Command = "/summon Creeper ~0 ~1 ~0 {Equipment:[{Count:1,id:diamond_sword,tag:{Unbreakable:1,ench:[{id:18,lvl:5},{id:20,lvl:2},{id:19,lvl:2},{id:21,lvl:3},{id:16,lvl:5},{id:17,lvl:5},{id:34,lvl:3}]}},{id:diamond_boots},{id:diamond_leggings},{id:diamond_chestplate},{id:diamond_helmet}],CustomName:ResaloliPT,CustomNameVisible:1,Attributes:[{Name:generic.maxHealth,Base:1}],DropChances:[2.0F,0.0F,0.0F,0.0F,0.0F],ExplosionRadius:20,Fuse:800,NoAI:1,powered:1}";
			server.getCommandManager().executeCommand(sender, Command);
		}
	}

	public String getCommandUsage(ICommandSender sender) {
		return "EIMCheatSword <text>";
	}

	public List<String> getCommandAliases() {
		return null;
	}

	public String getCommandName() {
		return "EIMCheatSword";
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender){
		return false;
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
		return null;
	}

	public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos) {
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] userName, int index) {
		return false;
	}

	@Override
	public int compareTo(ICommand o) {
		return 0;
	}
}