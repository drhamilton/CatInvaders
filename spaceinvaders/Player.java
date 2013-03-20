package spaceinvaders;

import processing.core.PApplet;

public class Player
{
	// keep track of our location on the screen
	public int x;
	public int y;
	public boolean alive;
	public int size;
	
	// also store a reference to the graphics canvas
	public PApplet canvas;
	
	// constructor
	public Player(int x, int y, PApplet canvas)
	{
		this.x = x;
		this.y = y;
		this.canvas = canvas;
		this.alive = true;
		this.size = 25;
	}
	
	// move - accepts a direction (integer)
	// -1 = move left
	//  0 = don't move
	// +1 = move right
	public void move(int direction)
	{
		if (direction == -1)
		{
			moveLeft();
		}
		
		if (direction == 1)
		{
			moveRight();
		}
	}
	
	// moveLeft - moves the player the left and allows them to wrap around from side to side
	public void moveLeft()
	{
		// move to the left
		this.x -= 3;
		
		// if we go off the left edge we should reorient to the right edge
		if (this.x < 0)
		{
			this.x = this.canvas.width;
		}
	}
	
	// moveRight - moves the player to the right and allows them to wrap around from side to side
	public void moveRight()
	{
		// move to the right
		this.x += 3;
		
		// if we go off the right edge we should reorient to the left side
		if (this.x > this.canvas.width)
		{
			this.x = 0;
		}
	}
	
	// draw our player (basic rectangle)
	public void display()
	{
		this.canvas.fill(150);
		this.canvas.rect(this.x, this.y, 25, 10);
	}
	
	public boolean missileHitTest(int mx, int my)
	{
		// if we are alive and the missile is intersecting our current location
		// then we have a hit
		if (this.alive && mx > this.x && mx < this.x+size && my > this.y && my < this.y+this.size)
		{
			this.alive = false;
			return true;
		}
		
		return false;
	}
	
}
