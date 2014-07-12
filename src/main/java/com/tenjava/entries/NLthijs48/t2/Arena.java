package com.tenjava.entries.NLthijs48.t2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public class Arena {

	ArrayList<Level> levels = null;
	//String name = null;
	
	public Arena() {
		//this.name = name;
	}
	
	public Arena(ConfigurationSection settings) {
		levels = new ArrayList<Level>();

		if(settings.isSet("levels")) {
			ConfigurationSection levels = settings.getConfigurationSection("levels");
			for(String level : levels.getKeys(false)) {
				this.levels.add(new Level(levels.getConfigurationSection(level)));
			}
		}
		
		// TODO save all settings
	}

	
	
	public boolean isReady() {
		boolean result = true;
		// TODO check if a level exists
		return result;
	}
	
	
	
	
	
	
	public ConfigurationSection toConfigSecion() {
		ConfigurationSection result = new YamlConfiguration();
		
		for(Level level : levels) {
			result.set(level.getName().toLowerCase(), level.toConfigSection());
		}

		
		return result;
	}

}























