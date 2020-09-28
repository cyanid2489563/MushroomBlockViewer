package team.dungeoncraft.mushroomblockviewer.event;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.MultipleFacing;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import team.dungeoncraft.mushroomblockviewer.utility.Utility;

public final class BlockPlace implements Listener {

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        Block block = event.getClickedBlock();
        if (block == null) {
            return;
        }

        Player player = event.getPlayer();
        ItemStack itemStack = player.getInventory().getItemInMainHand();

        if (itemStack.getType().equals(Material.TURTLE_HELMET) && ((Damageable) itemStack.getItemMeta()).hasDamage()) {
            Block relative = block.getRelative(event.getBlockFace());
            int blockId = ((Damageable) itemStack.getItemMeta()).getDamage();

            if (blockId < 54) {
                relative.setType(Material.BROWN_MUSHROOM_BLOCK);
            } else if (blockId < 100) {
                relative.setType(Material.RED_MUSHROOM_BLOCK);
            } else if (blockId < 161) {
                relative.setType(Material.MUSHROOM_STEM);
            }

            MultipleFacing multipleFacing = (MultipleFacing) relative.getBlockData();
            setBlockFacing(multipleFacing, blockId);
            relative.setBlockData(multipleFacing);
            event.setCancelled(true);
        }
    }

    public static void setBlockFacing(MultipleFacing blockData, int code) {
        final BlockFace[] properties = new BlockFace[] { BlockFace.DOWN, BlockFace.EAST, BlockFace.NORTH,
                BlockFace.SOUTH, BlockFace.UP, BlockFace.WEST };
        for (int i = 0; i < properties.length; i++) {
            blockData.setFace(properties[i], Utility.getFacingById(code)[i]);
        }
    }

}
