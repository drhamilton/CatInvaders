package spaceinvaders;

import processing.core.PApplet;
import processing.core.PImage;

public class cat extends Alien
{
	
	PImage graphic;
	PImage graphic2;
	
	public cat(int x, int y, PApplet canvas)
	{
		super(x,y,canvas);
		
		// laod in the cat.png graphic from the data folder
		// store it in our graphic instance variable
		this.graphic = this.canvas.loadImage("cat.png");
		this.graphic2 = this.canvas.loadImage("cat2.png");
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
			
			if (change < .7)
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