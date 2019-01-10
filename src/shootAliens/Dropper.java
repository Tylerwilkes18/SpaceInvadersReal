package shootAliens;

public class Dropper extends Thread
{
	AlienLevel gl;
	Alien[][] alien;
	
	Dropper(AlienLevel gl, Alien[][] alien)
	{
		this.alien = alien;
		this.gl = gl;
	}
	
	public void run()
	{
		while(alien[0][0].getyAxis()<700) 
		{
			
		for(int i = 0; i<alien.length;i++)
		{
			for(int j = 0; j<alien[i].length;j++)
			{
				alien[i][j].setyAxis(alien[i][j].getyAxis()+30);
				System.out.println(alien[i][j].getyAxis());
				
			}
		}
		try {
			Thread.sleep(900);
		} catch(Exception e) {System.out.println(e);}
		gl.repaint();
		
		}
	}
	

}
