package team.dungeoncraft.mushroomblockviewer.command.commands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import team.dungeoncraft.mushroomblockviewer.command.SubCommand;

import java.util.ArrayList;
import java.util.List;

public final class Menu extends SubCommand {

    @Override
    public void onCommand(Player player, String[] args) {
        if (player.isOp()) {
            new team.dungeoncraft.mushroomblockviewer.gui.Menu().show(player);
            player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
        } else {
            player.sendMessage("你沒有權限使用蘑菇塊檢視器");
        }
    }

    @Override
    public String getName() {
        return "menu";
    }

    @Override
    public List<String> getAliases() {
        return new ArrayList<>();
    }

    @Override
    public String getDepiction() {
        return "介面";
    }

    @Override
    public List<String> getSubCommand() {
        return new ArrayList<>();
    }
}
