package spaceinvaders;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import java.util.*;

public class spaceinvaders extends PApplet 
{
	// the user controlled player
	Player thePlayer;
	int playerMovementDirection = 0;

	// the user controlled missile
	ArrayList<Missile> missileList;
	EnemyMissile enemyMissile;

	// our aliens
	Alien[][] theAliens;
	
	//determines what screen is displayed
	int mode;

	State state;
	
	public void setup() 
	{
		// set the size of our graphics canvas
		size(1000, 300);
		
		// smooth all drawing
		smooth();
		
		// draw all rectangles from their center points
		rectMode(CENTER);

		// create a new instance of our Player class
		this.thePlayer = new Player(this.width/2, this.height-25, this);
		
		// create a new instance of our Missile class
		// (the player only gets one missile - if they shoot more than one then we
		// simply take the one in flight and bring it back down so that it can fire again)
		this.missileList = new ArrayList<Missile>();
		
		
		this.enemyMissile = new EnemyMissile(0 , 0, this);
		
		// create aliens
		this.theAliens = new Alien[4][4];
		
		//blue row
		this.theAliens[0][0] = new BlueAlien(0, 25, this);
		this.theAliens[1][0] = new BlueAlien(50, 25, this);
		this.theAliens[2][0] = new BlueAlien(100, 25, this);
		this.theAliens[3][0] = new BlueAlien(150, 25, this);
		
		//red row
		this.theAliens[0][1] = new RedAlien(0, 50, this);
		this.theAliens[1][1] = new RedAlien(50, 50, this);
		this.theAliens[2][1] = new RedAlien(100, 50, this);
		this.theAliens[3][1] = new RedAlien(150, 50, this);
		
		//skull row
		this.theAliens[0][2] = new skull(0, 75, this);
		this.theAliens[1][2] = new skull(50, 75, this);
		this.theAliens[2][2] = new skull(100, 75, this);
		this.theAliens[3][2] = new skull(150, 75, this);
		
		//cat row
		this.theAliens[0][3] = new cat(0, 100, this);
		this.theAliens[1][3] = new cat(50, 100, this);
		this.theAliens[2][3] = new cat(100, 100, this);
		this.theAliens[3][3] = new cat(150, 100, this);
		
		//load state class
		this.state = new State(0, 0, this);

		// load in our font so that we can draw text to the screen
		PFont genericFont = loadFont("sansSerifFont24.vlw");
		
		// set the default font as the one we just loaded
		this.textFont( genericFont );
	}

	public void draw() 
	{
		
		//start state
		if (mode == 0)
		{	
			state.display(mode);
			
			if (keyPressed)
			{
				mode = 1;
			}
		}
		
		//gameplay state
		if (mode == 1)
		{
			// erase the background
			background(0);
			
			// title text
			fill(255);
			text("Cosmic Cats!", 0, 25);
			text("Score: " + Alien.points, 0, 50);
			text("Ammo: " + Missile.ammo, 0, 75);
					
			// iterate over all aliens
			for (int i = 0; i < this.theAliens.length; i++)
			{
				for (int x = 0; x < this.theAliens.length; x ++)
				{
				// tell each one to move
				this.theAliens[x][i].move();
				
				// check each alien to see if the missile hit them
				// if so the alien will flip its own "alive" variable to false
				for (int n = 0; n < this.missileList.size(); n ++)
				{
					boolean hit = this.theAliens[x][i].missileHitTest(this.missileList.get(n).x,  this.missileList.get(n).y);
				}
				
				// you could do something with "hit" here if you needed to react to an alien being hit
	
				// display each alien
				this.theAliens[x][i].display();
				}
			}
				
			// move and display the missile
			for (int i = 0; i < missileList.size(); i ++)
			{
				this.missileList.get(i).move();
				this.missileList.get(i).display();
				this.missileList.get(i).moreAmmo(this.thePlayer.x);
			}
					
			this.enemyMissile.move();
			this.enemyMissile.display();
			if (this.enemyMissile.y > 300)
			{
				//random alien is shooter
				Alien shooter = this.theAliens[(int) (Math.random() * 4)][(int) (Math.random() * 4)];
				
				//check if shooter alive, if so, shoot
				if (shooter.alive)
				{
					this.enemyMissile.reload(shooter.x, shooter.y);
				}
			}
			
			
			// move and display the player
			this.thePlayer.move(this.playerMovementDirection);
			this.thePlayer.display();
			
			
			//check if won
			if (Alien.points == 16)
			{
				//change to winstate
				mode = 2;
			}
			
			//check if hit by enemy missile
			//if true, go to lose screen
			if (this.thePlayer.missileHitTest(this.enemyMissile.x, this.enemyMissile.y))
				{
					mode = 3;
				}
		}
		
		//win
		if (mode == 2)
		{
			state.display(mode);
		}
		
		//lose
		if (mode == 3)
		{
			state.display(mode);
		}
	}

	// every time a key is pressed this method will execute
	public void keyPressed()
	{
		// user hit the 'a' key - indicate that we want to move left
		if (key == 'a')
		{
			this.playerMovementDirection = -1;
		}
		
		// user hit the 'd' key - indicate that we want to move right
		if (key == 'd')
		{
			this.playerMovementDirection = 1;
		}
		
		// user hit the 'w' key - reload and fire the missile
		if ((key == 'w') && (Missile.ammo > 0))
		{
			Missile temp = new Missile(thePlayer.x, thePlayer.y, this);
			missileList.add(temp);
			Missile.ammo --;
		}
	}
	
	// every time a key is released this method will execute
	public void keyReleased()
	{
		// indicate that the player should stop moving
		this.playerMovementDirection = 0;
	}
	
}
