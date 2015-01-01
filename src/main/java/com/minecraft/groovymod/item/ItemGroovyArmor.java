package com.minecraft.groovymod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.minecraft.groovymod.GroovyMod;

public class ItemGroovyArmor extends ItemArmor {
	
	
	public enum GroovyArmorType{
		helmet(0),
		chestplate(1),
		legs(2),
		boots(3);
		
		private int typeNum;

		private GroovyArmorType(int typeNum) {
			this.typeNum = typeNum;
		}
		
		public int getTypeNum() {
			return typeNum;
		}
	}

	public static Item newBoots() {
		return new ItemGroovyArmor(GroovyMod.groovyArmorMaterial, 3, GroovyArmorType.boots.getTypeNum())
		 .setUnlocalizedName("GroovyBoots")
		 .setCreativeTab(CreativeTabs.tabCombat)
		 .setTextureName(GroovyMod.MODID + ":groovy_boots");
	}

	public static Item newChestplate() {
		return new ItemGroovyArmor(GroovyMod.groovyArmorMaterial, 1, GroovyArmorType.chestplate.getTypeNum())
		 .setUnlocalizedName("GroovyChestplate")
		 .setCreativeTab(CreativeTabs.tabCombat)
		 .setTextureName(GroovyMod.MODID + ":groovy_chestplate");
	}

	public static Item newHelmet() {
		return new ItemGroovyArmor(GroovyMod.groovyArmorMaterial, 0, GroovyArmorType.helmet.getTypeNum())
		 .setUnlocalizedName("GroovyHelmet")
		 .setCreativeTab(CreativeTabs.tabCombat)
		 .setTextureName(GroovyMod.MODID + ":groovy_helmet");
	}

	public static Item newLeggings() {
		return new ItemGroovyArmor(GroovyMod.groovyArmorMaterial, 2, GroovyArmorType.legs.getTypeNum())
		 .setUnlocalizedName("GroovyLeggings")
		 .setCreativeTab(CreativeTabs.tabCombat)
		 .setTextureName(GroovyMod.MODID + ":groovy_leggings");
	}

	public ItemGroovyArmor(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_) {
		super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		
		if (stack.getItem() == GroovyMod.item_helmet || 
				stack.getItem() == GroovyMod.item_chestplate || 
				stack.getItem() == GroovyMod.item_boots) {
			return GroovyMod.MODID + ":textures/armor/groovy_layer_1.png";
		}else if (stack.getItem() == GroovyMod.item_leggings) {
			return GroovyMod.MODID + ":textures/armor/groovy_layer_2.png";
		}
		return null;
	}
}