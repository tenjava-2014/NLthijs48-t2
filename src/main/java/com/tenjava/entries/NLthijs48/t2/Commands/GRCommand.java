package com.tenjava.entries.NLthijs48.t2.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.tenjava.entries.NLthijs48.t2.GravityReversal;

public abstract class GRCommand {
	GravityReversal plugin;
	
	/**
	 * Save the instance of the main plugin class
	 * @param plugin The main plugin
	 */
	public GRCommand(GravityReversal plugin) {
		this.plugin = plugin;
	}
	
	public boolean canExecute(Command command, String[] args) {
		String commandString = command.getName();
		for(String argument : args) {
			commandString += " " + argument;
		}
		if(commandString.length() > getCommandStart().length()) {
			return commandString.toLowerCase().startsWith(getCommandStart().toLowerCase() + " ");
		}
		return commandString.toLowerCase().startsWith(getCommandStart().toLowerCase());
	}
	
	/**
	 * Get the argument that comes after the base command that this command reacts to
	 * @return
	 */
	public abstract String getCommandStart();
	
	/**
	 * Returns the correct help string for the reciever
	 * @param target The CommandSender that the help message is for
	 * @return The help message according to the permissions of the reciever
	 */
	public abstract String getHelp(CommandSender target);
	
	/**
	 * Execute a (sub)command if the conditions are met
	 * @param sender The commandSender that executed the command
	 * @param args The arguments that are given
	 * @param command The command to be executed
	 */
	public abstract void execute(CommandSender sender, Command command, String[] args);	
	
	
	
}
