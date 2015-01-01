package com.minecraft.groovymod.item;

import java.util.Random;

import com.minecraft.groovymod.GroovyMod;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGroovyPickaxe extends ItemPickaxe{

	public ItemGroovyPickaxe() {
		super(GroovyMod.groovyToolMaterial);
	}
	
	 @Override
	public boolean onBlockDestroyed(ItemStack itemStack,
			World world, Block block, int p_150894_4_,
			int p_150894_5_, int p_150894_6_, EntityLivingBase entityLivingBase) {
		 
		 //5% of the time drop a diamond if the block was coal
		 if(!world.isRemote && 1 == new Random().nextInt(20) && "tile.oreCoal".equals(block.getUnlocalizedName())){
			 EntityItem dropItem = entityLivingBase.entityDropItem(new ItemStack(Items.diamond), 1.0F);
		 }

		return super.onBlockDestroyed(itemStack, world, block,
				p_150894_4_, p_150894_5_, p_150894_6_, entityLivingBase);
	}

}