package com.petenorf.ettm.age.jurassic.fluid;

import net.minecraftforge.fluids.Fluid;

public class FluidHotTar extends Fluid {
	public FluidHotTar(String fluidName)
	{
		super(fluidName);

		this.setViscosity(12000);
	} 

}
