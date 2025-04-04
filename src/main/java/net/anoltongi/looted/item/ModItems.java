package net.anoltongi.looted.item;

import net.anoltongi.looted.item.custom.LootBagItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.anoltongi.looted.Looted;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

    //Just registering the loot bags, nothing too crazy. We provide the loot table of the loot bag while registering so it can refer to the correct pool when consumed.
    //Also, we are using the vanilla system for rarities, so nothing custom here as well.
    public static final Item COMMON_LOOT_BAG = registerItem("loot_bag_common", new LootBagItem(
            new FabricItemSettings().rarity(Rarity.COMMON).maxCount(16), new Identifier("looted", "loot_bags/loot_bag_common")));
    public static final Item UNCOMMON_LOOT_BAG = registerItem("loot_bag_uncommon", new LootBagItem(
            new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(16), new Identifier("looted", "loot_bags/loot_bag_uncommon")));
    public static final Item RARE_LOOT_BAG = registerItem("loot_bag_rare", new LootBagItem(
            new FabricItemSettings().rarity(Rarity.RARE).maxCount(16), new Identifier("looted", "loot_bags/loot_bag_rare")));
    public static final Item EPIC_LOOT_BAG = registerItem("loot_bag_epic", new LootBagItem(
            new FabricItemSettings().rarity(Rarity.EPIC).maxCount(16), new Identifier("looted", "loot_bags/loot_bag_epic")));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Looted.MOD_ID, name), item);
    }

    /*private static void itemGroupFunctional(FabricItemGroupEntries entries) {
        entries.add(COMMON_LOOT_BAG);
        entries.add(UNCOMMON_LOOT_BAG);
        entries.add(RARE_LOOT_BAG);
        entries.add(EPIC_LOOT_BAG);
    }*/

    public static void registerModItems() {
        Looted.LOGGER.info("Registering Mod Items for " + Looted.MOD_ID);

    }
}