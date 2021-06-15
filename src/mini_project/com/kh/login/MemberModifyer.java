package mini_project.com.kh.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mini_project.com.kh.system_manager.vo.User;
import productFile.proFileFucntion.UserFileReader;

@SuppressWarnings("serial")
public class MemberModifyer extends JFrame {// 로그인 성공시
	
	// id password name phone address
	
	private User user = null;
	// User 클래스를 참조하여 새로운 user 객체변수를 생성
	// 하지만 아직은 빈껍데기이다.
	
	String thisMember = new MemberLogin().getLogginedMember();
	// MemeberLogin 클래스에 getLogginedMemeber 를 통해 지금 접속중인 유저의 ID 값을
	// thisMember 문자열에 담는다.
	
	private JButton btnBack;
	private JButton btnCommit;
	
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtPassword;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtAddress;
	private JTextField txtDogName;

	public MemberModifyer() {
		
		
		JPanel p = new JPanel();
		
		Font basicFont = new Font("NotoSansCJKkr", Font.PLAIN, 20);
		
		p.setBounds(0, 0, 1334, 861);
		p.setLayout(null);
		
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel(new ImageIcon(""));
		getContentPane().add(label);
		
		Color b = new Color(160, 242, 196);
		p.setBackground(b);
		
		
		getContentPane().add(p);
		btnBack = new JButton("뒤로");
		btnBack.setBounds(476, 759, 94, 44);
		p.add(btnBack);
		
		btnCommit = new JButton("완료");
		btnCommit.setBounds(745, 759, 104, 44);
		p.add(btnCommit);
		
		setButtonListener();

		JLabel labelName = new JLabel(" 이름  ");
		labelName.setBounds(450, 300, 189, 30);
		labelName.setFont(basicFont);
		p.add(labelName);

		JLabel labelID = new JLabel(" 아이디  ");
		labelID.setBounds(440, 160, 189, 35);
		labelID.setFont(basicFont);
		p.add(labelID);

		JLabel labelPassword = new JLabel("패스워드  ");
		labelPassword.setBounds(440, 230, 189, 30);
		labelPassword.setFont(basicFont);
		p.add(labelPassword);

		JLabel labelPhone = new JLabel("연락처");
		labelPhone.setBounds(450,366,251,30);
		labelPhone.setFont(basicFont);
		p.add(labelPhone);
		
		
		JLabel labelAddress = new JLabel(" 주소 ");
		labelAddress.setBounds(440, 427, 378, 41);
		labelAddress.setFont(basicFont);
		p.add(labelAddress);
		
		JLabel labelDogName = new JLabel("반려견 이름");
		labelDogName.setBounds(440,500,251,30);
		labelDogName.setFont(basicFont);
		p.add(labelDogName);
		
		
		JLabel labelModify = new JLabel("회원정보수정");
		labelModify.setBounds(569, 68, 189, 44);
		p.add(labelModify);
		
		
		JLabel labelImage = new JLabel("");
		labelImage.setIcon(new ImageIcon("img/doghouse.png"));
		labelImage.setBounds(940, 0, 519, 348);
		p.add(labelImage);
		
		JLabel labelImageBest = new JLabel("");
		labelImageBest.setIcon(new ImageIcon("img/best.png"));
		labelImageBest.setBounds(100, 303, 262, 395);
		p.add(labelImageBest);
		
		
		txtID = new JTextField();
		txtID.setBounds(568, 160, 189, 35);
		p.add(txtID);
		txtID.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setBounds(568, 230, 189, 30);
		p.add(txtPassword);
		txtPassword.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(568, 300, 189, 30);
		p.add(txtName);
		txtName.setColumns(10);

		txtPhone = new JTextField();
		txtPhone.setBounds(569, 370, 189,30);
		txtPhone.setColumns(10);
		txtPhone.setText("");
		p.add(txtPhone);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(568, 430, 378, 41);
		p.add(txtAddress);
		
		txtDogName = new JTextField();
		txtDogName.setColumns(10);
		txtDogName.setBounds(568,500,251,30);
		txtDogName.setText("");
		p.add(txtDogName);
		
		setTextField();
		
		setSize(1345, 900);
		setTitle("댕숲");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); // 크기 고정
		setLocationRelativeTo(null); // 가운데 크기맞추기
		setVisible(true);
		
	}
	
	public void setTextField() {  // 텍스트필드에 유저정보를 표시해주는 메소드
		
		user = new UserFileReader().fileToUser(thisMember);
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
		
		// 실패 사유 : fileToUser 메소드가 오작동 하였다.
		// 하지만 객체를 통해 정보값을 받아오는데 실패하였다.. 처음엔 null 값 그 다음엔 출처를 알 수 없는 잘못된 데이터를
		// 긁어왔다.
		
		/*
		File file = new File( thisMember + ".txt");
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(file));
			
			txtName.setText(br.readLine());
			txtID.setText(br.readLine());
			txtPassword.setText(br.readLine());
			txtAddress.setText(br.readLine());
			txtPhone.setText(br.readLine());
			txtDogName.setText(br.readLine());
			
			br.close();
							
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
	}
	
	public void setButtonListener() {
		
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
//				new MainPage11();
				dispose();
			}
			
		});
		
		btnCommit.addActionListener(new ActionListener() {
	
			File thisFile = null;
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String fileName = txtID.getText().toString().trim();
				
				thisFile = new File(fileName+".txt");
				FileWriter fw = null;
				try {
					fw = new FileWriter(thisFile);
					
					fw.write(txtID.getText() +"\n");
					fw.write(txtName.getText() + "\n");
					fw.write(txtPassword.getText()+ "\n");
					fw.write(txtAddress.getText() + "\n");
					fw.write(txtPhone.getText() + "\n");
					fw.write(txtDogName.getText());
					
					fw.flush();
					fw.close();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					if (fw != null) {
						try {
							fw.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			
				if(thisFile.exists()) {
					
					JOptionPane.showMessageDialog(null,"성공적으로 반영됐습니다.");
					
				}else {
					JOptionPane.showMessageDialog(null,"에러가 발생했습니다..!\n파일이 훼손됐거나 수정사항에 문제가 없는지 확인해주세요.");
				}
			}
			});
		
		
	}
}