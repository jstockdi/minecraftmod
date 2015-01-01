package com.minecraft.groovymod.item;

import com.minecraft.groovymod.GroovyMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ItemGroovySword extends ItemSword{

	public ItemGroovySword() {
		super(GroovyMod.groovyToolMaterial);

		setUnlocalizedName("GroovySword");
		setCreativeTab(CreativeTabs.tabCombat);
		setTextureName(GroovyMod.MODID + ":groovy_sword");
	}
}