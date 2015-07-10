package vg.civcraft.mc.civspawn.managers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import vg.civcraft.mc.civspawn.CivSpawn;

//manage all the things
public class CivSpawnManager {
	private CivSpawn plugin;
	private CivSpawnConfigManager config;

	public CivSpawnManager(CivSpawn instance) {
		plugin = instance;
		config = plugin.getConfigManager();
	}

	public void spawnPlayer(Player player) {
		//Spawning a player on this server
		if(config.getSpawnNearOthers()){
			//spawn near others is true lets find a group of people
			int groupRadius = config.getPlayerGroupRadius();
			int minSpawnDist = config.getSpawnMinDist();
			int maxSpawnDist = config.getSpawnMaxDist();
			
			HashMap<Player, Location> playerList = new HashMap<Player, Location>();
			
			
		}
		
	}

}
