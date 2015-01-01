package com.minecraft.groovymod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGlowstone;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import com.minecraft.groovymod.GroovyMod;

public class BlockGroovyDiscoball extends BlockGlowstone{

	public BlockGroovyDiscoball() {
		super(Material.glass);
		setHardness(0.3F);
		setStepSound(Block.soundTypeGlass);
		setLightLevel(1.0F);
		setBlockName("GroovyDiscoball");
		setBlockTextureName(GroovyMod.MODID + ":groovy_discoball");
		setCreativeTab(CreativeTabs.tabDecorations);
	}
	
}