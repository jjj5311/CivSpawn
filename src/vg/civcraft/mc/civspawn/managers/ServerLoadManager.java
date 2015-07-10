package vg.civcraft.mc.civspawn.managers;


import java.util.HashMap;

import vg.civcraft.mc.civspawn.CivSpawn;
import vg.civcraft.mc.civspawn.utility.Lag;

public class ServerLoadManager {
	private CivSpawn instance;
	private CivSpawnConfigManager config;
	private boolean allowSpawns = true;
	private int playerCount;
	private double tps;
	
	public ServerLoadManager(CivSpawn plugin){
		instance = plugin;
		config = instance.getConfigManager();
	}
	
	public String getStats() {
		fetchPlayerLoad();
		fetchTickLoad();
		StringBuilder sb = new StringBuilder();
		sb.append("playercount=");
		sb.append(playerCount);
		sb.append(",tps=");
		sb.append(tps);
		return sb.toString();
	}

	public void fetchPlayerLoad(){		
		playerCount = instance.getServer().getOnlinePlayers().size();
		StringBuilder sb = new StringBuilder();
		sb.append("Player Count: ");
		sb.append(playerCount);
		instance.getCivSpawnLogger().debug("ServerLoadManager", "fetchPlayerLoad", sb.toString());
		sb.delete(0, sb.length());
		allowSpawns = playerLimitReached();
	}
	
	public void fetchTickLoad(){
		tps = Lag.getTPS();
		StringBuilder sb = new StringBuilder();
		sb.append("Server Tick: ");
		sb.append(tps);
		instance.getCivSpawnLogger().debug("ServerLoadManager", "fetchTickLoad", sb.toString());
		sb.delete(0, sb.length());
	}
		
	public boolean playerLimitReached(){
		int maxPlayers = config.getMaxServerPlayers();
		if(playerCount > maxPlayers){
			return false;
		}
		return true;
	}
	
	public void determineSpawningServer(){
		//TODO
		//On player spawn event listen for other servers loading to see what is best
		//1. Capture mercury spawn messages from other servers and determine where to spawn player
		// Other servers will send serverName(string), TPS(string>double), PlayerCount(int), OverPlayerCount(boolean)
		
		
		//update our own stats
		getStats();
		
	}

}
