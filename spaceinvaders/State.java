package spaceinvaders;

import processing.core.PApplet;
import processing.core.PImage;

public class State
{
	// store our position on the screen
	public float x;
	public float y;
	PImage graphic;
	
	// store a reference to the canvas
	PApplet canvas;
	

	// constructor
	public State(int x, int y, PApplet canvas)
	{
		this.x = x;
		this.y = y;
		this.canvas = canvas;
	}
	
	public void display(int mode)
	{
		if (mode == 0)
		{
			this.graphic = this.canvas.loadImage("catstart.png");
			canvas.image(this.graphic, 0 , 0);
		}
		if (mode == 2)
		{
			this.graphic = this.canvas.loadImage("win.png");
			canvas.image(this.graphic, 0 , 0);
		}
		if (mode == 3)
		{
			this.graphic = this.canvas.loadImage("lose.png");
			canvas.image(this.graphic, 0, 0);
		}
	}
}
