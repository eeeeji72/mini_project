package mini_project.com.kh.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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

import mini_project.com.kh.cs.board.MainBoard;
import mini_project.com.kh.login.MemberJoin;
import mini_project.com.kh.login.MemberLogin;
import mini_project.com.kh.my.Page11;
import mini_project.com.kh.product.ProductMain;
import mini_project.com.kh.product.Snack_Gum;
import mini_project.com.kh.review.ReviewMain;

public class MainPage11 extends JFrame{

	private Image img;
	private JPanel contentPane;

	public MainPage11() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1350, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Color b = new Color(160, 242, 196);
		contentPane.setBackground(b);

		// 폰트, 크기 적용
		Font btn = new Font("NotoSansCJKkr", Font.PLAIN, 13);
		
		JButton btnNewButton = new JButton("상품 홈\r\n");
		btnNewButton.setBounds(149, 91, 110, 37);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductMain();
				System.out.println("환영합니다. 댕댕이의 숲 상품 홈입니다. 즐거운 쇼핑 되세요");				
				System.out.println("[ -> 상품 홈]");
				setVisible(false); // 창 안보이게 하기
			}
		});		

		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(btn);
		contentPane.add(btnNewButton);
	

		JButton btnNewButton_1 = new JButton("상품후기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReviewMain();
				System.out.println("[ -> 상품후기]");
				setVisible(false); // 창 안보이게 하기

			}
		});
		btnNewButton_1.setBounds(473, 91, 110, 37);
		btnNewButton_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(btn);
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
		btnNewButton_2.setBackground(new Color(0, 153, 255));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(btn);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("고객센터");
		btnNewButton_3.setBounds(1083, 91, 110, 37);
		btnNewButton_3.setBackground(new Color(0, 153, 255));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(btn);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainBoard main = new MainBoard();
				main.setVisible(true);
				setVisible(false); 
			}
		});
		
		
		
		

		JButton btnNewButton_4 = new JButton("로그인");
		btnNewButton_4.setBounds(1095, 10, 97, 23);
		btnNewButton_4.setBackground(new Color(0, 153, 255));
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setFont(btn);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MemberLogin ml = new MemberLogin();
				ml.setVisible(true);
				setVisible(false); 
			}
		});
		JButton btnNewButton_5 = new JButton("회원가입");
		btnNewButton_5.setBounds(1225, 10, 97, 23);
		btnNewButton_5.setBackground(new Color(0, 153, 255));
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setFont(btn);
		contentPane.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MemberJoin mj = new MemberJoin();
				//mj.setVisible(true);
				setVisible(false); 
			}
		});
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("img/d.PNG"));
		lblNewLabel.setBounds(417, 242, 402, 372);
		contentPane.add(lblNewLabel);
		setVisible(true);

		setTitle("댕숲");
		try {

			setIconImage(ImageIO.read(new File("img/d.PNG")));

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new MainPage11();
	}

}

