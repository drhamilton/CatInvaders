package spaceinvaders;

import processing.core.PApplet;

public class EnemyMissile
{
	// store our current position on the screen
	public int x;
	public int y;
	
	// store a reference to our graphical canvas
	public PApplet canvas;


	// constructor
	public EnemyMissile(int x, int y, PApplet canvas)
	{
		this.x = x;
		this.y = y;
		this.canvas = canvas;
	}

	// missiles consistently move up towards the top of the screen
	public void move()
	{
		this.y += 5;
	}
	
	// draw the missile on the screen
	public void display()
	{
		this.canvas.fill(200);
		this.canvas.rect(x,y,5,25);
	}
	
	// "reload" the missile - essentially place it on top of the player
	// and trigger the sound effect
	public void reload(float x2, float y2)
	{
		this.x = (int) x2;
		this.y = (int) y2;
	}
}

