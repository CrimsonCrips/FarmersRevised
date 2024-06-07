package com.crimsoncrips.farmersrevised.mixins;



import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.crafting.Ingredient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;


@Mixin(Pig.class)

public class PigMixin {

    @ModifyVariable(method = "<clinit>", at = @At(value = "STORE"), ordinal = 0)
    private static Ingredient injectMyIngredient(Ingredient original) {
        return Ingredient.of(Items.CARROT, Items.POTATO, Items.BEETROOT);
    }



}
