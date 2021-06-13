package mini_project.com.kh.review;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ProductPageReview extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public String goodCount = "0"; // 추천수 
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			ProductPageReview proReviewdialog = new ProductPageReview();
//			proReviewdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			proReviewdialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public ProductPageReview() {
		RunProductPageReview();
	}
	
	public void RunProductPageReview() {
		
		setBounds(100, 100, 1350, 600);
		contentPanel.setLayout(null);
		contentPanel.setBackground(new Color(160, 242, 196));
		getContentPane().add(contentPanel);
		
		//댕숲 아이콘
		ImageIcon img = new ImageIcon("img/allergy_dog.png");
		setIconImage(img.getImage());
		setTitle("댕숲");
		
		//리뷰 사진 라벨
		JLabel lblNewLabel = new JLabel((Icon) null);
		lblNewLabel.setBounds(14, 49, 434, 449);
		contentPanel.add(lblNewLabel);
		
		//리뷰 텍스트 패널
		JPanel reviewTextPanel = new JPanel();
		reviewTextPanel.setLayout(null);
		reviewTextPanel.setBounds(462, 37, 838, 471);
		contentPanel.add(reviewTextPanel);
		
		//더보기 버튼
		JButton btnNewButton = new JButton("더보기");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("NotoSansCJKr", Font.PLAIN, 15));
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(699, 399, 114, 53);
		btnNewButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				ProductPageReviewComent dialog = new ProductPageReviewComent();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
			
		});
		reviewTextPanel.add(btnNewButton);

		setAlwaysOnTop(true); // 항상 위에
		//엄지 이미지 최적화 작업
		ImageIcon img1 = new ImageIcon("img/good.png");
		Image LImg = img1.getImage();
		Image changeLImg = LImg.getScaledInstance(69, 70, Image.SCALE_SMOOTH); // 이미지 사이즈 최적화
		ImageIcon goodImg = new ImageIcon(changeLImg);
		
		//추천수 기입 라벨
		JLabel goodCountLabel = new JLabel(goodCount);
		goodCountLabel.setBounds(794, 22, 69, 63);
		goodCountLabel.setFont(new Font("NotoSansCJKr", Font.BOLD, 25));
		reviewTextPanel.add(goodCountLabel);
		
		// 엄지 이미지 라벨
		JLabel goodLabel = new JLabel(goodImg);
		goodLabel.setBounds(711, 22, 69, 70);
		goodLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) { // 누르면 추천수 +1
				// TODO Auto-generated method stub
				super.mouseClicked(arg0);
				switch (goodCount) {
				case "0":
					goodCountLabel.setText("1");
					goodCount = "1";
					
					FileWriter fw = null;

					try {
						fw = new FileWriter("goodCount.txt");
						fw.write(goodCount);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						try {
							if (fw != null)
								fw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					break;
				}
			}
		});
		reviewTextPanel.add(goodLabel);
		
		// 리뷰 텍스트 담길 칸
		try {
			FileReader fr1 = new FileReader("starPoint.txt");
			BufferedReader bufReader = new BufferedReader(fr1);
			String SPData = "";
			while ((SPData = bufReader.readLine()) != null) {
				switch(SPData) {
				case "1":
					SPData = "★";
					break;
				case "2":
					SPData = "★★";
					break;
				case "3":
					SPData = "★★★";
					break;
				case "4":
					SPData = "★★★★";
					break;
				case "5":
					SPData = "★★★★★";
					break;
				}
				JLabel starPointLabel = new JLabel("별점 : " + SPData);
				starPointLabel.setFont(new Font("NotoSansCJKr", Font.PLAIN, 20));
				starPointLabel.setBounds(17, 139, 471, 33);
				reviewTextPanel.add(starPointLabel);
			}
			if(fr1 != null) fr1.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			FileReader fr2 = new FileReader("reviewText.txt");
			BufferedReader bufReader = new BufferedReader(fr2);
			String RTData = "";
			while ((RTData = bufReader.readLine()) != null) {
				JTextField reviewTextLabel = new JTextField("구매평 : " + RTData);
				reviewTextLabel.setFont(new Font("NotoSansCJKr", Font.PLAIN, 20));
				reviewTextLabel.setBounds(17, 196, 788, 173);
				reviewTextLabel.setEditable(false);
				reviewTextPanel.add(reviewTextLabel);				
			}
			if(fr2 != null) fr2.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		// 상품명
		try {
			FileReader fr3 = new FileReader("productName_list.txt");
			BufferedReader bufReader = new BufferedReader(fr3);
			String productName = "";
			while ((productName = bufReader.readLine()) != null) {
				JLabel productLabel = new JLabel("상품명 : " + productName);
				productLabel.setFont(new Font("NotoSansCJKr", Font.PLAIN, 20));
				productLabel.setBounds(17, 32, 674, 40);
				reviewTextPanel.add(productLabel);
			}
			if (fr3 != null)
				fr3.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 선택옵션
		try {
			FileReader fr4 = new FileReader("productOption_list.txt");
			BufferedReader bufReader = new BufferedReader(fr4);
			String productOption = "";
			while ((productOption = bufReader.readLine()) != null) {
				JLabel optionLabel = new JLabel("선택옵션 : " + productOption);
				optionLabel.setFont(new Font("NotoSansCJKr", Font.PLAIN, 20));
				optionLabel.setBounds(17, 84, 629, 33);
				reviewTextPanel.add(optionLabel);
			}
			if (fr4 != null)
				fr4.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
