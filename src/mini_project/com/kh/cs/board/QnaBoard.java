package mini_project.com.kh.cs.board;

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

import mini_project.com.kh.main.MainPage11;

public class QnaBoard extends JFrame implements MouseListener, ActionListener {

//		전체화면 배경색   : .setBackground(new Color(160, 242, 196));
//		 버튼 색(파란색) : .setBackground(new Color(0, 153, 255));
//		 버튼 색(까만색) : .setBackground(Color.DARK_GRAY);
//		 버튼 글자색 : setForeground(Color.WHITE);
//		 폰트 크기
//		 제목 : 30
//		 소제목 : 20 
//		 버튼 : 13
//		 프레임 크기 : setSize(1350, 900);
//		 Font font1 = new Font("NotoSansCJKkr-Black.otf", 0,13);
//		 Font font2 = new Font("NotoSansCJKkr-Black.otf", 0,20);
//		 Font font3 = new Font("NotoSansCJKkr-Bold.otf", Font.BOLD,20);
//		 Font font4 = new Font("NotoSansCJKkr-Black.otf", Font.BOLD,30);
//		 전체화면 배경색   : .setBackground(new Color(160, 242, 196));

	JTable table;
	JScrollPane scroll;
	JPanel northp, southp, centerp, topp;
	JLabel label;
	JButton bt_add, bt_del, bt_up, bt_search, bt_main, bt_qna, bt_complain, bt_check, bt_mainhome;

	MainPage11 mainhome;
	DefaultTableModel dtm;
	QnaBoard qna;
	ComplainBoard complain;
	MainBoard main;
	InputForm form;
	// InputPassword ipPw;

	int srow;

