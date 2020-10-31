package team.dungeoncraft.mushroomblockviewer;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import team.dungeoncraft.mushroomblockviewer.customblock.CustomBlock;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
        }
        config = YamlConfiguration.loadConfiguration(file);
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

    public void save(Map<Integer, CustomBlock> blocks) {
        ConfigurationSection section = config.getConfigurationSection("customBlocks");
        for (int id : blocks.keySet()) {
            ConfigurationSection idSection = section.getConfigurationSection(String.valueOf(id));
            idSection.set("id", id);
            idSection.set("name", blocks.get(id).getName());
            idSection.set("lore", blocks.get(id).getLore());
        }

        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
