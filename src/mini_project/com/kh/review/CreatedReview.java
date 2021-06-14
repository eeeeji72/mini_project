package mini_project.com.kh.review;

import java.awt.BorderLayout;
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
import java.io.PrintWriter;

public class CreatedReview extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public CreateReview cr = new CreateReview();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			CreatedReview dialog = new CreatedReview();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public CreatedReview() {
		setBounds(100, 100, 1350, 600);
		contentPanel.setLayout(null);
		contentPanel.setBackground(new Color(160, 242, 196));
		getContentPane().add(contentPanel);
		
		//댕숲 아이콘
		ImageIcon img = new ImageIcon("img/allergy_dog.png");
		setIconImage(img.getImage());
		setTitle("댕숲");
		
		//리뷰 사진 라벨
		JLabel reviewPhotoLabel = new JLabel((Icon) null);
		reviewPhotoLabel.setBounds(14, 49, 434, 449);
		contentPanel.add(reviewPhotoLabel);
		
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
				ReviewDetails detailsDialog = new ReviewDetails();
				detailsDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				detailsDialog.setVisible(true);
			}
			
		});
		reviewTextPanel.add(btnNewButton);
		
		//엄지 이미지 최적화 작업
		ImageIcon img1 = new ImageIcon("img/good.png");
		Image LImg = img1.getImage();
		Image changeLImg = LImg.getScaledInstance(69, 70, Image.SCALE_SMOOTH); // 이미지 사이즈 최적화
		ImageIcon goodImg = new ImageIcon(changeLImg);
		
		//추천수 기입 라벨
		try {
			FileReader fr = new FileReader("goodCount.txt");
			BufferedReader bufReader = new BufferedReader(fr);
			String GCData = "";
			if ((GCData = bufReader.readLine()) != null) {
				JLabel goodCountLabel = new JLabel(GCData);
				goodCountLabel.setBounds(794, 22, 69, 63);
				goodCountLabel.setFont(new Font("NotoSansCJKr", Font.BOLD, 25));
				reviewTextPanel.add(goodCountLabel);
			}else if((GCData = bufReader.readLine()) == null) {
				JLabel goodCountLabel = new JLabel("0");
				goodCountLabel.setBounds(794, 22, 69, 63);
				goodCountLabel.setFont(new Font("NotoSansCJKr", Font.BOLD, 25));
				reviewTextPanel.add(goodCountLabel);
			}
			if(fr != null) fr.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//엄지 이미지 라벨
		JLabel goodLabel = new JLabel(goodImg);
		goodLabel.setBounds(711, 22, 69, 70);
		reviewTextPanel.add(goodLabel);
		
		// 리뷰 텍스트 담길 칸
		
//		JLabel productLabel = new JLabel("상품명 : ");
//		productLabel.setFont(new Font("NotoSansCJKr", Font.PLAIN, 20));
//		productLabel.setBounds(17, 32, 674, 40);
//		reviewTextPanel.add(productLabel);
//
//		JLabel optionLabel = new JLabel("선택옵션 : ");
//		optionLabel.setFont(new Font("NotoSansCJKr", Font.PLAIN, 20));
//		optionLabel.setBounds(17, 84, 629, 33);
//		reviewTextPanel.add(optionLabel);

		//별점 찍기
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
		
		//리뷰 텍스트
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
		
		//상품명
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
			if(fr3 != null) fr3.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//선택옵션
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
			if(fr4 != null) fr4.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		// 댓글 카운트 
		try {
			FileReader fr = new FileReader("coment.txt");
			BufferedReader bufReader = new BufferedReader(fr);
			int num = 0;
			for(int i = 1;  bufReader.readLine() != null; i++) {
				num = i;
			}
			JLabel comentCountLabel = new JLabel(num + "개의 댓글이 있습니다."); 
			comentCountLabel.setFont(new Font("NotoSansCJKr", Font.PLAIN, 20));
			comentCountLabel.setBounds(35, 407, 302, 33);
			reviewTextPanel.add(comentCountLabel);
			
			if(fr != null) fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}
}
