package team.dungeoncraft.mushroomblockviewer.event;

import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.MultipleFacing;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import team.dungeoncraft.mushroomblockviewer.customblock.CustomBlock;
import team.dungeoncraft.mushroomblockviewer.customblock.CustomBlockManager;
import team.dungeoncraft.mushroomblockviewer.utility.CustomBlockConverter;
import team.dungeoncraft.mushroomblockviewer.utility.Utility;

public final class BlockCopy implements Listener {

    private final CustomBlockManager customBlockManager = new CustomBlockManager();

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            Player player = event.getPlayer();
            if (!player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                return;
            }

            BlockData blockdata = event.getClickedBlock().getBlockData();
            MultipleFacing multicasting = (MultipleFacing) blockdata;
            int blockId = Utility.getIdByFacing(multicasting.getFaces());
            player.getInventory().addItem(getItemStack(blockId));
            event.setCancelled(true);
        }
    }

    private ItemStack getItemStack(int id) {
        CustomBlock customBlock = customBlockManager.getCustomBlock(id);
        return CustomBlockConverter.convertCustomBlockToItemStack(customBlock);
    }
}
