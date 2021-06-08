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
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import mini_project.com.kh.product.ProductMain;

public class Cart extends JFrame implements MouseListener, ActionListener{
	private JTable table;	//table
	private static int HEADER_HEIGHT = 40;	//table header 높이
	//Etc_DogHouse edh;
	public Cart() {
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

		//장바구니 글자
		JLabel lblNewLabel = new JLabel("< 장바구니 >");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		//table 담긴 panel
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
		
		//table
        String [] title = {"상품명","수량", "가격"};	//header
        DefaultTableModel model = new DefaultTableModel(title, 0);
        JTable table = new JTable(model);
		table.setRowHeight(50);
		ArrayList pay_list = new ArrayList(); //결제 금액 관련 리스트 선언
		panel_1.add(table);
		table.setPreferredScrollableViewportSize(new Dimension(500,50));
		table.setFillsViewportHeight(true);
		JTableHeader header = table.getTableHeader();
		header.setPreferredSize(new Dimension(100, HEADER_HEIGHT));
		panel_1.add(header, BorderLayout.NORTH);
		panel_1.add(table, BorderLayout.CENTER);		
		
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
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(btnNewButton_2, BorderLayout.WEST);
		
		//합계 가격 호출
		String str = "총 합계 : ";
		JLabel lblNewLabel_1 = new JLabel(str, SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1, BorderLayout.CENTER);
		Font usef = new Font("궁서", Font.PLAIN, 20);
		lblNewLabel_1.setFont(usef);
		
		// 결제하기 버튼
		JButton btnNewButton_3 = new JButton("결제하기");
		btnNewButton_3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(btnNewButton_3, BorderLayout.EAST);

		//우측 마우스 클릭 시 상품 홈으로
		panel.addMouseListener(this);
		table.addMouseListener(this);
		
		panel.setBackground(new Color(160, 242, 196));
		panel_2.setBackground(new Color(160, 242, 196));
		setSize(1350, 900);
		setVisible(true);
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

}
