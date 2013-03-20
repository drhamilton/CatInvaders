package spaceinvaders;

import processing.core.PApplet;
import processing.core.PImage;

public class skull extends Alien
{
	// blue aliens get their own graphic
	PImage graphic;
	
	public skull(int x, int y, PApplet canvas)
	{
		super(x,y,canvas);
		
		// laod in the skull.png graphic from the data folder
		// store it in our graphic instance variable
		this.graphic = this.canvas.loadImage("catwhite.png");
	}
	
	// override the superclass display method
	@Override
	public void display()
	{
		double change = Math.random();
		// only draw if we are alive
		if (this.alive)
		{
			// image the graphic to the screen
			
			if (change < .2)
			{
				canvas.image(this.graphic, this.x ,this.y, this.size + 3, this.size + 3);
			}
			else if (change < .8)
			{
				canvas.image(this.graphic, this.x ,this.y, this.size, this.size);
			}
			else
			{
				canvas.image(this.graphic, this.x ,this.y, this.size - 3, this.size - 3);
			}
		}
	}
}