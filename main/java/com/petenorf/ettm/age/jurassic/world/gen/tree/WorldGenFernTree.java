package com.petenorf.ettm.age.jurassic.world.gen.tree;

import java.util.Random;

import com.petenorf.ettm.age.jurassic.blocks.JurassicBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.util.ForgeDirection;

public class WorldGenFernTree extends WorldGenAbstractTree{
	private final int minTreeHeight;
	private final int randomTreeHeight;

	private final Block wood;
	private final Block leaves;

	private final int metaWood;
	private int metaLeaves;


	public WorldGenFernTree(Block wood, Block leaves, int metaWood, int metaLeaves)
	{
		this(wood, leaves, metaWood, metaLeaves, false, 4, 3);
	}

	public WorldGenFernTree(Block wood, Block leaves, int metaWood)
	{
		this(wood, leaves, metaWood, -1, false, 5, 4);

	}

	public WorldGenFernTree(Block wood, Block leaves, int metaWood, int metaLeaves, boolean doBlockNotify, int minTreeHeight, int randomTreeHeight)
	{
		super(doBlockNotify);

		this.wood = wood;
		this.leaves = leaves;
		this.metaWood = metaWood;
		this.metaLeaves = metaLeaves;
		this.minTreeHeight = minTreeHeight;
		this.randomTreeHeight = randomTreeHeight;
	}

    @Override
	public boolean generate(World world, Random random, int x, int y, int z)
    {
    	while(world.isAirBlock(x, y, z) && y > 2){
    		--y;
    	}
    	
    	Block block = world.getBlock(x, y, z);
    	
    	for(int i = 0; i < 5; i++){
    		buildBlock(world, x, y + i, z, JurassicBlocks.jurassicLog, 0);
    	}
    	buildBlock(world, x+1, y + 4, z, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x-1, y + 4, z, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x, y+ 4, z - 1, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x, y+ 4, z + 1, JurassicBlocks.jurassicLeaves, 0);
    	for(int j = 0; j < 4; j++){
    	for(int i = -1; i <= 1; i ++){		
    	for(int k = -1; k <= 1; k++){
    				buildBlock(world, x+k, y + j + 5, z + i, JurassicBlocks.jurassicLeaves, 0);
    			}
    	}
    	}
    	buildBlock(world, x, y+ 8, z + 2, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x, y+ 7, z + 2, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x, y+ 6, z + 2, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x, y+ 5, z + 2, JurassicBlocks.jurassicLeaves, 0);
    	
    	buildBlock(world, x, y+ 8, z + 3, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x, y+ 7, z + 3, JurassicBlocks.jurassicLeaves, 0);
    	
    	buildBlock(world, x, y+ 8, z + 4, JurassicBlocks.jurassicLeaves, 0);
    	
    	buildBlock(world, x, y+ 8, z - 2, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x, y+ 7, z - 2, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x, y+ 6, z - 2, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x, y+ 5, z - 2, JurassicBlocks.jurassicLeaves, 0);
    	
    	buildBlock(world, x, y+ 8, z - 3, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x, y+ 7, z - 3, JurassicBlocks.jurassicLeaves, 0);
    	
    	buildBlock(world, x, y+ 8, z - 4, JurassicBlocks.jurassicLeaves, 0);
    	
    	buildBlock(world, x + 2, y+ 8, z, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x + 2, y+ 7, z, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x + 2, y+ 6, z, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x + 2, y+ 5, z, JurassicBlocks.jurassicLeaves, 0);
    	
    	buildBlock(world, x + 3, y+ 8, z, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x + 3, y+ 7, z, JurassicBlocks.jurassicLeaves, 0);
    	
    	buildBlock(world, x + 4, y+ 8, z, JurassicBlocks.jurassicLeaves, 0);
    	
    	buildBlock(world, x - 2, y+ 8, z, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x - 2, y+ 7, z, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x - 2, y+ 6, z, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x - 2, y+ 5, z, JurassicBlocks.jurassicLeaves, 0);
    	
    	buildBlock(world, x - 3, y+ 8, z, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x - 3, y+ 7, z, JurassicBlocks.jurassicLeaves, 0);
    	
    	buildBlock(world, x - 4, y+ 8, z, JurassicBlocks.jurassicLeaves, 0);
    	
    	buildBlock(world, x + 2, y+ 8, z + 2, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x + 2, y+ 7, z + 2, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x + 2, y+ 6, z + 2, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x + 2, y+ 5, z + 2, JurassicBlocks.jurassicLeaves, 0);
    	
    	buildBlock(world, x + 3, y+ 8, z + 3, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x + 3, y+ 7, z + 3, JurassicBlocks.jurassicLeaves, 0);
    	
    	buildBlock(world, x - 2, y+ 8, z - 2, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x - 2, y+ 7, z - 2, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x - 2, y+ 6, z - 2, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x - 2, y+ 5, z - 2, JurassicBlocks.jurassicLeaves, 0);
    	
    	buildBlock(world, x - 3, y+ 8, z - 3, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x - 3, y+ 7, z - 3, JurassicBlocks.jurassicLeaves, 0);
    	
    	buildBlock(world, x + 2, y+ 8, z -  2, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x + 2, y+ 7, z - 2, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x + 2, y+ 6, z - 2, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x + 2, y+ 5, z - 2, JurassicBlocks.jurassicLeaves, 0);
    	
    	buildBlock(world, x + 3, y+ 8, z - 3, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x + 3, y+ 7, z - 3, JurassicBlocks.jurassicLeaves, 0);
    	
    	buildBlock(world, x - 2, y+ 8, z + 2, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x - 2, y+ 7, z + 2, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x - 2, y+ 6, z + 2, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x - 2, y+ 5, z + 2, JurassicBlocks.jurassicLeaves, 0);
    	
    	buildBlock(world, x - 3, y+ 8, z + 3, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x - 3, y+ 7, z + 3, JurassicBlocks.jurassicLeaves, 0);
    	
    	buildBlock(world, x + 4, y+ 8, z + 3, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x + 3, y+ 8, z + 4, JurassicBlocks.jurassicLeaves, 0);
    	
    	buildBlock(world, x - 4, y+ 8, z - 3, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x - 3, y+ 8, z - 4, JurassicBlocks.jurassicLeaves, 0);
    	
    	buildBlock(world, x - 4, y+ 8, z + 3, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x - 3, y+ 8, z + 4, JurassicBlocks.jurassicLeaves, 0);
    	
    	buildBlock(world, x + 4, y+ 8, z - 3, JurassicBlocks.jurassicLeaves, 0);
    	buildBlock(world, x + 3, y+ 8, z - 4, JurassicBlocks.jurassicLeaves, 0);
    	
    	
    	
    
    		
    	return true;
    }
    
    public void buildBlock(World world, int x, int y, int z, Block block, int meta)
    {
    	if (world.isAirBlock(x, y, z) || world.getBlock(x, y, z).isLeaves(world, x, y, z))
		{
    		world.setBlock(x, y, z, block, meta, 2);
		}
    }
}
