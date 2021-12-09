package dte.inversearrow.events;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class ArrowHitPlayerEvent extends AbstractArrowEvent
{
	private final Player shooter, hit;
	
	private static final HandlerList HANDLERS = new HandlerList();
	
	public ArrowHitPlayerEvent(Arrow arrow, Player shooter, Player hit) 
	{
		super(arrow);
		
		this.shooter = shooter;
		this.hit = hit;
	}
	
	public Player getShooter()
	{
		return this.shooter;
	}

	public Player getHitPlayer() 
	{
		return this.hit;
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
