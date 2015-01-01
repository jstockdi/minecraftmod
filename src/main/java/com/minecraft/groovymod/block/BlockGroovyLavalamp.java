package com.minecraft.groovymod.block;

import java.util.Random;

import com.minecraft.groovymod.GroovyMod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGroovyLavalamp extends BlockTorch {

	
	public BlockGroovyLavalamp() {
		setBlockTextureName(GroovyMod.MODID + ":groovy_lavalamp");
		setHardness(0.0F);
		setCreativeTab(CreativeTabs.tabDecorations);
		setLightLevel(0.9999F);
		setStepSound(Block.soundTypeAnvil);
		setBlockName("GroovyLavalamp");
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		
		int l = world.getBlockMetadata(x, y, z);
        double d0 = (double)((float)x + 0.5F);
        double d1 = (double)((float)y + 0.7F);
        double d2 = (double)((float)z + 0.5F);
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;

    	world.spawnParticle("slime", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
    	
	}
	
	public void setFire(Entity entity){
		entity.setFire(new Random().nextInt(10));
	}
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		setFire(entity);
	}
	
	@Override
	public void onFallenUpon(World world, int x, int y, int z,
			Entity entity, float p_149746_6_) {
		setFire(entity);
		
	}
}