package net.tangentmc.wonderland.entity;

import com.bergerkiller.bukkit.common.controller.DefaultEntityController;
import com.bergerkiller.bukkit.common.controller.EntityController;
import com.bergerkiller.bukkit.common.entity.CommonEntity;
import lombok.Getter;
import lombok.Singular;
import net.tangentmc.wonderland.WonderlandGamePlugin;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.entity.EntityType.ARMOR_STAND;


public abstract class Entity {
	private WonderlandGamePlugin main;
	private ArmorStand as;
	@Getter private Location location;
	@Getter private EntityType type;
	private EntityController<CommonEntity<ArmorStand>> controller;

	Entity(Location location, EntityType type) {
		main = WonderlandGamePlugin.getInstance();
		controller = new Controller();
		this.location = location;
		this.type = type;
	}

	public void spawn() {
		as = (ArmorStand) location.getWorld().spawnEntity(location, ARMOR_STAND);
		as.setHelmet(new ItemStack(type.getMaterial(), 1));
		as.setVisible(false);
		as.setInvulnerable(true);
		main.getEntityList().add(this);
		new CommonEntity<>(as).setController(controller);
	}

	public void despawn() {
		as.remove();
		main.getEntityList().remove(this);
	}

	@Override
	public String toString() {
		return "Entity{" + location + ", " + type + '}';
	}

	public abstract void playerCollision(Player player);
}
