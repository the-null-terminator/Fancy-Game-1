package enemies;

import java.util.Random;

import com.sun.prism.Graphics;

import main.Projectile;

public class Ninja extends main.Enemy {

	public static int minDif = 2; // minimum difficulty level required to spawn
	public static int nMod = 5; // 1/nMod = likelyhood of spawning
	public Ninja(int x, int y, int k) {
		super(x, y, k);
		// TODO Auto-generated constructor stub
		speed = 5;
	}
	
	public Ninja(int x, int y, int k,int attack, int defense) {
		super(x, y, k, attack, defense);
		speed = 5;
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, (eList.get(i)).x - 300, (eList.get(i)).y - 220, null);
	}
	
	public void shapeMe() {/*
		super.addPoint(x-5, y);
		super.addPoint(x+5, y);
		super.addPoint(x+5, y-8);
		super.addPoint(x+20, y-8);
		super.addPoint(x-20, y-8);
		super.addPoint(x, y-30);*/
		super.addPoint(x-5, y);
		super.addPoint(x+5, y);
		super.addPoint(x+5, y-8);
		super.addPoint(x+20, y-10);
		super.addPoint(x, y+30);
		super.addPoint(x-20, y-10);
		super.addPoint(x-5, y-8);
	}
	
	//Creates and returns a projectile
	public Projectile shoot()
	{
		shootCount=160;
		return new Projectile(x,y,-1);
	}
	
	//determines enemy movement
	public void act() {
		spookyCheckBounds();
		if (driftDir&&hp>0) {		
			driftRight();
		} else if (hp>0) {
			driftLeft();
		}
		if((int)(Math.random()*10)==0)
		{
			driftDown();
		}
		else if((int)(Math.random()*20)==0)
		{
			driftUp();
		}
		if((int)(Math.random()*30)==0) {
			driftDir=new Random().nextBoolean();
		}
		shootCount--;
	}
	
	
}
