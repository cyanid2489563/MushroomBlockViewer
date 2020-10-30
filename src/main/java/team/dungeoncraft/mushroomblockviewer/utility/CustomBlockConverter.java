package team.dungeoncraft.mushroomblockviewer.utility;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import team.dungeoncraft.mushroomblockviewer.customblock.CustomBlock;

public class CustomBlockConverter {

    public static ItemStack convertCustomBlockToItemStack(CustomBlock customBlock) {
        ItemStack itemStack = new ItemStack(Material.TURTLE_HELMET);    // 自訂義方塊的 Item 是用海龜頭盔做的

        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(customBlock.getName());
        itemMeta.setLore(customBlock.getLore());
        ((Damageable) itemMeta).setDamage(customBlock.getId());
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_DESTROYS);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
