package miniproject_customerservice.com.kh.cs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import miniproject_customerservice.com.kh.cs.InputForm_Complain;
import miniproject_customerservice.com.kh.cs.ComplainBoard;

public class ComplainBoard extends JFrame implements MouseListener, ActionListener{

	Font font1 = new Font("NotoSansCJKkr-Black.otf", 0,10);
	Font font2 = new Font("NotoSansCJKkr-Black.otf", 0,12);
	Font font3 = new Font("NotoSansCJKkr-Bold.otf", Font.BOLD,20);
	Font font4 = new Font("NotoSansCJKkr-Black.otf", Font.BOLD, 13);
	
	JTable table;
	JScrollPane scroll;
	 JPanel northp,southp,p, p1, p2;
	 JLabel label;
	 JButton bt_add, bt_del, bt_up, bt_search, bt, bt1, bt2, bt3,bt_main ,bt_qna,bt_complain, bt_check;
	
	 InputForm_Complain form;
	 DefaultTableModel dtm;
	 QnaBoard qna;
	 ComplainBoard complain;
	 MainBoard main;
	 
	 int srow;
	 
	 
	 
	 public ComplainBoard() {
	    setTitle("댕숲");
	    setSize(1250,880);  
	    getContentPane().setBackground(new Color(160, 242, 196));
	    try {
			setIconImage(ImageIO.read(new File("images/dog.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	    
	    form = new InputForm_Complain();
	   
	  
	   
	    //JTable(Object[][] rowData, Object[] columnNames)

	    Object[][] rowData={
	            
	                               {0, "TEST", "관리자", "내용test"},
	                             
	             
	                                };
	    Object[] columnNames={"번호","제목","작성자","작성내용"};
	   
	    //JTable(TableModel dm)
	    dtm = new DefaultTableModel(rowData, columnNames) {
	    	@Override

			public boolean isCellEditable(int row, int column) {  //수정, 입력 불가

				return false;

			}

	    };
	   
	    table = new JTable(dtm);//(rowData,columnNames);
	    
	    scroll = new JScrollPane(table);
	   // scroll.setBackground(new Color(160, 242, 196));  //???? null도 안됨
	    label = new JLabel("불편접수");
	    label.setFont(font3);
	    northp = new JPanel();
	    
	    p1 = new JPanel();
	    p1.add(label);
	    p1.setBackground(null);
	    northp.add("South", p1); // ??
	    northp.setBackground(null);
	     
	/*     bt = new JButton("상품");
	     bt1 = new JButton("상품후기");
	     bt2 = new JButton("마이페이지");
	     bt3 = new JButton("고객센터");
	     	     
	      p = new JPanel();
	     // l = new JLabel();
	      p.setBackground(null);
	      p.add(bt);
	      p.add(bt1);
	      p.add(bt2);
	      p.add(bt3);
	      northp.add("Center", p);
	      */ 
	      
	      
			bt_main = new JButton("공지사항");
			bt_qna = new JButton("상품문의");
			bt_complain = new JButton("불편접수");
			p2 = new JPanel();
			p2.setBackground(null);
			p2.add(bt_main);
			p2.add(bt_qna);
			p2.add(bt_complain);
			 northp.add("North", p2);
			
			
			
	      
	    bt_add = new JButton("추가"); 
	    bt_del = new JButton("삭제"); 
	    bt_up = new JButton("수정"); 
	    bt_check = new JButton("보기");
	 //   bt_search = new JButton("검색"); 
	   
	    southp = new JPanel();
	    southp.setBackground(null);
	      southp.add(bt_add);
	      southp.add(bt_del);
	      southp.add(bt_up);
	      southp.add(bt_check);
//	      southp.add(bt_search);
	   
	   
	    //add("Center",table);
	      
	    add("Center",scroll);
	    add("North",northp);
	    add("South",southp);
	   
	   // setBounds(400,300,300,300);
	
	    setVisible(true);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    eventUp();
	 }//생성자
	 

	 private void eventUp(){
	    table.addMouseListener(this);
	   
	    bt_add.addActionListener(this);
	    bt_del.addActionListener(this);
	    bt_up.addActionListener(this);
	    bt_check.addActionListener(this);
	    bt_main.addActionListener(this);
	    bt_qna.addActionListener(this);
	    bt_complain.addActionListener(this);
	    
	   
	    form.bt_input.addActionListener(this);
	    form.bt_cancel.addActionListener(this);
	    form.bt_check.addActionListener(this);
	    		
	   
	 }
	 
	 @Override
	 public void actionPerformed(ActionEvent e) {
	  //이벤트 소스에 대한 구분 :
	  //object e.getSource(), String e.getActionCommand()
	  
	//  System.out.println(e.getActionCommand());

	  Object ob=e.getSource();
		if (ob == bt_add) {// 추가버튼 클릭시
			form.initTF();
			setVisible(false);
			form.setVisible(true);
		} else if (ob == form.bt_input) {// 입력버튼 클릭시(입력폼, 수정폼)
			String number = form.tf_number.getText();
			String title = form.tf_title.getText();
			String writer = form.tf_writer.getText();
			String content = form.tf_content.getText();

			if (number == null || number.length() == 0) {
				// number변수에 null값이 들어올 가능성이 단 1%라도 있다면
				// null에 대한 체크를 하는 데 반드시 앞에서 체크해야 함.
				JOptionPane.showMessageDialog(form, "번호를 입력해 주세요.");
				form.tf_number.requestFocus();
				return;
			}

			if (title.length() == 0) {
				// TextField에는 null값이 들어오지 않으므로 null체크 뺌.
				JOptionPane.showMessageDialog(form, "제목을 작성해주세요");
				form.tf_title.requestFocus();
				return;
			}

			if (writer.length() == 0) {// 입력된 문자가 없다면
				JOptionPane.showMessageDialog(form, "작성자를 입력해주세요");
				form.tf_writer.requestFocus();
				return;
			}

			if (content.length() == 0) {// 입력된 문자가 없다면
				JOptionPane.showMessageDialog(form, "내용을 작성해주세요");
				form.tf_content.requestFocus();
				return;
			}

			if (form.getTitle().equals("게시글 작성")) {// 게시글 작성이었을때
				Object rowData[] = { number, title, writer, content };
				dtm.addRow(rowData);
			} else /* if (form.getTitle().equals("게시글 수정")) */ {// 게시글 수정이었을때
//	       table.setValueAt(Object aValue, int row, int column)
				table.setValueAt(title, srow, 1);
				// 제목 수정
				table.setValueAt(writer, srow, 2);
				// 작성자 수정
				table.setValueAt(content, srow, 3);
				// 내용 수정

			}
			form.setVisible(false);
			setVisible(true);

		} else if (ob == form.bt_cancel) {
			form.setVisible(false);

			setVisible(true);
		} else if (ob == bt_del) {
			// 삭제할 번호 입력
			// JOptionPane.showInputDialog(parentComponent, object message)
			String delNumber = JOptionPane.showInputDialog(this, "삭제할 번호:");
			// System.out.println("delNumber="+delNumber);
			// 확인, 취소, X : 입력된 번호 또는 빈문자열, null,null

			// delNumber.equals(table.getValueAt(0,0));
			// delNumber.equals(table.getValueAt(1,0));
			// delNumber.equals(table.getValueAt(2,0));
			// table.getRowCount();//전체 행갯수
			if (delNumber == null)
				return; // 취소, X

			if (delNumber.length() == 0) {
				JOptionPane.showMessageDialog(this, "삭제할 번호를 입력해 주세요");

				return; // 빈문자열 체크
			}

//	    table.getRowCount();
			for (int i = 0; i < table.getRowCount(); i++) {
				if (delNumber.equals(table.getValueAt(i, 0))) {
//	     dtm.removeRow(int 행인덱스)
					dtm.removeRow(i);

				}

			} // for

		} else if (ob == bt_up) {// 수정버튼을 클릭했다면
//	     table.getValueAt(row index, column index);
			srow = table.getSelectedRow();
			// JTable에서 선택된 행이 없다면 -1값을 리턴.

			if (srow == -1) {
				JOptionPane.showMessageDialog(this, "수정할 곳을 선택해주세요");
				return;
			}

			// String number = (String) table.getValueAt(srow,0);
			String number = table.getValueAt(srow, 0).toString();
			String title = (String) table.getValueAt(srow, 1);
			// nw Integer(13);
			String writer = (String) table.getValueAt(srow, 2);
			String content = (String) table.getValueAt(srow, 3);

			form.tf_number.setText(number);
			form.tf_title.setText(title);
			form.tf_writer.setText(writer);
			form.tf_content.setText(content);

			form.initUp();

			setVisible(false);
			form.setVisible(true);
		} else if (ob == bt_check) {

			srow = table.getSelectedRow();

			if (srow == -1) {
				JOptionPane.showMessageDialog(this, "볼 게시물을 선택해주세요");
				return;
			}
			String number = table.getValueAt(srow, 0).toString();
			String title = (String) table.getValueAt(srow, 1);
			// nw Integer(13);
			String writer = (String) table.getValueAt(srow, 2);
			String content = (String) table.getValueAt(srow, 3);

			form.tf_number.setText(number);
			form.tf_title.setText(title);
			form.tf_writer.setText(writer);
			form.tf_content.setText(content);

			form.initCk();
			setVisible(false);
			form.setVisible(true);
		} else if (ob == form.bt_check) {
			form.setVisible(false);

			setVisible(true);
			return;
		} else if (ob == bt_main) {// 메인 버튼 클릭시
			
			   main = new MainBoard();
			setVisible(false);
			main.setVisible(true);
		}  else if (ob == bt_qna) {// 상품문의 버튼 클릭시
			 qna = new QnaBoard();
			 setVisible(false);
			qna.setVisible(true);
			 
		} else if (ob == bt_complain) {// 불편접수 버튼 클릭시
			  complain = new ComplainBoard();
			 
			    
			 setVisible(false);
			complain.setVisible(true);
			 
		}
	}

	 /*
	 @Override
	 public void mouseClicked(MouseEvent e) {//이벤트핸들러
	     //System.out.println("mouseClicked");
	     //JTable을 클릭했을때 선택되어진 행의 데이터정보를
	     //JLabel에 출력.
	   
	    
	     int srow= table.getSelectedRow();//선택된 행 인덱스
	     //System.out.println("srow="+srow);
	  //table.getValueAt(int row, int column)
	     //column 0:번호, 1:제목, 2:작성자
//	     System.out.println(table.getValueAt(srow, 0));
//	     System.out.println(table.getValueAt(srow, 1));
//	     System.out.println(table.getValueAt(srow, 2));
	     Object number = table.getValueAt(srow, 0);
	     Object title = table.getValueAt(srow, 1);
	     Object writer = table.getValueAt(srow, 2);
	    
	     label.setText(number+" 제목:"+title+"   작성자:"+writer);   // 레이블 레이아웃 옮기는거 가능하면 나중에 수정
	    
	 }
	 */
	 
		/*
		 * public static void main(String[] args) { new ComplainBoard();
		 * 
		 * }
		 */
	 

	 @Override
	 public void mousePressed(MouseEvent e) {
	  // TODO Auto-generated method stub
	  
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
