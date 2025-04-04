package net.anoltongi.looted;

import net.anoltongi.looted.item.ModItemGroup;
import net.anoltongi.looted.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Looted implements ModInitializer {
	public static final String MOD_ID = "looted";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroup.registerItemGroups();
	}
}