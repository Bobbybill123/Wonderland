package net.tangentmc.wonderland.entity;

import lombok.Getter;
import org.bukkit.Material;

@Getter
public enum EntityType {
	BOX(Material.WOOD), BOULDER(Material.COBBLESTONE), ENEMY(Material.CACTUS), PLAYER(Material.BARRIER);

	Material material;
	EntityType(Material material) {
		this.material = material;
	}
}
