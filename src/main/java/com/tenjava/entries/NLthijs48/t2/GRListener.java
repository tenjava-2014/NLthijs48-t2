package com.tenjava.entries.NLthijs48.t2;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GRListener implements Listener {
	GravityReversal plugin = null;
	
	public GRListener(GravityReversal plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);	
	}
	
	@EventHandler
	public void onPlayerInteract() {
		
	}

}
