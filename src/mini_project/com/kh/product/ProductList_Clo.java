package mini_project.com.kh.product;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import mini_project.com.kh.cs.board.MainBoard;
import mini_project.com.kh.main.MainPage11;
import mini_project.com.kh.my.Page11;
import mini_project.com.kh.product.ProductMain;
import mini_project.com.kh.review.ReviewMain;

public class ProductList_Clo extends JFrame implements MouseListener {
	public ProductList_Clo() {

		JMenuBar menuBar = new JMenuBar(); // 메뉴바 생성

		// 메뉴 생성
		JMenu categ = new JMenu("카테고리");
		JMenu my = new JMenu("내 정보");
		JMenu cen = new JMenu("고객센터");
		JMenu main = new JMenu("메인페이지");
		JMenu review = new JMenu("상품후기");

		// 폰트, 크기 적용
		Font ft = new Font("NotoSansCJKkr", Font.BOLD, 13);
		categ.setFont(ft);
		my.setFont(ft);
		cen.setFont(ft);
		main.setFont(ft);
		review.setFont(ft);

		menuBar.add(categ);
		menuBar.add(my);
		menuBar.add(cen);
		menuBar.add(main);
		menuBar.add(review);

		// 서브메뉴-카테고리
		JMenuItem menuItem = null;

		menuItem = new JMenuItem("상품 홈");
		menuItem.addActionListener(menuItemListener);
		categ.add(menuItem);
		// 클릭시 이동
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductMain();
				System.out.println("[ -> 상품 홈]");
				setVisible(false); // 창 안보이게 하기
			}
		});
		categ.addSeparator();

		menuItem = new JMenuItem("장난감");
		menuItem.addActionListener(menuItemListener);
		categ.add(menuItem);
		// 클릭시 이동
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductList_Toy();
				System.out.println("[ -> 장난감 카테고리]");
				setVisible(false); // 창 안보이게 하기
			}
		});

		menuItem = new JMenuItem("의류");
		menuItem.addActionListener(menuItemListener);
		categ.add(menuItem);
		// 클릭시 이동
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductList_Clo();
				System.out.println("[ -> 의류 카테고리]");
				setVisible(false); // 창 안보이게 하기
			}
		});

		menuItem = new JMenuItem("간식");
		menuItem.addActionListener(menuItemListener);
		categ.add(menuItem);
		// 클릭시 이동
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductList_Snack();
				System.out.println("[ -> 간식 카테고리]");
				setVisible(false); // 창 안보이게 하기
			}
		});

		menuItem = new JMenuItem("액세서리");
		menuItem.addActionListener(menuItemListener);
		categ.add(menuItem);
		// 클릭시 이동
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductList_Acc();
				System.out.println("[ -> 액세서리 카테고리]");
				setVisible(false); // 창 안보이게 하기
			}
		});

		menuItem = new JMenuItem("기타");
		menuItem.addActionListener(menuItemListener);
		categ.add(menuItem);
		// 클릭시 이동
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductList_Etc();
				System.out.println("[ -> 기타 카테고리]");
				setVisible(false); // 창 안보이게 하기
			}
		});

		// 서브메뉴-마이페이지, 고객센터
		menuItem = new JMenuItem("마이페이지");
		menuItem.addActionListener(menuItemListener);
		my.add(menuItem);
		// 클릭시 이동
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Page11();
				System.out.println("[-> 마이페이지]");
				setVisible(false); // 창 안보이게 하기
			}
		});

		menuItem = new JMenuItem("고객센터");
		menuItem.addActionListener(menuItemListener);
		cen.add(menuItem);
		// 클릭시 이동
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainBoard();
				System.out.println("[-> 고객센터]");
				setVisible(false); // 창 안보이게 하기
			}
		});

		menuItem = new JMenuItem("메인 페이지");
		menuItem.addActionListener(menuItemListener);
		main.add(menuItem);
		// 클릭시 이동
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainPage11();
				System.out.println("[-> 메인페이지]");
				setVisible(false); // 창 안보이게 하기
			}
		});

		menuItem = new JMenuItem("상품후기");
		menuItem.addActionListener(menuItemListener);
		review.add(menuItem);
		// 클릭시 이동
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ReviewMain();
				System.out.println("[-> 상품후기]");
				setVisible(false); // 창 안보이게 하기
			}
		});

		// JFrame에 메뉴바 설정
		setJMenuBar(menuBar);

		// TODO Auto-generated constructor stub
		// panel 생성
		JPanel panel = new JPanel();
		panel.addMouseListener(this);

		// 세로 스크롤만 적용
		getContentPane().add(
				new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

		// GridBagLayout 설정
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 450, 450, 450, 450, 0 };
		gbl_panel.rowHeights = new int[] { 300, 300, 300, 300 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };

		panel.setLayout(gbl_panel);

		// ---------------------상품 1
		JButton button = new JButton("방수 하네스", new ImageIcon("img/harness.png"));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		panel.add(button, gbc_button);
		button.setBackground(new Color(160, 242, 196));
		button.addMouseListener(this);
		// button(하네스) -> 이동
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Clo_Han();
				System.out.println("[ -> 방수 하네스]");
				setVisible(false); // 창 안보이게 하기
			}
		});

		// ---------------------상품 2
		JButton button1 = new JButton("스프라이트 티셔츠", new ImageIcon("img/clo.png"));
		GridBagConstraints gbc_button1 = new GridBagConstraints();
		gbc_button1.fill = GridBagConstraints.BOTH;
		gbc_button1.insets = new Insets(0, 0, 5, 5);
		gbc_button1.gridx = 1;
		gbc_button1.gridy = 0;
		panel.add(button1, gbc_button1);
		button1.setBackground(new Color(160, 242, 196));
		button1.addMouseListener(this);
		// button1(스프라이트 티셔츠) -> 이동
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Clo_T();
				System.out.println("[ -> 스프라이트 티셔츠]");
				setVisible(false); // 창 안보이게 하기
			}
		});

		// 폰트, 크기 적용
		Font btn = new Font("NotoSansCJKkr", Font.BOLD, 20);
		button.setFont(btn);
		button1.setFont(btn);

		// panel 색상
		panel.setBackground(new Color(160, 242, 196));

		// 사이즈
		// this.setBounds(30, 30, 1350, 900);
		setSize(1350, 900);

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
			System.out.println("[의류 카테고리 -> 상품 홈]");
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

	ActionListener menuItemListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	};
}
