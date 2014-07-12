package com.tenjava.entries.NLthijs48.t2;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Utils {

	private Utils() {
	}

	
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
	
	public static Map<String, Object> locationToMap(Location location) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("world", location.getWorld().getName());
		result.put("x", location.getX());
		result.put("y", location.getY());
		result.put("z", location.getZ());
		result.put("yaw", location.getYaw());
		result.put("pitch", location.getPitch());		
		return result;
	}
	
	public static Location mapToLocation(Map<String, Object> map) {
		return new Location(
				Bukkit.getWorld((String)map.get("world")), 
				(Double)map.get("x"), 
				(Double)map.get("y"), 
				(Double)map.get("z"), 
				(Float)map.get("yaw"), 
				(Float)map.get("pitch"));
	}
	
}








