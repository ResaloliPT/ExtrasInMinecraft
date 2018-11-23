package com.resaloli.eim.content.gui;

public enum GUIID {
    DUAL_CRAFTING_TABLE(1),
    GUI_ENERGY_GENERATOR_ID(2);

    private final int id;

    GUIID(int id) {
        this.id = id;
    }

    public static GUIID getGUI(int id) {
        for (GUIID gui : GUIID.values()) {
            if (gui.id == id) {
                return gui;
            }
        }

        return null;
    }

    public int getId() {
        return id;
    }
}
