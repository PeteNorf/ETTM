package com.petenorf.ettm.age.jurassic.fluid;

import com.petenorf.ettm.age.jurassic.blocks.JurassicBlocks;
import com.petenorf.ettm.util.reference.Names;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class JurassicFluids {
	public static Fluid hotTar;
	
	public static void preInit()
	{
		registerFluids();
	}

	public static void init()
	{
		registerFluidBlocks();
	}

	private static void registerFluids()
	{
		hotTar = registerFluid(new FluidHotTar(Names.Blocks.HOT_TAR));
	}

	private static void registerFluidBlocks()
	{
		hotTar.setBlock(JurassicBlocks.hotTar);

	}
	
	public static Fluid registerFluid(Fluid fluid)
	{
		FluidRegistry.registerFluid(fluid);

		return fluid;
	}
}
