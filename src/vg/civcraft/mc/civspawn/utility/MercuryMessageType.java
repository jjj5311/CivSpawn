package vg.civcraft.mc.civspawn.utility;

public enum MercuryMessageType {
	//spawn_query, spawn_not_allowed, spawn_allowed, spawn_request, ..
	SPAWN_QUERY,
	SPAWN_QUERY_RESPONSE,
	SPAWN_CROSS_SERVER,
	SPAWNED_PLAYER;

	public static MercuryMessageType getmmType(String string) {
		MercuryMessageType returnType = null;
		try{
			returnType = MercuryMessageType.valueOf(string.toUpperCase());
		} catch (IllegalArgumentException e){}
		return returnType;
	}
}
