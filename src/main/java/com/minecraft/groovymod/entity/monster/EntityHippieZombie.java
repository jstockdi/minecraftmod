package com.minecraft.groovymod.entity.monster;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import com.minecraft.groovymod.GroovyMod;

public class EntityHippieZombie extends EntityZombie{

	public static final int ID = 117;

	public EntityHippieZombie(World world) {
		super(world);
	}
	
	@Override
	public IEntityLivingData onSpawnWithEgg(
			IEntityLivingData par1EntityLivingData) {
		IEntityLivingData onSpawnWithEgg = super.onSpawnWithEgg(par1EntityLivingData);
		setVillager(false);
		return onSpawnWithEgg;
	}
	
	@Override
	protected Item getDropItem() {
		return GroovyMod.item_scoobysnack;
	}
	
	@Override
	protected void dropRareDrop(int par1) {
		switch (this.rand.nextInt(4))
        {
            case 0:
                this.dropItem(Items.diamond_chestplate, 1);
                break;
            case 1:
            	this.dropItem(Items.diamond_boots, 1);
                break;
            case 2:
            	this.dropItem(Items.diamond_leggings, 1);
                break;
            case 3:
            	this.dropItem(Items.diamond_helmet, 1);
                break;
        }	
	}
	
	
	@Override
	protected void addRandomArmor() {
		
		int count = 0;
		for(Item item : new Item[]{
				Items.diamond_sword, 
				Items.diamond_helmet, 
				Items.diamond_chestplate, 
				Items.diamond_leggings, 
				Items.diamond_boots}){
			if (this.rand.nextFloat() < (this.worldObj.difficultySetting == EnumDifficulty.HARD ? 0.5F : 0.25F)) {
				this.setCurrentItemOrArmor(count++, new ItemStack(item));
			}	
		}
	}
	
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(80.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
	}
}