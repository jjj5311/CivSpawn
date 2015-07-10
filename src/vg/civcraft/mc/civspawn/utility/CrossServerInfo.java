package vg.civcraft.mc.civspawn.utility;

import java.util.HashMap;

import vg.civcraft.mc.civspawn.CivSpawn;
import vg.civcraft.mc.mercury.MercuryPlugin;
import vg.civcraft.mc.namelayer.NameLayerPlugin;

public class CrossServerInfo {
	private CivSpawn plugin;
	private HashMap<String, String> servers; 
	
	public CrossServerInfo(CivSpawn instance){
		plugin = instance;
		servers = getOnlineServers();
	}
	
	public HashMap<String, String> getOnlineServers(){
		return servers; 
	}
	
	public void setServers(){
		servers = NameLayerPlugin.getOnlineAllServers();
	}
	
	public HashMap<String, Integer> requestPlayerCounts(){
		return null;
		//TODO have mercury send a query to each servers instance of CivSpawn to get playercount
	}
	
	public HashMap<String, Integer> requestServerTPS(){
		return null;
		//TODO have mercury send message to each server to get tps of each
	}
	
	public void sendMercuryMessage(String message){
		MercuryPlugin.handler.sendMessage("civspawn", message);
		plugin.getCivSpawnLogger().debug(this.getClass().getName(), "sendMercuryMessage", message);
	}
	
}
