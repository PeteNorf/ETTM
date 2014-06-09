package com.petenorf.ettm.age.jurassic.world.gen.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.petenorf.ettm.util.help.WorldGenPart;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenConiferTree extends WorldGenAbstractTree {
	
	private Block wood;
	private Block leaves;
	private int metaWood;
	private int metaLeaves;
	private int minTreeHeight;
	private int randomTreeHeight;
	
	public WorldGenConiferTree(Block wood, Block leaves, int metaWood)
	{
		this(wood, leaves, metaWood, -1, false, 20, 11);

	}

	public WorldGenConiferTree(Block wood, Block leaves, int metaWood, int metaLeaves, boolean doBlockNotify, int minTreeHeight, int randomTreeHeight)
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
	public boolean generate(World world, Random rand, int x, int y, int z) {
		if(!world.isRemote){
		List<WorldGenPart> tree = new ArrayList<WorldGenPart>();
		int preHeight = minTreeHeight + rand.nextInt(randomTreeHeight);
		int height = preHeight % 2 == 0 ? preHeight: preHeight - 1;
		//Trunk
		for(int i = 0; i < height; i++){
			tree.add(new WorldGenPart(x, y + i, z, metaWood, wood));
		}
		
		//Leaves
		double d = (height / 3D);
		System.out.println(d);
		for(int level = height; level >(int) Math.round(d); level = level - 2){
		//Big Layer
		for (int i = -3; i <= 3; i++){
			for (int j = -3; j <= 3; j++){
				//Making big layer circular
				if(i != 0 || j !=0)
					if(i != 3 || j != 3)
						if(i != -3 || j !=-3)
							if(i != -3 || j !=3)
								if(i != 3 || j !=-3)
				tree.add(new WorldGenPart(x + i, y + level - 3, z + j, metaLeaves, leaves));
			}
		}
		//Small Layer
		for (int i = -2; i <= 2; i++){
			for (int j = -2; j <= 2; j++){
				//Cutting up the small layer (Making it round)
				if(i != 0 || j !=0)
					if(i != 2 || j !=2)
						if(i != -2 || j !=2)
							if(i != 2 || j !=-2)
								if(i != -2 || j !=-2)
				tree.add(new WorldGenPart(x + i, y + level - 4, z + j, metaLeaves, leaves));
			}
		}
		}
		//Hat
		tree.add(new WorldGenPart(x + 1, y + height - 1, z, metaLeaves, leaves));
		tree.add(new WorldGenPart(x - 1, y + height - 1, z, metaLeaves, leaves));
		tree.add(new WorldGenPart(x, y + height - 1, z + 1, metaLeaves, leaves));
		tree.add(new WorldGenPart(x, y + height - 1, z - 1, metaLeaves, leaves));
		tree.add(new WorldGenPart(x, y + height, z, metaLeaves, leaves));
		
		//Check for space
		for(int i = 0; i < tree.size(); i ++){
			WorldGenPart block = tree.get(i);
			if(!world.isAirBlock(block.x, block.y, block.z) && !world.getBlock(block.x, block.y, block.z).isLeaves(world, block.x, block.y, block.z) ){
				return false;
			}
		}
		//Generate Tree
		for(int i = 0; i < tree.size(); i ++){
			WorldGenPart block = tree.get(i);
			world.setBlock(block.x, block.y, block.z, block.blockType);
		}
		return true;
		}
		return false;
	}

}
