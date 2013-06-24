package com.thecherno.rain.entity.mob;

import java.util.Random;

import com.thecherno.rain.entity.projectile.Fire;
import com.thecherno.rain.entity.projectile.Projectile;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.input.Keyboard;
import com.thecherno.rain.level.tile.Tile;

public class Knight extends Mob{
	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	long timer = System.currentTimeMillis();
	public static Sprite spriteFire;
	private boolean walking = false;
	private boolean mousePressed = false;
	private static final Random random = new Random();
	private int fireRate = 0;
	Projectile p;
	public Knight(Sprite sprite) {
		super();
	}
	public Knight(int x, int y){
		this.x = x;
		this.y = y;
		sprite = Sprite.player_backward;
	}
	public boolean sleep(){
		System.out.println(timer);
		if(timer>2000){
			timer = timer-timer;
		}
		while(timer<=1000){
			timer+=500;
		}
		if(timer>=1000){
			timer = timer-timer;
			System.out.println(timer);
			return true;
		}
		return false;
	}
	public void update(){
		if(fireRate>0)fireRate--;
		int xa = 0, ya = 0,speed = 0;
		if(anim<7500)anim++;
		else anim = 0;
		speed = random.nextInt(4);
		if(speed==0){
			if(walking==true){
				ya--;
				sprite = Sprite.player_backward;
				if(anim%20>10){
					sprite = Sprite.player_backward1;
					sprite = Sprite.player_backward2;
					sprite = Sprite.player_backward3;
					}
			}
			spriteFire = Sprite.fire_forward;
			spriteFire = Sprite.fire_forward2;
			
			if(walking==false){
				spriteFire = Sprite.fire_forward;
				spriteFire = Sprite.fire_forward2;
			}
		}
		if(speed==1&&walking==true){
			ya++;
			sprite = Sprite.player_right;
				if(anim%20>10){
					sprite = Sprite.player_right1;
					sprite = Sprite.player_right2;
					sprite = Sprite.player_right3;
				}
			spriteFire = Sprite.fire_right;
			spriteFire = Sprite.fire_right2;
			if(walking==false){
				spriteFire = Sprite.fire_right;
				spriteFire = Sprite.fire_right2;
			}
		}
		if(speed==2&&walking==true){
			sprite = Sprite.player_forward;
			xa--;
				if(anim%20>10){
					sprite = Sprite.player_forward1;
					sprite = Sprite.player_forward2;
					sprite = Sprite.player_forward3;
			}
			spriteFire = Sprite.fire_backward;
			spriteFire = Sprite.fire_backward2;
			if(walking==false){
				spriteFire = Sprite.fire_backward;
				spriteFire = Sprite.fire_backward2;
			}
		}
		if(speed==3&&walking==true){
			sprite = Sprite.player_left;
			xa++;
				if(anim%20>10){
					sprite = Sprite.player_left1;
					sprite = Sprite.player_left2;
					sprite = Sprite.player_left3;
				}
			spriteFire = Sprite.fire_left;
			spriteFire = Sprite.fire_left2;
			if(walking==false){
				spriteFire = Sprite.fire_left;
				spriteFire = Sprite.fire_left2;
			}
		}
		if(xa!=0&&sleep() == true|| ya!=0&&sleep() == true){
			if(!collision(xa,ya)){
				x += xa;
				y += ya;
			}
			move(xa,ya);
			walking = true;
		}
		else{
			walking = false;
			
		}
	}
	protected boolean collision(int xa, int ya){
		boolean solid = false;
		if(level.getTile((x+xa*70)/16,(y+ya*70)/16).soild())solid = true;
		return solid;
	}
	
	public void render(Screen screen){
		int xx = x +60;
		int yy = y -70;
		screen.renderPlayer(xx, yy, sprite);
	}
	
	
}
