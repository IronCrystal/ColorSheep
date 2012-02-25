package me.IronCrystal.ColorSheep;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ColorSheep extends JavaPlugin{

	public final Logger logger = Logger.getLogger("Minecraft");
	public static ColorSheep plugin;
	public final SheerSheep PlayerListener = new SheerSheep(this);
	boolean shear = false;

	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " is now disabled!");		
	}

	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled.");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this.PlayerListener, this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (sender instanceof Player)
		{
			Player player = (Player) sender;

			if(cmd.getName().equalsIgnoreCase("sheepnevershearon"))
			{
				if (player.hasPermission("ColorSheep.sheepnevershear"))
				{
					shear = true;
					player.sendMessage(ChatColor.GREEN + "Sheep will not lose their wool.");
					return true;
				}
				else
				{
					player.sendMessage(ChatColor.RED + "You do not have the proper permissions to use this command");
					return true;
				}
			}
			if(cmd.getName().equalsIgnoreCase("sheepnevershearoff"))
			{
				if (player.hasPermission("ColorSheep.sheepnevershear"))
				{
					shear = false;
					player.sendMessage(ChatColor.GREEN + "Sheep will lose their wool.");
					return true;
				}
				else
				{
					player.sendMessage(ChatColor.RED + "You do not have the proper permissions to use this command");
					return true;
				}
			}
		}
		return false;
	}

}
