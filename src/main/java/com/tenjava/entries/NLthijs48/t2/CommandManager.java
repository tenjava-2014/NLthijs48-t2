package com.tenjava.entries.NLthijs48.t2;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.tenjava.entries.NLthijs48.t2.Commands.AddLevelCommand;
import com.tenjava.entries.NLthijs48.t2.Commands.GRCommand;
import com.tenjava.entries.NLthijs48.t2.Commands.HelpCommand;

public class CommandManager implements CommandExecutor {
	GravityReversal plugin;
	ArrayList<GRCommand> commands;
	
	public CommandManager(GravityReversal plugin) {
		this.plugin = plugin;
		commands = new ArrayList<GRCommand>();
		// Adding commands
		commands.add(new HelpCommand(plugin));
		commands.add(new AddLevelCommand(plugin));
		
		// Register commands in bukkit
		plugin.getCommand("GR").setExecutor(this);	
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
		boolean executed = false;		
		for(int i=0; i<commands.size() && !executed; i++) {
			if(commands.get(i).canExecute(command, args)) {
				commands.get(i).execute(sender, command, args);
				executed = true;
			}
		}
		if(!executed && args.length == 0) {
			this.showHelp(sender);
		} else if(!executed && args.length > 0) {
			plugin.message(sender, "cmd-notValid");
		}
		return true;
	}
	
	/**
	 * Shows the help page for the CommandSender
	 * @param target The CommandSender to show the help to
	 */
	public void showHelp(CommandSender target) {
		/* Add all messages to a list */
		ArrayList<String> messages = new ArrayList<String>();
		messages.add(plugin.getConfig().getString("chatPrefix") + plugin.getLanguageManager().getLang("help-header"));
		messages.add(plugin.getConfig().getString("chatPrefix") + plugin.getLanguageManager().getLang("help-alias"));
		for(GRCommand command : commands) {
			String help = command.getHelp(target);
			if(help != null && help.length() != 0) {
				messages.add(help);
			}
		}
		
		/* Send the messages to the target */
		for(String message : messages) {
			target.sendMessage(plugin.fixColors(message));
		}
	}

}
