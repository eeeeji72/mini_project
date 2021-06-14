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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import mini_project.com.kh.cs.board.MainBoard;
import mini_project.com.kh.main.MainPage11;
import mini_project.com.kh.my.Page11;
import mini_project.com.kh.review.CreatedList;
import mini_project.com.kh.review.ReviewMain;

public class Acc_Party extends JFrame implements MouseListener {
	private JTable table;
	private static int HEADER_HEIGHT = 40; // table header 높이

	private File dir;
	private String filePath;
	ArrayList<String> pFiles = new ArrayList<String>();

	String ptitle;
	String pprice;
	String pinfo;

	void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Acc_Party() {
		// File Open
		File wFile = new File("PD3333.txt");

		// File Reader를 위한 객체 생성
		FileReader frd = null;
		BufferedReader brd = null;

		// 내용 저장을 위한 ArrayList 정의
		ArrayList<String> lineList = new ArrayList<String>();

		// 라인 단위 저장 및 카운트를 위한 변수 정의
		String rLine = null;
		int lineNum = 0;
		boolean hasMore = true;

		try {
			frd = new FileReader(wFile);
			brd = new BufferedReader(frd);
			while (hasMore) {
				if ((rLine = brd.readLine()) != null) {
					// ArrayList에 읽은 라인 추가
					lineList.add(rLine);
					lineNum++;
					hasMore = true;
				} else
					hasMore = false;
			}
			frd.close();
			brd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 라인단위 출력(for loop)
		lineNum = lineList.size();

		ptitle = lineList.get(2);
		System.out.println("ptitle : " + ptitle);
		pprice = lineList.get(3);
		System.out.println("pprice : " + pprice);
		pinfo = lineList.get(5);
		System.out.println("pinfo : " + pinfo);

		JMenuBar menuBar = new JMenuBar(); // 메뉴바 생성

		// 메뉴 생성
		JMenu categ = new JMenu("카테고리");
		JMenu my = new JMenu("내 정보");
		JMenu cen = new JMenu("고객센터");
		JMenu main = new JMenu("메인페이지");
		JMenu review = new JMenu("상품후기");

		// 폰트, 크기 적용
		Font ft = new Font("NotoSansCJKkr", Font.BOLD, 13);
		categ.setFont(ft);
		my.setFont(ft);
		cen.setFont(ft);
		main.setFont(ft);
		review.setFont(ft);

		menuBar.add(categ);
		menuBar.add(my);
		menuBar.add(cen);
		menuBar.add(main);
		menuBar.add(review);

		// 서브메뉴-카테고리
		JMenuItem menuItem = null;

		menuItem = new JMenuItem("상품 홈");
		menuItem.addActionListener(menuItemListener);
		categ.add(menuItem);
		// 클릭시 이동
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductMain();
				System.out.println("[ -> 상품 홈]");
				setVisible(false); // 창 안보이게 하기
			}
		});
		categ.addSeparator();

		menuItem = new JMenuItem("장난감");
		menuItem.addActionListener(menuItemListener);
		categ.add(menuItem);
		// 클릭시 이동
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductList_Toy();
				System.out.println("[ -> 장난감 카테고리]");
				setVisible(false); // 창 안보이게 하기
			}
		});

		menuItem = new JMenuItem("의류");
		menuItem.addActionListener(menuItemListener);
		categ.add(menuItem);
		// 클릭시 이동
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductList_Clo();
				System.out.println("[ -> 의류 카테고리]");
				setVisible(false); // 창 안보이게 하기
			}
		});

		menuItem = new JMenuItem("간식");
		menuItem.addActionListener(menuItemListener);
		categ.add(menuItem);
		// 클릭시 이동
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductList_Snack();
				System.out.println("[ -> 간식 카테고리]");
				setVisible(false); // 창 안보이게 하기
			}
		});

		menuItem = new JMenuItem("액세서리");
		menuItem.addActionListener(menuItemListener);
		categ.add(menuItem);
		// 클릭시 이동
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductList_Acc();
				System.out.println("[ -> 액세서리 카테고리]");
				setVisible(false); // 창 안보이게 하기
			}
		});

		menuItem = new JMenuItem("기타");
		menuItem.addActionListener(menuItemListener);
		categ.add(menuItem);
		// 클릭시 이동
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductList_Etc();
				System.out.println("[ -> 기타 카테고리]");
				setVisible(false); // 창 안보이게 하기
			}
		});

		// 서브메뉴-마이페이지, 고객센터
		menuItem = new JMenuItem("마이페이지");
		menuItem.addActionListener(menuItemListener);
		my.add(menuItem);
		// 클릭시 이동
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Page11();
				System.out.println("[-> 마이페이지]");
				setVisible(false); // 창 안보이게 하기
			}
		});

		menuItem = new JMenuItem("고객센터");
		menuItem.addActionListener(menuItemListener);
		cen.add(menuItem);
		// 클릭시 이동
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainBoard();
				System.out.println("[-> 고객센터]");
				setVisible(false); // 창 안보이게 하기
			}
		});

		menuItem = new JMenuItem("메인 페이지");
		menuItem.addActionListener(menuItemListener);
		main.add(menuItem);
		// 클릭시 이동
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainPage11();
				System.out.println("[-> 메인페이지]");
				setVisible(false); // 창 안보이게 하기
			}
		});

		menuItem = new JMenuItem("상품후기");
		menuItem.addActionListener(menuItemListener);
		review.add(menuItem);
		// 클릭시 이동
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ReviewMain();
				System.out.println("[-> 상품후기]");
				setVisible(false); // 창 안보이게 하기
			}
		});
		
		// JFrame에 메뉴바 설정
		setJMenuBar(menuBar);

		// 이름, 이미지
		setTitle("댕숲");
		try {
			setIconImage(ImageIO.read(new File("img/d.PNG")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

		// 전체적 화면
		JPanel panel_5 = new JPanel();
		getContentPane().add(panel_5);

		panel_5.setBounds(0, 0, 900, 900);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] { 39, 275, 350, 0 };
		gbl_panel_5.rowHeights = new int[] { 383, 0 };
		gbl_panel_5.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_5.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_5.setLayout(gbl_panel_5);

		// 사진 영역
		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 0, 5);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 1;
		gbc_panel_7.gridy = 0;
		panel_5.add(panel_7, gbc_panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[] { 0, 535, 37, 0 };
		gbl_panel_7.rowHeights = new int[] { 100, 586, 0, 0 };
		gbl_panel_7.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_7.rowWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		panel_7.setLayout(gbl_panel_7);

		// 사진
		JPanel panel_8 = new JPanel() {
			Image background = new ImageIcon("img/partycap.png").getImage();

			public void paint(Graphics g) {// 그리는 함수
				Dimension d = getSize();
				g.drawImage(background, 0, 0, d.height, d.width, null);// background를 그려줌
			}
		};
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.gridwidth = 3;
		gbc_panel_8.insets = new Insets(0, 0, 5, 5);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 1;
		panel_7.add(panel_8, gbc_panel_8);

		// 상품 설명 영역
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 2;
		gbc_panel_6.gridy = 0;
		panel_5.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[] { 0, 217, 89, 68, 0 };
		gbl_panel_6.rowHeights = new int[] { 72, 39, 36, 262, 50, 0, 78, 132, 0, 0 };
		gbl_panel_6.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_6.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panel_6.setLayout(gbl_panel_6);

		// 상품명
		JLabel lblNewLabel = new JLabel("[" + lineList.get(1) + "] " + ptitle);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel_6.add(lblNewLabel, gbc_lblNewLabel);
		// 폰트, 크기 적용
		Font product = new Font("NotoSansCJKkr", Font.PLAIN, 30);
		lblNewLabel.setFont(product);

		// 상품 가격
		JLabel lblNewLabel_1 = new JLabel(pprice + "원");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		panel_6.add(lblNewLabel_1, gbc_lblNewLabel_1);
		// 폰트, 크기 적용
		lblNewLabel_1.setFont(product);

		// 상품 설명
		JLabel lblNewLabel_2 = new JLabel(pinfo);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		// 폰트, 크기 적용
		Font detail = new Font("NotoSansCJKkr", Font.PLAIN, 20);
		lblNewLabel_2.setFont(detail);

		panel_6.add(lblNewLabel_2, gbc_lblNewLabel_2);

		// 제품 선택-콤보박스
		String dsize[] = { "소형견 용", "중형견 용 (+5000원)", "대형견 용 (+10000원)" };
		// int [] productprice = {Integer.parseInt(pprice), 26000, 31000};
		// Integer.parseInt(pprice)
		int p = Integer.parseInt(pprice);
		int p1 = Integer.parseInt(pprice) + 5000;
		int p2 = Integer.parseInt(pprice) + 10000;
		int[] productprice = { p, p1, p2 };
		JComboBox hsize = new JComboBox(dsize);
		GridBagConstraints gbc_hsize = new GridBagConstraints();
		gbc_hsize.insets = new Insets(0, 0, 5, 5);
		gbc_hsize.fill = GridBagConstraints.HORIZONTAL;
		gbc_hsize.gridx = 1;
		gbc_hsize.gridy = 4;
		panel_6.add(hsize, gbc_hsize);
		// 폰트, 크기 적용
		Font btn = new Font("NotoSansCJKkr", Font.PLAIN, 13);
		hsize.setFont(btn);

		// 리뷰 버튼
		JButton btnNewButton_2 = new JButton("리뷰보기");
		btnNewButton_2.setPreferredSize(new Dimension(118, 27));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 5;
		btnNewButton_2.addActionListener(new ActionListener() {

			// 작성한 리뷰
			@Override
			public void actionPerformed(ActionEvent e) {
				CreatedList CLdialog = new CreatedList();
				CLdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				CLdialog.setVisible(true);

			}
		});
		panel_6.add(btnNewButton_2, gbc_btnNewButton_2);
		// 폰트, 크기 적용
		btnNewButton_2.setFont(btn);

		// 우측 하단 장바구니 영역
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 6;
		panel_6.add(panel, gbc_panel);

		// 장바구니
		String[] title = { "상품명", "수량", "가격" }; // header
		int count = 1;
		panel.setLayout(new BorderLayout(0, 0));
		DefaultTableModel model = new DefaultTableModel(title, 0);
		JTable table = new JTable(model);
		ArrayList pay_list = new ArrayList(); // 결제 금액 관련 리스트 선언
		ArrayList proN_list = new ArrayList(); // 결제된 상품명
		ArrayList proO_list = new ArrayList(); // 결제된 상품 옵션명
		table.setRowHeight(40);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		table.setFillsViewportHeight(true);
		JTableHeader header = table.getTableHeader();
		header.setPreferredSize(new Dimension(100, HEADER_HEIGHT));
		panel.add(header, BorderLayout.NORTH);
		panel.add(table, BorderLayout.CENTER);
		panel.add(table);
		// 폰트, 크기 적용
		table.setFont(btn);
		// 스크롤 적용-많이 누르면 등장
		panel.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

		// 우측 하단 결제, 선택 취소 버튼 영역
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 8;
		panel_6.add(panel_2, gbc_panel_2);

		// 선택 삭제 버튼
		JButton del_btn = new JButton("선택 삭제");
		del_btn.setForeground(Color.WHITE);
		del_btn.setBackground(Color.DARK_GRAY);
		panel_2.add(del_btn);
		// 폰트, 크기 적용
		del_btn.setFont(btn);

		del_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 선택한 줄(row)의 번호 알아내기
				int rowIndex = table.getSelectedRow();

				// 선택 안하고 누를 경우 리턴값 -1
				if (rowIndex == -1) {
					return;
				}
				model.removeRow(rowIndex); // 해당 테이블 행 삭제
				table.getSelectedRow();

				// pay_list.remove(rowIndex); // 결제 금액 리스트에서도 삭제 실시
			}
		});

		// 총 금액 출력 영역
		JLabel totalprice = new JLabel("");
		panel_2.add(totalprice);
		// 폰트, 크기 적용
		totalprice.setFont(btn);

		// 장바구니 버튼
		JButton btnNewButton = new JButton("장바구니 담기");
		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.setForeground(Color.WHITE);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 4;
		panel_6.add(btnNewButton, gbc_btnNewButton);
		// 폰트, 크기 적용
		btnNewButton.setFont(btn);

		// 결제 영역
		JButton pay_btn = new JButton("결제하기");
		pay_btn.setBackground(new Color(0, 153, 255));
		pay_btn.setForeground(Color.WHITE);
		panel_2.add(pay_btn);
		pay_btn.setFont(btn);

		// String[] buy;
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getActionCommand().equals("장바구니 담기")) {

					JButton goCart = (JButton) e.getSource();
					DefaultTableModel m = (DefaultTableModel) table.getModel();
					if (hsize.getSelectedItem().toString().equals("소형견 용")) {
						m.addRow(new Object[] { hsize.getSelectedItem().toString(), count, productprice[0] });
					} else if (hsize.getSelectedItem().toString().equals("중형견 용 (+5000원)")) {
						m.addRow(new Object[] { hsize.getSelectedItem().toString(), count, productprice[1] });
					} else {
						m.addRow(new Object[] { hsize.getSelectedItem().toString(), count, productprice[2] });
					}

				

					int rowCont = table.getRowCount();
					int sum = 0;
					for (int i = 0; i < rowCont; i++) {
						sum += (int) table.getValueAt(i, 2);
					}
					totalprice.setText(String.valueOf("총 금액 : " + sum + "원"));

				} else if (e.getActionCommand().equals("결제하기")) { // 결제 버튼 클릭이벤트 처리
					int rowCont = table.getRowCount();
					int sum = 0;
					for (int i = 0; i < rowCont; i++) {
						sum += (int) table.getValueAt(i, 2);
					}
					totalprice.setText(String.valueOf("총 금액 : " + sum + "원"));

					/** TODO [질문 알림창] */
					if (rowCont > 0) { // 테이블에 내역 있을때에만 창 뜨도록
						int qut_data = JOptionPane.showConfirmDialog(getContentPane(), "주문을 결제하시겠습니까?", "주문 진행",
								JOptionPane.YES_NO_CANCEL_OPTION);
						if (qut_data == 0) { // [예] 버튼
							// 구매내역 관련-------------------------------------------------------
							String info[] = new String[3]; // 한행 (row) 에 저장할 데이터 모음
							info[0] = hsize.getSelectedItem().toString(); // 콤보박스 값을 가져온다
							info[1] = "1";
							if (hsize.getSelectedItem().toString().equals("소형견 용")) {
								info[2] = Integer.toString(p);
							} else if (hsize.getSelectedItem().toString().equals("중형견 용 (+5000원)")) {
								info[2] = Integer.toString(p1);
							} else {
								info[2] = Integer.toString(p2);
							}
							pay_list.add(ptitle + hsize.getSelectedItem().toString() + " => 수량 : " + count + ", 가격 : " + info[2]
									+ "원 / "); // 결제 금액 리스트에 추가
							proN_list.add(ptitle);
							proO_list.add(info[0]);
							System.out.println(pay_list.toString());
							String text = pay_list.toString();
							String fileN = "buy_list.txt";

							String text1 = proN_list.toString(); // 상품명 리스트
							String proN = "productName_list.txt";

							String text2 = proO_list.toString(); // 상품 옵션 리스트
							String proO = "productOption_list.txt";
							try {
								File file = new File(fileN); // 구매내역
								File file1 = new File(proN); // 구매한 상품명
								File file2 = new File(proO); // 구매한 상품 옵션
								if (!file.exists()) {
									file.createNewFile();
									file1.createNewFile();
									file2.createNewFile();
								}
								FileWriter fw1 = new FileWriter(file, true);
								FileWriter fw2 = new FileWriter(file1, true);
								FileWriter fw3 = new FileWriter(file2, true);
								fw1.write(text);
								fw1.write("\r\n");
								fw1.close();

								fw2.write(text1);
								fw2.write("\r\n");
								fw2.close();

								fw3.write(text2);
								fw3.write("\r\n");
								fw3.close();
							} catch (Exception e1) {
								e1.printStackTrace();
							}

							JOptionPane.showMessageDialog(getContentPane(),
									"정상적으로 결제되었습니다." + "\n" + "[결제금액]" + "\n" + sum + "원"
							/* +"\n"+"[주문내역]\n" + pay_list.toString(),---> 구매내역 뽑아내는 부분 */
							, "결제 완료", JOptionPane.INFORMATION_MESSAGE);

						} else if (qut_data == 1) { // [아니오] 버튼

						} else if (qut_data == 2) { // [취소] 버튼

						}

					} else { // 테이블에 값 없으면 뜨지 않도록

					}
				} else if (e.getActionCommand().equals("선택 삭제")) { // 삭제 버튼 클릭이벤트 처리
					// 선택한 줄(row)의 번호 알아내기
					int rowIndex = table.getSelectedRow();

					// 선택 안하고 누를 경우 리턴값 -1
					if (rowIndex == -1) {
						return;
					}
					model.removeRow(rowIndex); // 해당 테이블 행 삭제
					// pay_list.remove(rowIndex.getValueAt(i, 2)); //결제 금액 리스트에서도 삭제 실시
				}

			}

		};

		btnNewButton.addActionListener(action);
		del_btn.addActionListener(action);
		pay_btn.addActionListener(action);

		// 마우스 클릭 이벤트
		panel_2.addMouseListener(this);
		panel_5.addMouseListener(this);
		panel_7.addMouseListener(this);
		panel_6.addMouseListener(this);

		// panel 색상 적용
		panel_5.setBackground(new Color(160, 242, 196));
		panel_7.setBackground(new Color(160, 242, 196));
		panel_6.setBackground(new Color(160, 242, 196));
		panel_2.setBackground(new Color(160, 242, 196));

		// 크기 설정, 보이게, 크기 고정
		setSize(1350, 900);
		setVisible(true);
		setResizable(false);
	}

	// 마우스 이벤트
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// 눌렀을 때 이전 화면으로 전환
		if (e.getModifiers() == MouseEvent.BUTTON3_MASK) {
			System.out.println("[ -> 액세서리 카테고리]");
			new ProductList_Acc();
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

	ActionListener menuItemListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	};
}
