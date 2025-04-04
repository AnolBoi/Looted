package net.anoltongi.looted.item;

import net.anoltongi.looted.Looted;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup LOOT_BAG_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Looted.MOD_ID, "loot_bag_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.loot_bag_group"))
                    .icon(() -> new ItemStack(ModItems.EPIC_LOOT_BAG)).entries((displayContext, entries) -> {
                        entries.add(ModItems.COMMON_LOOT_BAG);
                        entries.add(ModItems.UNCOMMON_LOOT_BAG);
                        entries.add(ModItems.RARE_LOOT_BAG);
                        entries.add(ModItems.EPIC_LOOT_BAG);
                    }).build());

    public static void registerItemGroups() {

    }
}
