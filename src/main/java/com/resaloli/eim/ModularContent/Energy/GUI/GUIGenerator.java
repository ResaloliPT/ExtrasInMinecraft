package com.resaloli.eim.ModularContent.Energy.GUI;

import com.resaloli.eim.CONSTANTS;
import com.resaloli.eim.ModularContent.Energy.Container.ContainerGenerator;
import com.resaloli.eim.ModularContent.Energy.TileEntities.TileEntityGenerator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GUIGenerator  extends GuiContainer {
    public ResourceLocation GUIGeneratorRes = new ResourceLocation(CONSTANTS.MOD_ID, "textures/gui/eim_generator.png");

    public static TileEntityGenerator te;

    public GUIGenerator(InventoryPlayer playerInv, World world, BlockPos pos) {
        super(new ContainerGenerator(playerInv, world, pos));
        this.xSize = 175;
        this.ySize = 165;
        this.te = (TileEntityGenerator)world.getTileEntity(pos);
    }

    protected void drawGuiContainerBackgroundLayer(float arg0, int arg1, int arg2) {
        // Draw Container
        Minecraft.getMinecraft().getTextureManager().bindTexture(GUIGeneratorRes);
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        //Draw Burn Progress
        int rBurnTimeScaled = this.te.getBurnTimeRemainingScaled(13);
        this.drawTexturedModalRect(guiLeft + 57, guiTop + 50-rBurnTimeScaled, 176, 13-rBurnTimeScaled, 14, rBurnTimeScaled );

        //Draw Energy Storage
        int energyScaled = te.getEnergyScaled(32);
        this.drawTexturedModalRect(guiLeft + 79, guiTop + 39, 176, 14, energyScaled, 9);
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {


    }
}
