package com.tenjava.entries.NLthijs48.t2;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;

public class Arena {

	String name = null;
	Location normalMax = null;
	Location normalMin = null;
	Location flippedMax = null;
	Location flippedMin = null;
	
	public Arena(String name) {
		this.name = name;
	}
	
	public Arena(Map<String, Object> settings) {
		this.name = (String)settings.get("name");
		
		// TODO save all settings
	}
	
	
	public void setNormalArea(Location first, Location second) {
		normalMax = Utils.getMaximumLocation(first, second);
		normalMin = Utils.getMinimumLocation(first, second);
	}
	
	public void setFlippedArea(Location first, Location second) {
		flippedMax = Utils.getMaximumLocation(first, second);
		flippedMin = Utils.getMinimumLocation(first, second);
	}
	
	
	
	
	
	
	
	
	public Map<String, Object> toMap() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("name", name);
		
		
		return result;
	}

}
