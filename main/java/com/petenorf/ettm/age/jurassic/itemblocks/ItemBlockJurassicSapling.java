package com.petenorf.ettm.age.jurassic.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemBlockJurassicSapling extends ItemBlock {
	private static final String[] saplings = new String[] {"fern"};
	private static final int MAX = 0;
	public ItemBlockJurassicSapling(Block block)
	{
		super(block);

		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int meta)
	{
		return meta & 15;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		int meta = itemStack.getItemDamageForDisplay() > MAX ? 0 : itemStack.getItemDamageForDisplay();
		return super.getUnlocalizedName() + "." + (new StringBuilder()).append(saplings[meta]).append("Sapling").toString();
	}

	@Override
	public IIcon getIconFromDamage(int meta)
	{
		//TODO:	linkedBlock   getIcon
		return field_150939_a.getIcon(0, meta);
	}
}

