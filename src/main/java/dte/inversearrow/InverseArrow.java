package dte.inversearrow;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

import dte.inversearrow.events.ArrowHitPlayerEvent;
import dte.inversearrow.events.PlayerShootArrowEvent;
import dte.inversearrow.events.listeners.ArrowHitPlayerListener;
import dte.inversearrow.events.listeners.PlayerShootArrowListener;

//TODO: add an amount of arrows that the plugin will be activated BELOW.
public class InverseArrow extends JavaPlugin implements Listener
{
	private final Map<Arrow, ItemStack> arrowsItems = new HashMap<>();

	@Override
	public void onEnable() 
	{
		//register custom event(Player & Arrow interaction) listeners
		Bukkit.getPluginManager().registerEvents(new PlayerShootArrowListener(), this);
		Bukkit.getPluginManager().registerEvents(new ArrowHitPlayerListener(), this);

		Bukkit.getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onArrowShoot(PlayerShootArrowEvent event) 
	{
		Player shooter = event.getShooter();
		Arrow arrow = event.getArrow();

		if(shooter.getGameMode() == GameMode.CREATIVE)
			return;

		this.arrowsItems.put(arrow, findArrow(shooter.getInventory()));
	}

	@EventHandler
	public void onArrowHit(ArrowHitPlayerEvent event) 
	{
		Arrow arrow = event.getArrow();
		Player shooter = event.getShooter();

		if(!shooter.hasPermission("inversearrow.active"))
			return;
		
		/*
		 * If the EntityShootBowEvent had been cancelled, the shooter was on Creative, or it generated an Exception prior to registering the arrow:
		 * The arrow return will fail silently.
		 */
		if(!this.arrowsItems.containsKey(arrow))
			return;

		shooter.getInventory().addItem(this.arrowsItems.remove(arrow));
	}

	//EntityShootBowEvent#getConsumable wasn't used in order to support all versions
	private static ItemStack findArrow(PlayerInventory inventory) 
	{
		ItemStack arrow = new ItemStack(inventory.getItem(inventory.first(Material.ARROW)));
		arrow.setAmount(1);

		return arrow;
	}
}
