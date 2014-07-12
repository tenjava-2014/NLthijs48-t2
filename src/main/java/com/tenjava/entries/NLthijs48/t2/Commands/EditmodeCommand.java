package com.tenjava.entries.NLthijs48.t2.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.tenjava.entries.NLthijs48.t2.GravityReversal;

public class EditmodeCommand extends GRCommand {

	
	public EditmodeCommand(GravityReversal plugin) {
		super(plugin);
	}

	@Override
	public String getCommandStart() {
		return "GR editmode";
	}

	@Override
	public String getHelp(CommandSender target) {
		if(target.hasPermission("gravityreversal.admin")) {
			return plugin.getLanguageManager().getLang("help-editmode");
		}
		return null;
	}

	@Override
	public void execute(CommandSender sender, Command command, String[] args) {
		// TODO Auto-generated method stub
		
	}

}
