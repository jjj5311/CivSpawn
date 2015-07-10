package vg.civcraft.mc.civspawn.managers;

import org.bukkit.configuration.file.FileConfiguration;

public class CivSpawnConfigManager {
	
	private static FileConfiguration config;
	
	public CivSpawnConfigManager(FileConfiguration pluginConfig){
		config = pluginConfig;
	}
	
	public boolean getDebugEnabled(){
		return config.getBoolean("info.debug");
	}
	
	public boolean getSpawnWorlds(){
		return config.getBoolean("SpawnConfig.Worlds");
	}
	
	public boolean getSpawnNether(){
		return config.getBoolean("SpawnConfig.Worlds.Nether");
	}
	
	public boolean getSpawnEnd(){
		return config.getBoolean("SpawnConfig.Worlds.End");
	}
	
	public String getSpawnMessage(){
		return config.getString("info.SpawnMessage");
	}
	
	public boolean getSpawnNearOthers(){
		return config.getBoolean("SpawnConfig.SpawnNearOthers");
	}
	
	public int getSpawnMinDist(){
		return config.getInt("SpawnConfig.SpawnNearOthers.MinDist");
	}

	public int getSpawnMaxDist(){
		return config.getInt("SpawnConfig.SpawnNearOthers.MaxDist");
	}
	
	public int getPlayerGroupThreshold(){
		return config.getInt("SpawnConfig.SpawnNearOthers.PlayerGroupCount");	
	}
	
	public int getPlayerGroupRadius(){
		return config.getInt("SpawnConfig.SpawnNearOthers.PlayerGroupRadius");
	}
	
	public boolean getServerLoadEnabled(){
		return config.getBoolean("SpawnConfig.ServerChoice");
	}
	
	public int getMaxServerPlayers(){
		return config.getInt("SpawnConfig.ServerChoice.MaxServerPlayers");
	}
	
	public int getServerTPSThreshold(){
		return config.getInt("SpawnConfig.ServerChoice.ServerTPSThreshold");
	}
}


