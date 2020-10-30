package team.dungeoncraft.mushroomblockviewer.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CommandTabCompleter implements TabCompleter {

    private static final List<String> COMMANDS = Arrays.asList("menu", "help");
    private static final List<String> BLANK = Arrays.asList("", "");

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 1) {
                return StringUtil.copyPartialMatches(args[0], COMMANDS, new ArrayList<>());
            }
        }
        return BLANK;
    }
}
