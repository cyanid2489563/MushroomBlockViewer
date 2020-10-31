package team.dungeoncraft.mushroomblockviewer.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import team.dungeoncraft.mushroomblockviewer.MushroomBlockViewer;
import team.dungeoncraft.mushroomblockviewer.customblock.CustomBlock;
import team.dungeoncraft.mushroomblockviewer.customblock.CustomBlockManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CommandTabCompleter implements TabCompleter {

    private static final CustomBlockManager customBlockManager = MushroomBlockViewer.plugin.getCustomBlockManager();
    private static final List<String> COMMANDS = Arrays.asList("menu", "help", "blockedit");
    private static final List<String> BLOCK_EDIT = Arrays.asList("name", "lore");
    private static final List<String> BLANK = Arrays.asList("", "");

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 1) {
                return StringUtil.copyPartialMatches(args[0], COMMANDS, new ArrayList<>());
            } else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("blockedit")) {
                    return StringUtil.copyPartialMatches(args[1], BLOCK_EDIT, new ArrayList<>());
                }
            }
        }
        return BLANK;
    }
}
