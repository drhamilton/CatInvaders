package spaceinvaders;

import processing.core.PApplet;
import processing.core.PImage;

public class RedAlien extends Alien
{
	// red aliens get their own graphic
	PImage graphic;
	PImage graphic2;
	
	public RedAlien(int x, int y, PApplet canvas)
	{
		super(x,y,canvas);
		
		// load in the alien1.png graphic from the data folder
		// store it in our graphic instance variable
		this.graphic = this.canvas.loadImage("greencat.png");
		this.graphic2 = this.canvas.loadImage("blackcat.png");
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
			
			if (change < .5)
			{
				canvas.image(this.graphic, this.x ,this.y, this.size, this.size);
			}
			else
			{
				canvas.image(this.graphic2, this.x ,this.y, this.size, this.size);
			}
		}
	}
}
