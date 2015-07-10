package vg.civcraft.mc.civspawn;


import vg.civcraft.mc.civmodcore.ACivMod;
import vg.civcraft.mc.civspawn.listeners.MercuryMessageListener;
import vg.civcraft.mc.civspawn.listeners.PlayerListener;
import vg.civcraft.mc.civspawn.logging.CivSpawnLogger;
import vg.civcraft.mc.civspawn.managers.CivSpawnConfigManager;
import vg.civcraft.mc.civspawn.managers.CivSpawnManager;
import vg.civcraft.mc.civspawn.utility.Lag;


public class CivSpawn extends ACivMod{

	private static CivSpawn instance;
	private static CivSpawnConfigManager config;
	private static PlayerListener playerListener;
	private static MercuryMessageListener mercuryListener;
	private static CivSpawnLogger logger;
	private static boolean isMercuryEnabled = false;
	private static boolean isWorldBorderEnabled = false;
	private static boolean isBastionsEnabled = false;
	private static CivSpawnManager spawnMan;
	private boolean debugEnabled = false;
	
	@Override
	public void onEnable(){
		super.onEnable();
		setInstance(this);
		setConfig(new CivSpawnConfigManager(instance.getConfig()));
		setLogger(new CivSpawnLogger(instance.getLogger(), instance));
		setPlayerListener(new PlayerListener(instance));
		setMercuryListener(new MercuryMessageListener(instance));
		setSpawnManager(new CivSpawnManager(instance));
		instance.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Lag(), 100L, 1L);
	}
	
	
	private void setSpawnManager(CivSpawnManager civSpawnManager) {
		CivSpawn.spawnMan = civSpawnManager;
	}


	public void onDisable(){
		//do on disable things
	}
	
	@Override
	protected String getPluginName(){
		return "CivSpawn";
	}
	
	public void registerEvents(){
		getServer().getPluginManager().registerEvents(playerListener, instance);
		setMercuryEnabled(getServer().getPluginManager().isPluginEnabled("Mercury"));
		setWorldBorderEnabled(getServer().getPluginManager().isPluginEnabled("WorldBorder"));
		setBastionEnabled(getServer().getPluginManager().isPluginEnabled("Bastion"));
		if(getMercuryEnabled()){
			this.getServer().getPluginManager().registerEvents(new MercuryMessageListener(instance), instance);
		}
	}

	public boolean getBastionEnabled() {
		return CivSpawn.isBastionsEnabled;
	}


	public void setBastionEnabled(boolean pluginEnabled) {
		CivSpawn.isBastionsEnabled = pluginEnabled;
	}


	public boolean getWorldBorderEnabled() {
		return CivSpawn.isWorldBorderEnabled;
	}


	public void setWorldBorderEnabled(boolean pluginEnabled) {
		CivSpawn.isWorldBorderEnabled = pluginEnabled;
		
	}


	public boolean getMercuryEnabled() {
		return CivSpawn.isMercuryEnabled;
	}


	public void setMercuryEnabled(boolean pluginEnabled) {
		CivSpawn.isMercuryEnabled = pluginEnabled;
	}


	public static CivSpawn getInstance() {
		return instance;
	}

	public static void setInstance(CivSpawn instance) {
		CivSpawn.instance = instance;
	}

	public CivSpawnConfigManager getConfigManager(){
		return CivSpawn.config;
	}
	
	public CivSpawnManager getCivSpawnManager(){
		return CivSpawn.spawnMan;
	}
	
	public static void setConfig(CivSpawnConfigManager configMan){
		CivSpawn.config = configMan;
	}
	public PlayerListener getPlayerListener(){
		return CivSpawn.playerListener;
	}
	
	public static void setPlayerListener(PlayerListener listener){
		CivSpawn.playerListener = listener;
	}
	
	public MercuryMessageListener getMercuryListener(){
		return CivSpawn.mercuryListener;
	}
	
	public static void setMercuryListener(MercuryMessageListener mListener){
		CivSpawn.mercuryListener = mListener;
	}
	
	public boolean getDebugEnabled(){
		return instance.debugEnabled;
	}
	
	public static void setDebugEnabled(boolean debug){
		instance.debugEnabled = debug;
	}
	
	public static void setLogger(CivSpawnLogger civSpawnLogger){
		CivSpawn.logger = civSpawnLogger;
	}
	
	public CivSpawnLogger getCivSpawnLogger(){
		return CivSpawn.logger;
	}
	
}
