package com.minecraft.groovymod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemSword;
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
	
	private static enum GroovyArmorType{
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
	
	public class GroovySword extends ItemSword{

		public GroovySword(ToolMaterial toolMaterial) {
			super(toolMaterial);
		}
	}
	
	public class GroovyArmor extends ItemArmor {

		public GroovyArmor(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_) {
			super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
			// TODO Auto-generated constructor stub
		}

		public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
			
			if (stack.getItem() == GroovyMod.groovy_helmet || 
					stack.getItem() == GroovyMod.groovy_chestplate ||
					stack.getItem() == GroovyMod.groovy_boots) {
				return GroovyMod.MODID + ":textures/armor/groovy_layer_1.png";
			}else if (stack.getItem() == GroovyMod.groovy_leggings) {
				return GroovyMod.MODID + ":textures/armor/groovy_layer_2.png";
			}
			return null;
		}
	}

	
	public static final String MODID = "groovymod";
	public static final String VERSION = "0.1";
	public static final String NAME = "Groovy Mod";
	
	public static Item groovy_helmet;
	public static Item groovy_leggings;
	public static Item groovy_chestplate;
	public static Item groovy_boots;
	public static Item groovy_sword;
	
	//Create the material to make the groovy armor
	public static ArmorMaterial groovyArmorMaterial = EnumHelper.addArmorMaterial("Groovy", 
			60, new int[]{2, 5, 4, 2}, 10);

	public static ToolMaterial groovyToolMaterial = EnumHelper.addToolMaterial("Groovy",
			3, 3000, 10.0F, 30.0F, 25);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		groovy_helmet = new GroovyArmor(groovyArmorMaterial, 0, GroovyArmorType.helmet.getTypeNum())
		 .setUnlocalizedName("GroovyHelmet")
		 .setCreativeTab(CreativeTabs.tabCombat)
		 .setTextureName(GroovyMod.MODID + ":groovy_helmet");
		
		groovy_chestplate = new GroovyArmor(groovyArmorMaterial, 1, GroovyArmorType.chestplate.getTypeNum())
		 .setUnlocalizedName("GroovyChestplate")
		 .setCreativeTab(CreativeTabs.tabCombat)
		 .setTextureName(GroovyMod.MODID + ":groovy_chestplate");
		
		groovy_leggings = new GroovyArmor(groovyArmorMaterial, 2, GroovyArmorType.legs.getTypeNum())
		 .setUnlocalizedName("GroovyLeggings")
		 .setCreativeTab(CreativeTabs.tabCombat)
		 .setTextureName(GroovyMod.MODID + ":groovy_leggings");
		
		groovy_boots = new GroovyArmor(groovyArmorMaterial, 3, GroovyArmorType.boots.getTypeNum())
		 .setUnlocalizedName("GroovyBoots")
		 .setCreativeTab(CreativeTabs.tabCombat)
		 .setTextureName(GroovyMod.MODID + ":groovy_boots");
		
		groovy_sword = new GroovySword(groovyToolMaterial)
		.setUnlocalizedName("GroovySword")
		.setCreativeTab(CreativeTabs.tabCombat)
		.setTextureName(GroovyMod.MODID + ":groovy_sword");
		
		GameRegistry.registerItem(groovy_helmet, "groovy_helment");
		GameRegistry.registerItem(groovy_chestplate, "groovy_chestplate");
		GameRegistry.registerItem(groovy_leggings, "groovy_leggings");
		GameRegistry.registerItem(groovy_boots, "groovy_boots");
		GameRegistry.registerItem(groovy_sword, "groovy_sword");
		
		initializeRecipes();
		
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
	}
	
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println("DIRT BLOCK >> " + Blocks.dirt.getUnlocalizedName());
		System.out.println("EVENT NAME >> " + event.getModState());

	}
}
