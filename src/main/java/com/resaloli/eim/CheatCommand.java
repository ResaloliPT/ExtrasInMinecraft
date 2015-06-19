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
    	    String Command = "/summon Creeper ~ ~1 ~ {CustomName:\"Resaloli\",CustomNameVisible:1,powered:1,ExplosionRadius:0,Fuse:100,Equipment:[{id:diamond_sword,Count:1,tag:{CanPlaceOn:[\"minecraft:grass\"],AttributeModifiers:[{AttributeName:\"generic.movementSpeed\",Name:\"generic.movementSpeed\",Amount:20,Operation:2,UUIDLeast:894654,UUIDMost:2872},{AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\",Amount:60,Operation:2,UUIDLeast:894654,UUIDMost:2872}],Unbreakable:1,display:{Name:ResaloliPT},ench:[{id:16,lvl:99},{id:17,lvl:99},{id:18,lvl:99},{id:19,lvl:99},{id:20,lvl:99},{id:21,lvl:99},{id:34,lvl:99}]}},{id:golden_boots,Count:1},{id:golden_leggings,Count:1},{id:golden_chestplate,Count:1},{id:beacon,Count:1}],DropChances:[2.0F,0.085F,0.085F,0.085F,2.0F],Attributes:[{Name:generic.maxHealth,Base:1}],HealF:1,CanPickUpLoot:1b}";
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