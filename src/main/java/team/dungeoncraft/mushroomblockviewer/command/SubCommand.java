package team.dungeoncraft.mushroomblockviewer.command;


import org.bukkit.entity.Player;

import java.util.List;

public abstract class SubCommand {

    public abstract void onCommand(Player player, String[] args);

    public abstract String getName();

    public abstract List<String> getAliases();

    public abstract String getDepiction();

    public abstract List<String> getSubCommand();
}