package shootAliens;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.prism.paint.Color;

public class LevelWindow extends JPanel implements ActionListener,KeyListener{
	
	JFrame window = new JFrame();
	String[] s = {"Alien-Level"};
	JComboBox nameOfLevels = new JComboBox(s);
	JButton enterButton = new JButton();
	JButton backButton = new JButton();
	
	Font customFont = new Font("Bold",Font.BOLD,30);
	Font comboFont = new Font("Italic",Font.ITALIC,25);
	
	LevelWindow()
	{
		window.add(this);
		
		nameOfLevels.setFont(comboFont);
		nameOfLevels.getForeground();
		
		window.add(nameOfLevels,BorderLayout.PAGE_START);
		
		backButton.setFont(customFont);
		backButton.setText("Back");
		backButton.addKeyListener(this);
		backButton.addActionListener(this);
		window.add(backButton,BorderLayout.PAGE_END);
		
		enterButton.setIcon(new ImageIcon("Images//earthAlien.jpg"));
		enterButton.addKeyListener(this);
		enterButton.addActionListener(this);
		window.add(enterButton,BorderLayout.CENTER);
		
		window.setUndecorated(true);
		window.setSize(750,550);
		window.setLocation(50,50);
		window.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent kp) {
		if(kp.getKeyCode()==KeyEvent.VK_ESCAPE)
		{
			window.dispose();
			Menu m = new Menu();
		}
		
		else if(kp.getKeyCode()==KeyEvent.VK_ENTER&&nameOfLevels.getSelectedIndex()==0)
		{
			JOptionPane.showMessageDialog(null, "Alien level not ready");
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

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==backButton)
		{
			window.dispose();
			Menu m = new Menu();
		}
		
		else if(ae.getSource()==enterButton&&nameOfLevels.getSelectedIndex()==0)
		{
			JOptionPane.showMessageDialog(null, "Alien level is still in maintenance");
		}
		
	}

}
