package vg.civcraft.mc.civspawn.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import vg.civcraft.mc.civspawn.CivSpawn;
import vg.civcraft.mc.civspawn.managers.CivSpawnConfigManager;
import vg.civcraft.mc.civspawn.utility.MercuryMessageType;
import vg.civcraft.mc.mercury.MercuryAPI;
import vg.civcraft.mc.mercury.MercuryPlugin;
import vg.civcraft.mc.mercury.events.AsyncPluginBroadcastMessageEvent;

public class MercuryMessageListener implements Listener{

	private static CivSpawn plugin;
	private static CivSpawnConfigManager config;
	private static String seperator;
	private MercuryAPI mercAPI;
	private String serverName;
	
	public MercuryMessageListener(CivSpawn instance){
		plugin = instance;
		config = instance.getConfigManager();
		serverName = MercuryPlugin.name;
		seperator = config.getMercurySeperator();
		mercAPI = new MercuryAPI();
		mercAPI.registerPluginMessageChannel(instance, "civspawn");
	}
	
	@EventHandler
	public void handleMessage(AsyncPluginBroadcastMessageEvent event){
		if(!event.getChannel().equals("civspawn") || !event.getChannel().equals("all")){
			//ignore its not for civspawn
			return;
		}
		
		if(event.getChannel().equals("all")){
			if(event.getMessage().contains("login ")){
				//this is a login message from namelayer alerting each server a player logged in
				plugin.getCivSpawnLogger().debug(this.getClass().getName(), "handleMessage", "MercuryLoginNotice from NameLayer");
			}
		}
		
		if(event.getChannel().equals("civspawn")){
			//This is a message for us lets process it
			processCivSpawnMessage(event.getMessage());
		} 
		
	}

	private void processCivSpawnMessage(String message) {
		//Handle messages sent on the civspawn channel
		//message format messagetype sendingserverName messageinfo1,info2,info3...
		//messagetype: spawn_query, spawn_not_allowed, spawn_allowed, spawn_request, ...
			plugin.getCivSpawnLogger().debug(this.getClass().getName(), "processCivSpawnMessage", message);
			String[] msgParts = message.split("\\s+");
			
			MercuryMessageType messageType = MercuryMessageType.getmmType(msgParts[0]);
			String sendingServerName = msgParts[1];
			String[] messageReceived = msgParts[2].split(",");
			
			switch(messageType){
			case SPAWN_QUERY:
				//TODO ask servers to respond their loading
				if(!sendingServerName.equals(serverName)){
					//Make sure we didn't send the request
				}
				break;
			case SPAWN_QUERY_RESPONSE:
				//TODO recieve servers response
				break;
			case SPAWN_CROSS_SERVER:
				//TODO spawn player on another server
				break;
			case SPAWNED_PLAYER:
				//TODO announce that player was spawned in the world
				break;
			default:
				plugin.getCivSpawnLogger().warning("processCivSpawnMessage messageType was default");
				break;
			}
		}
	
	public void sendCivSpawnMessage(String messageType, String[] messageInfo){
		//TODO
		//format and send message according to message format above
		
	}
}
