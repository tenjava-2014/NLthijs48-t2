package com.tenjava.entries.NLthijs48.t2;

import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class GravityReversal extends JavaPlugin {
	////////// Variables ////////////
	private Arena arena = null;
	private LanguageManager languageManager = null;
	private CommandManager commandManager = null;
	private String chatPrefix;
	
	private HashMap<UUID, HashMap<String, Object>> levelSetup = null;
	
	////////// Constants ////////////
	
	/**
	 * Called on the start of the plugin
	 */
	public void onEnable() {		
		this.saveDefaultConfig();
		this.languageManager = new LanguageManager(this);
		this.commandManager = new CommandManager(this);
		chatPrefix = getConfig().getString("chatPrefix");		
		levelSetup = new HashMap<UUID, HashMap<String, Object>>();
		new GRListener(this);
		loadArena();
	}
	
	
	/**
	 * Method to send a message to a CommandSender, using chatprefix if it is a player
	 * @param target The CommandSender you wan't to send the message to (e.g. a player)
	 * @param key The key to get the translation
	 * @param params The parameters to inject into the message string
	 */
	public void message(Object target, String key, Object... params) {
		String langString = this.fixColors(languageManager.getLang(key, params));
		if(langString == null) {
			this.getLogger().info("Something is wrong with the language file, could not find key: " + key);
		} else if(langString.equals("")) {
			// Do nothing, message is disabled
		} else {
			if(target instanceof Player) {
				((Player)target).sendMessage(this.fixColors(chatPrefix) + langString);
			} else if(target instanceof CommandSender) {
				((CommandSender)target).sendMessage(langString);
			}	
			else if(target instanceof Logger) {
				((Logger)target).info(langString);
			} else {
				this.getLogger().info("Could not send message, target is wrong: " + langString);
			}
		}
	}
	
	public HashMap<UUID, HashMap<String, Object>> getLevelSetupMap() {
		return levelSetup;
	}
	
	/**
	 * Get the languagemanager
	 * @return The languageManager
	 */
	public LanguageManager getLanguageManager() {
		return languageManager;
	}
	
	/**
	 * Get the commandmanager
	 * @return The commandManager
	 */
	public CommandManager getCommandManager() {
		return commandManager;
	}
	
	public Arena getArena() {
		return arena;
	}
	
	/**
	 * Load the arena from the config
	 */
	public void loadArena() {		
		if(getConfig().isSet("arena")) {
			arena = new Arena(this, getConfig().getConfigurationSection("arena"));
		} else {
			arena = new Arena(this);
		}
	}
	
	public void saveArena() {
		getConfig().set("arena", getArena().toConfigSection());		
		this.saveConfig();
	}
	
	
	/**
	 * Convert color and formatting codes to bukkit values
	 * @param input Start string with color and formatting codes in it
	 * @return String with the color and formatting codes in the bukkit format
	 */
	public String fixColors(String input) {
		return ChatColor.translateAlternateColorCodes('&', input);		
	}
}



















