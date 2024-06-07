package com.crimsoncrips.farmersrevised.event;


import com.crimsoncrips.farmersrevised.FarmersRevised;

import com.crimsoncrips.farmersrevised.FarmersRevisedTagRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.function.Predicate;
import static net.minecraft.world.level.block.SculkShriekerBlock.CAN_SUMMON;

@Mod.EventBusSubscriber(modid = FarmersRevised.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FarmersRevisedEvents {

    @SubscribeEvent
    public void onBreak(BlockEvent.BreakEvent breakEvent){
        Player player = breakEvent.getPlayer();
        ServerLevel serverLevel = (ServerLevel) player.level();
        BlockPos blockPos = breakEvent.getPos();
        if(breakEvent.getState().is(FarmersRevisedTagRegistry.GRASS_LIKE_BLOCK) && player.isHolding(Ingredient.of(FarmersRevisedTagRegistry.HARVESTERS)) && Math.random() < 0.2){
           ItemStack straw = ModItems.STRAW.get().getDefaultInstance();
            ItemEntity strawEntity = new ItemEntity(serverLevel, blockPos.getX(), blockPos.getY(), blockPos.getZ(), straw);
            serverLevel.addFreshEntity(strawEntity);
        }
    }


}
