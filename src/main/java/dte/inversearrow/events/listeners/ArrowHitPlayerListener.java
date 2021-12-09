package dte.inversearrow.events.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import dte.inversearrow.events.ArrowHitPlayerEvent;

public class ArrowHitPlayerListener implements Listener
{
	@EventHandler(priority = EventPriority.MONITOR)
	public void onArrowHit(ProjectileHitEvent event)
	{
		if(!(event.getEntity() instanceof Arrow) || !(event.getEntity().getShooter() instanceof Player) || !(event.getHitEntity() instanceof Player))
			return;
		
		Arrow arrow = (Arrow) event.getEntity();
		Player shooter = (Player) arrow.getShooter();
		Player hit = (Player) event.getHitEntity();
		
		Bukkit.getPluginManager().callEvent(new ArrowHitPlayerEvent(arrow, shooter, hit));
	}
}
