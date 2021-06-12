	package miniproject_customerservice.com.kh.cs;

	import java.io.File;
	import java.io.IOException;

	import javax.imageio.ImageIO;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JTextField;

	public class InputForm_Qna  extends JFrame{//입력폼
		 
		 JLabel la_number, la_title, la_writer, la_content;
		 JTextField tf_number, tf_title, tf_writer, tf_content;
		 JButton bt_input, bt_cancel, bt_check;
		 
		 public InputForm_Qna() {
		 
		  setTitle("게시글 작성");
		  try {
				setIconImage(ImageIO.read(new File("images/dog.png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		//  setSize(1250,880);
		  la_number = new JLabel("번호");
		  la_title = new JLabel("제목");
		  la_writer = new JLabel("작성자");
		  la_content = new JLabel("내용");
		  

		  tf_number = new JTextField();
		  tf_title = new JTextField();
		  tf_writer = new JTextField();
		  tf_content = new JTextField();
		  
		  
		  bt_input = new JButton("입력");
		  bt_cancel = new JButton("취소");
		  bt_check = new JButton("확인");
		  
		  setLayout(null);
		  la_number.setBounds(30, 30, 30, 30);//location+size
		  la_title.setBounds(30, 80, 30, 30);//location+size
		  la_writer.setBounds(30, 130, 65, 30);//location+size
		  la_content.setBounds(30, 180, 30, 30);
		  
		  tf_number.setBounds(80, 30, 80, 30);
		  tf_title.setBounds(80, 80, 80, 30);
		  tf_writer.setBounds(80, 130, 80, 30);
		  tf_content.setBounds(80, 180, 300, 400);

		  bt_input.setBounds(30, 590, 60, 30);
		  bt_cancel.setBounds(100, 590, 60, 30);
		  bt_check.setBounds(100, 590, 60, 30);
		  
		  add(la_number);
		  add(la_title);
		  add(la_writer);
		  add(la_content);
		  
		  add(tf_number);
		  add(tf_title);
		  add(tf_writer);
		  add(tf_content);

		        add(bt_input);  
		        add(bt_cancel);
		       
		        setBounds(300, 300, 500, 700);
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
		//  tf_name.setEnabled(boolean enabled);
		 
		 }
		 
		 public void initCk() { // 게시물 확인
			 setTitle("게시물 보기");
			  tf_number.setEditable(false);
			  tf_title.setEditable(false);
			  tf_writer.setEditable(false);
			  tf_content.setEditable(false);

			  remove(bt_input);
			  remove(bt_cancel);
			  add(bt_check);
			  //.requestFocus();  --> ??? 이거 뭐임???
			 
		 }

	}


