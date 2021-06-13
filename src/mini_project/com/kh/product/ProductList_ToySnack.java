package mini_project.com.kh.product;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import mini_project.com.kh.product.ProductMain;

public class ProductList_ToySnack extends JFrame implements MouseListener {
	public ProductList_ToySnack() {
		// TODO Auto-generated constructor stub
		// panel 생성
		JPanel panel = new JPanel();
		panel.addMouseListener(this);
		
		// 세로 스크롤만 적용
		getContentPane().add(new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

		// GridBagLayout 설정
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 450, 450, 450, 450, 0 };
		gbl_panel.rowHeights = new int[] { 300, 300, 300, 300 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };

		panel.setLayout(gbl_panel);

		// ---------------------상품 1
		JButton button = new JButton("건식 사료", new ImageIcon("img/food.png"));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		panel.add(button, gbc_button);
		button.setBackground(new Color(160, 242, 196));
		button.addMouseListener(this);

		// ---------------------상품 2
		JButton button1 = new JButton("닭가슴살", new ImageIcon("img/chi.png"));
		GridBagConstraints gbc_button1 = new GridBagConstraints();
		gbc_button1.fill = GridBagConstraints.BOTH;
		gbc_button1.insets = new Insets(0, 0, 5, 5);
		gbc_button1.gridx = 1;
		gbc_button1.gridy = 0;
		panel.add(button1, gbc_button1);
		button1.setBackground(new Color(160, 242, 196));
		button1.addMouseListener(this);

		// ---------------------상품 3
		JButton button2 = new JButton("개껌", new ImageIcon("img/bone.png"));
		GridBagConstraints gbc_button2 = new GridBagConstraints();
		gbc_button2.fill = GridBagConstraints.BOTH;
		gbc_button2.insets = new Insets(0, 0, 5, 5);
		gbc_button2.gridx = 2;
		gbc_button2.gridy = 0;
		panel.add(button2, gbc_button2);
		button2.setBackground(new Color(160, 242, 196));
		button2.addMouseListener(this);

		// ---------------------상품 4
		JButton button3 = new JButton("플라잉 디스크", new ImageIcon("img/fdisk.png"));
		GridBagConstraints gbc_button3 = new GridBagConstraints();
		gbc_button3.fill = GridBagConstraints.BOTH;
		gbc_button3.insets = new Insets(0, 0, 5, 5);
		gbc_button3.gridx = 0;
		gbc_button3.gridy = 1;
		panel.add(button3, gbc_button3);
		button3.setBackground(new Color(160, 242, 196));
		button3.addMouseListener(this);

		// ---------------------상품 5
		JButton button4 = new JButton("삑삑이 인형 세트", new ImageIcon("img/doll.png"));
		GridBagConstraints gbc_button4 = new GridBagConstraints();
		gbc_button4.fill = GridBagConstraints.BOTH;
		gbc_button4.insets = new Insets(0, 0, 5, 5);
		gbc_button4.gridx = 1;
		gbc_button4.gridy = 1;
		panel.add(button4, gbc_button4);
		button4.setBackground(new Color(160, 242, 196));
		button4.addMouseListener(this);

		// ---------------------상품 6
		JButton button5 = new JButton("고무공", new ImageIcon("img/softball.png"));
		GridBagConstraints gbc_button5 = new GridBagConstraints();
		gbc_button5.fill = GridBagConstraints.BOTH;
		gbc_button5.insets = new Insets(0, 0, 5, 5);
		gbc_button5.gridx = 2;
		gbc_button5.gridy = 1;
		panel.add(button5, gbc_button5);
		button5.setBackground(new Color(160, 242, 196));
		button5.addMouseListener(this);

		// ---------------------상품 7
		JButton button6 = new JButton("간식", new ImageIcon("img/snack.png"));
		GridBagConstraints gbc_button6 = new GridBagConstraints();
		gbc_button6.fill = GridBagConstraints.BOTH;
		gbc_button6.insets = new Insets(0, 0, 5, 5);
		gbc_button6.gridx = 0;
		gbc_button6.gridy = 2;
		panel.add(button6, gbc_button6);
		button6.setBackground(new Color(160, 242, 196));
		button6.addMouseListener(this);
		

		//---------------------상품 8
		JButton button7 = new JButton("육포", new ImageIcon("img/meat.png"));
		GridBagConstraints gbc_button7 = new GridBagConstraints();
		gbc_button7.fill = GridBagConstraints.BOTH;
		gbc_button7.insets = new Insets(0, 0, 5, 5);
		gbc_button7.gridx = 1;
		gbc_button7.gridy = 2;
		panel.add(button7, gbc_button7);
		button7.setBackground(new Color(160, 242, 196));
		button7.addMouseListener(this);

		//---------------------상품 9
		JButton button8 = new JButton("봉제인형 세트", new ImageIcon("img/toy2.png"));
		GridBagConstraints gbc_button8 = new GridBagConstraints();
		gbc_button8.fill = GridBagConstraints.BOTH;
		gbc_button8.insets = new Insets(0, 0, 5, 5);
		gbc_button8.gridx = 2;
		gbc_button8.gridy = 2;
		panel.add(button8, gbc_button8);
		button8.setBackground(new Color(160, 242, 196));
		button8.addMouseListener(this);

		//---------------------상품 10
		JButton button9 = new JButton("삑삑공", new ImageIcon("img/ball.png"));
		GridBagConstraints gbc_button9 = new GridBagConstraints();
		gbc_button9.fill = GridBagConstraints.BOTH;
		gbc_button9.insets = new Insets(0, 0, 5, 5);
		gbc_button9.gridx = 0;
		gbc_button9.gridy = 3;
		panel.add(button9, gbc_button9);
		button9.setBackground(new Color(160, 242, 196));
		button9.addMouseListener(this);

		
		// panel 색상
		panel.setBackground(new Color(160, 242, 196));

		// 사이즈
		this.setBounds(30, 30, 1350, 900);

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

		// 크기 고정
		setResizable(false);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		if (e.getModifiers() == MouseEvent.BUTTON3_MASK) {
			System.out.println("[장난감&간식 카테고리 -> 상품 홈]");
			new ProductMain();
			setVisible(false);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}