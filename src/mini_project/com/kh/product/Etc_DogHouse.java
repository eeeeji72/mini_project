package mini_project.com.kh.product;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import mini_project.com.kh.product.ProductList_Etc;

public class Etc_DogHouse extends JFrame  implements MouseListener {
	private JTable table;
	private static int HEADER_HEIGHT = 40;	//table header 높이
	public Etc_DogHouse() {
		
		//이름, 이미지
		setTitle("댕숲");
		try {
			setIconImage(ImageIO.read(new File("img/d.PNG")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

		//전체적 화면
		JPanel panel_5 = new JPanel();
		getContentPane().add(panel_5);

		panel_5.setBounds(0, 0, 900, 900);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{80, 275, 350, 0};
		gbl_panel_5.rowHeights = new int[]{383, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		//사진 영역
		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 0, 5);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 1;
		gbc_panel_7.gridy = 0;
		panel_5.add(panel_7, gbc_panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{0, 535, 37, 0};
		gbl_panel_7.rowHeights = new int[]{100, 586, 0, 0};
		gbl_panel_7.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);

		//사진
		JPanel panel_8 = new JPanel() {
			
			Image background=new ImageIcon("img/DH.png").getImage();
			public void paint(Graphics g) {//그리는 함수
				g.drawImage(background, 0, 0, null);//background를 그려줌		
			}
		};
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 5);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 1;
		gbc_panel_8.gridy = 1;
		panel_7.add(panel_8, gbc_panel_8);
		
		//상품 설명 영역
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 2;
		gbc_panel_6.gridy = 0;
		panel_5.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 217, 89, 68, 0};
		gbl_panel_6.rowHeights = new int[]{144, 39, 36, 262, 50, 0, 78, 132, 0, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		//상품명
		JLabel lblNewLabel = new JLabel("강아지 집");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel_6.add(lblNewLabel, gbc_lblNewLabel);
		
		//상품 가격
		JLabel lblNewLabel_1 = new JLabel("가격 : 8000원");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		panel_6.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		//상품 설명
		String str = "<html>강아지 집은 원목 소재로 되어있습니다.<br>"
				+ "튼튼하고 내구성이 좋아 휘어짐이나 변형이 적습니다.<br>"
				+ "(크기는 아래 참조)<br><br><br>"
				+ "[  집 크기   (너비, 크기, 깊이 / 단위 : cm)  ]<br>"
				+ " - 소형견 용(W : 60, h : 65, d : 50)<br><br>"
				+ " - 중형견 용(W : 80, h : 70, d : 80)<br><br>"
				+ " - 대형견 용(W : 100, h : 85, d : 100)<html>";

		JLabel lblNewLabel_2 = new JLabel(str);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;

		Font usef = new Font("궁서", Font.PLAIN, 20);
		lblNewLabel_2.setFont(usef);
		
		panel_6.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		
		//제품 선택
		String dsize[] = {"소형견 용", "중형견 용 (+5000원)", "대형견 용 (+10000원)"};
		JComboBox hsize = new JComboBox(dsize);
		GridBagConstraints gbc_hsize = new GridBagConstraints();
		gbc_hsize.insets = new Insets(0, 0, 5, 5);
		gbc_hsize.fill = GridBagConstraints.HORIZONTAL;
		gbc_hsize.gridx = 1;
		gbc_hsize.gridy = 4;
		panel_6.add(hsize, gbc_hsize);
		
		//장바구니 버튼
		JButton btnNewButton = new JButton("장바구니 담기");
		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.setForeground(Color.WHITE);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 4;
		panel_6.add(btnNewButton, gbc_btnNewButton);
		
		//리뷰 버튼
		//String txt = "리뷰보기";
		JButton btnNewButton_2 = new JButton("리뷰보기");
		btnNewButton_2.setPreferredSize(new Dimension(118, 27));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 5;
		panel_6.add(btnNewButton_2, gbc_btnNewButton_2);


		panel_5.setBackground(new Color(160, 242, 196));
		panel_7.setBackground(new Color(160, 242, 196));
		panel_6.setBackground(new Color(160, 242, 196));
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 6;
		panel_6.add(panel, gbc_panel);
		
		
        String [] title = {"상품명","수량", "가격"};	//header

    	int count =1;
        panel.setLayout(new BorderLayout(0, 0));
        DefaultTableModel model = new DefaultTableModel(title, 0);
		JTable table = new JTable(model);	
		ArrayList pay_list = new ArrayList(); //결제 금액 관련 리스트 선언
		table.setRowHeight(50);
		table.setPreferredScrollableViewportSize(new Dimension(500,50));
		table.setFillsViewportHeight(true);
		JTableHeader header = table.getTableHeader();
		header.setPreferredSize(new Dimension(100, HEADER_HEIGHT));
		panel.add(header, BorderLayout.NORTH);
		panel.add(table, BorderLayout.CENTER);
		panel.add(table);
		
		panel.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 8;
		panel_6.add(panel_2, gbc_panel_2);
		JButton del_btn = new JButton("선택 삭제");
		del_btn.setForeground(Color.WHITE);
		del_btn.setBackground(Color.DARK_GRAY);
		panel_2.add(del_btn);
		
		JLabel totalprice = new JLabel("총 금액 : ");
		panel_2.add(totalprice);
		
		JButton pay_btn = new JButton("결제하기");
		pay_btn.setBackground(new Color(0, 153, 255));
		pay_btn.setForeground(Color.WHITE);
		panel_2.add(pay_btn);
		
		
		ActionListener action = new ActionListener(){		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				if (e.getActionCommand().equals("장바구니 담기")) {
					//TODO 입력된 값 테이블에 추가하기
					String info[] = new String[3]; //한행 (row) 에 저장할 데이터 모음
					info[0] = hsize.getSelectedItem().toString(); //콤보박스 값을 가져온다
					info[1] = "1";				
					if(hsize.getSelectedItem().toString().equals("소형견 용")) {
						info[2] = "8000";
					}else if(hsize.getSelectedItem().toString().equals("중형견 용 (+5000원)")) {
						info[2] = "13000";
					}else {
						info[2] = "18000";
					}
					model.addRow(info); //테이블 모델에 데이터 삽입 실시
					pay_list.add(hsize.getSelectedItem().toString()+ " => 수량 : " +  count + " : "+ info[2] + "원"); //결제 금액 리스트에 추가
					
				}else if(e.getActionCommand().equals("결제하기")) { // 결제 버튼 클릭이벤트 처리
					/** TODO [질문 알림창]*/ 
					int qut_data = JOptionPane.showConfirmDialog(getContentPane(), "주문을 결제하시겠습니까?","주문 진행", 
							JOptionPane.YES_NO_CANCEL_OPTION);
					if(qut_data == 0) { //[예] 버튼
						System.out.println(pay_list.toString());
						JOptionPane.showMessageDialog(getContentPane(), "정상적으로 결제되었습니다."+"\n"+"[주문내역]\n"+pay_list.toString(), "결제 완료", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(qut_data == 1) { //[아니오] 버튼
						
					}
					else if(qut_data == 2){ //[취소] 버튼
						
					}

				}
				else if(e.getActionCommand().equals("선택 삭제")) { // 삭제 버튼 클릭이벤트 처리
					//선택한 줄(row)의 번호 알아내기
					int rowIndex = table.getSelectedRow();
					
					//선택 안하고 누를 경우 리턴값 -1
					if(rowIndex == -1) {
						return;	
					}
					model.removeRow(rowIndex); //해당 테이블 행 삭제
					pay_list.remove(rowIndex); //결제 금액 리스트에서도 삭제 실시
				}

		}
		
		};
		

		
		
		btnNewButton.addActionListener(action);
		del_btn.addActionListener(action);
		pay_btn.addActionListener(action);	
		
		panel_2.addMouseListener(this);
		panel_5.addMouseListener(this);
		panel_7.addMouseListener(this);
		panel_6.addMouseListener(this);

		panel_2.setBackground(new Color(160, 242, 196));
		


		
		setSize(1350,900);
		setVisible(true);
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		if (e.getModifiers() == MouseEvent.BUTTON3_MASK) {
			System.out.println("[ -> 기타 카테고리]");
			new ProductList_Etc();
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
}
