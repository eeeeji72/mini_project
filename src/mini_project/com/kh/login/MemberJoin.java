package mini_project.com.kh.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mini_project.com.kh.main.MainPage11;
import mini_project.com.kh.system_manager.vo.User;
import productFile.proFileFucntion.BuildFile;
@SuppressWarnings("serial")
public class MemberJoin extends JFrame {
	
	private JButton btnCommit, btnBack;
	private JTextField txtID,txtPassword,txtName,txtPhone, txtAddress, txtDogName;
	
	User user;
	
	BuildFile buildFile = null;
	private JFrame frame;
	
	public MemberJoin() {
		
		frame = new JFrame("댕숲");
		JPanel container = new JPanel();
		container.setLayout(null);
		container.setBackground(new Color(160, 242, 196));
		
		frame.setTitle("댕숲");
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image icon = toolkit.getImage("img/d.png");
		frame.setIconImage(icon);
		
		Font basicFont = new Font("NotoSansCJKkr", Font.PLAIN, 13);
		
		JPanel p = new JPanel();
		
		btnCommit = new JButton("완료");
		btnCommit.setBackground(new Color(0, 153, 255));
		btnCommit.setForeground(Color.WHITE);
		btnCommit.setFont(basicFont);

		btnBack = new JButton("이전");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.DARK_GRAY);
		btnBack.setFont(basicFont);

		setButtonListener(); // 버튼에 리스너를 붙이는 메소드
		
		container.add(btnCommit);
		container.add(btnBack);

		btnCommit.setBounds(683, 792, 142, 49);
		btnBack.setBounds(452, 801, 80, 30);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		container.setBackground(new Color(160, 242, 196));
		
		JLabel labelTitle = new JLabel("회원가입");
		labelTitle.setFont(new Font("NotoSansCJKr", Font.BOLD, 40));
		labelTitle.setBounds(518, 82, 246, 49);
		container.add(labelTitle);
		
		
		JLabel labelID = new JLabel("아이디");
		labelID.setFont(new Font("NotoSansCJKr", Font.BOLD, 20));
		labelID.setBounds(450, 150, 80, 40);
		container.add(labelID);
		
		JLabel labelPassword = new JLabel("비밀번호");
		labelPassword.setFont(new Font("NotoSansCJKr", Font.BOLD, 20));
		labelPassword.setBounds(450, 210, 80, 40);
		container.add(labelPassword);
		
		JLabel labelName = new JLabel("이름");
		labelName.setFont(new Font("NotoSansCJKr", Font.BOLD, 20));
		labelName.setBounds(450, 270, 80, 40);
		container.add(labelName);
		
		JLabel labelPhone = new JLabel("연락처");
		labelPhone.setFont(new Font("NotoSansCJKr", Font.BOLD, 20));
		labelPhone.setBounds(450, 330, 80, 40);
		container.add(labelPhone);
		
		JLabel labelAddress = new JLabel("주소");
		labelAddress.setFont(new Font("NotoSansCJKr", Font.BOLD, 20));
		labelAddress.setBounds(450, 390, 80, 40);
		container.add(labelAddress);
		
		JLabel labelDog = new JLabel("반려견 이름");
		labelDog.setFont(new Font("NotoSansCJKr", Font.BOLD, 20));
		labelDog.setBounds(450, 450, 80, 40);
		container.add(labelDog);
		
		JLabel labelImage1 = new JLabel("");
		labelImage1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\img\\sf.png"));
		labelImage1.setBounds(1088, 517, 453, 391);
		container.add(labelImage1);
		
		JLabel labelImage2 = new JLabel("");
		labelImage2.setIcon(new ImageIcon("img/dname.png"));
		labelImage2.setBounds(85, 25, 330, 370);
		container.add(labelImage2);
		
		txtID = new JTextField();
		txtID.setBounds(580, 150, 80, 40);
		txtID.setColumns(10);
		container.add(txtID);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(580, 210, 80, 40);
		txtPassword.setColumns(10);
		container.add(txtPassword);
		
		txtName = new JTextField();
		txtName.setBounds(580, 270, 80, 40);
		txtName.setColumns(10);
		container.add(txtName);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(580, 330, 80, 40);
		txtPhone.setColumns(10);
		container.add(txtPhone);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(580, 390, 80, 40);
		txtAddress.setColumns(10);
		container.add(txtAddress);
		
		txtDogName = new JTextField();
		txtDogName.setBounds(580, 450, 80, 40);
		txtDogName.setColumns(10);
		container.add(txtDogName);
		
		
		
		frame.setSize(1350, 900);
		frame.add(container);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false); // 크기 고정
		frame.setLocationRelativeTo(null); // 가운데 크기맞추기
		frame.setVisible(true);
	}
	
	public void setButtonListener() {
		
		btnCommit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String alarm = txtID.getText().trim() == "" ? "아이디를 입력하세요." :
					   txtPassword.getText().trim() == "" ? "비밀번호를 입력하세요." :
					   txtName.getText().trim() == "" ? "이름을 입력하세요." :
					   txtPhone.getText().trim() == "" ? "연락처를 입력하세요." :
					   txtAddress.getText().trim() == "" ? "주소를 입력하세요." :
					   txtDogName.getText().trim() == "" ? "반려견 이름을 입력하세요." : null;
				
				
				if(alarm != null) {
					JOptionPane.showMessageDialog(null, alarm);
					return;
				}
				
				user = new User(); // 정보를 담을 user 객체 생성
				
				if(user.checkDuplication(txtID.getText())) {  // User 클래스에서 중복되는 파일이 존재하는지 검사
					JOptionPane.showMessageDialog(null,"이미 존재하는 유저입니다.");
					return;  // 결과값이 true면 (중복이면) if문 실행 알림창을 띄우고 return;
				}else {  // 결과값이 false면 (중복이 아니면) else문 실행
					
				user.setUserID(txtID.getText().trim());  // ID 입력란의 문자열을 새로 생성한 user 객체 ID 에 저장 
				user.setUserPassword(txtPassword.getText().trim()); // 비밀번호 입력란의 문자열을 새로 생성한 user 객체 비밀번호 에 저장
				user.setName(txtName.getText().trim()); // 이름 입력란의 문자열을 새로 생성한 user 객체 이름 에 저장
				user.setPhone(txtPhone.getText().trim()); // 연락처 입력란의 문자열을 새로 생성한 user 객체 연락처 에 저장
				user.setAddress(txtAddress.getText().trim()); // 주소 입력란의 문자열을 새로 생성한 user 객체 주소 에 저장
				user.setDogName(txtDogName.getText().trim()); // 반려견 이름 입력란의 문자열을 새로 생성한 user 객체 반려견 이름 에 저장
				
				buildFile = new BuildFile(); // 파일을 생성해주는 클래스의 객체 생성
				
				buildFile.userFileBuilder(user); // 지금 만든 user 객체의 정보를 보내서
												 // 텍스트파일을 생성해주는 메소드를 실행
				
				// user.checkDuplication(문자열) -> 해당하는 문자열과 같은 이름을 가지는 파일이 있는지 검색
				// 있으면 true 없으면 false 반환
				
				if(user.checkDuplication(user.getName())) { // 잘만들어졌는지 한번더 중복검사를 해서 확인
					JOptionPane.showMessageDialog(null,"성공적으로 가입하였습니다.\n환영합니다!" + user.getName()+ "님!");
				}
				
				}
				new MainPage11();
				frame.dispose();
			}
		});
		
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"가입을 취소하였습니다.");
				new MainPage11();
				frame.dispose();
			}
			
		});
		
	}
	
}