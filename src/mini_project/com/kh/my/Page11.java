package mini_project.com.kh.my;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import mini_project.com.kh.login.MemberLogin;
import mini_project.com.kh.main.MainPage11;
import mini_project.com.kh.review.CreatedList;
import mini_project.com.kh.system_manager.vo.User;
import productFile.proFileFucntion.UserFileReader;
public class Page11 extends JFrame {
//
	
	private JTextField txtName , txtID  ,txtPassword ,txtAddress,txtPhone ,txtDogName;
	private JPanel Mypage;
	
	private User user = null;
	// User 클래스를 참조하여 새로운 user 객체변수를 생성
	// 하지만 아직은 빈껍데기이다.
	
	String thisMember = new MemberLogin().getLogginedMember();
	
	// MemeberLogin 클래스에 getLogginedMemeber 를 통해 지금 접속중인 유저의 ID 값을
	// thisMember 문자열에 담는다.

	public Page11() {
		setTitle("댕숲");
		setVisible(true);
		try {
			setIconImage(ImageIO.read(new File("img/allergy_dog.png")));
			//setIconImage(ImageIO.read(new File("img/d.PNG")));
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
		lblNewLabel_1.setIcon(new ImageIcon("img/best.png"));
		lblNewLabel_1.setBounds(31, 185, 457, 555);
		Mypage.add(lblNewLabel_1);
		
		JButton btnNewButton_6 = new JButton("메인 홈");
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setBackground(new Color(0, 153, 255));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainPage11();
				setVisible(false);
			}
		});
		btnNewButton_6.setBounds(565, 10, 199, 48);
		Mypage.add(btnNewButton_6);
		//setVisible(true);
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
			setIconImage(ImageIO.read(new File("img/allergy_dog.png")));
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
		
		setTextField();

		JButton btnNewButton = new JButton("정보 수정");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.setBounds(558, 768, 180, 46);
		contentPane.add(btnNewButton);

		JButton btnNewButton9 = new JButton("뒤로");
		btnNewButton9.setBackground(Color.DARK_GRAY);
		btnNewButton9.setForeground(Color.WHITE);
		btnNewButton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page1();
			}
		});
		btnNewButton9.setBounds(12, 10, 97, 23);
		contentPane.add(btnNewButton9);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("img/bath_r.png"));
		lblNewLabel.setBounds(12, 131, 402, 471);
		contentPane.add(lblNewLabel);
	}

	public void Inquire() {
		setTitle("댕숲");
		try {
			setIconImage(ImageIO.read(new File("img/allergy_dog.png")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Container c = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 880);
		JFrame a = new JFrame("마이 페이지");
		Color b = new Color(160, 242, 196);
		ImageIcon img = new ImageIcon("img/allergy_dog.png");
		//ImageIcon img = new ImageIcon("img/d.PNG");

		contentPane = new JPanel();
		contentPane.setBackground(b);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		

		JButton btnNewButton_1 = new JButton("내가 쓴 리뷰");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1.setBounds(12, 201, 125, 50);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				CreatedList dialog = new CreatedList();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
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

		txtID = new JTextField();
		txtID.setBounds(401, 106, 201, 37);
		contentPane.add(txtID);

		txtName = new JTextField();
		txtName.setBounds(401, 229, 201, 44);
		contentPane.add(txtName);

		txtPassword = new JTextField();
		txtPassword.setBounds(401, 361, 203, 44);
		contentPane.add(txtPassword);

		txtDogName = new JTextField();
		txtDogName.setBounds(401, 483, 201, 44);
		contentPane.add(txtDogName);

		txtAddress = new JTextField();
		txtAddress.setBounds(401, 604, 201, 44);
		contentPane.add(txtAddress);

		txtPhone = new JTextField();
		txtPhone.setBounds(401, 725, 201, 44);
		contentPane.add(txtPhone);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("img/dname.png"));
		lblNewLabel_1.setBounds(765, 185, 438, 488);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_9 = new JButton("뒤로");
		btnNewButton_9.setBackground(Color.DARK_GRAY);
		btnNewButton_9.setForeground(Color.WHITE);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page1();
			}
		});
		btnNewButton_9.setBounds(12, 10, 97, 23);
		contentPane.add(btnNewButton_9);

	}
