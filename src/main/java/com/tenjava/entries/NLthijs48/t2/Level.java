package com.tenjava.entries.NLthijs48.t2;

import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public class Level {

	private Location normalMax = null;
	private Location normalMin = null;
	private Location flippedMax = null;
	private Location flippedMin = null;
	private String name = null;
	
	public Level(String name) {
		this.name = name;
	}
	
	public Level(ConfigurationSection settings) {
		name = settings.getString("name");
		normalMax = Utils.configToLocation(settings.getConfigurationSection("normalMax"));
		normalMin = Utils.configToLocation(settings.getConfigurationSection("normalMin"));
		flippedMax = Utils.configToLocation(settings.getConfigurationSection("flippedMax"));
		flippedMin = Utils.configToLocation(settings.getConfigurationSection("flippedMin"));
	}
	
	public String getName() {
		return name;
	}
	
	
	public void setNormalArea(Location first, Location second) {
		normalMax = Utils.getMaximumLocation(first, second);
		normalMin = Utils.getMinimumLocation(first, second);
	}
	
	public void setFlippedArea(Location first, Location second) {
		flippedMax = Utils.getMaximumLocation(first, second);
		flippedMin = Utils.getMinimumLocation(first, second);
	}
	
	
	public ConfigurationSection toConfigSection() {
		ConfigurationSection result = new YamlConfiguration();
		result.set("name", name);
		result.set("normalMax", Utils.locationToConfig(normalMax));
		result.set("normalMin", Utils.locationToConfig(normalMin));
		result.set("flippedMax", Utils.locationToConfig(flippedMax));
		result.set("flippedMin", Utils.locationToConfig(flippedMin));
		return result;
	}
	
	public boolean isReady() {
		boolean result = true;
		result = result && normalMax != null;
		result = result && normalMin != null;
		result = result && flippedMax != null;
		result = result && flippedMin != null;		
		return result;
	}


}






















