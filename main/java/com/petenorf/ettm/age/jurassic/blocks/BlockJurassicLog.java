package com.petenorf.ettm.age.jurassic.blocks;


import java.util.List;

import com.petenorf.ettm.age.jurassic.JurassicPeriod;
import com.petenorf.ettm.util.reference.Names;
import com.petenorf.ettm.util.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockJurassicLog extends Block{
	private static final String[] types = new String[] {"fern"};
	private IIcon[] textures;
	private IIcon[] logHearts;

	public BlockJurassicLog()
	{
		super(Material.wood);
		this.setHardness(2.0F);
		this.setHarvestLevel("axe", 0);
		this.setResistance(5.0F);
		this.setStepSound(Block.soundTypeWood);
		this.setCreativeTab(JurassicPeriod.jurassicTab);
		this.setBlockName(Names.Blocks.JURASSIC_WOOD);
	}

	@Override

	public void registerBlockIcons(IIconRegister iconRegister)
	{
		textures = new IIcon[types.length];
		logHearts = new IIcon[types.length];

		for (int i = 0; i < types.length; ++i)
		{
			textures[i] = iconRegister.registerIcon(Reference.MOD_ID + ":log_" + types[i]+"_side");
			logHearts[i] = iconRegister.registerIcon(Reference.MOD_ID + ":log_" + types[i]+"_heart");
		}
	}

	@Override

	public IIcon getIcon(int side, int meta)
	{
		int pos = meta & 12;

		if (pos == 0 && (side == 1 || side == 0) || pos == 4 && (side == 5 || side == 4) || pos == 8 && (side == 2 || side == 3))
			return logHearts[(getTypeFromMeta(meta))];
		else
			return textures[(getTypeFromMeta(meta))];
	}

	@Override
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) 
	{
		for (int i = 0; i < types.length; ++i) {
			list.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block par5, int par6)
	{
		byte radius = 4;
		int bounds = radius + 1;

		if (world.checkChunksExist(x - bounds, y - bounds, z - bounds, x + bounds, y + bounds, z + bounds)) 
		{
			for (int i = -radius; i <= radius; ++i) 
			{
				for (int j = -radius; j <= radius; ++j) 
				{
					for (int k = -radius; k <= radius; ++k)
					{

						Block block = world.getBlock(x + i, y + j, z + k);

						if (block.isLeaves(world, x, y, z)) 
						{
							block.beginLeavesDecay(world, x + i, y + j, z + k);
						}
					}
				}
			}
		}
	}

	@Override

	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta)
	{
		int type = getTypeFromMeta(meta);
		byte orientation = 0;

		switch (side)
		{
		case 0:
		case 1:
			orientation = 0;
			break;

		case 2:
		case 3:
			orientation = 8;
			break;

		case 4:
		case 5:
			orientation = 4;
		}

		return type | orientation;
	}

	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return Blocks.fire.getFlammability(this);
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return Blocks.fire.getEncouragement(this);
	}

	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return getFlammability(world, x, y, z, face) > 0;
	}

	@Override
	public int damageDropped(int meta)
	{
		return getTypeFromMeta(meta);
	}

	@Override
	protected ItemStack createStackedBlock(int meta)
	{
		return new ItemStack(this, 1, getTypeFromMeta(meta));
	}

	@Override
	public int getRenderType()
	{
		return 31;
	}

	@Override
	public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z)
	{
		return true;
	}

	@Override
	public boolean isWood(IBlockAccess world, int x, int y, int z)
	{
		return true;
	}

	public String getWoodType(int meta)
	{
		return types[getTypeFromMeta(meta)];
	}

	private static int getTypeFromMeta(int meta)
	{
		return meta & 3;
	}
}

