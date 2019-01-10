package shootAliens;

import java.awt.Rectangle;

public class Fire extends Thread{

	
	Bullets bullets;
	AlienLevel gl;
	Alien[][] alien;
	
	Fire(Bullets bullets, AlienLevel gl, Alien[][]alien)
	{
		this.bullets = bullets;
		this.gl = gl;
		this.alien = alien;
		
	}
	
	
	public void run()
	{
		while(bullets.getyAxis()>-100)
		{
			bullets.setyAxis(bullets.getyAxis()-10);
			checkCollision();
			
			try {
			Thread.sleep(100);
			}
			catch (InterruptedException e )
			{
			e.printStackTrace();
			}
			gl.repaint();
	}
	}
	
	public void checkCollision()
	{
		Rectangle bulletsRect = new Rectangle(bullets.getxAxis(),bullets.getyAxis(),17,13);
		
		for(int i = 0 ; i<alien.length; i++)
		{
			for(int j = 0; j<alien[j].length; j++)
			{
				Rectangle alienRect= new Rectangle(alien[i][j].getxAxis(),alien[i][j].getyAxis(),23,69);
				if (bulletsRect.intersects(alienRect))
				{
					alien[i][j].setxAxis(500000);
					bullets.setxAxis(-500000);
				}
			}
		}
	}

}
