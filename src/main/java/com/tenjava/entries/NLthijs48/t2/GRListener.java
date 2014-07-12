package com.tenjava.entries.NLthijs48.t2;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class GRListener implements Listener {
	GravityReversal plugin = null;
	
	public GRListener(GravityReversal plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if((event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& plugin.getLevelSetupMap().keySet().contains(player.getUniqueId())) {
			HashMap<String, Object> info = plugin.getLevelSetupMap().get(player.getUniqueId());
			int number = Integer.parseInt((String)info.get("number"));
			Block block = event.getClickedBlock();
			if(number == 0) {
				info.put("normal1", block.getLocation());
				info.put("number", "" + (number+1));
				plugin.message(player, "addlevel-normal1done");				
			} else if(number == 1) {
				info.put("normal2", block.getLocation());
				info.put("number", "" + (number+1));
				plugin.message(player, "addlevel-normal2done");	
			} else if(number == 2) {
				info.put("flipped1", block.getLocation());
				info.put("number", "" + (number+1));
				plugin.message(player, "addlevel-flipped1done");	
			} else if(number == 3) {
				Location normal1 = (Location)info.get("normal1");
				Location normal2 = (Location)info.get("normal2");
				Location flipped1 = (Location)info.get("flipped1");
				Location flipped2 = block.getLocation();
				
				Location normalMin = Utils.getMinimumLocation(normal1, normal2);
				Location normalMax = Utils.getMaximumLocation(normal1, normal2);
				Location flippedMin = Utils.getMinimumLocation(flipped1, flipped2);
				Location flippedMax = Utils.getMaximumLocation(flipped1, flipped2);
				
				if((normalMax.getBlockX()-normalMin.getBlockX()) == (flippedMax.getBlockX()-flippedMin.getBlockX())
						&& (normalMax.getBlockY()-normalMin.getBlockY()) == (flippedMax.getBlockY()-flippedMin.getBlockY())
						&& (normalMax.getBlockZ()-normalMin.getBlockZ()) == (flippedMax.getBlockZ()-flippedMin.getBlockZ())) {
					Level level = plugin.getArena().getLevel((String)info.get("level"));
					level.setNormalArea(normalMin, normalMax);
					level.setFlippedArea(flippedMin, flippedMax);
					plugin.saveArena();
					plugin.message(player, "addlevel-success");		
					plugin.getLevelSetupMap().remove(player.getUniqueId());
				} else {
					plugin.message(player, "addlevel-locationsFailed");
					info.put("number", "" + (0));
				}
			}
			
			
			
			event.setCancelled(true);
		}		
	}

}
















