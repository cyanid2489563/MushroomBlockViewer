package team.dungeoncraft.mushroomblockviewer;

import org.bukkit.plugin.java.JavaPlugin;
import team.dungeoncraft.mushroomblockviewer.command.CommandManager;
import team.dungeoncraft.mushroomblockviewer.event.BlockPhysics;
import team.dungeoncraft.mushroomblockviewer.event.BlockPlace;

public final class MushroomBlockViewer extends JavaPlugin {

    public static MushroomBlockViewer plugin;

    @Override
    public void onLoad() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        new CommandManager(plugin);
        setUpEvents();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void setUpEvents() {
        plugin.getServer().getPluginManager().registerEvents(new BlockPlace(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new BlockPhysics(), plugin);
    }
}
