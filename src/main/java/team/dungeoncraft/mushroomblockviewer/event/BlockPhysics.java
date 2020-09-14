package team.dungeoncraft.mushroomblockviewer.event;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;

import java.util.ArrayList;
import java.util.List;

public class BlockPhysics implements Listener {
    private final List<Material> replaceableBlocks = new ArrayList<>();

    public BlockPhysics() {
        replaceableBlocks.add(Material.BROWN_MUSHROOM_BLOCK);
        replaceableBlocks.add(Material.RED_MUSHROOM_BLOCK);
        replaceableBlocks.add(Material.MUSHROOM_STEM);
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onBlockPhysics(BlockPhysicsEvent event) {
        if (!replaceableBlocks.contains(event.getChangedType())) return;
        event.setCancelled(true);
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendBlockChange(event.getBlock().getLocation(), event.getBlock().getBlockData());
        }
    }
}
