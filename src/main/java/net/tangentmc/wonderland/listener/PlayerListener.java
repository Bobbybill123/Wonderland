package net.tangentmc.wonderland.listener;

import net.tangentmc.wonderland.WonderlandGamePlugin;
import net.tangentmc.wonderland.entity.Entity;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Optional;

public class PlayerListener implements Listener {
	private WonderlandGamePlugin main;

	public PlayerListener() {
		main = WonderlandGamePlugin.getInstance();
	}
	@EventHandler
	public void onLogin(PlayerJoinEvent e) {
		Bukkit.getServer().broadcastMessage(e.getPlayer().getName() + " has logged in!");
	}

	@EventHandler
	public void PlayerMoved(PlayerMoveEvent e) {
		main.getEntityList().stream()
				.filter(en -> en.getLocation().equals(e.getPlayer().getLocation()))
				.findFirst().ifPresent(entity -> entity.playerCollision(e.getPlayer())
		);
	}
}
