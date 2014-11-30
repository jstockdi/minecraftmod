package com.minecraft.groovymod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGlowstone;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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

		public GroovySword() {
			super(groovyToolMaterial);

			setUnlocalizedName("GroovySword");
			setCreativeTab(CreativeTabs.tabCombat);
			setTextureName(GroovyMod.MODID + ":groovy_sword");
		}
	}
	
	public class GroovyScoobySnack extends ItemFood{

		public GroovyScoobySnack() {
			super(10,  //heal amount 
					0.9F,   //saturationModifier
					false  //isWolfsFavoriteMeat
					);
		}
		
		
		@Override
		public ItemStack onEaten(ItemStack arg0, World arg1, EntityPlayer player) {
			ItemStack itemStack = super.onEaten(arg0, arg1, player);
			
			for(int i=0;i<5;i++){
				player.jump();  // can we put this in a thread and make the player jump repeatedly afterwards?
			}
			
			return itemStack;
		}
	}
	
	public class GroovyPickaxe extends ItemPickaxe{

		protected GroovyPickaxe() {
			super(groovyToolMaterial);
		}
		
		 @Override
		public boolean onBlockDestroyed(ItemStack itemStack,
				World world, Block block, int p_150894_4_,
				int p_150894_5_, int p_150894_6_, EntityLivingBase entityLivingBase) {
			 
			 
			 //5% of the time drop a diamond if the block was coal
			 if(!world.isRemote && 1 == new Random().nextInt(20) && "tile.oreCoal".equals(block.getUnlocalizedName())){
				 EntityItem dropItem = entityLivingBase.entityDropItem(new ItemStack(Items.diamond), 1.0F);
			 }

			return super.onBlockDestroyed(itemStack, world, block,
					p_150894_4_, p_150894_5_, p_150894_6_, entityLivingBase);
		}

	}

	public class GroovyHoe extends ItemHoe{

		protected GroovyHoe() {
			super(groovyToolMaterial);

			setUnlocalizedName("GroovyHoe");
			setCreativeTab(CreativeTabs.tabTools);
			setTextureName(GroovyMod.MODID + ":groovy_hoe");
		}

	}
	
	public class GroovyLavalamp extends BlockTorch {

		
		public GroovyLavalamp() {
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
	
	
	
	
	
	public class GroovyArmor extends ItemArmor {

		public GroovyArmor(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_) {
			super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
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
	
	public static class GroovyDiscoball extends BlockGlowstone{

		public GroovyDiscoball() {
			super(Material.glass);
			setHardness(0.3F);
			setStepSound(Block.soundTypeGlass);
			setLightLevel(1.0F);
			setBlockName("GroovyDiscoball");
			setBlockTextureName(GroovyMod.MODID + ":groovy_discoball");
			setCreativeTab(CreativeTabs.tabDecorations);
		}
		
	}

	
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

		instantiateItems();
		
		registerItems();
		
		initializeRecipes();
		
		
	}


	private void instantiateItems() {
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
		
		groovy_scoobysnack = new GroovyScoobySnack()
		.setUnlocalizedName("GroovyScoobySnack")
		.setCreativeTab(CreativeTabs.tabFood)
		.setTextureName(GroovyMod.MODID + ":groovy_scoobysnack");
		
		groovy_sword = new GroovySword();
		
		groovy_pickaxe = new GroovyPickaxe()
		.setUnlocalizedName("GroovyPickaxe")
		.setCreativeTab(CreativeTabs.tabTools)
		.setTextureName(GroovyMod.MODID + ":groovy_pickaxe");
		
		groovy_hoe = new GroovyHoe();
		
		groovy_lavalamp = new GroovyLavalamp();
		
		groovy_discoball = new GroovyDiscoball();
	}


	private void registerItems() {
		GameRegistry.registerItem(groovy_helmet, "groovy_helment");
		GameRegistry.registerItem(groovy_chestplate, "groovy_chestplate");
		GameRegistry.registerItem(groovy_leggings, "groovy_leggings");
		GameRegistry.registerItem(groovy_boots, "groovy_boots");
		GameRegistry.registerItem(groovy_sword, "groovy_sword");
		GameRegistry.registerItem(groovy_pickaxe, "groovy_pickaxe");
		GameRegistry.registerItem(groovy_hoe, "groovy_hoe");
		GameRegistry.registerItem(groovy_scoobysnack, "groovy_scoobysnack");
		
		
		GameRegistry.registerBlock(groovy_lavalamp, "Groovy Lavalamp");
		GameRegistry.registerBlock(groovy_discoball, "Groovy Discoball");
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
