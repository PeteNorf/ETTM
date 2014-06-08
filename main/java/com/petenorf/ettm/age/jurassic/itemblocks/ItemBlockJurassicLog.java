package com.petenorf.ettm.age.jurassic.itemblocks;

import com.petenorf.ettm.age.jurassic.blocks.BlockJurassicLog;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockJurassicLog extends ItemBlock {
	public ItemBlockJurassicLog(Block block)
	{
		super(block);

		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int meta)
	{
		return meta & 3;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		//TODO:							block
		BlockJurassicLog block = (BlockJurassicLog)field_150939_a;
		return super.getUnlocalizedName() + "." + block.getWoodType(itemStack.getItemDamage());
	}
}
