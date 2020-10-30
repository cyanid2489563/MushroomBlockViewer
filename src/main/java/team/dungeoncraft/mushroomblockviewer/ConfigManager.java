package team.dungeoncraft.mushroomblockviewer;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigManager {

    private final File file = new File(MushroomBlockViewer.plugin.getDataFolder(), "blocks.yml");
    private YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

    public ConfigManager() {
        checkBlocks();
    }

    public YamlConfiguration getBlocksConfig() {
        return config;
    }

    private void checkBlocks() {
        if (!file.exists()) {
            createConfig_();
            // createConfig();
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    private void createConfig() {
        Map<Integer, String> blocks = new HashMap<>();
        for (int i = 1; i <= 160; i++) {
            blocks.put(i, "自訂義方塊" + i);
        }
        config.set("customBlocks", blocks);

        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createConfig_() {
        List<String> lore = new ArrayList<>();
        lore.add("lore - 1");
        lore.add("lore - 2");
        lore.add("lore - 3");

        ConfigurationSection section = config.createSection("customBlocks");
        for (int i = 1; i <= 160; i++) {
            ConfigurationSection id = section.createSection(String.valueOf(i));
            id.set("id", i);
            id.set("name", "自訂義方塊" + i);
            id.set("lore", lore);
        }

        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
