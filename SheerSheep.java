package me.IronCrystal.ColorSheep;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.inventory.ItemStack;

public class SheerSheep implements Listener{
	public static ColorSheep plugin;
	public SheerSheep(ColorSheep instance) 
	{
		plugin = instance;
	}

	@EventHandler
	public void onPlayerSheerSheepEvent (PlayerShearEntityEvent event)
	{
		Entity sheep = event.getEntity();
		final Random rg = new Random();
		Player player = event.getPlayer();

		if (plugin.shear == true)
		{
			if (sheep instanceof Sheep)
			{
				event.setCancelled(true);
				
				int durability = (player.getItemInHand().getDurability()) + 1;
				player.getItemInHand().setDurability((short) durability);
				int amount = rg.nextInt(5);

				if (amount == 1)
				{
					for (int count = 0; count < 3; count++)
					{
						World currentWorld = event.getPlayer().getWorld();

						ItemStack itemStack = new ItemStack(Material.WOOL, 1, (short)rg.nextInt(16));
						currentWorld.dropItem(event.getEntity().getLocation(), itemStack);
					}
				}
				else
				{
					for (int count = 0; count < 2; count++)
					{
						World currentWorld = event.getPlayer().getWorld();

						ItemStack itemStack = new ItemStack(Material.WOOL, 1, (short)rg.nextInt(16));
						currentWorld.dropItem(event.getEntity().getLocation(), itemStack);
					}
				}
				if(player.getItemInHand().getDurability() >= 238)
				{
					player.setItemInHand(null);
				}
			}
		}
		else
		{
			if (sheep instanceof Sheep)
			{
				event.setCancelled(true);
				Sheep s1 = (Sheep)event.getEntity();
				s1.setSheared(true);

				s1.setSheared(true);
				int durability = (player.getItemInHand().getDurability()) + 1;
				player.getItemInHand().setDurability((short) durability);
				int amount = rg.nextInt(5);

				if (amount == 1)
				{
					for (int count = 0; count < 3; count++)
					{
						World currentWorld = event.getPlayer().getWorld();

						ItemStack itemStack = new ItemStack(Material.WOOL, 1, (short)rg.nextInt(16));
						currentWorld.dropItem(event.getEntity().getLocation(), itemStack);
					}
				}
				else
				{
					for (int count = 0; count < 2; count++)
					{
						World currentWorld = event.getPlayer().getWorld();

						ItemStack itemStack = new ItemStack(Material.WOOL, 1, (short)rg.nextInt(16));
						currentWorld.dropItem(event.getEntity().getLocation(), itemStack);
					}
				}
				if(player.getItemInHand().getDurability() >= 238)
				{
					player.setItemInHand(null);
				}
			}
		}
	}
}

