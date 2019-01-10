package shootAliens;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.scene.paint.Color;

public class Menu extends JPanel implements ActionListener,KeyListener {
	
	JFrame window = new JFrame();
	JButton playButton = new JButton();
	JButton exitButton = new JButton();
	JLabel infoLabel = new JLabel();
	JLabel centerImageLabel = new JLabel();
	JButton backgroundButton = new JButton();
	
	Font customFont = new Font("Italic",Font.ITALIC,22);
	
	Menu()
	{
		
		this.setForeground(Color.DARKGRAY);
		this.setBackground(Color.DARKGRAY);
		window.add(this);
		
		
		playButton.setIcon(new ImageIcon("images//play.png"));
		playButton.addActionListener(this);
		playButton.addKeyListener(this);
		window.add(playButton, BorderLayout.PAGE_START);
		
		exitButton.setIcon(new ImageIcon("images//exit.png"));
		exitButton.addActionListener(this);
		exitButton.addKeyListener(this);
		window.add(exitButton, BorderLayout.PAGE_END);
		
		infoLabel.setText("Press 'S' to shoot");
		infoLabel.setFont(customFont);
		infoLabel.setOpaque(true);
		window.add(infoLabel,BorderLayout.EAST);
		
		centerImageLabel.setIcon(new ImageIcon("images//Space.jpg"));
		window.add(centerImageLabel,BorderLayout.CENTER);
		
		window.setLocation(40, 40);
		window.setUndecorated(true);
		window.setSize(1000,550);
		window.setVisible(true);
		
	}

	private void setForeground(Color mediumseagreen) {
		// TODO Auto-generated method stub
		
	}

	private void setBackground(Color mediumseagreen) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent kp) {
		if(kp.getKeyCode()==KeyEvent.VK_ESCAPE)
		{
			window.dispose();
		}
		
		else if(kp.getKeyCode()==KeyEvent.VK_ENTER)
		{
			window.dispose();
			LevelWindow lw = new LevelWindow();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==exitButton)
		{
			window.dispose();
		}
		
		else if(ae.getSource()==playButton)
		{
			window.dispose();
			LevelWindow lw = new LevelWindow();
		}
	}

}
