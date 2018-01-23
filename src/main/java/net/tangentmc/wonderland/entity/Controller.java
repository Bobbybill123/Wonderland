package net.tangentmc.wonderland.entity;

import com.bergerkiller.bukkit.common.controller.EntityController;
import com.bergerkiller.bukkit.common.entity.CommonEntity;
import com.bergerkiller.bukkit.common.utils.FaceUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Controller extends EntityController<CommonEntity<ArmorStand>> {
	@Override
	public boolean onEntityCollision(Entity e) {
		System.out.println("collided");
		if(!(e instanceof Player)) return false;
		Player p = ((Player) e);
		Location eLoc = getEntity().getLocation();
		BlockFace face = FaceUtil.getDirection(p.getLocation().subtract(eLoc).toVector(), false);
		getEntity().getEntity().teleport(eLoc.add(FaceUtil.faceToVector(face)));
		return true;
	}
}
