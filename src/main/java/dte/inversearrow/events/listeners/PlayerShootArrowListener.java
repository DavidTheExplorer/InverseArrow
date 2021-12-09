package dte.inversearrow.events.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

import dte.inversearrow.events.PlayerShootArrowEvent;

public class PlayerShootArrowListener implements Listener
{
	@EventHandler(priority = EventPriority.MONITOR)
	public void onArrowShoot(EntityShootBowEvent event) 
	{
		if(!(event.getProjectile() instanceof Arrow))
			return;
		
		Arrow arrow = (Arrow) event.getProjectile();
		
		if(!(arrow.getShooter() instanceof Player))
			return;
		
		Player shooter = (Player) arrow.getShooter();
		
		Bukkit.getPluginManager().callEvent(new PlayerShootArrowEvent(arrow, shooter));
	}
}
