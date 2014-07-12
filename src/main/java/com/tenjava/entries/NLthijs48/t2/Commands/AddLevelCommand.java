package com.tenjava.entries.NLthijs48.t2.Commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.tenjava.entries.NLthijs48.t2.GravityReversal;
import com.tenjava.entries.NLthijs48.t2.Level;

public class AddLevelCommand extends GRCommand {

	public AddLevelCommand(GravityReversal plugin) {
		super(plugin);
	}

	@Override
	public String getCommandStart() {
		return "GR addlevel";
	}

	@Override
	public String getHelp(CommandSender target) {
		if(target.hasPermission("gravityreversal.admin")) {
			return plugin.getLanguageManager().getLang("help-addlevel");
		}
		return null;
	}

	@Override
	public void execute(CommandSender sender, Command command, String[] args) {
		if(!sender.hasPermission("gravityreversal.admin")) {
			plugin.message(sender, "addlevel-noPermission");
			return;
		}
		if(!(sender instanceof Player)) {
			plugin.message(sender, "notFromConsole");
			return;
		}
		Player player = (Player)sender;
		if(args.length < 1) {
			plugin.message(sender, "addlevel-help");
			return;
		}
		Level level = new Level(args[0]);
		plugin.getArena().addLevel(level);
		plugin.message(sender, "addlevel-blocksstart");
		HashMap<String, String> info = new HashMap<String, String>();
		info.put("level", level.getName());
		info.put("number", ""+0);
		plugin.getLevelSetupMap().put(player.getUniqueId(), info);	
	}

}
















