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
		this(wood, leaves, metaWood, -1, false, 5, 4);

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
		List<WorldGenPart> tree = new ArrayList<WorldGenPart>();
		tree.add(new WorldGenPart(x, y, z, metaWood, wood, world));
		tree.add(new WorldGenPart(x, y + 1, z, metaWood, wood, world));
		tree.add(new WorldGenPart(x, y + 2, z, metaWood, wood, world));
		tree.add(new WorldGenPart(x, y + 3, z, metaWood, wood, world));
		tree.add(new WorldGenPart(x + 1, y + 3, z, metaWood, wood, world));
		
		for(int i = 0; i < tree.size(); i ++){
			WorldGenPart block = tree.get(i);
			if(!world.isAirBlock(block.x, block.y, block.z)){
				return false;
			}
		}
		
		for(int i = 0; i < tree.size(); i ++){
			WorldGenPart block = tree.get(i);
			world.setBlock(block.x, block.y, block.z, block.blockType);
		}
		return true;
	}

}
