package com.resaloli.eim.proxies;

import com.resaloli.eim.content.items.EIMItems;

public class ProxyClient extends ProxyServer{

	public static void registerRenders() {
		EIMItems.registerRenders();
	}

}
