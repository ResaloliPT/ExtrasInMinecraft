package com.resaloli.eim;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class CheatCommand extends CommandBase {

	public final String commandName;

	public CheatCommand()
	{
		commandName = "EIMCheatSword";
	}



	@Override
	public String getName() {
		return commandName;
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return commandName+" <text>";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(sender instanceof EntityPlayer)
		{
			sender.sendMessage(new TextComponentString("You Little Cheater! >:D"));
			String Command = "/summon creeper ~ ~5 ~ {Silent:1,CustomName:\"Over 9000!!!\",ActiveEffects:[{Id:1,Amplifier:1,Duration:999999},{Id:22,Amplifier:0,Duration:999999}],powered:1}"; //"/summon Creeper ~0 ~1 ~0 {Equipment:[{Count:1,id:diamond_sword,tag:{Unbreakable:1,ench:[{id:18,lvl:5},{id:20,lvl:2},{id:19,lvl:2},{id:21,lvl:3},{id:16,lvl:5},{id:17,lvl:5},{id:34,lvl:3}]}},{id:diamond_boots},{id:diamond_leggings},{id:diamond_chestplate},{id:diamond_helmet}],CustomName:ResaloliPT,CustomNameVisible:1,Attributes:[{Name:generic.maxHealth,Base:1}],DropChances:[2.0F,0.0F,0.0F,0.0F,0.0F],ExplosionRadius:20,Fuse:800,NoAI:1,powered:1}";
			server.getCommandManager().executeCommand(sender, Command);
		}
	}
}