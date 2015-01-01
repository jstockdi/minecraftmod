package com.minecraft.groovymod;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import com.minecraft.groovymod.block.BlockGroovyDiscoball;
import com.minecraft.groovymod.block.BlockGroovyLavalamp;
import com.minecraft.groovymod.entity.monster.EntityHippieZombie;
import com.minecraft.groovymod.item.ItemGroovyArmor;
import com.minecraft.groovymod.item.ItemGroovyHoe;
import com.minecraft.groovymod.item.ItemGroovyPickaxe;
import com.minecraft.groovymod.item.ItemGroovyScoobySnack;
import com.minecraft.groovymod.item.ItemGroovySword;
import com.minecraft.groovymod.renderer.entity.RenderHippieZombie;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = GroovyMod.MODID, name = GroovyMod.NAME, version = GroovyMod.VERSION)
public class GroovyMod {
	
	public static final String MODID = "groovymod";
	public static final String VERSION = "0.2";
	public static final String NAME = "Groovy Mod";
	
	public static Item groovy_helmet;
	public static Item groovy_leggings;
	public static Item groovy_chestplate;
	public static Item groovy_boots;
	public static Item groovy_sword;
	public static Item groovy_pickaxe;
	public static Item groovy_hoe;
	public static Block groovy_lavalamp;
	public static Block groovy_discoball;
	public static Item groovy_scoobysnack;
	
	//Create the material to make the groovy armor
	public static ArmorMaterial groovyArmorMaterial = EnumHelper.addArmorMaterial("Groovy", 
			60, new int[]{5, 6, 5, 4}, 25);
	//DIAMOND(33, new int[]{3, 8, 6, 3}, 10);
	
	public static ToolMaterial groovyToolMaterial = EnumHelper.addToolMaterial("Groovy",
			3, 3000, 10.0F, 10.0F, 25);
	//EMERALD(3, 1561, 8.0F, 3.0F, 10),
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		initializeItems();
		
		initializeBlocks();
		
		initializeRecipes();
		
		initializeMobs();
		
	}


	private void initializeBlocks() {
		groovy_lavalamp = new BlockGroovyLavalamp();
		groovy_discoball = new BlockGroovyDiscoball();
		
		GameRegistry.registerBlock(groovy_lavalamp, "Groovy Lavalamp");
		GameRegistry.registerBlock(groovy_discoball, "Groovy Discoball");
	}


	private void initializeMobs() {
		EntityList.addMapping(EntityHippieZombie.class, 
				EntityHippieZombie.class.getSimpleName(), EntityHippieZombie.ID, 15373203, 5009705); 
		
		RenderingRegistry.registerEntityRenderingHandler(EntityHippieZombie.class, new RenderHippieZombie());
	}


	private void initializeItems() {

		groovy_helmet = ItemGroovyArmor.newHelmet();
		groovy_chestplate = ItemGroovyArmor.newChestplate();
		groovy_leggings = ItemGroovyArmor.newLeggings();
		groovy_boots = ItemGroovyArmor.newBoots();
		
		groovy_sword = new ItemGroovySword();
		groovy_pickaxe = new ItemGroovyPickaxe();
		groovy_hoe = new ItemGroovyHoe();
		
		groovy_scoobysnack = new ItemGroovyScoobySnack();
		
		
		GameRegistry.registerItem(groovy_helmet, "groovy_helment");
		GameRegistry.registerItem(groovy_chestplate, "groovy_chestplate");
		GameRegistry.registerItem(groovy_leggings, "groovy_leggings");
		GameRegistry.registerItem(groovy_boots, "groovy_boots");
		GameRegistry.registerItem(groovy_sword, "groovy_sword");
		GameRegistry.registerItem(groovy_pickaxe, "groovy_pickaxe");
		GameRegistry.registerItem(groovy_hoe, "groovy_hoe");
		GameRegistry.registerItem(groovy_scoobysnack, "groovy_scoobysnack");

	}




	private void initializeRecipes() {
		
		//Helmet recipe
		GameRegistry.addRecipe(new ItemStack(groovy_helmet), new Object[]{
	    	"YDY",
	    	"Y Y",
	    	"   ",
	    	'Y', Blocks.yellow_flower,
	    	'D', Items.diamond
		});
		
		//Chest plate recipe
		GameRegistry.addRecipe(new ItemStack(groovy_chestplate), new Object[]{
	    	"Y Y",
	    	"YDY",
	    	"YYY",
	    	'Y', Blocks.yellow_flower,
	    	'D', Items.diamond
		});
		
		//Leggings recipe
		GameRegistry.addRecipe(new ItemStack(groovy_leggings), new Object[]{
	    	"YDY", 
	    	"Y Y",
	    	"Y Y",
	    	'Y', Blocks.yellow_flower,
	    	'D', Items.diamond
		});	
		
		//Boots recipe
		GameRegistry.addRecipe(new ItemStack(groovy_boots), new Object[]{
	    	"   ", 
	    	"Y Y",
	    	"Y Y",
	    	'Y', Blocks.yellow_flower
		});
		
		//Sword recipe
		GameRegistry.addRecipe(new ItemStack(groovy_sword), new Object[]{
	    	" Y ", 
	    	" D ",
	    	" S ",
	    	'Y', Blocks.yellow_flower,
	    	'D', Items.diamond,
	    	'S', Items.stick
		});
		
		//Pickaxe recipe
		GameRegistry.addRecipe(new ItemStack(groovy_pickaxe), new Object[]{
	    	"YDY", 
	    	" S ",
	    	" S ",
	    	'Y', Blocks.yellow_flower,
	    	'D', Items.diamond,
	    	'S', Items.stick
		});
		
		//Hoe recipe
		GameRegistry.addRecipe(new ItemStack(groovy_hoe), new Object[]{
	    	"YD ", 
	    	" S ",
	    	" S ",
	    	'Y', Blocks.yellow_flower,
	    	'D', Items.diamond,
	    	'S', Items.stick
		});
		
		//Scooby snack recipe
		GameRegistry.addRecipe(new ItemStack(groovy_scoobysnack, 24, 0), new Object[]{
	    	"SD ", 
	    	" E ",
	    	"  G",
	    	'S', Items.sugar,
	    	'D', Blocks.dirt,
	    	'E', Items.egg,
	    	'G', Blocks.tallgrass
		});
	}
	
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println("DIRT BLOCK >> " + Blocks.dirt.getUnlocalizedName());
		System.out.println("EVENT NAME >> " + event.getModState());

	}
}
