package team.dungeoncraft.mushroomblockviewer.command;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import team.dungeoncraft.mushroomblockviewer.MushroomBlockViewer;
import team.dungeoncraft.mushroomblockviewer.command.commands.BlockEdit;
import team.dungeoncraft.mushroomblockviewer.command.commands.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class CommandManager implements CommandExecutor {

    private final String command = "mbv";
    private final List<SubCommand> subCommands = new ArrayList<>();

    public CommandManager(MushroomBlockViewer plugin) {
        setUpCommand();
        Objects.requireNonNull(plugin.getCommand(command)).setExecutor(this);
        Objects.requireNonNull(plugin.getCommand(command)).setTabCompleter(new CommandTabCompleter());
    }

    private void setUpCommand() {
        subCommands.add(new Menu());
        subCommands.add(new BlockEdit());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (this.command.equalsIgnoreCase(command.getName())) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("錯誤的指令發送者");
                return false;
            }

            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage("輸入/mbv help 來檢視命令列表");
                return true;
            }

            SubCommand target = this.get(args[0]);
            if (target == null) {
                player.sendMessage("錯誤的子命令");
                return true;
            }

            try {
                target.onCommand(player, args);
            } catch (Exception e) {
                player.sendMessage("發生未預期錯誤");
                e.printStackTrace();
            }
        }
        return false;
    }

    private SubCommand get(String name) {
        for (SubCommand sc : subCommands) {
            if (sc.getName() != null && sc.getName().equalsIgnoreCase(name)) {
                if (sc.getAliases() != null && sc.getAliases().contains(name)) {
                    return sc;
                }
                return sc;
            }
        }
        return null;
    }

}
