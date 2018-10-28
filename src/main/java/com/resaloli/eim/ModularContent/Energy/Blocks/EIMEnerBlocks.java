package com.resaloli.eim.ModularContent.Energy.Blocks;

import net.minecraft.block.Block;

public class EIMEnerBlocks {
    public static BlockGenerator generator = new BlockGenerator();

    public static final Block[] BLOCKS = {
            generator
    };

    public static Block[] getList() {
        return BLOCKS;
    }
}
