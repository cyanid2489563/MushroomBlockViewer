package team.dungeoncraft.mushroomblockviewer.customblock;

import java.util.List;

public final class CustomBlock {

    private final int id;
    private String name;
    private List<String> lore;

    public CustomBlock(int id, String name, List<String> lore) {
        this.id = id;
        this.name = name;
        this.lore = lore;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public List<String> getLore() {
        return lore;
    }

    void setLore(List<String> lore) {
        this.lore = lore;
    }
}
