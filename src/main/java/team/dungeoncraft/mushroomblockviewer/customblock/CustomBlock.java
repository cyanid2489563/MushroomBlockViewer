package team.dungeoncraft.mushroomblockviewer.customblock;

public final class CustomBlock {

    private final int id;
    private final String name;

    public CustomBlock(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}