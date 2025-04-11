package net.anoltongi.looted.item.custom;

import net.anoltongi.looted.sound.ModSounds;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LootBagItem extends Item {
    private final Identifier lootTableId;

    public LootBagItem(Settings settings, Identifier lootTableId) {
        super(settings);
        this.lootTableId = lootTableId;
    }
    /* We use the use method so we can run our code when the player right clicks with the item in their hand:
        First we create an ItemStack object, get the item in their hand. Then we check if it's happening in the server.
        We cast World into a ServerWorld so we can use methods like getServer() and whatnot. Since we already confirmed we are on the server side with if (!world.isCLient), it's all fine.
        Then the code looks for the corresponding loot table we have made with JSON files with getLootTable(lootTableId)
        We create a LootContextParameterSet, and add the position of the player and the player entity itself.
        Then we iterate through each loot in the according loot pool and try to put it into the player's inventory, if their inventory is full the items drop instead.
        Finally, we consume the loot bag by decrementing the stack.
    */

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient) {
            ServerWorld serverWorld = (ServerWorld) world;
            LootTable lootTable = serverWorld.getServer().getLootManager().getLootTable(lootTableId);

            LootContextParameterSet lootContext = new LootContextParameterSet.Builder(serverWorld)
                    .add(LootContextParameters.ORIGIN, user.getPos())
                    .add(LootContextParameters.THIS_ENTITY, user)
                    .build(LootContextTypes.COMMAND);

            List<ItemStack> loot = lootTable.generateLoot(lootContext);
            for (ItemStack item : loot) {
                if (!user.giveItemStack(item)) {
                    user.dropItem(item, false);
                }
            }
            stack.decrement(1);
            world.playSound(null, BlockPos.ofFloored(user.getPos()), ModSounds.LOOTBAG_OPENED,
                    SoundCategory.NEUTRAL, 1f, 1f);
        }
        return TypedActionResult.success(stack, world.isClient());
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
            tooltip.add(Text.translatable("tooltip.looted.loot_bag.tooltip"));
    }
}