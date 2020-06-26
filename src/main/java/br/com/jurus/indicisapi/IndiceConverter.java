package br.com.jurus.indicisapi;

import java.util.HashMap;
import java.util.Map;

public class IndiceConverter {
	
private static HashMap<String, Integer> mapindices;
	
	static {
		mapindices= new HashMap<String, Integer>();
		mapindices.put("cdi", 1);
		mapindices.put("difuturo", 2);
		mapindices.put("ipca", 3);
		mapindices.put("ipcaindice", 4);
		mapindices.put("ipcamensal", 5);
		mapindices.put("cdifator", 6);
	}
	
	public static Integer convertTpIndice(String tpindice) {
		if(!mapindices.containsKey(tpindice)) {
			return -1;
		}
		return mapindices.get(tpindice);
	}


}
