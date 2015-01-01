package com.minecraft.groovymod.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.minecraft.groovymod.GroovyMod;

public class ItemGroovyArmor extends ItemArmor {

	public ItemGroovyArmor(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_) {
		super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		
		if (stack.getItem() == GroovyMod.groovy_helmet || 
				stack.getItem() == GroovyMod.groovy_chestplate ||
				stack.getItem() == GroovyMod.groovy_boots) {
			return GroovyMod.MODID + ":textures/armor/groovy_layer_1.png";
		}else if (stack.getItem() == GroovyMod.groovy_leggings) {
			return GroovyMod.MODID + ":textures/armor/groovy_layer_2.png";
		}
		return null;
	}
}