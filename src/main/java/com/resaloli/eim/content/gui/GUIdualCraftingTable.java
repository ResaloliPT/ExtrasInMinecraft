package com.resaloli.eim.content.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import com.resaloli.eim.ExtrasInMinecraft;
import com.resaloli.eim.content.container.ContainerDCT;

public class GUIdualCraftingTable extends GuiContainer{

	public static ResourceLocation GUIdualCraftingTableRes = new ResourceLocation(ExtrasInMinecraft.modid, "textures/gui/gui_dual_crafting_table.png");

	public GUIdualCraftingTable(InventoryPlayer playerInv, World world, BlockPos pos) {
		super(new ContainerDCT(playerInv, world, pos));
		this.xSize = 176;
		this.ySize = 183;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float arg0, int arg1, int arg2) {
		Minecraft.getMinecraft().getTextureManager().bindTexture(GUIdualCraftingTableRes);
		this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
	}
}
