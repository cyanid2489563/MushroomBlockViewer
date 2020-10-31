package team.dungeoncraft.mushroomblockviewer.command.commands;

import org.bukkit.entity.Player;
import team.dungeoncraft.mushroomblockviewer.MushroomBlockViewer;
import team.dungeoncraft.mushroomblockviewer.command.SubCommand;
import team.dungeoncraft.mushroomblockviewer.customblock.CustomBlock;
import team.dungeoncraft.mushroomblockviewer.customblock.CustomBlockManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class BlockEdit extends SubCommand {

    private final CustomBlockManager customBlockManager = MushroomBlockViewer.plugin.getCustomBlockManager();

    @Override
    public void onCommand(Player player, String[] args) {
        if (args.length >= 2) {
            switch (args[1]) {
                case "name":
                    if (args.length >= 3) {
                        int blockId = Integer.parseInt(args[2]);
                        CustomBlock customBlock = customBlockManager.getCustomBlock(blockId);
                        if (customBlock != null) {
                            if (args.length >= 4) {
                                String blockName = args[3];
                                customBlockManager.changeCustomBlockName(blockId, blockName);
                                player.sendMessage("方塊編號: " + blockId + " ,已更名為" + blockName);
                            } else {
                                player.sendMessage("請輸入方塊名稱");
                            }
                        } else {
                            player.sendMessage("該方塊不存在");
                        }
                    } else {
                        player.sendMessage("請輸入方塊編號");
                    }
                    break;
                case "lore":
                    if (args.length >= 3) {
                        int blockId = Integer.parseInt(args[2]);
                        CustomBlock customBlock = customBlockManager.getCustomBlock(blockId);
                        if (customBlock != null) {
                            if (args.length > 3) {
                                List<String> lore = new ArrayList<>(Arrays.asList(args).subList(3, args.length));
                                customBlockManager.setCustomBlockLore(blockId, lore);
                            } else {
                                player.sendMessage("請輸入 lore");
                            }
                        } else {
                            player.sendMessage("該方塊不存在");
                        }
                    } else {
                        player.sendMessage("請輸入方塊編號");
                    }
                    break;
            }
        }
    }

    @Override
    public String getName() {
        return "blockedit";
    }

    @Override
    public List<String> getAliases() {
        return new ArrayList<>();
    }

    @Override
    public String getDepiction() {
        return "編輯自訂義方塊";
    }

    @Override
    public List<String> getSubCommand() {
        return new ArrayList<>();
    }
}
