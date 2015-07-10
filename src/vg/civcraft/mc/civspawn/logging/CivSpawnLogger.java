package vg.civcraft.mc.civspawn.logging;

import java.util.logging.Logger;


import vg.civcraft.mc.civspawn.CivSpawn;

public class CivSpawnLogger {
	private CivSpawn instance;
	private Logger log;
	
	public CivSpawnLogger(Logger instanceLogger, CivSpawn plugin){
		log = instanceLogger;
		instance = plugin;
	}
	
	public void info(String infoMessage){
		log.info(infoMessage);
	}
	
	public void warning(String errorMessage){
		log.warning(errorMessage);
	}
	
	public void severe(String severeMessage){
		log.severe(severeMessage);
	}
	
	public void debug(String debugClass, String debugMethod, String debugMessage){
		if(instance.getDebugEnabled()){
			//if debugging is enabled go ahead and make the debug message
			StringBuilder debugMsg = new StringBuilder();
			debugMsg.append("[DEBUG] CLASS=[");
			debugMsg.append(debugClass);
			debugMsg.append("] METHOD=[");
			debugMsg.append(debugMethod);
			debugMsg.append("] MESSAGE=[");
			debugMsg.append(debugMessage);
			debugMsg.append("]");
			log.info(debugMsg.toString());
			debugMsg.delete(0, debugMsg.length());
		}
	}
}
