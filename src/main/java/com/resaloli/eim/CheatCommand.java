package com.resaloli.eim;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;

public class CheatCommand implements ICommand{
	ArrayList<String> aliases = new ArrayList<String>(); 
	
	public CheatCommand() 
    { 
        
        aliases.add("EIMCheatSword");
    } 
	
	@Override
	public int compareTo(Object arg0) {
		return 0;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender arg0, String[] arg1,
			BlockPos arg2) {
		return null;
	}

	@Override
	public boolean canCommandSenderUse(ICommandSender arg0) {
		return true;
	}

	@Override
	public void execute(ICommandSender sender, String[] arg1)
			throws CommandException {
		if(sender instanceof EntityPlayer)
		{
			sender.addChatMessage(new ChatComponentText("You Little Cheater! >:D"));
    	    String Command = "/summon Creeper ~0 ~1 ~0 {Equipment:[{Count:1,id:diamond_sword,tag:{Unbreakable:1,ench:[{id:18,lvl:5},{id:20,lvl:2},{id:19,lvl:2},{id:21,lvl:3},{id:16,lvl:5},{id:17,lvl:5},{id:34,lvl:3}]}},{id:diamond_boots},{id:diamond_leggings},{id:diamond_chestplate},{id:diamond_helmet}],CustomName:ResaloliPT,CustomNameVisible:1,Attributes:[{Name:generic.maxHealth,Base:1}],DropChances:[2.0F,0.0F,0.0F,0.0F,0.0F],ExplosionRadius:20,Fuse:800,NoAI:1,powered:1}";
    	    MinecraftServer.getServer().getCommandManager().executeCommand(sender, Command);
		}
		
	}

	@Override
	public List<String> getAliases() {
		return this.aliases;
	}

	@Override
	public String getCommandUsage(ICommandSender arg0) {
		return "EIMCheatSword <text>";
	}

	@Override
	public String getName() {
		return "EIMCheatSword";
	}

	@Override
	public boolean isUsernameIndex(String[] arg0, int arg1) {
		return false;
	}
	
}