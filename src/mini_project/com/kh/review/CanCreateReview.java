package mini_project.com.kh.review;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;

public class CanCreateReview extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			CanCreateReview dialog = new CanCreateReview();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
	/**
	 * Create the dialog.
	 */
	public CanCreateReview() {
		setBounds(100, 100, 1000, 500);
		contentPanel.setLayout(null);
		contentPanel.setBackground(new Color(160, 242, 196));
		getContentPane().add(contentPanel);
				
//		//리뷰쓰기 버튼 
//		JButton creBtn = new JButton("리뷰쓰기");
//		creBtn.setForeground(Color.WHITE);
//		creBtn.setBackground(Color.DARK_GRAY);
//		creBtn.setFont(new Font("NotoSansCJKr", Font.PLAIN, 12));
//		creBtn.setBounds(38, 368, 89, 33);
//		creBtn.addMouseListener(new MouseAdapter() {
//			
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				super.mouseClicked(e);
//				CreateReview createDialog = new CreateReview();
//				createDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//				createDialog.setVisible(true);
//			}
//			
//		});
//		contentPanel.add(creBtn);

		// 댕숲 로고 
		ImageIcon img = new ImageIcon("img/allergy_dog.png");
		setIconImage(img.getImage());
		setTitle("댕숲");
		
		// 스크롤바 
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(963, 0, 19, 458);
		contentPanel.add(scrollPane);
		
		// 버튼 구현
		try {
			FileReader fr = new FileReader("productName_list.txt");
			BufferedReader br = new BufferedReader(fr);
			String productName = "";
			while ((productName = br.readLine()) != null) {
				// 버튼 1 구현
					JButton btnNewButton = new JButton("상품명 : " + productName);
					btnNewButton.setForeground(Color.WHITE);
					btnNewButton.setBackground(Color.DARK_GRAY);
					btnNewButton.setFont(new Font("NotoSansCJKr", Font.PLAIN, 20));
					btnNewButton.setBounds(199, 32, 568, 99);
					btnNewButton.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							// TODO Auto-generated method stub
							super.mouseClicked(e);
							CreateReview createDialog = new CreateReview();
							createDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							createDialog.setVisible(true);
						}
					});
					contentPanel.add(btnNewButton);

			}
			if(fr != null) fr.close();

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"작성할 수 있는 후기가 없습니다.", "", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
