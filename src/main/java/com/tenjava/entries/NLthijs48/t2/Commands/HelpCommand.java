package com.tenjava.entries.NLthijs48.t2.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.tenjava.entries.NLthijs48.t2.GravityReversal;

public class HelpCommand extends GRCommand {

	public HelpCommand(GravityReversal plugin) {
		super(plugin);
	}

	@Override
	public String getCommandStart() {
		return "GR help";
	}

	@Override
	public String getHelp(CommandSender target) {
		if(target.hasPermission("gravityreversal.help")) {
			return plugin.getLanguageManager().getLang("help-help");
		}
		return null;
	}

	@Override
	public void execute(CommandSender sender, Command command, String[] args) {
		plugin.getCommandManager().showHelp(sender);		
	}

}
