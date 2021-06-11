package mini_project.com.kh.MyPage1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import mini_project.com.kh.MyPage1.Page11;

public class MainPage11 extends JFrame {
//
	private Image img;
	private JPanel contentPane;
//
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { MainPage frame = new MainPage();
	 * frame.setVisible(true);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } } });
	 * 
	 * }
	 * 
	 * /** Create the frame.
	 */
	public MainPage11() {

		/*
		 * setTitle("댕숲"); try { setIconImage(ImageIO.read(new
		 * File("C:/Workspace1/JAVA/MyPage/allergy_dog.png")));
		 * 
		 * } catch (IOException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 */

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1350, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Color b = new Color(160, 242, 196);
		contentPane.setBackground(b);

		JButton btnNewButton = new JButton("상품\r\n");
		btnNewButton.setBounds(149, 91, 110, 37);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("상품후기");
		btnNewButton_1.setBounds(473, 91, 110, 37);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("마이페이지");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Page11();
				System.out.println("[ -> 마이페이지]");
				setVisible(false); // 창 안보이게 하기

			}
		});
		btnNewButton_2.setBounds(783, 91, 110, 37);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("고객센터");
		btnNewButton_3.setBounds(1083, 91, 110, 37);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("로그인");
		btnNewButton_4.setBounds(1095, 10, 97, 23);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("회원가입");
		btnNewButton_5.setBounds(1225, 10, 97, 23);
		contentPane.add(btnNewButton_5);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\h9898\\Desktop\\ui이미지-removebg-preview.png"));
		lblNewLabel.setBounds(417, 242, 402, 372);
		contentPane.add(lblNewLabel);
		setVisible(true);

		setTitle("댕숲");
		try {

			setIconImage(ImageIO.read(new File("C:/Workspace1/JAVA/MyPage/allergy_dog.png")));

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new MainPage11();
	}

}
