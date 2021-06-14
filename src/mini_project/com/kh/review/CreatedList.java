package mini_project.com.kh.review;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class CreatedList extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			CreatedList dialog = new CreatedList();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public CreatedList() {
		setBounds(100, 100, 1000, 500);
		contentPanel.setLayout(null);
		contentPanel.setBackground(new Color(160, 242, 196));
		getContentPane().add(contentPanel);
		
//		//리뷰쓰기 버튼 
//		JButton creBtn = new JButton("작성한 리뷰");
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
//				CreatedReview CRdialog = new CreatedReview();
//				CRdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//				CRdialog.setVisible(true);
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
		
		try {
			FileReader fr = new FileReader("productName_list.txt");
			BufferedReader br = new BufferedReader(fr);
			String productName = "";
			while ((productName = br.readLine()) != null) {
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
							CreatedReview dialog = new CreatedReview();
							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialog.setVisible(true);
						}
					});
					contentPanel.add(btnNewButton);
			}if(fr != null) fr.close();

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"작성할 수 있는 후기가 없습니다.", "", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
	public void loadProduct() {
		try {
			FileReader fr = new FileReader("PA0000.txt");
			BufferedReader bufReader = new BufferedReader(fr);
			String productName = "";
			String productExp = "";
			for(int i = 1;  bufReader.readLine() != null; i++) {
				if(i == 3) {
					productName = bufReader.readLine();
				}
				if(i == 6) {
					productExp = bufReader.readLine();
				}
			}
			System.out.println( productName + productExp);
			if(fr != null) fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
