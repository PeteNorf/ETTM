package com.petenorf.ettm.age.jurassic.blocks;


import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import com.petenorf.ettm.age.jurassic.JurassicPeriod;
import com.petenorf.ettm.util.reference.Names;
import com.petenorf.ettm.util.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHotTar extends BlockFluidClassic{
    @SideOnly(Side.CLIENT) 
	protected IIcon flowingIcon;
    @SideOnly(Side.CLIENT)
    
	protected IIcon stillIcon;
	public BlockHotTar() {
		super(FluidRegistry.getFluid(Names.Blocks.HOT_TAR), Material.water);
		setCreativeTab(JurassicPeriod.jurassicTab);
	}
    
	@Override
    public IIcon getIcon(int side, int meta) {
            return (side == 0 || side == 1)? stillIcon : flowingIcon;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
            stillIcon = register.registerIcon(Reference.MOD_ID + ":fluid_" + Names.Blocks.HOT_TAR + "_still");
            flowingIcon = register.registerIcon(Reference.MOD_ID + ":fluid_" + Names.Blocks.HOT_TAR + "_flowing" );
    }
    
    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.canDisplace(world, x, y, z);
    }
    
    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.displaceIfPossible(world, x, y, z);
    }
}
