package net.tangentmc.wonderland.entity;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class EntityBox extends Entity implements Listener {
	public EntityBox(Location location) {
		super(location, EntityType.BOX);
	}

	@Override
	public void playerCollision(Player player) {
		player.sendMessage("You collided with " + super.toString());
	}
}
