package com.petenorf.ettm.age.jurassic.blocks;

import java.util.List;
import java.util.Random;

import com.petenorf.ettm.age.jurassic.JurassicPeriod;
import com.petenorf.ettm.age.jurassic.world.gen.tree.WorldGenConiferTree;
import com.petenorf.ettm.age.jurassic.world.gen.tree.WorldGenFernTree;
import com.petenorf.ettm.util.reference.Names;
import com.petenorf.ettm.util.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockJurassicSapling extends BlockSapling {
	private static final String[] saplings = new String[] {"fern", "conifer"};
	private IIcon[] textures;
	private static final int TYPES = 15;

	public BlockJurassicSapling()
	{
		this.setHardness(0.0F);
		this.setStepSound(Block.soundTypeGrass);
		this.setCreativeTab(JurassicPeriod.jurassicTab);
		this.setBlockName(Names.Blocks.JURASSIC_SAPLING);
	}

	@Override

	public void registerBlockIcons(IIconRegister iconRegister)
	{
		textures = new IIcon[saplings.length];

		for (int i = 0; i < saplings.length; ++i) {
			textures[i] = iconRegister.registerIcon(Reference.MOD_ID + ":" + saplings[i]);
		}

	}

	@Override

	public IIcon getIcon(int side, int meta)
	{
		if (meta < 0 || meta >= saplings.length) {
			meta = 0;
		}

		return textures[meta];
	}

	@Override

	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) 
	{
		for (int i = 0; i < saplings.length; ++i) 
		{
			list.add(new ItemStack(block, 1, i));
		}
	}

	public boolean isValidPosition(World world, int x, int y, int z, int metadata)
	{
		Block block = world.getBlock(x, y - 1, z);
		return block == Blocks.grass || block == Blocks.dirt || block == Blocks.farmland || block.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this);	
	}

	@Override

	public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side)
	{
		return isValidPosition(world, x, y, z, -1);
	}

	@Override

	public boolean canBlockStay(World world, int x, int y, int z)
	{
	
		Block soil = world.getBlock(x, y - 1, z);

		if (world.getBlockMetadata(x, y, z) != 1)
			return (world.getFullBlockLightValue(x, y, z) >= 8 || world.canBlockSeeTheSky(x, y, z)) &&
					(soil != null && soil.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this));
		else
			return (world.getFullBlockLightValue(x, y, z) >= 8 || world.canBlockSeeTheSky(x, y, z)) &&
					(soil != null && (soil.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this)));
	}

	@Override

	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if (!world.isRemote)
		{
			if (world.getBlockLightValue(x, y + 1, z) >= 9 && random.nextInt(7) == 0) 
			{

				this.func_149878_d(world, x, y, z, random);
			}
		}
	}

	@Override
	public void func_149878_d(World world, int x, int y, int z, Random random)
	{
		int meta = world.getBlockMetadata(x, y, z) & TYPES;
		Object obj = null;
		int rnd = random.nextInt(8);

		if (obj == null)
		{
			switch (meta)
			{
			case 0:
				obj = new WorldGenFernTree(JurassicBlocks.jurassicLog, JurassicBlocks.jurassicLeaves, 0);
				break;
			case 1:
				obj = new WorldGenConiferTree(JurassicBlocks.jurassicLog, JurassicBlocks.jurassicLeaves, 1);
				break;
			}
		}

		if (obj != null)
		{
			world.setBlockToAir(x, y, z);
			if (!((WorldGenerator)obj).generate(world, random, x, y, z)) 
			{
				world.setBlock(x, y, z, this, meta, 2);
			}
		}
	}

	@Override

	public int damageDropped(int meta)
	{
		return meta & TYPES;
	}

	@Override

	public int getDamageValue(World world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z) & TYPES;
	}
}
