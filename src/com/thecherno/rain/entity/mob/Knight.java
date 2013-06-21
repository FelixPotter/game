package com.thecherno.rain.entity.mob;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.level.tile.Tile;

public class Knight extends Tile{
	public Knight(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y,Screen screen){
		screen.renderTile(x/48, y/48, this);
	}

	public boolean soild(){
		return true;
	}
	
}
