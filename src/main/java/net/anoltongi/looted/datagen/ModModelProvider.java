package net.anoltongi.looted.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.anoltongi.looted.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.COMMON_LOOT_BAG, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNCOMMON_LOOT_BAG, Models.GENERATED);
        itemModelGenerator.register(ModItems.RARE_LOOT_BAG, Models.GENERATED);
        itemModelGenerator.register(ModItems.EPIC_LOOT_BAG, Models.GENERATED);

    }
}
