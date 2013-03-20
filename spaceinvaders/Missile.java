package spaceinvaders;

import processing.core.PApplet;

public class Missile
{
	// store our current position on the screen
	public int x;
	public int y;
	public static int ammo = 10;
	
	// store a reference to our graphical canvas
	public PApplet canvas;


	// constructor
	public Missile(int x, int y, PApplet canvas)
	{
		this.x = x;
		this.y = y;
		this.canvas = canvas;
	}

	// missiles consistently move up towards the top of the screen
	public void move()
	{
		this.y -= 5;
	}
	
	// draw the missile on the screen
	public void display()
	{
		this.canvas.fill(225);
		this.canvas.rect(x,y,5,25);
	}
	
	// "reload" the missile - essentially place it on top of the player
	// and trigger the sound effect
	public void reload(int x2, int y2)
	{
		if (ammo > 0)
		{
			this.x = x2;
			this.y = y2;
			ammo --;
		}
	}
	
	public void moreAmmo(int x)
	{
		if ((x < 100 || x > 900) && (ammo < 10))
			ammo ++;
	}
	
}
