package com.resaloli.eim.content.te;

import net.minecraftforge.items.IItemHandler;

public class TileEntityDCT extends TileEntityBase {

    public TileEntityDCT() {
        super(25);
    }


    public IItemHandler getHandler(){
        return super.handler;
    }
}