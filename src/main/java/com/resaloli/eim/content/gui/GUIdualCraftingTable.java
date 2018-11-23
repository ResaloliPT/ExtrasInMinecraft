package com.resaloli.eim.content.gui;

import com.resaloli.eim.ExtrasInMinecraft;
import com.resaloli.eim.content.container.ContainerDCT;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GUIdualCraftingTable extends GuiContainer{

    public static ResourceLocation GUIdualCraftingTableRes = new ResourceLocation(ExtrasInMinecraft.MOD_ID, "textures/gui/gui_dual_crafting_table.png");

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

	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
	}
}
