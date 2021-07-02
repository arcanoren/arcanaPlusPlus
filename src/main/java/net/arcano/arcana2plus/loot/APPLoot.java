package net.arcano.arcana2plus.loot;

import net.arcano.arcana2plus.items.APPItems;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplier;
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class APPLoot {

    private static final Identifier ACACIA_LEAVES_ID = new Identifier("minecraft", "blocks/acacia_leaves");
    private static final Identifier BIRCH_LEAVES_ID = new Identifier("minecraft", "blocks/birch_leaves");
    private static final Identifier JUNGLE_LEAVES_ID = new Identifier("minecraft", "blocks/jungle_leaves");
    private static final Identifier SPRUCE_LEAVES_ID = new Identifier("minecraft", "blocks/spruce_leaves");


    private static final ArrayList<Block> shearables = new ArrayList<>();
    private static final ArrayList<Item> shears = new ArrayList<>();

    public static void initializeShearsLoot(@Nullable ArrayList<Block> shearable_blocks, @Nullable ArrayList<Item> shears_tools){

        if (shearable_blocks != null) {
            shearables.addAll(shearable_blocks);
        }
        if(shears_tools != null){
            shears.addAll(shears_tools);
        }
        initializeShearsLoot();
    }

    private static void initializeShearsLoot(){

        shearables.add(Blocks.ACACIA_LEAVES);
        shearables.add(Blocks.BIRCH_LEAVES);
        shearables.add(Blocks.DARK_OAK_LEAVES);
        shearables.add(Blocks.JUNGLE_LEAVES);
        shearables.add(Blocks.OAK_LEAVES);
        shearables.add(Blocks.SPRUCE_LEAVES);
        shearables.add(Blocks.GRASS);
        shearables.add(Blocks.TALL_GRASS);
        shearables.add(Blocks.FERN);
        shearables.add(Blocks.LARGE_FERN);
        shearables.add(Blocks.DEAD_BUSH);
        shearables.add(Blocks.SEAGRASS);
        shearables.add(Blocks.TALL_SEAGRASS);
        shearables.add(Blocks.NETHER_SPROUTS);
        shearables.add(Blocks.VINE);
        shearables.add(Blocks.COBWEB);

        shears.add(APPItems.FLINT_SHEARS);
        shears.add(APPItems.GOLDEN_SHEARS);
        shears.add(APPItems.DIAMOND_SHEARS);
        shears.add(APPItems.NETHERITE_SHEARS);

        lootHelper(shearables, shears);
    }

    private static void lootHelper(ArrayList<Block> blocks, ArrayList<Item> shears){

        for(Block block: blocks){
            String block_name = block.getName().toString();

            LootTableLoadingCallback.EVENT.register(((resourceManager, manager, id, supplier, setter) -> {
                if(block.getLootTableId().equals(id)){
                    FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder();
                    FabricLootSupplier refLoot = (FabricLootSupplier) supplier.build();

                    LootContextType contextType = refLoot.getType();
                    List<LootPool> pools = refLoot.getPools();
                    List<LootFunction> functions = refLoot.getFunctions();

                    replacement.type(contextType);

                    for (LootPool pool: pools){

                        replacement.withPool(pool);

                    }

                    for (Item shear:shears) {
                        LootCondition condition = MatchToolLootCondition.builder(
                                ItemPredicate.Builder.create().items(shear)).build();
                        //ItemPredicate.Builder.create().tag(FabricToolTags.SHEARS)).build();

                        ItemConvertible item;
                        int quantity;

                        if(block_name.contains("tall_seagrass")){
                            item = Items.SEAGRASS;
                            quantity = 2;
                        }else if(block_name.contains("large_fern")) {
                            item = Items.FERN;
                            quantity = 2;
                        } else{
                            item = block;
                            quantity = 1;
                        }

                        replacement.withPool(FabricLootPoolBuilder.builder()
                                .withEntry(ItemEntry.builder(item).build()).withCondition(condition)
                                .rolls(ConstantLootNumberProvider.create(quantity))
                                .build());

                    }

                    for (LootFunction function : functions) {
                        replacement.withFunction(function);
                    }

                    setter.set(replacement.build());
                }
            }));
        }
    }

    private static void leavesFruits(Identifier treeId, Item fruit){

        LootTableLoadingCallback.EVENT.register(((resourceManager, manager, id, supplier, setter) -> {
            if(treeId.equals(id)){

                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .withEntry(ItemEntry.builder(fruit).build())
                        .rolls(BinomialLootNumberProvider.create(1, 0.025f));

                supplier.withPool(poolBuilder.build());
            }
        }));

    }

    public static void allTreesDropFruits(){
        leavesFruits(ACACIA_LEAVES_ID, APPItems.GUAVA);
        leavesFruits(BIRCH_LEAVES_ID, APPItems.PEACH);
        leavesFruits(JUNGLE_LEAVES_ID, APPItems.MANGO);
        leavesFruits(SPRUCE_LEAVES_ID, APPItems.HAZELNUT);
    }
}
