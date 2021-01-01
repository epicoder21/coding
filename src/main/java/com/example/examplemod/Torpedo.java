//package com.example.examplemod;
//
//import net.minecraft.entity.EntityType;
//import net.minecraft.entity.MobEntity;
//import net.minecraft.entity.ai.attributes.AttributeModifierMap;
//import net.minecraft.entity.ai.attributes.Attributes;
//import net.minecraft.entity.ai.goal.RandomWalkingGoal;
//import net.minecraft.entity.monster.MonsterEntity;
//import net.minecraft.entity.monster.ZombieEntity;
//import net.minecraft.world.World;
//
//public class Torpedo extends ZombieEntity {
//    protected Torpedo(EntityType<? extends ZombieEntity> type, World worldIn) {
//        super(type, worldIn);
//    }
//
//    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
//        return MobEntity.func_233666_p_()
//                .createMutableAttribute(Attributes.MAX_HEALTH, 30D)
//                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 44)
//                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 5)
//                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.30)
//                .createMutableAttribute(Attributes.ATTACK_SPEED, 10)
//                .createMutableAttribute(Attributes.ARMOR, 2D);
//    }
//
//    @Override
//    protected void registerGoals() {
//        super.registerGoals();
//        this.goalSelector.addGoal(1,new RandomWalkingGoal(this, 5));
//    }
//}
