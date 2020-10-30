package team.dungeoncraft.mushroomblockviewer.customblock;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import team.dungeoncraft.mushroomblockviewer.MushroomBlockViewer;

import java.util.*;

public final class CustomBlockManager {

    private final Map<Integer, CustomBlock> customBlocks = new HashMap<>();

    public CustomBlockManager() {
        YamlConfiguration config = MushroomBlockViewer.plugin.getConfigManager().getBlocksConfig();

        for (String key : config.getConfigurationSection("customBlocks").getKeys(false)) {
            int id = Integer.parseInt(key);
            ConfigurationSection blockSection = config.getConfigurationSection("customBlocks." + key);
            String name = blockSection.getString("name");
            List<String> lore = blockSection.getStringList("lore");
            customBlocks.put(id, new CustomBlock(id, name, lore));
        }
    }

    public Set<CustomBlock> getCustomBlocks() {
        return new HashSet<>(customBlocks.values());
    }

    public CustomBlock getCustomBlock(int id) {
        return customBlocks.get(id);
    }

    public void changeCustomBlockName(int id, String name) {
        getCustomBlock(id).setName(name);
    }
}
