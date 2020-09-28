package team.dungeoncraft.mushroomblockviewer.command;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import team.dungeoncraft.mushroomblockviewer.MushroomBlockViewer;
import java.util.Objects;

public class CommandManager implements CommandExecutor {

    private final String command = "mbv";

    public CommandManager(MushroomBlockViewer plugin) {
        Objects.requireNonNull(plugin.getCommand(command)).setExecutor(this);
        Objects.requireNonNull(plugin.getCommand(command)).setTabCompleter(new CommandTabCompleter());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (this.command.equalsIgnoreCase(command.getName())) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("無效的命令發送者");
                return false;
            }

            Player player = (Player) sender;
            if (player.isOp()) {
                new team.dungeoncraft.mushroomblockviewer.gui.Menu().show(player);
                player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
            } else {
                player.sendMessage("你沒有權限使用蘑菇塊檢視器");
            }
        }
        return false;
    }
}