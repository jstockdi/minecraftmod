package com.minecraft.groovymod.item;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.minecraft.groovymod.GroovyMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemGroovyScoobySnack extends ItemFood{

	public static ScheduledExecutorService SCOOBYSNACK_EXECUTOR = Executors.newScheduledThreadPool(4);
	
	public ItemGroovyScoobySnack() {
		super(10,  //heal amount 
				0.9F,   //saturationModifier
				false  //isWolfsFavoriteMeat
				);
		
		setUnlocalizedName("GroovyScoobySnack")
		.setCreativeTab(CreativeTabs.tabFood)
		.setTextureName(GroovyMod.MODID + ":groovy_scoobysnack");
	}
	
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, final EntityPlayer player) {
		ItemStack itemStack = super.onEaten(stack, world, player);
		
		for(int i=0;i<5;i++){
			
			SCOOBYSNACK_EXECUTOR.schedule(new Runnable() {
				
				@Override
				public void run() {
					player.jump();
				}
			}, i, TimeUnit.SECONDS);
			
			player.addChatMessage(new ChatComponentText("Yum!  Yum!  Yum!  I love Rooby Racks"));
			player.extinguish();
		}
		
		return itemStack;
	}
}