package mini_project.com.kh.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mini_project.com.kh.main.MainPage11;
import mini_project.com.kh.system_manager.view.Manager_MainMenu;
import mini_project.com.kh.system_manager.vo.User;
import productFile.proFileFucntion.UserFileReader;


@SuppressWarnings("serial")
public class MemberLogin extends JFrame {// 로그인화면

	private User user = new User();
	private UserFileReader ufr = null;
	private ArrayList<String> userId = user.getUserFile();

	private Image img = null;
	
	private TextField txtID = null;
	private TextField txtPassword = null;
	
	private static String LogginedMember; // 로그인 한 유저의 파일명을 담을 문자열;

	public MemberLogin() {
		JPanel p = new JPanel();
		p.setBounds(0, 0, 1350, 900);
		p.setLayout(null);
		getContentPane().setLayout(null);

		setTitle("댕숲");
		try {
			setIconImage(ImageIO.read(new File("img/d.PNG")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Color b = new Color(160, 242, 196);
		p.setBackground(b);
		getContentPane().add(p);

		JLabel labelID = new JLabel(" 아이디   ");
		labelID.setFont(new Font("NotoSansCJKr", Font.BOLD, 20));
		labelID.setBounds(295, 400, 108, 26);
		p.add(labelID);

		JLabel labelPassword = new JLabel(" 비밀번호  ");
		labelPassword.setFont(new Font("NotoSansCJKr", Font.BOLD, 20));
		labelPassword.setBounds(284, 494, 153, 32);
		p.add(labelPassword);

		JButton btnLogin = new JButton("로그인");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(Color.DARK_GRAY);
		btnLogin.setFont(new Font("NotoSansCJKr", Font.BOLD, 20));
		btnLogin.setBounds(540, 607, 204, 44);
		p.add(btnLogin);

		JButton btnSignIn = new JButton("회원가입");
		btnSignIn.setForeground(Color.WHITE);
		btnSignIn.setBackground(Color.DARK_GRAY);
		btnSignIn.setFont(new Font("NotoSansCJKr", Font.BOLD, 20));
		btnSignIn.setBounds(540, 768, 204, 37);
		p.add(btnSignIn);

		txtID = new TextField(); // 아이디 입력창
		txtID.setBounds(496, 384, 268, 53);
		p.add(txtID);

		txtPassword = new TextField(); // 비밀번호 입력창
		txtPassword.setBounds(496, 472, 268, 54);
		p.add(txtPassword);
		txtPassword.setEchoChar('*');// 암호화

		JLabel labelImage = new JLabel("");
		labelImage.setIcon(new ImageIcon("img" + File.separator + "harness.png"));
		labelImage.setBounds(-3, -20, 519, 408);
		p.add(labelImage);

		JLabel labelTitle = new JLabel("Welcome!!");
		labelTitle.setFont(new Font("NotoSansCJKr", Font.BOLD, 50));
		labelTitle.setBounds(152, -25, 544, 158);
		p.add(labelTitle);

		JLabel labelImage2 = new JLabel("");
		labelImage2.setIcon(new ImageIcon("img\toy3.png"));
		labelImage2.setBounds(944, 390, 519, 554);
		p.add(labelImage2);

		JLabel label = new JLabel(new ImageIcon(""));
		label.setBounds(-13, 116, 350, 255);
		p.add(label);

		JLabel labelLogin = new JLabel("Login");
		labelLogin.setFont(new Font("Dialog", Font.BOLD, 40));
		labelLogin.setBounds(529, 198, 215, 113);
		p.add(labelLogin);

		btnSignIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {// 회원가입창으로 이동
				// TODO Auto-generated method stub
				MemberJoin mj = new MemberJoin();

			}
		});

		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e2) {// 로그인 할때
				// TODO Auto-generated method stub

				String sMember = txtID.getText();
				String memberpw = txtPassword.getText();
				
				if (checkMember(sMember, memberpw)) {
					
					setLogginedMember(sMember);
					if(sMember.equals("admin")) {
						JOptionPane.showMessageDialog(null, "관리자 접속입니다.");
						new Manager_MainMenu();
						dispose();
					}
					
					else {
					JOptionPane.showMessageDialog(null, "어서오세요!" + sMember + "님!");
					new MainPage11();
					dispose();
					}
				} else {
					JOptionPane.showConfirmDialog(null,"로그인 실패.. 옳바른 아이디 또는 비밀번호가 아닙니다.");
				}
			}
		});

		setSize(1345, 900);
		setTitle("댕숲");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); // 크기 고정
		setLocationRelativeTo(null); // 가운데 크기맞추기
		// setVisible(true);
	}

	public boolean checkMember(String memberID, String memberPW) {

		UserFileReader ufr = new UserFileReader();
		
		User thisMember = ufr.fileToUser(memberID);
	      
	    boolean isMember = !(memberID.equals(thisMember.getUserID())) ? false : !(memberPW.equals(thisMember.getUserPassword())) ? false : true;
	      
		return isMember;
	}
	

	public String getLogginedMember() {
		return LogginedMember;
	}
	
	private void setLogginedMember(String LogginedMember) {
		MemberLogin.LogginedMember = LogginedMember;
	}
	
	public void setLogOut() {
		LogginedMember = null;
	}

}