/*
	public void review() {
		setTitle("댕숲");
		try {
			setIconImage(ImageIO.read(new File("img/d.PNG")));
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

		JButton btnNewButton = new JButton("");
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
		btnNewButton9.setForeground(Color.WHITE);
		btnNewButton9.setBackground(Color.DARK_GRAY);
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
*/
	public void buy() {
		setTitle("댕숲");
		try {
			setIconImage(ImageIO.read(new File("img/d.PNG")));
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

		try {
			FileReader f2 = new FileReader("buy_list.txt");
					BufferedReader bufReader = new BufferedReader(f2);
			String RTData1 = "";
			while((RTData1 = bufReader.readLine()) != null) {
				JTextArea buyList = new JTextArea( RTData1);
				
				buyList.setFont(new Font("NotoSansCJKkr", Font.PLAIN, 20));
				buyList.setBounds(401, 106, 800, 300);
				buyList.setEditable(false);
				contentPane.add(buyList);
			}
			if(f2 != null)f2.close();
		}catch (FileNotFoundException e ) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	

		
       
		JLabel lblNewLabel2 = new JLabel("       구매목록");
		lblNewLabel2.setBounds(-20, 43, 171, 38);
		contentPane.add(lblNewLabel2);
		Font usef2 = new Font("NotoSansCJKkr", Font.PLAIN, 20);
		lblNewLabel2.setFont(usef2);

		JButton btnNewButton9 = new JButton("뒤로");
		btnNewButton9.setBackground(Color.DARK_GRAY);
		btnNewButton9.setForeground(Color.WHITE);
		btnNewButton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inquire();
			}
		});
		btnNewButton9.setBounds(12, 10, 97, 23);
		contentPane.add(btnNewButton9);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img/dogmedi.PNG"));
		lblNewLabel.setBounds(12, 65, 367, 347);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("img/dname.PNG"));
		lblNewLabel_1.setBounds(895, 356, 314, 397);
		contentPane.add(lblNewLabel_1);
	}

	

	public void remove() {
		setTitle("댕숲");
		try {
			setIconImage(ImageIO.read(new File("img/d.PNG")));
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

		
	
		
		JButton btnNewButton = new JButton("회원탈퇴");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.setBounds(591, 785, 167, 46);
		contentPane.add(btnNewButton);

		JButton btnNewButton1 = new JButton("뒤로");
		btnNewButton1.setBackground(Color.DARK_GRAY);
		btnNewButton1.setForeground(Color.WHITE);
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page1();
			}
		});
		btnNewButton1.setBounds(22, 10, 97, 23);
		contentPane.add(btnNewButton1);

		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setIcon(new ImageIcon("img/sf.png"));
		lblNewLabel1.setBounds(94, 104, 376, 532);
		contentPane.add(lblNewLabel1);
	}

	public void Page1() {
		setTitle("댕숲");
		try {
			setIconImage(ImageIO.read(new File("img/d.PNG")));
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
		
		
		JButton btnNewButton_6 = new JButton("메인 홈");
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setBackground(new Color(0, 153, 255));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainPage11();
				setVisible(false);
			}
		});
		btnNewButton_6.setBounds(565, 10, 199, 48);
		Mypage.add(btnNewButton_6);

		JLabel lblNewLabel = new JLabel("     마이 페이지");
		lblNewLabel.setBounds(10, 26, 215, 75);
		Mypage.add(lblNewLabel);
		Font usef1 = new Font("NotoSansCJKkr", Font.PLAIN, 20);
		lblNewLabel.setFont(usef1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("img/best.png"));
		lblNewLabel_1.setBounds(31, 185, 457, 555);
		Mypage.add(lblNewLabel_1);
	}
//;
	
	void setTextField() {
		
	user = new UserFileReader().fileToUser(thisMember);
	System.out.println(user.getAddress());
	// UserFileReader 클래스에 있는 fileToUser 메소드를 불러와서 사용한다. 
	// 해당 메소드가 멤버ID 값을 통해 유저의 파일을 찾아내고 이 파일을 user 객체로 변환해준다.
	// 그리고 그 객체를 위에서 만들어둔 user 객체 변수에 담아낸다.
	// 즉 멤버아이디로 유저를 만들기
	
	txtName.setText(user.getName());  // User 클래스로부터 참조하여 새로만든 user 객체로 부터 이름 값을 받아와 txtName 에 표시
	txtID.setText(user.getUserID());  // User 클래스로부터 참조하여 새로만든 user 객체로 부터 아이디 값을 받아와 txtID 에 표시
	txtPassword.setText(user.getUserPassword());   // User 클래스로부터 참조하여 새로만든 user 객체로 부터 비밀번호를 받아와 txtPassword 에 표시
	txtPhone.setText(user.getPhone());  // User 클래스로부터 참조하여 새로만든 user 객체로 부터 연락처을 받아와 txtPhone 에 표시
	txtAddress.setText(user.getAddress());  // User 클래스로부터 참조하여 새로만든 user 객체로 부터 주소를 받아와 txtAddress 에 표시
	txtID.setText(user.getUserID());  // User 클래스로부터 참조하여 새로만든 user 객체로 부터 반려견이름 받아와 txtDogName 에 표시
	}
	/*
	public static void main(String[] args) {

		new Page11();
	}
	*/
}
