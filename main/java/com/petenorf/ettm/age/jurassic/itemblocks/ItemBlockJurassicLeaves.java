package com.petenorf.ettm.age.jurassic.itemblocks;

import com.petenorf.ettm.age.jurassic.blocks.BlockJurassicLeaves;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockJurassicLeaves extends ItemBlock {
	public ItemBlockJurassicLeaves(Block block)
	{
		super(block);

		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int meta)
	{
		return meta | 4;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		BlockJurassicLeaves block = (BlockJurassicLeaves)field_150939_a;

		return super.getUnlocalizedName() + "." + block.getLeafType(itemStack.getItemDamage());
	}
}
