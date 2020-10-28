package team.dungeoncraft.mushroomblockviewer.gui;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.pane.PaginatedPane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import team.dungeoncraft.mushroomblockviewer.customblock.CustomBlockManager;
import team.dungeoncraft.mushroomblockviewer.MushroomBlockViewer;
import team.dungeoncraft.mushroomblockviewer.utility.CustomBlockConverter;

public final class Menu {

    private final Gui gui = new Gui(MushroomBlockViewer.plugin, 6, "蘑菇方塊檢視器");
    private int offset = 1;
    private final CustomBlockManager customBlockManager = new CustomBlockManager();

    public Menu() {
        setUpMenu();
    }

    public void show(Player player) {
        gui.show(player);
    }

    private void setUpMenu() {
        PaginatedPane pane = new PaginatedPane(0, 0, 9, 6);
        setSubMenus(pane);
        gui.addPane(pane);
    }

    private void setSubMenus(PaginatedPane pane) {
        for (int page = 0; page <= 3; page++) {
            pane.addPane(page, setContext(pane, page));
        }
    }

    private Pane setContext(PaginatedPane pane, final int page) {
        StaticPane staticPane = new StaticPane(0,0, 9, 6);
        staticPane.setOnClick(inventoryClickEvent -> inventoryClickEvent.setCancelled(true));

        int counter = (page * 45) + offset;

        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 9; x++) {
                ItemStack itemStack = CustomBlockConverter.convertCustomBlockToItemStack(
                                customBlockManager.getCustomBlock(counter));

                staticPane.addItem(new GuiItem(itemStack, inventoryClickEvent ->
                        inventoryClickEvent.getWhoClicked().getInventory().addItem(itemStack)), x, y);
                counter++;
                if (counter == 54 || counter == 84) {
                    counter++;
                    offset++;
                    continue;
                }
                if (counter > 160) break;
            }
            if (counter > 160) break;
        }
        staticPane.addItem(new GuiItem(new ItemStack(Material.RED_STAINED_GLASS_PANE),
                        inventoryClickEvent -> {
                            int nextPage = page + 1;
                            if (nextPage > 3) nextPage = 3;
                            pane.setPage(nextPage);
                            gui.update();
                        }), 8, 5);

        staticPane.addItem(new GuiItem(new ItemStack(Material.GREEN_STAINED_GLASS_PANE),
                inventoryClickEvent -> {
                    int nextPage = page - 1;
                    if (nextPage < 0) nextPage = 0;
                    pane.setPage(nextPage);
                    gui.update();
                }), 0, 5);
        return staticPane;
    }

    public static ItemStack getCustomBlockItem(int counter) {
        ItemStack itemStack = new ItemStack(Material.TURTLE_HELMET);    // 自訂義方塊的 Item 是用海龜頭盔做的

        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setUnbreakable(true);
        ((Damageable) itemMeta).setDamage(counter);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_DESTROYS);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
