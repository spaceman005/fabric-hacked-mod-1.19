package net.ethan.learnmod;

import net.ethan.learnmod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LearnMod implements ModInitializer {
	public static final String MOD_ID = "learnmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void onInitialize() {
		//fly hack
		ClientTickEvents.START_CLIENT_TICK.register(client -> {
			FlyHack.tick(client);
		});
		//legit
		ModItems.registerModItems();
	}
}
