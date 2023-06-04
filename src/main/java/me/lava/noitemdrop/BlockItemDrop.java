package me.lava.noitemdrop;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class BlockItemDrop implements Listener {
    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        if (RejectCore.instance.denyBreak) {
            if (!event.getPlayer().isOp()) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Item dropping is disabled on this server.");
            }
        }
    }
}