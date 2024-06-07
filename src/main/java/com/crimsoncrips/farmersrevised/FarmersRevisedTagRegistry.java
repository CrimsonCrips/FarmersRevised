package com.crimsoncrips.farmersrevised;



import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;


public class FarmersRevisedTagRegistry {
    public static final TagKey<Block> GRASS_LIKE_BLOCK = registerBlockTag("grasslike_blocks");

    public static final TagKey<Item> HARVESTERS = registerItemTag("straw_harvesters");



    public FarmersRevisedTagRegistry() {
    }

    private static TagKey<Item> registerItemTag(String name) {
        return TagKey.create(Registries.ITEM, new ResourceLocation("farmersdelight", name));
    }

    private static TagKey<Block> registerBlockTag(String name) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation("farmersrevised", name));
    }


}
