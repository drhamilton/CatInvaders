package spaceinvaders;

import processing.core.PApplet;
import processing.core.PImage;

public class BlueAlien extends Alien
{
	// blue aliens get their own graphic
	PImage graphic;
	
	public BlueAlien(int x, int y, PApplet canvas)
	{
		super(x,y,canvas);
		
		// laod in the alien1.png graphic from the data folder
		// store it in our graphic instance variable
		this.graphic = this.canvas.loadImage("greycat.png");
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
				canvas.image(this.graphic, this.x + 5 ,this.y, this.size, this.size);
			}
			else if (change < .8)
			{
				canvas.image(this.graphic, this.x ,this.y, this.size, this.size);
			}
			else
			{
				canvas.image(this.graphic, this.x - 5 ,this.y, this.size, this.size);
			}
		}
	}
}
