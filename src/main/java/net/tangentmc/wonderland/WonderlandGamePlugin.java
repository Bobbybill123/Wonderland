package net.tangentmc.wonderland;

import com.bergerkiller.bukkit.common.controller.EntityController;
import lombok.Getter;
import net.tangentmc.wonderland.entity.Entity;
import net.tangentmc.wonderland.entity.EntityBox;
import net.tangentmc.wonderland.listener.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
@Getter
public class WonderlandGamePlugin extends JavaPlugin {
	@Getter private static WonderlandGamePlugin instance;
	private List<Entity> entityList;
	@Override
	public void onDisable() {
		entityList.get(0).despawn();
	}

	@Override
	public void onEnable() {
		System.out.println(getServer().getWorlds().get(0).getSpawnLocation());
		instance = this;
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		entityList = new ArrayList<>();
		entityList.add(new EntityBox(getServer().getWorlds().get(0).getSpawnLocation().add(0, 0 ,1)));
		entityList.get(0).spawn();
	}
}