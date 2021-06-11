package miniproject_customerservice.com.kh.cs;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;

public class InputForm_Main  extends JFrame{//입력폼
	 
	 JLabel la_number, la_title, la_writer, la_content;
	 JTextField tf_number, tf_title, tf_writer, tf_content;
	 JButton bt_input, bt_cancel, bt_check;
	 private JPanel panel_1;
	 
	 public InputForm_Main() {
	 
	  setTitle("게시글 작성");
	  setBounds(300, 300, 784, 789);
	  getContentPane().setLayout(null);
	  getContentPane().setBackground(new Color(160, 242, 196));
	  try {
			setIconImage(ImageIO.read(new File("images/dog.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	   
	//  setSize(1250,880);
	  la_number = new JLabel("번호");
	  la_number.setBounds(30, 41, 30, 30);
//	  la_number.setBackground(null);
	  la_number.setFont(new Font("NotoSansCJKkr-Black.otf", Font.BOLD,13));
	  
	  
	  la_title = new JLabel("제목");
	  la_title.setBounds(30, 185, 30, 30);
	  la_title.setFont(new Font("NotoSansCJKkr-Black.otf", Font.BOLD,13));
	  
	  la_writer = new JLabel("작성자");
	  la_writer.setBounds(28, 113, 65, 30);
	  la_writer.setFont(new Font("NotoSansCJKkr-Black.otf", Font.BOLD,13));
	  
	  la_content = new JLabel("내용");
	  la_content.setFont(new Font("NotoSansCJKkr-Black.otf", Font.BOLD,13));
	  la_content.setBounds(30, 258, 30, 30);
	  

	  tf_number = new JTextField();
	  tf_number.setBounds(72, 42, 80, 30);
	  tf_title = new JTextField();
	  tf_title.setBounds(72, 186, 643, 30);
	  tf_writer = new JTextField();
	  tf_writer.setBounds(72, 114, 144, 30);
	  tf_content = new JTextField();
	  tf_content.setBounds(72, 258, 643, 400);
	
	//  bt_check.setBounds(100, 590, 60, 30);
	  
	  getContentPane().add(la_number);
	  getContentPane().add(la_title);
	  getContentPane().add(la_writer);
	  getContentPane().add(la_content);
	  
	  getContentPane().add(tf_number);
	  getContentPane().add(tf_title);
	  getContentPane().add(tf_writer);
	  getContentPane().add(tf_content);
	        
	        panel_1 = new JPanel();
	        panel_1.setBounds(305, 679, 168, 71);
	        getContentPane().add(panel_1);
	        panel_1.setLayout(null);
	        panel_1.setBackground(null);
	        
	        
	        bt_input = new JButton("확인");
	        bt_input.setForeground(Color.WHITE);
	        bt_input.setBounds(18, 20, 60, 30);
	        bt_input.setFont(new Font("NotoSansCJKkr-Black.otf", 0,13));
		    bt_input.setBackground(new Color(0, 153, 255));
	        panel_1.add(bt_input);  
	        
	        bt_cancel = new JButton("취소");
	        bt_cancel.setForeground(Color.WHITE);
	        bt_cancel.setBounds(88, 20, 60, 30);
	        bt_cancel.setFont(new Font("NotoSansCJKkr-Black.otf", 0,13));
	        bt_cancel.setBackground(Color.DARK_GRAY);
	        panel_1.add(bt_cancel);

	     
	       
	       
	 //       setVisible(true);
	        setResizable(false);  //프레임 사이즈 변경 불가
	       
	 }//생성자
	 public void initTF(){
	  //텍스트필드 초기화
	  setTitle("게시글 작성");
	  tf_number.setEditable(true);
	  tf_number.setText("");
	  tf_title.setText("");
	  tf_writer.setText("");
	  tf_content.setText("");
	  tf_number.requestFocus();
	   
	  
	 }
	 
	 public void initUp(){//수정 초기화
	  setTitle("게시글 수정");
	  tf_number.setEditable(false);
	  tf_title.setEditable(true);
	  tf_writer.setEditable(true);
	  tf_content.setEditable(true);
	//  tf_number.setEnabled(false);
	 
	 }
	 
	 public void initCk() { // 게시물 확인
		 setTitle("게시물 보기");
		  tf_number.setEditable(false);
		  tf_title.setEditable(false);
		  tf_writer.setEditable(false);
		  tf_content.setEditable(false);

//		  remove(bt_input);
//		  remove(bt_cancel);
//		  add(bt_check);
		  //.requestFocus();  --> ??? 이거 뭐임???
		 
	 }
}
