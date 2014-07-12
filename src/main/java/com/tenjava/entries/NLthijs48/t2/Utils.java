package com.tenjava.entries.NLthijs48.t2;

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
	
}
