package com.petenorf.ettm.util.help;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class WorldGenPart {
	public int x;
	public int y;
	public int z;
	public int meta;
	public Block blockType;
	public World world;
	
	public WorldGenPart(int x, int y, int z, int meta, Block block, World world){
		this.x = x;
		this.y = y;
		this.z = z;
		this.meta = meta;
		this.blockType = block;
		this.world = world;
	}
}
