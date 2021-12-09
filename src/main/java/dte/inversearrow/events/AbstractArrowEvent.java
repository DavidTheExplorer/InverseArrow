package dte.inversearrow.events;

import org.bukkit.entity.Arrow;
import org.bukkit.event.Event;

public abstract class AbstractArrowEvent extends Event
{
	private final Arrow arrow;
	
	public AbstractArrowEvent(Arrow arrow) 
	{
		this.arrow = arrow;
	}
	
	public Arrow getArrow()
	{
		return this.arrow;
	}
}