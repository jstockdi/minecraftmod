package com.minecraft.groovymod.item;

import com.minecraft.groovymod.GroovyMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

public class ItemGroovyHoe extends ItemHoe{

	public ItemGroovyHoe() {
		super(GroovyMod.groovyToolMaterial);

		setUnlocalizedName("GroovyHoe");
		setCreativeTab(CreativeTabs.tabTools);
		setTextureName(GroovyMod.MODID + ":groovy_hoe");
	}

}