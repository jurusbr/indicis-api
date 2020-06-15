package br.com.jurus.indicisapi;

import java.util.HashMap;
import java.util.Map;

public class IndiceConverter {
	
private static Map<String, Integer> tpindices;
	
	static {
		tpindices= new HashMap<String, Integer>();
		tpindices.put("cdi", 1);
		tpindices.put("difuturo", 2);
		tpindices.put("ipca", 3);
		tpindices.put("ipcaindice", 4);
		tpindices.put("ipcamensal", 5);
		tpindices.put("cdifator", 6);
	}
	
	public static Integer convertTpIndice(String tpindice) {
		return tpindices.get(tpindice);
	}


}
