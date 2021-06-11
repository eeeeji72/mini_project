package mini_project.com.kh.product;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import mini_project.com.kh.product.ProductMain;
import mini_project.com.kh.product.Etc_DogHouse;

public class Cart extends JFrame implements MouseListener, ActionListener {
	private JTable table; // table
	private static int HEADER_HEIGHT = 40; // table header 높이
	// Etc_DogHouse edh;

	public Cart() {
		
		JMenuBar menuBar = new JMenuBar(); //메뉴바 생성

		 //메뉴 생성
		JMenu categ = new JMenu("카테고리");
		JMenu my = new JMenu("내 정보");		
		JMenu cen = new JMenu("고객센터");	
		
		// 폰트, 크기 적용
		Font ft = new Font("NotoSansCJKkr", Font.BOLD, 13);
		categ.setFont(ft);
		my.setFont(ft);
		cen.setFont(ft);
		
		menuBar.add(categ);
		menuBar.add(my);
		menuBar.add(cen);
		
		//서브메뉴-카테고리
		JMenuItem menuItem = null;

		menuItem = new JMenuItem("상품 홈");
		menuItem.addActionListener(menuItemListener);
		categ.add(menuItem);
		//클릭시 이동
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductMain();
				System.out.println("[ 장바구니 -> 상품 홈]");
				setVisible(false); // 창 안보이게 하기
			}
		});		
		categ.addSeparator();
		
		menuItem = new JMenuItem("베스트 상품");
		menuItem.addActionListener(menuItemListener);
		categ.add(menuItem);
		//클릭시 이동
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductList_Best();
				System.out.println("[ 장바구니 -> 베스트 카테고리]");
				setVisible(false); // 창 안보이게 하기
			}
		});		

		menuItem = new JMenuItem("의류");
		menuItem.addActionListener(menuItemListener);
		categ.add(menuItem);
		//클릭시 이동
		menuItem.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			new ProductList_Clo();
			System.out.println("[ 장바구니 -> 의류 카테고리]");
			setVisible(false); // 창 안보이게 하기
			}
		});		
				
		menuItem = new JMenuItem("장난감&간식");
		menuItem.addActionListener(menuItemListener);
		categ.add(menuItem);
		//클릭시 이동
		menuItem.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			new ProductList_ToySnack();
			System.out.println("[ 장바구니 -> 장난감&간식 카테고리]");
			setVisible(false); // 창 안보이게 하기
			}
		});		
						
				
		menuItem = new JMenuItem("액세서리");
		menuItem.addActionListener(menuItemListener);
		categ.add(menuItem);
		//클릭시 이동
		menuItem.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			new ProductList_Acc();
			System.out.println("[ 장바구니 -> 액세서리 카테고리]");
			setVisible(false); // 창 안보이게 하기
			}
		});						
				
		menuItem = new JMenuItem("기타");
		menuItem.addActionListener(menuItemListener);
		categ.add(menuItem);
		//클릭시 이동
		menuItem.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			new ProductList_Etc();
			System.out.println("[ 장바구니 -> 기타 카테고리]");
			setVisible(false); // 창 안보이게 하기
			}
		});		
				
		menuItem = new JMenuItem("장바구니");
		menuItem.addActionListener(menuItemListener);
		categ.add(menuItem);
		//클릭시 이동
		menuItem.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			new Cart();
			System.out.println("[ 장바구니 -> 장바구니]");
			setVisible(false); // 창 안보이게 하기
			}
		});		
		
		//서브메뉴-마이페이지, 고객센터
		menuItem = new JMenuItem("마이페이지");
		menuItem.addActionListener(menuItemListener);
		my.add(menuItem);	
		//클릭시 이동
		menuItem.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			//new ProductList_Acc();
			System.out.println("[ 장바구니  -> 마이페이지]");
			//setVisible(false); // 창 안보이게 하기
			}
		});		
		
		menuItem = new JMenuItem("고객센터");
		menuItem.addActionListener(menuItemListener);
		cen.add(menuItem);	
		//클릭시 이동
		menuItem.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			//new ProductList_Acc();
			System.out.println("[ 장바구니  -> 고객센터]");
			//setVisible(false); // 창 안보이게 하기
			}
		});		
		
		
		//JFrame에 메뉴바 설정
		setJMenuBar(menuBar);
		
		
		
		// 이름, 이미지
		setTitle("댕숲");
		try {
			setIconImage(ImageIO.read(new File("img/d.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

		// 전체 틀
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 63, 116, 0, 305, 116, 56, 0 };
		gbl_panel.rowHeights = new int[] { 52, 0, 56, -38, 0, 454, 0, 16, 0, 37, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		// 장바구니 글자
		JLabel lblNewLabel = new JLabel("< 장바구니 >");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		// 폰트, 크기 적용
		Font txt = new Font("NotoSansCJKkr", Font.BOLD, 30);
		lblNewLabel.setFont(txt);
		panel.add(lblNewLabel, gbc_lblNewLabel);

		// table 담긴 panel
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 2;
		gbc_panel_1.gridwidth = 4;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 4;
		panel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout());

		// table
		String[] title = { "상품명", "수량", "가격" }; // header
		int count = 1;
		DefaultTableModel model = new DefaultTableModel(title, 0);
		JTable table = new JTable(model);
		table.setRowHeight(50);
		ArrayList pay_list = new ArrayList(); // 결제 금액 관련 리스트 선언
		panel_1.add(table);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		table.setFillsViewportHeight(true);
		JTableHeader header = table.getTableHeader();
		header.setPreferredSize(new Dimension(100, HEADER_HEIGHT));
		panel_1.add(header, BorderLayout.NORTH);
		panel_1.add(table, BorderLayout.CENTER);
		panel_1.add(table);
		
		// 폰트, 크기 적용
		Font tab = new Font("NotoSansCJKkr", Font.BOLD, 13);
		table.setFont(tab);
		// 스크롤 적용-많이 누르면 등장
		panel_1.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

		//Etc_DogHouse edgh;
		//edgh = new Etc_DogHouse();
		
		//edgh.actionPerformed();
		
		// 하단 영역
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 4;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 8;
		panel.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		// 선택 취소 버튼
		JButton btnNewButton_2 = new JButton("선택 상품 삭제");
		// 폰트, 크기 적용
		Font btn = new Font("NotoSansCJKkr", Font.PLAIN, 13);
		table.setFont(btn);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setFont(btn);
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(btnNewButton_2, BorderLayout.WEST);

		// 합계 가격 호출
		// String str = "총 합계 : ";
		//String str = "";
		JLabel lblNewLabel_1 = new JLabel("", SwingConstants.CENTER);
		//JLabel lblNewLabel_1 = new JLabel(str, SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1, BorderLayout.CENTER);
		Font usef = new Font("NotoSansCJKkr", Font.PLAIN, 20);
		lblNewLabel_1.setFont(usef);

		// 결제하기 버튼
		JButton btnNewButton_3 = new JButton("결제하기");
		btnNewButton_3.setPreferredSize(new Dimension(118, 27));
		btnNewButton_3.setBackground(new Color(0, 153, 255));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(btn);
		panel_2.add(btnNewButton_3, BorderLayout.EAST);

		// 버튼 클릭 시 이벤트
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("장바구니 담기")) {
					/*
					// 입력된 값 테이블에 추가하기
					String info[] = new String[3]; // 한행 (row) 에 저장할 데이터 모음
					info[0] = hsize.getSelectedItem().toString(); // 콤보박스 값을 가져온다
					info[1] = "1";
					if (hsize.getSelectedItem().toString().equals("소형견 용")) {
						info[2] = "8000";
					} else if (hsize.getSelectedItem().toString().equals("중형견 용 (+5000원)")) {
						info[2] = "13000";
					} else {
						info[2] = "18000";
					}
					model.addRow(info); // 테이블 모델에 데이터 삽입 실시
					pay_list.add(hsize.getSelectedItem().toString() + " => 수량 : " + count + " : " + info[2] + "원"); // 결제
					*/																				// 금액
																													// 리스트에
																													// 추가
					int rowCont = table.getRowCount();

					System.out.println(rowCont); // 줄 개수\
					int sad = 0;
					//int pp = Integer.parseInt(info[2].toString()); // 금액 부분...ㅋ 매번 클릭시 새로운걸로 업데이트-> 누적으로 만들고 싶음
					//System.out.println(pp);
					//totalprice.setText(String.valueOf("총 금액 " + pp));

					for (int i = 0; i < rowCont; i++) {

					}
					/*
					 * int sum =0; for(int i=0;i<rowCont;i++) { sum += (int)table.getValueAt(i, 3);
					 * System.out.println(sum); }
					 * 
					 * /* totalprice.setText(String.valueOf("총 금액 " + sum)); totalprice.setFont(new
					 * Font("맑은고딕", Font.BOLD, 40)); /* System.out.println(info[2].toString()); int
					 * pp = Integer.parseInt(info[2].toString()); hap += pp;
					 * System.out.println("총 합 : " + pp);
					 */
				} else if (e.getActionCommand().equals("결제하기")) { // 결제 버튼 클릭이벤트 처리
					int rowCont = table.getRowCount();
					int sum =0;
					for(int i=0;i<rowCont;i++) {
						sum += (int)table.getValueAt(i, 2);
					}
					lblNewLabel_1.setText(String.valueOf("총 금액 : " + sum + "원"));
					/** TODO [질문 알림창]*/ 
					if(rowCont > 0) {	//테이블에 내역 있을때에만 창 뜨도록
						int qut_data = JOptionPane.showConfirmDialog(getContentPane(), "주문을 결제하시겠습니까?", "주문 진행",
								JOptionPane.YES_NO_CANCEL_OPTION);
						if (qut_data == 0) { // [예] 버튼
							System.out.println(pay_list.toString());
							JOptionPane.showMessageDialog(getContentPane(),
									"정상적으로 결제되었습니다." + "\n" + "[주문내역]\n" + pay_list.toString(), "결제 완료",
									JOptionPane.INFORMATION_MESSAGE);
						} else if (qut_data == 1) { // [아니오] 버튼
	
						} else if (qut_data == 2) { // [취소] 버튼
	
						}
					}else {	//테이블에 값 없으면 뜨지 않도록
						
					}

				} else if (e.getActionCommand().equals("선택 상품 삭제")) { // 삭제 버튼 클릭이벤트 처리
					// 선택한 줄(row)의 번호 알아내기
					int rowIndex = table.getSelectedRow();

					// 선택 안하고 누를 경우 리턴값 -1
					if (rowIndex == -1) {
						return;
					}
					model.removeRow(rowIndex); // 해당 테이블 행 삭제
					pay_list.remove(rowIndex); // 결제 금액 리스트에서도 삭제 실시
				}

			}

		};

		btnNewButton_2.addActionListener(action);
		btnNewButton_3.addActionListener(action);

		// 우측 마우스 클릭 시 상품 홈으로
		panel.addMouseListener(this);
		table.addMouseListener(this);

		panel.setBackground(new Color(160, 242, 196));
		panel_2.setBackground(new Color(160, 242, 196));
		setSize(1350, 900);
		setVisible(true);
		setResizable(false); // 크기 고정
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		if (e.getModifiers() == MouseEvent.BUTTON3_MASK) {
			System.out.println("[ 장바구니 -> 상품 홈]");
			new ProductMain();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	ActionListener menuItemListener = new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	};
}