	public QnaBoard() {

		// 전체 화면 틀
		setTitle("댕숲");
		setSize(1350, 900);
		getContentPane().setBackground(new Color(160, 242, 196));
		try {
			setIconImage(ImageIO.read(new File("img/dog.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		form = new InputForm();
//		    ipPw = new InputPassword();

//			 JTable(Object[][] rowData, Object[] columnNames)

		Object[][] rowData = { { 0, "TEST", "관리자", "테스트", "테스트중" } };
		Object[] columnNames = { "번호", "제목", "작성자", "작성내용", "비밀번호" };
		// JTable(TableModel dm)
		dtm = new DefaultTableModel(rowData, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) { // 수정, 입력 불가
				return false;
			}
		};
		table = new JTable(dtm);// (rowData,columnNames);
//			table.getColumnModel().getColumn(3).setMinWidth(0);
//			table.getColumnModel().getColumn(4).setMinWidth(0);

		// 열 숨기기
		table.getColumn("작성내용").setWidth(0);
		table.getColumn("작성내용").setMinWidth(0);
		table.getColumn("작성내용").setMaxWidth(0);

		table.getColumn("비밀번호").setWidth(0);
		table.getColumn("비밀번호").setMinWidth(0);
		table.getColumn("비밀번호").setMaxWidth(0);

		
		topp = new JPanel();
		topp.setBounds(0, 0, 1334, 65);
		topp.setBackground(null);
		
		northp = new JPanel();
		northp.setBounds(0, 76, 1334, 65);
		northp.setBackground(null);

		centerp = new JPanel();
		centerp.setBounds(598, 151, 140, 33);
		centerp.setBackground(null);

		scroll = new JScrollPane(table);
		scroll.setBounds(230, 228, 874, 525);

		southp = new JPanel();
		southp.setBounds(0, 796, 1334, 65);
		southp.setBackground(null);

		
		
		bt_mainhome = new JButton("메인홈");
		bt_mainhome.setFont(new Font("NotoSansCJKkr-Black.otf", Font.BOLD, 30));
		bt_mainhome.setBorderPainted(false);
		bt_mainhome.setBackground((Color) null);
		
		bt_main = new JButton("공지사항");
		bt_main.setFont(new Font("NotoSansCJKkr-Black.otf", Font.BOLD, 30));
		bt_main.setBackground(null);
		bt_main.setBorderPainted(false);

		bt_qna = new JButton("상품문의");
		bt_qna.setFont(new Font("NotoSansCJKkr-Black.otf", Font.BOLD, 30));
		bt_qna.setBackground(null);
		bt_qna.setBorderPainted(false);

		bt_complain = new JButton("불편접수");
		bt_complain.setFont(new Font("NotoSansCJKkr-Black.otf", Font.BOLD, 30));
		bt_complain.setBackground(null);
		bt_complain.setBorderPainted(false);

		label = new JLabel("상품문의");
		label.setFont(new Font("NotoSansCJKkr-Black.otf", Font.BOLD, 20));

		bt_add = new JButton("등록");
		bt_add.setForeground(Color.WHITE);
		bt_add.setFont(new Font("NotoSansCJKkr-Black.otf", 0, 13));
		bt_add.setBackground(new Color(0, 153, 255));

		bt_check = new JButton("보기");
		bt_check.setForeground(Color.WHITE);
		bt_check.setFont(new Font("NotoSansCJKkr-Black.otf", 0, 13));
		bt_check.setBackground(new Color(0, 153, 255));

		bt_up = new JButton("수정");
		bt_up.setForeground(Color.WHITE);
		bt_up.setFont(new Font("NotoSansCJKkr-Black.otf", 0, 13));
		bt_up.setBackground(new Color(0, 153, 255));

		bt_del = new JButton("삭제");
		bt_del.setForeground(Color.WHITE);
		bt_del.setFont(new Font("NotoSansCJKkr-Black.otf", 0, 13));
		bt_del.setBackground(Color.DARK_GRAY);

//			 bt = new JButton("상품");
//		     bt1 = new JButton("상품후기");
//		     bt2 = new JButton("마이페이지");
//		     bt3 = new JButton("고객센터");
//		     	     
//		      p = new JPanel();
//		      p.setBackground(null);
//		      p.add(bt);
//		      p.add(bt1);
//		      p.add(bt2);
//		      p.add(bt3);
//		      northp.add("Center", p);
//		      
//			
//		     bt_search = new JButton("검색"); 
//		     southp.add(bt_search);

		getContentPane().setLayout(null);
		
		
		getContentPane().add(topp);
		getContentPane().add(northp);
		getContentPane().add(centerp);
		getContentPane().add(scroll);
		getContentPane().add(southp);

		
		topp.add(bt_mainhome);
		
		northp.add(bt_main);
		northp.add(bt_qna);
		northp.add(bt_complain);

		centerp.add(label);

		southp.add(bt_add);
		southp.add(bt_check);
		southp.add(bt_up);
		southp.add(bt_del);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		eventUp();

	}

	private void eventUp() {
		table.addMouseListener(this);

		bt_mainhome.addActionListener(this);
		bt_main.addActionListener(this);
		bt_qna.addActionListener(this);
		bt_complain.addActionListener(this);
		bt_add.addActionListener(this);
		bt_del.addActionListener(this);
		bt_up.addActionListener(this);
		bt_check.addActionListener(this);

		form.bt_input.addActionListener(this);
		form.bt_cancel.addActionListener(this);
//			    form.bt_check.addActionListener(this);

//			    ipPw.bt_check.addActionListener(this);
//			    ipPw.bt_cancel.addActionListener(this);

	}

	@Override
			public void actionPerformed(ActionEvent e) {
				// 이벤트 소스에 대한 구분 :
				// object e.getSource(), String e.getActionCommand()
				// System.out.println(e.getActionCommand());

				Object ob = e.getSource();

				// 메인홈 버튼 클릭시
				if (ob == bt_mainhome) {
					mainhome = new MainPage11();
					setVisible(false);
					mainhome.setVisible(true);
					
				}	
				
				// 공지사항 버튼 클릭시
				else if (ob == bt_main) {
					main = new MainBoard();
					setVisible(false);
					main.setVisible(true);

				}

				// 상품문의 버튼 클릭시
				else if (ob == bt_qna) {
					qna = new QnaBoard();
					setVisible(false);
					qna.setVisible(true);

				}

				// 불편접수 버튼 클릭시
				else if (ob == bt_complain) {
					complain = new ComplainBoard();
					setVisible(false);
					complain.setVisible(true);

				}

				// 등록 버튼 클릭시
				else if (ob == bt_add) {
					form.initTF();
					setVisible(false);
					form.setVisible(true);
				}
	 
				// 보기 버튼 클릭시  
				else if (ob == bt_check) {

					srow = table.getSelectedRow();

					if (srow == -1) {
						JOptionPane.showMessageDialog(this, "볼 게시물을 선택해주세요");
						return;
					}
					
					
					String number = table.getValueAt(srow, 0).toString();
					String title = (String) table.getValueAt(srow, 1);
					String writer = (String) table.getValueAt(srow, 2);
					String content = (String) table.getValueAt(srow, 3);
//					String password = (String) table.getValueAt(srow, 4);
					
	
					form.tf_number.setText(number);
					form.tf_title.setText(title);
					form.tf_writer.setText(writer);
					form.tf_content.setText(content);
//					form.pf_pw.setText(password);

					
//					ipPw.ippwCk();
//					setVisible(false);
//					ipPw.setVisible(true);
					
					
					form.initCk();
					setVisible(false);
					form.setVisible(true);
				}

				// 수정 버튼 클릭시 
				else if (ob == bt_up) {
//		     table.getValueAt(row index, column index);

					srow = table.getSelectedRow();
					// JTable에서 선택된 행이 없다면 -1값을 리턴.

					if (srow == -1) {
						JOptionPane.showMessageDialog(this, "수정할 곳을 선택해주세요");
						return;
					}
					
					
					String number = table.getValueAt(srow, 0).toString();
					String title = (String) table.getValueAt(srow, 1);
					String writer = (String) table.getValueAt(srow, 2);
					String content = (String) table.getValueAt(srow, 3);
//					String password = (String) table.getValueAt(srow, 4);

					form.tf_number.setText(number);
					form.tf_title.setText(title);
					form.tf_writer.setText(writer);
					form.tf_content.setText(content);
//					form.pf_pw.setText(password);

			
//					ipPw.ippwCk();
//					setVisible(false);
//					ipPw.setVisible(true);
				
								
					 form.initUp();
					 form.setVisible(true);
				}
				
				// 삭제 버튼 클릭시 -->  테이블에서 불러오지말고 파일에서 출력하기
				else if (ob == bt_del) {
					// 삭제할 번호 입력
					// JOptionPane.showInputDialog(parentComponent, object message)
					String delNumber = JOptionPane.showInputDialog(this, "삭제할 번호:");
		
					
					// System.out.println("delNumber="+delNumber);
					// 확인, 취소, X : 입력된 번호 또는 빈문자열, null,null
					if (delNumber == null)
						return; // 취소, X
					

					if (delNumber.length() == 0) {
						JOptionPane.showMessageDialog(this, "삭제할 번호를 입력해 주세요");

						return; // 빈문자열 체크
					}

				
					// delNumber.equals(table.getValueAt(0,0));
					// delNumber.equals(table.getValueAt(1,0));
					// delNumber.equals(table.getValueAt(2,0));
					// table.getRowCount();//전체 행갯수
					
					


//					ipPw.ippwCk();
//					setVisible(false);
//					ipPw.setVisible(true);		
			
					
//		    table.getRowCount();
					for (int i = 0; i < table.getRowCount(); i++) {
						if (delNumber.equals(table.getValueAt(i, 0))) {
//		     dtm.removeRow(int 행인덱스)
							dtm.removeRow(i);
						}
					} // for	
					
				}
				
				/*	// 확인 버튼 클릭시(비밀번호 확인 창)
				else if (ob == ipPw.bt_check) {
					String pw = ipPw.pw_field.getText();

					if (pw.length() == 0) {// 입력된 문자가 없다면
						JOptionPane.showMessageDialog(form, "비밀번호를 입력해주세요");
						form.pf_pw.requestFocus();
						return;
					}

					BufferedReader br;
					try {
						String s;
					//	String[] array;
						br = new BufferedReader(new FileReader("비밀번호.txt"));
						while((s = br.readLine()) != null){
						//	array=s.split("/");
						if (ipPw.pw_field.getText().equals(s)) {
							//form.initUp();

							
					//		if() // 보기,수정,삭제버튼 경로별로 해당 input으로 보내야함
							
							
							ipPw.setVisible(false);
							form.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
							
							
						}break;
						}
						br.close();
						dispose();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

				// 취소 버튼 클릭시(비밀번호 확인 창)
				else if (ob == ipPw.bt_cancel) {
					ipPw = new InputPassword();
					ipPw.setVisible(false);
					setVisible(true);

				}
	*/

				// 확인 버튼 클릭시(입력폼 수정폼)
				else if (ob == form.bt_input) {
					
					String number = form.tf_number.getText();
					String title = form.tf_title.getText();
					String writer = form.tf_writer.getText();
					String content = form.tf_content.getText();
//					String password = form.pf_pw.getText();

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

//					if (password.length() == 0) {// 입력된 문자가 없다면
//						JOptionPane.showMessageDialog(form, "비밀번호를 입력해주세요");
//						form.pf_pw.requestFocus();
//						return;
//					}

					
					if (form.getTitle().equals("게시글 작성")) {// 게시글 작성이었을때
						Object rowData[] = { number, title, writer, content/*, password*/ };
						dtm.addRow(rowData);

//						try {
//							BufferedWriter bos = new BufferedWriter(new FileWriter("비밀번호.txt", true));
//							bos.write(form.pf_pw.getText() + "\r\n");
//							bos.close();
//
//						} catch (IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
					} else if (form.getTitle().equals("게시글 수정")) {// 게시글 수정이었을때
//		       table.setValueAt(Object aValue, int row, int column)
						table.setValueAt(title, srow, 1);
						// 제목 수정
						table.setValueAt(writer, srow, 2);
						// 작성자 수정
						 table.setValueAt(content, srow, 3);
						// 내용 수정
//						 table.setValueAt(password, srow, 4);
						 // 비밀번호 수정

//						try { // 수정시 회원정보 불러오기
//
//							BufferedReader br = new BufferedReader(new FileReader("비밀번호.txt"));
//							br.readLine();
//							br.close();
//						} catch (IOException e2) {
//							e2.printStackTrace();
//						}
//
//						try {
//							BufferedWriter bos = new BufferedWriter(new FileWriter("비밀번호.txt", true));
//							bos.write(form.pf_pw.getText() + "\r\n");
//							bos.close();
//
//						} catch (IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}

					}

					form.setVisible(false);
					setVisible(true);

				}
				
			//  취소 버튼 클릭시(입력폼 수정폼)
				else if (ob == form.bt_cancel) {
					form.setVisible(false);
					setVisible(true);

				}
			
				 
/*				 @Override
				 public void mouseClicked(MouseEvent e) {//이벤트핸들러
				     //System.out.println("mouseClicked");
				     //JTable을 클릭했을때 선택되어진 행의 데이터정보를
				     //JLabel에 출력.
				   
				    
				     int srow= table.getSelectedRow();//선택된 행 인덱스
				     //System.out.println("srow="+srow);
				  //table.getValueAt(int row, int column)
				     //column 0:번호, 1:제목, 2:작성자
//				     System.out.println(table.getValueAt(srow, 0));
//				     System.out.println(table.getValueAt(srow, 1));
//				     System.out.println(table.getValueAt(srow, 2));
				     Object number = table.getValueAt(srow, 0);
				     Object title = table.getValueAt(srow, 1);
				     Object writer = table.getValueAt(srow, 2);
				    
				     label.setText(number+" 제목:"+title+"   작성자:"+writer);   // 레이블 레이아웃 옮기는거 가능하면 나중에 수정
				    
				 }
				 
*/				 
					
				
				
				
				
			}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
