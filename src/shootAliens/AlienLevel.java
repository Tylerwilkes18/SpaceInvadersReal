package shootAliens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AlienLevel extends JPanel implements KeyListener {

	JFrame window = new JFrame("Alien level");
	Shooter shooter = new Shooter(400,500,"Images//Laser_Cannon.png");
	Alien[][] alien = new Alien[2][20];
	int xAxis = 0;
	int yAxis = 0;
	Bullets[] bullets = new Bullets[1000];	
	int count = 0;
	Dropper dropper = new Dropper(this, alien);
	private boolean fail = false;
	
	AlienLevel()
	{
		this.setFocusable(true);
		this.addKeyListener(this);
		
		window.add(this);
		
		for(int i = 0;1<alien.length;i++)
		{
			for(int j = 0; 1<alien[i].length;j++)
			{
				alien[i][j] = new Alien(xAxis, yAxis, "Images//sprite1.jpg");
				xAxis += 50;
			}
			yAxis+=50;
			xAxis = 0;
		}
		
		dropper.start();
		
		for(int i = 0;i<bullets.length;i++) 
		{
			bullets[i] = new Bullets(410,650, "Images//LaserCannon.png");
			
		}
		
		window.setSize(800,650);
		window.setLocation(200,180);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	
	public void paint(Graphics g)
	{
	
		ImageIcon background = new ImageIcon("Images//Space.jpg");
		g.drawImage(background.getImage(),0, 0, null);
		
		shooter.drawShooter(g);
		for(int i=0; i<alien.length;i++)
		{
			for(int j = 0; j<alien[i].length;j++)
			{
				alien[i][j].drawAlien(g);
			}
		}
		
		for(int i = 0; i<bullets.length;i++)
		{
			bullets[i].drawBullet(g);
		}
		g.setColor(Color.WHITE);
		g.setFont(new Font("",Font.BOLD,22));
		g.drawString("Score = ", 650, 500);
		levelFailed();
		
	}
	
	public void levelFailed()
	{
		for(int i = 0; i<alien.length;i++)
		{
			for(int j = 0; j<alien[i].length;j++)
			{
				if(alien[i][i].getyAxis()>350)
				{
					
					fail = true;
					dropper.stop();
					break;
				}
			}
		}
		
		if(fail== true)
		{
			window.dispose();
			JOptionPane.showMessageDialog(null, "Game Over!");
		}
	}
	
	@Override
	public void keyPressed(KeyEvent kp) {
		if(kp.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			if(shooter.getxAxis()<805)
				shooter.setxAxis(shooter.getyAxis()+5);
			this.repaint();
				
		}
		else if(kp.getKeyCode()==KeyEvent.VK_LEFT)
		{
			if(shooter.getxAxis()>-2)
			{
				shooter.setxAxis(shooter.getxAxis()-5);
			}
				this.repaint();
			
		}
		
		else if(kp.getKeyCode()==KeyEvent.VK_SPACE)
		{
			try {
				File sound = new File("Sounds//Cannonlaser.aiff");
			AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
			
			}catch(Exception e) {System.out.println(e);}
			
			Fire f = new Fire(bullets[count],this,alien);
			bullets[count].setxAxis(shooter.getxAxis()+30);
			bullets[count].setyAxis(shooter.getyAxis()+10);
			f.start();
			count++;
			
		}
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
