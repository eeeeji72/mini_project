package mini_project.com.kh.project1;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
public class ex5 extends JFrame {//그림나오는 거
	public ex5(){
		JPanel p = new JPanel();
		add(p);
		setSize(1350, 900);
		setTitle("확인");
		getContentPane().setBackground(new Color(160, 242, 196));
		try {
			setIconImage(ImageIO.read(new File("img/dog.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void paint(Graphics g)
	{
		g.drawRect(30, 50, 460, 440);//20 40
		g.drawRect(110,390,300,50);
		g.drawRect(240,190,50,150);
		g.drawOval(140,80,50,50);
		g.drawOval(330,80,50,50);
		g.fillOval(160, 90, 30, 30);
		g.fillOval(330, 90, 30, 30);
	}
	
}
