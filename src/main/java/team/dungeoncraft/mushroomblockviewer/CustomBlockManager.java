package team.dungeoncraft.mushroomblockviewer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class CustomBlockManager {

    private final Map<Integer, CustomBlock> customBlocks = new HashMap<>();

    public CustomBlockManager() {
        for (int i = 0; i < 162; i++) {
            customBlocks.put(i, new CustomBlock(i, "方塊編號: " + i));
        }
    }

    public Set<CustomBlock> getCustomBlocks() {
        return new HashSet<>(customBlocks.values());
    }

    public CustomBlock getCustomBlock(int id) {
        return customBlocks.get(id);
    }
}
