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
	
	public static Item item_helmet;
	public static Item item_leggings;
	public static Item item_chestplate;
	public static Item item_boots;
	
	public static Item item_sword;
	public static Item item_pickaxe;
	public static Item item_hoe;
	
	public static Item item_scoobysnack;
	
	public static Block block_lavalamp;
	public static Block block_discoball;
	
	
	
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
		block_lavalamp = new BlockGroovyLavalamp();
		block_discoball = new BlockGroovyDiscoball();
		
		GameRegistry.registerBlock(block_lavalamp, "Groovy Lavalamp");
		GameRegistry.registerBlock(block_discoball, "Groovy Discoball");
	}


	private void initializeMobs() {
		EntityList.addMapping(EntityHippieZombie.class, 
				EntityHippieZombie.class.getSimpleName(), EntityHippieZombie.ID, 15373203, 5009705); 
		
		RenderingRegistry.registerEntityRenderingHandler(EntityHippieZombie.class, new RenderHippieZombie());
	}


	private void initializeItems() {

		item_helmet = ItemGroovyArmor.newHelmet();
		item_chestplate = ItemGroovyArmor.newChestplate();
		item_leggings = ItemGroovyArmor.newLeggings();
		item_boots = ItemGroovyArmor.newBoots();
		
		item_sword = new ItemGroovySword();
		item_pickaxe = new ItemGroovyPickaxe();
		item_hoe = new ItemGroovyHoe();
		
		item_scoobysnack = new ItemGroovyScoobySnack();
		
		
		GameRegistry.registerItem(item_helmet, "groovy_helment");
		GameRegistry.registerItem(item_chestplate, "groovy_chestplate");
		GameRegistry.registerItem(item_leggings, "groovy_leggings");
		GameRegistry.registerItem(item_boots, "groovy_boots");
		GameRegistry.registerItem(item_sword, "groovy_sword");
		GameRegistry.registerItem(item_pickaxe, "groovy_pickaxe");
		GameRegistry.registerItem(item_hoe, "groovy_hoe");
		GameRegistry.registerItem(item_scoobysnack, "groovy_scoobysnack");

	}




	private void initializeRecipes() {
		
		//Helmet recipe
		GameRegistry.addRecipe(new ItemStack(item_helmet), new Object[]{
	    	"YDY",
	    	"Y Y",
	    	"   ",
	    	'Y', Blocks.yellow_flower,
	    	'D', Items.diamond
		});
		
		//Chest plate recipe
		GameRegistry.addRecipe(new ItemStack(item_chestplate), new Object[]{
	    	"Y Y",
	    	"YDY",
	    	"YYY",
	    	'Y', Blocks.yellow_flower,
	    	'D', Items.diamond
		});
		
		//Leggings recipe
		GameRegistry.addRecipe(new ItemStack(item_leggings), new Object[]{
	    	"YDY", 
	    	"Y Y",
	    	"Y Y",
	    	'Y', Blocks.yellow_flower,
	    	'D', Items.diamond
		});	
		
		//Boots recipe
		GameRegistry.addRecipe(new ItemStack(item_boots), new Object[]{
	    	"   ", 
	    	"Y Y",
	    	"Y Y",
	    	'Y', Blocks.yellow_flower
		});
		
		//Sword recipe
		GameRegistry.addRecipe(new ItemStack(item_sword), new Object[]{
	    	" Y ", 
	    	" D ",
	    	" S ",
	    	'Y', Blocks.yellow_flower,
	    	'D', Items.diamond,
	    	'S', Items.stick
		});
		
		//Pickaxe recipe
		GameRegistry.addRecipe(new ItemStack(item_pickaxe), new Object[]{
	    	"YDY", 
	    	" S ",
	    	" S ",
	    	'Y', Blocks.yellow_flower,
	    	'D', Items.diamond,
	    	'S', Items.stick
		});
		
		//Hoe recipe
		GameRegistry.addRecipe(new ItemStack(item_hoe), new Object[]{
	    	"YD ", 
	    	" S ",
	    	" S ",
	    	'Y', Blocks.yellow_flower,
	    	'D', Items.diamond,
	    	'S', Items.stick
		});
		
		//Scooby snack recipe
		GameRegistry.addRecipe(new ItemStack(item_scoobysnack, 24, 0), new Object[]{
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
