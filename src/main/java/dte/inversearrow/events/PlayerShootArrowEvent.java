package dte.inversearrow.events;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class PlayerShootArrowEvent extends AbstractArrowEvent
{
	private static final HandlerList HANDLERS = new HandlerList();
	
	private final Player shooter;
	
	public PlayerShootArrowEvent(Arrow arrow, Player shooter) 
	{
		super(arrow);
		
		this.shooter = shooter;
	}
	
	public Player getShooter() 
	{
		return this.shooter;
	}
	
	@Override
	public HandlerList getHandlers() 
	{
		return HANDLERS;
	}
	
	public static HandlerList getHandlerList() 
	{
		return HANDLERS;
	}
}
