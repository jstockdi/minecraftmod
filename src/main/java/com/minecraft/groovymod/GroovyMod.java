package com.minecraft.groovymod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = GroovyMod.MODID, name = GroovyMod.NAME, version = GroovyMod.VERSION)
public class GroovyMod {
	
	
	public class GroovyArmor extends ItemArmor {

		public GroovyArmor(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_) {
			super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
			// TODO Auto-generated constructor stub
		}

		public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
			
			if (stack.getItem() == GroovyMod.groovy_helmet) {
				return GroovyMod.MODID + ":textures/armor/groovy_layer_1.png";
			}
			return null;
		}
	}

	
	public static final String MODID = "groovymod";
	public static final String VERSION = "0.1";
	public static final String NAME = "Groovy Mod";
	
	public static Item groovy_helmet;
	
	//Create the material to make the groovy armor
	public static ArmorMaterial groovyMaterial = EnumHelper
			.addArmorMaterial("Groovy", 60, new int[]{2, 5, 4, 2}, 10);

	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		groovy_helmet = new GroovyArmor(groovyMaterial, 0, 0)
		 .setUnlocalizedName("GroovyHelmet")
		 .setCreativeTab(CreativeTabs.tabCombat)
		 .setTextureName(GroovyMod.MODID + ":groovy_helmet");

		
		GameRegistry.registerItem(groovy_helmet, "groovy_helment");
		initializeRecipes();
		
	}


	private void initializeRecipes() {
		
		//Helmet recipe
		GameRegistry.addRecipe(new ItemStack(Items.diamond_helmet), new Object[]{
	    	"YDY",
	    	"Y Y",
	    	"   ",
	    	'Y', Blocks.yellow_flower,
	    	'D', Items.diamond
		});
		
		//Chest plate recipe
		GameRegistry.addRecipe(new ItemStack(Items.diamond_chestplate), new Object[]{
	    	"Y Y",
	    	"YDY",
	    	"YYY",
	    	'Y', Blocks.yellow_flower,
	    	'D', Items.diamond
		});
		
		//Leggings recipe
		GameRegistry.addRecipe(new ItemStack(Items.diamond_leggings), new Object[]{
	    	"YDY", 
	    	"Y Y",
	    	"Y Y",
	    	'Y', Blocks.yellow_flower,
	    	'D', Items.diamond
		});	
		
		//Boots recipe
		GameRegistry.addRecipe(new ItemStack(Items.diamond_boots), new Object[]{
	    	"   ", 
	    	"Y Y",
	    	"Y Y",
	    	'Y', Blocks.yellow_flower
		});
		
		//Sword recipe
		GameRegistry.addRecipe(new ItemStack(Items.diamond_sword), new Object[]{
	    	" Y ", 
	    	" D ",
	    	" S ",
	    	'Y', Blocks.yellow_flower,
	    	'D', Items.diamond,
	    	'S', Items.stick
		});
	}
	
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println("DIRT BLOCK >> " + Blocks.dirt.getUnlocalizedName());
		System.out.println("EVENT NAME >> " + event.getModState());

	}
}
