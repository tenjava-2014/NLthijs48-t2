package com.tenjava.entries.NLthijs48.t2;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public class Utils {

	/**
	 * Only static methods at the moment, constructor is useless
	 */
	private Utils() {
	}

	/**
	 * Get a minimum location from 2 locations
	 * @param first The first location
	 * @param second The second location
	 * @return The minimum location
	 */
	public static Location getMinimumLocation(Location first, Location second) {
		Location result = first.clone();
		if(second.getX() < result.getX()) {
			result.setX(second.getX());
		}
		if(second.getY() < result.getY()) {
			result.setY(second.getY());
		}
		if(second.getZ() < result.getZ()) {
			result.setZ(second.getZ());
		}		
		return result;
	}
	
	/**
	 * Get a maximum location from 2 locations
	 * @param first The first location
	 * @param second The second location
	 * @return The maximum location
	 */
	public static Location getMaximumLocation(Location first, Location second) {
		Location result = first.clone();
		if(second.getX() > result.getX()) {
			result.setX(second.getX());
		}
		if(second.getY() > result.getY()) {
			result.setY(second.getY());
		}
		if(second.getZ() > result.getZ()) {
			result.setZ(second.getZ());
		}		
		return result;
	}
	
	/**
	 * Create a map from a location, to save it in the config
	 * @param location The location to transform
	 * @return The map with the location values
	 */
	public static ConfigurationSection locationToConfig(Location location) {
		ConfigurationSection result = new YamlConfiguration();
		result.set("world", location.getWorld().getName());
		result.set("x", location.getX());
		result.set("y", location.getY());
		result.set("z", location.getZ());
		result.set("yaw", Float.toString(location.getYaw()));
		result.set("pitch", Float.toString(location.getPitch()));		
		return result;
	}
	
	/**
	 * Create a location from a map, reconstruction from the config values
	 * @param map The map to reconstruct from
	 * @return The location
	 */
	public static Location configToLocation(ConfigurationSection config) {
		if(config == null
				|| config.isString("world")
				|| config.isDouble("x")
				|| config.isDouble("y")
				|| config.isDouble("z") 
				|| config.isString("yaw")
				|| config.isString("pitch")) {
			return null;
		}
		return new Location(
				Bukkit.getWorld(config.getString("world")), 
				(Double)config.getDouble("x"), 
				(Double)config.getDouble("y"), 
				(Double)config.getDouble("z"), 
				Float.parseFloat(config.getString("yaw")), 
				Float.parseFloat(config.getString("pitch")));
	}
	
}








