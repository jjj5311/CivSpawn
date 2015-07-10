package vg.civcraft.mc.civspawn.listeners;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import vg.civcraft.mc.civspawn.CivSpawn;
import vg.civcraft.mc.civspawn.managers.CivSpawnConfigManager;
import vg.civcraft.mc.civspawn.managers.CivSpawnManager;

public class PlayerListener implements Listener {
	private CivSpawn plugin;
	private CivSpawnManager spawnMan;
	private CivSpawnConfigManager config;
	
	public PlayerListener(CivSpawn instance) {
		plugin = instance;
		spawnMan = plugin.getCivSpawnManager();
		config = plugin.getConfigManager();
	}
	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event){
		Player player = event.getPlayer();
		World world = player.getWorld();
		if(config.getSpawnWorlds()){
			//spawn modification is on for more than just the overworld
			if(config.getSpawnNether()){
				//modify spawning in the nether
			}
			if(config.getSpawnEnd()){
				//modify end spawning
			}
			
		}
		//if mercury is not enabled spawn the player on our server like there are no other servers
		if(!plugin.getMercuryEnabled()){
			//mercury is not enabled no cross server
			
			spawnMan.spawnPlayer(player);
		}
		//TODO 1. Make sure all servers have reported spawn/no-spawn status
		//     2. determine server to spawn
		//     3. Spawn player in correct server/location
	}
	
	@EventHandler
	public void onPlayerTeleport(PlayerTeleportEvent event){
		//TODO 1. Ensure player teleports to ground level
	}
	
	@EventHandler
	public void onEntityDamageEvent(EntityDamageEvent event){
		//TODO Be sure we arent killing player we just spawned
	}
	
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event){
		//TODO check if player has a set spawn location from bed otherwise random spawn them
		
	}
	
	@EventHandler
	public void onPlayerWorldChange(PlayerChangedWorldEvent event){
		//TODO I think civcraft does not need to check this
	}

}
