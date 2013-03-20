package spaceinvaders;

import processing.core.PApplet;
import processing.core.PImage;

public class winState
{
	// store our position on the screen
	public float x;
	public float y;
	PImage graphic;
	
	// store a reference to the canvas
	PApplet canvas;
	

	// constructor
	public winState(int x, int y, PApplet canvas)
	{
		this.x = x;
		this.y = y;
		this.canvas = canvas;
		this.graphic = this.canvas.loadImage("win.png");
	}
	
	public void display()
	{
		canvas.image(this.graphic, 0 , 0);
	}
}
