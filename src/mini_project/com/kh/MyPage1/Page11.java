package mini_project.com.kh.MyPage1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import mini_project.com.kh.MyPage1.MainPage11;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Page11 extends JFrame {
//
	private JPanel Mypage;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) {
	 * 
	 * EventQueue.invokeLater(new Runnable() {
	 * 
	 * public void run() {
	 * 
	 * try { Page frame = new Page(); frame.setVisible(true); } catch (Exception e)
	 * { e.printStackTrace(); } } }); }
	 * 
	 * /** Create the frame.
	 */
	public Page11() {
		setTitle("댕숲");
		setVisible(true);
		try {
			setIconImage(ImageIO.read(new File("C:/Workspace1/JAVA/MyPage/allergy_dog.png")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 880);
		Mypage = new JPanel();
		Mypage.setForeground(new Color(0, 0, 0));
		Mypage.setBorder(new EmptyBorder(5, 5, 5, 5));
		Color b = new Color(160, 242, 196);
		Mypage.setBackground(b);
		setContentPane(Mypage);
		Mypage.setLayout(null);

		JButton btnNewButton_1 = new JButton("내 정보 수정\r\n");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modify(); // 정보수정 창 불러오는 메소드

			}
		});
		btnNewButton_1.setFont(new Font("NotoSansCJKkr", Font.PLAIN, 20));
		btnNewButton_1.setBounds(614, 381, 197, 69);
		Mypage.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("회원 탈퇴");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(0, 153, 255));
		btnNewButton_2.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnNewButton_2.setBounds(614, 611, 197, 69);
		Mypage.add(btnNewButton_2);

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				remove(); // 회원탈퇴 불러오는 메소드
			}
		});

		JButton btnNewButton_3 = new JButton("내 정보 조회");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(new Color(0, 153, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inquire(); // 정보조회 불러오는 메소드

			}

		});

		btnNewButton_3.setBounds(614, 174, 197, 62);
		btnNewButton_3.setFont(new Font("NotoSansCJKkr", Font.PLAIN, 20));
		Mypage.add(btnNewButton_3);

		JLabel lblNewLabel = new JLabel("     마이 페이지");
		lblNewLabel.setBounds(10, 26, 215, 75);
		Mypage.add(lblNewLabel);
		Font usef1 = new Font("NotoSansCJKkr", Font.PLAIN, 20);
		lblNewLabel.setFont(usef1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\h9898\\Desktop\\eto_inu_kataguruma-removebg-preview.png"));
		lblNewLabel_1.setBounds(31, 185, 457, 555);
		Mypage.add(lblNewLabel_1);
	}

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel1;
	private Component label;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @return
	 */
	public void modify() {

		setTitle("댕숲");
		try {
			setIconImage(ImageIO.read(new File("C:/Workspace1/JAVA/MyPage/allergy_dog.png")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 880);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Color b = new Color(160, 242, 196);
		contentPane.setBackground(b);

		JLabel lblNewLabel = new JLabel("내 정보 수정");
		lblNewLabel.setBounds(22, 25, 172, 66);
		contentPane.add(lblNewLabel);
		Font usef2 = new Font("NotoSansCJKkr", Font.PLAIN, 20);
		lblNewLabel.setFont(usef2);

		textField = new JTextField();
		textField.setText("닉네임 : ");
		textField.setBounds(542, 131, 196, 43);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setText("비밀번호 : ");
		textField_1.setBounds(542, 245, 196, 43);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setText("주소 : ");
		textField_2.setBounds(542, 362, 196, 43);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setText("전화번호 :");
		textField_3.setBounds(542, 504, 196, 43);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JButton btnNewButton = new JButton("정보 수정");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.setBounds(558, 768, 180, 46);
		contentPane.add(btnNewButton);

		JButton btnNewButton9 = new JButton("뒤로");

		btnNewButton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page1();
			}
		});
		btnNewButton9.setBounds(12, 10, 97, 23);
		contentPane.add(btnNewButton9);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\h9898\\Desktop\\bath_r-removebg-preview.png"));
		lblNewLabel.setBounds(12, 131, 402, 471);
		contentPane.add(lblNewLabel);
	}

	public void Inquire() {
		setTitle("댕숲");
		try {
			setIconImage(ImageIO.read(new File("C:/Workspace1/JAVA/MyPage/allergy_dog.png")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Container c = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 880);
		JFrame a = new JFrame("마이 페이지");
		Color b = new Color(160, 242, 196);
		ImageIcon img = new ImageIcon("file:///C:/Workspace1/JAVA/MyPage/allergy_dog.png");

		contentPane = new JPanel();
		contentPane.setBackground(b);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("작성한 글");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.setBounds(12, 102, 125, 50);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Write();
			}
		});

		JButton btnNewButton_1 = new JButton("내가 쓴 리뷰");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1.setBounds(12, 201, 125, 50);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				review();
			}
		});

		JButton btnNewButton_2 = new JButton("구매 목록");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(0, 153, 255));
		btnNewButton_2.setBounds(12, 299, 125, 50);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				buy();
			}
		});

		lblNewLabel1 = new JLabel("  내 정보 조회");
		lblNewLabel1.setBounds(0, 37, 220, 41);
		contentPane.add(lblNewLabel1);
		Font usef2 = new Font("NotoSansCJKkr", Font.PLAIN, 20);
		lblNewLabel1.setFont(usef2);

		JButton btnNewButton_3 = new JButton("아이디 : ");

		btnNewButton_3.setBounds(401, 106, 201, 37);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("이름 :");
		btnNewButton_4.setBounds(401, 229, 201, 44);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("닉네임 :");
		btnNewButton_5.setBounds(401, 361, 203, 44);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("댕댕이 이름 : ");
		btnNewButton_6.setBounds(401, 483, 201, 44);
		contentPane.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("주소 :");
		btnNewButton_7.setBounds(401, 604, 201, 44);
		contentPane.add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("전화 번호 :");
		btnNewButton_8.setBounds(401, 725, 201, 44);
		contentPane.add(btnNewButton_8);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\h9898\\Desktop\\dname-removebg-preview.png"));
		lblNewLabel_1.setBounds(765, 185, 438, 488);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_9 = new JButton("뒤로");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page1();
			}
		});
		btnNewButton_9.setBounds(12, 10, 97, 23);
		contentPane.add(btnNewButton_9);

	}

	public void review() {
		setTitle("댕숲");
		try {
			setIconImage(ImageIO.read(new File("C:/Workspace1/JAVA/MyPage/allergy_dog.png")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 880);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Color b = new Color(160, 242, 196);
		contentPane.setBackground(b);

		JButton btnNewButton = new JButton("리뷰 1 :");
		btnNewButton.setBounds(659, 115, 177, 38);
		contentPane.add(btnNewButton);
		btnNewButton.setFont(new Font("NotoSansCJKkr", Font.PLAIN, 20));

		JButton btnNewButton_1 = new JButton("리뷰 2 :");
		btnNewButton_1.setBounds(659, 229, 177, 38);
		contentPane.add(btnNewButton_1);
		Font usef2 = new Font("NotoSansCJKkr", Font.PLAIN, 20);
		btnNewButton_1.setFont(usef2);
		JButton btnNewButton_2 = new JButton("리뷰 3 :");
		btnNewButton_2.setBounds(659, 355, 177, 38);
		contentPane.add(btnNewButton_2);
		Font usef3 = new Font("NotoSansCJKkr", Font.PLAIN, 20);
		btnNewButton_2.setFont(usef3);
		JButton btnNewButton_3 = new JButton("리뷰 4 :");
		btnNewButton_3.setBounds(659, 483, 177, 38);
		contentPane.add(btnNewButton_3);
		Font usef4 = new Font("NotoSansCJKkr", Font.PLAIN, 20);
		btnNewButton_3.setFont(usef4);
		JButton btnNewButton_4 = new JButton("삭제");
		btnNewButton_4.setBounds(665, 789, 171, 42);
		contentPane.add(btnNewButton_4);
		Font usef5 = new Font("NotoSansCJKkr", Font.PLAIN, 20);
		btnNewButton_4.setFont(usef5);
		JLabel lblNewLabel = new JLabel("       내가 쓴 리뷰");
		lblNewLabel.setBounds(-36, 43, 171, 38);
		contentPane.add(lblNewLabel);
		Font usef6 = new Font("NotoSansCJKkr", Font.PLAIN, 20);
		lblNewLabel.setFont(usef6);

		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(647, 95, 21, 23);
		contentPane.add(chckbxNewCheckBox);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		chckbxNewCheckBox_1.setBounds(647, 468, 21, 23);
		contentPane.add(chckbxNewCheckBox_1);

		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("");
		chckbxNewCheckBox_2.setBounds(647, 339, 21, 23);
		contentPane.add(chckbxNewCheckBox_2);

		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("");
		chckbxNewCheckBox_3.setBounds(647, 211, 21, 23);
		contentPane.add(chckbxNewCheckBox_3);

		JButton btnNewButton9 = new JButton("뒤로");
		btnNewButton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inquire();
			}
		});
		btnNewButton9.setBounds(12, 10, 97, 23);
		contentPane.add(btnNewButton9);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\h9898\\Desktop\\gum-removebg-preview.png"));
		lblNewLabel_1.setBounds(42, 168, 428, 422);
		contentPane.add(lblNewLabel_1);
	}

	public void buy() {
		setTitle("댕숲");
		try {
			setIconImage(ImageIO.read(new File("C:/Workspace1/JAVA/MyPage/allergy_dog.png")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 880);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Color b = new Color(160, 242, 196);
		contentPane.setBackground(b);

		JButton btnNewButton = new JButton("구매목록 1 :");
		btnNewButton.setBounds(611, 165, 134, 31);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("구매 목록 2 :");
		btnNewButton_1.setBounds(611, 283, 134, 31);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("구매목록 3 :");
		btnNewButton_2.setBounds(611, 450, 134, 31);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("구매목록 4 :");
		btnNewButton_3.setBounds(611, 614, 134, 31);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("삭제");
		btnNewButton_4.setBounds(608, 791, 137, 40);
		contentPane.add(btnNewButton_4);

		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(595, 254, 21, 23);
		contentPane.add(chckbxNewCheckBox);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		chckbxNewCheckBox_1.setBounds(595, 149, 21, 23);
		contentPane.add(chckbxNewCheckBox_1);

		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("");
		chckbxNewCheckBox_2.setBounds(595, 429, 21, 23);
		contentPane.add(chckbxNewCheckBox_2);

		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("");
		chckbxNewCheckBox_3.setBounds(595, 591, 21, 23);
		contentPane.add(chckbxNewCheckBox_3);

		JLabel lblNewLabel2 = new JLabel("       구매목록");
		lblNewLabel2.setBounds(-20, 43, 171, 38);
		contentPane.add(lblNewLabel2);
		Font usef2 = new Font("NotoSansCJKkr", Font.PLAIN, 20);
		lblNewLabel2.setFont(usef2);

		JButton btnNewButton9 = new JButton("뒤로");
		btnNewButton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inquire();
			}
		});
		btnNewButton9.setBounds(12, 10, 97, 23);
		contentPane.add(btnNewButton9);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\h9898\\Desktop\\dogmedi-removebg-preview.png"));
		lblNewLabel.setBounds(43, 179, 367, 347);
		contentPane.add(lblNewLabel);
	}

	public void Write() {
		setTitle("댕숲");
		try {
			setIconImage(ImageIO.read(new File("C:/Workspace1/JAVA/MyPage/allergy_dog.png")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 880);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Color b = new Color(160, 242, 196);
		contentPane.setBackground(b);

		JButton btnNewButton = new JButton("글 1 :");
		btnNewButton.setBounds(567, 84, 168, 37);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("글 2 : ");
		btnNewButton_1.setBounds(567, 170, 168, 37);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("글 3 : ");
		btnNewButton_2.setBounds(567, 270, 168, 37);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("글 4 : ");
		btnNewButton_3.setBounds(567, 363, 168, 37);
		contentPane.add(btnNewButton_3);

		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(548, 254, 21, 23);
		contentPane.add(chckbxNewCheckBox);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		chckbxNewCheckBox_1.setBounds(548, 148, 21, 17);
		contentPane.add(chckbxNewCheckBox_1);

		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("");
		chckbxNewCheckBox_2.setBounds(548, 67, 21, 23);
		contentPane.add(chckbxNewCheckBox_2);

		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("");
		chckbxNewCheckBox_3.setBounds(548, 348, 21, 23);
		contentPane.add(chckbxNewCheckBox_3);

		JLabel lblNewLabel2 = new JLabel("       작성한 글");
		lblNewLabel2.setBounds(-25, 43, 171, 38);
		contentPane.add(lblNewLabel2);
		Font usef2 = new Font("NotoSansCJKkr", Font.PLAIN, 20);
		lblNewLabel2.setFont(usef2);

		JButton btnNewButton9 = new JButton("뒤로");
		btnNewButton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inquire();
			}
		});
		btnNewButton9.setBounds(12, 10, 97, 23);
		contentPane.add(btnNewButton9);

		JButton btnNewButton_4 = new JButton("삭제");
		btnNewButton_4.setBounds(598, 785, 166, 46);
		contentPane.add(btnNewButton_4);

		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\h9898\\Desktop\\muffler-removebg-preview.png"));
		lblNewLabel_1.setBounds(34, 131, 412, 469);
		contentPane.add(lblNewLabel_1);
	}

	public void remove() {
		setTitle("댕숲");
		try {
			setIconImage(ImageIO.read(new File("C:/Workspace1/JAVA/MyPage/allergy_dog.png")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 880);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Color b = new Color(160, 242, 196);
		contentPane.setBackground(b);

		JLabel lblNewLabel = new JLabel("회원탈퇴");
		lblNewLabel.setBounds(22, 48, 125, 46);
		contentPane.add(lblNewLabel);
		Font usef1 = new Font("NotoSansCJKkr", Font.PLAIN, 20);
		lblNewLabel.setFont(usef1);

		textField = new JTextField();
		textField.setText("아이디 : ");
		textField.setBounds(553, 144, 205, 46);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setText("비밀번호 : ");
		textField_1.setBounds(553, 262, 205, 46);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setText("탈퇴 사유 : ");
		textField_2.setBounds(553, 443, 205, 58);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton = new JButton("회원탈퇴");
		btnNewButton.setBounds(591, 785, 167, 46);
		contentPane.add(btnNewButton);

		JButton btnNewButton1 = new JButton("뒤로");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page1();
			}
		});
		btnNewButton1.setBounds(22, 10, 97, 23);
		contentPane.add(btnNewButton1);

		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setIcon(new ImageIcon("C:\\Users\\h9898\\Desktop\\c-removebg-preview.png"));
		lblNewLabel1.setBounds(94, 104, 376, 532);
		contentPane.add(lblNewLabel1);
	}

	public void Page1() {
		setTitle("댕숲");
		try {
			setIconImage(ImageIO.read(new File("C:/Workspace1/JAVA/MyPage/allergy_dog.png")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 880);
		Mypage = new JPanel();
		Mypage.setForeground(new Color(0, 0, 0));
		Mypage.setBorder(new EmptyBorder(5, 5, 5, 5));
		Color b = new Color(160, 242, 196);
		Mypage.setBackground(b);
		setContentPane(Mypage);
		Mypage.setLayout(null);

		JButton btnNewButton_1 = new JButton("내 정보 수정\r\n");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modify(); // 정보수정 창 불러오는 메소드

			}
		});
		btnNewButton_1.setFont(new Font("NotoSansCJKkr", Font.PLAIN, 20));
		btnNewButton_1.setBounds(614, 375, 197, 69);
		Mypage.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("회원 탈퇴");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(0, 153, 255));
		btnNewButton_2.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnNewButton_2.setBounds(614, 611, 197, 69);
		Mypage.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				remove(); // 회원탈퇴 불러오는 메소드
			}
		});

		JButton btnNewButton_3 = new JButton("내 정보 조회");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(new Color(0, 153, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inquire(); // 정보조회 불러오는 메소드

			}

		});

		btnNewButton_3.setBounds(614, 174, 197, 69);
		btnNewButton_3.setFont(new Font("NotoSansCJKkr", Font.PLAIN, 20));
		Mypage.add(btnNewButton_3);

		JLabel lblNewLabel = new JLabel("     마이 페이지");
		lblNewLabel.setBounds(10, 26, 215, 75);
		Mypage.add(lblNewLabel);
		Font usef1 = new Font("NotoSansCJKkr", Font.PLAIN, 20);
		lblNewLabel.setFont(usef1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\h9898\\Desktop\\eto_inu_kataguruma-removebg-preview.png"));
		lblNewLabel_1.setBounds(31, 185, 457, 555);
		Mypage.add(lblNewLabel_1);
	}

	public static void main(String[] args) {

		new Page11();
	}
}
