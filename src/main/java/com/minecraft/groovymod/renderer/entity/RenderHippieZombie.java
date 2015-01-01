package com.minecraft.groovymod.renderer.entity;

import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderHippieZombie extends RenderZombie{
	
	private static final ResourceLocation hippieZombieTextures = new ResourceLocation("textures/entity/hippiezombie/hippiezombie.png");
	
	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return hippieZombieTextures;
	}
}