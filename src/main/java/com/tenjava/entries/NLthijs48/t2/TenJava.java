package com.tenjava.entries.NLthijs48.t2;

import org.bukkit.plugin.java.JavaPlugin;

public class TenJava extends JavaPlugin {
	Arena arena = null;
	
	public void onEnable() {
		
		this.saveDefaultConfig();
		
		loadArena();
		
	}
	
	
	
	
	
	public void loadArena() {
		
		if(getConfig().isSet("arena")) {
			arena = new Arena(getConfig().getConfigurationSection("arena" ).getValues(true));
		}
	}
}
