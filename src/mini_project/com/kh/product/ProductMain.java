package mini_project.com.kh.product;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import mini_project.com.kh.product.Cart;
import mini_project.com.kh.product.ProductList_Acc;
import mini_project.com.kh.product.ProductList_Best;
import mini_project.com.kh.product.ProductList_Clo;
import mini_project.com.kh.product.ProductList_Etc;
import mini_project.com.kh.product.ProductList_ToySnack;
import mini_project.com.kh.product.ProductMain;

public class ProductMain extends JFrame {
	public ProductMain() {
		//상품 메인 화면
		setLayout(new GridLayout(2, 3, 4, 4));
		JButton button = new JButton("베스트 상품", new ImageIcon("img/best.png"));
		JButton button1 = new JButton("의류", new ImageIcon("img/sf.png"));
		JButton button2 = new JButton("장난감&간식", new ImageIcon("img/snack.png"));
		JButton button3 = new JButton("액세서리", new ImageIcon("img/acc.png"));
		JButton button4 = new JButton("기타", new ImageIcon("img/sham.png"));
		JButton button5 = new JButton("장바구니", new ImageIcon("img/cart.png"));

		add(button);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);

		//상품 메인&버튼 색
		button.setBackground(new Color(160, 242, 196));
		button1.setBackground(new Color(160, 242, 196));
		button2.setBackground(new Color(160, 242, 196));
		button3.setBackground(new Color(160, 242, 196));
		button4.setBackground(new Color(160, 242, 196));
		button5.setBackground(new Color(160, 242, 196));

		getContentPane().setBackground(new Color(160, 242, 196));

		
		
		//button(베스트) -> 이동
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductList_Best();
				System.out.println("[ -> 베스트 카테고리]");
				setVisible(false); // 창 안보이게 하기
			}
		});

		
		//button1(의류) -> 이동
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductList_Clo();
				System.out.println("[ -> 의류 카테고리]");
				setVisible(false); // 창 안보이게 하기
			}
		});		
		
		//button2(장난감&간식) -> 이동
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductList_ToySnack();
				System.out.println("[ -> 장난감&간식 카테고리]");
				setVisible(false); // 창 안보이게 하기
			}
		});		
		
		//button3(액세서리) -> 이동
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductList_Acc();
				System.out.println("[ -> 액세서리 카테고리]");
				setVisible(false); // 창 안보이게 하기
			}
		});	
		
		//button4(기타) -> 이동
		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductList_Etc();
				System.out.println("[ -> 기타 카테고리]");
				setVisible(false); // 창 안보이게 하기
			}
		});

		//button5(장바구니) -> 이동
		button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Cart();
				System.out.println("[ -> 장바구니]");
				setVisible(false); // 창 안보이게 하기
			}
		});

		//크기
		this.setBounds(30, 30, 1350, 900);
		setResizable(false);// 크기 고정
		setAlwaysOnTop(true);

		setTitle("댕숲");
		try {
			setIconImage(ImageIO.read(new File("img/d.PNG")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("환영합니다. 댕댕이의 숲 상품 홈입니다. 즐거운 쇼핑 되세요");
		new ProductMain();
	}
}

