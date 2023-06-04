package me.lava.noitemdrop;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockBuilding implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (RejectCore.instance.denyBuild) {
            if (!event.getPlayer().isOp()) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You can't build on this server.");
            }
        }
    }
}