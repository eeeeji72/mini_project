package mini_project.com.kh.review;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CreateReview extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	public String reviewText;
	public String starPoint;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			CreateReview dialog = new CreateReview();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public CreateReview() {

		setBounds(100, 100, 445, 705);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBackground(new Color(160, 242, 196));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		//별점 입력칸
		JTextField starPointField = new JTextField();
		starPointField.setBounds(54, 63, 313, 40);
		starPointField.setFont(new Font("NotoSansCJKr", Font.PLAIN, 12));
		contentPanel.add(starPointField);
		starPointField.setColumns(10);
		
		//후기 텍스트 입력칸 
		JTextField reviewTextField = new JTextField();
		reviewTextField.setColumns(10);
		reviewTextField.setBounds(54, 189, 313, 311);
		reviewTextField.setFont(new Font("NotoSansCJKr", Font.PLAIN, 12));
		contentPanel.add(reviewTextField);
		
		//라벨 텍스트 
		JLabel lblNewLabel = new JLabel("별점을 입력해주세요. (1~5 숫자 입력)");
		lblNewLabel.setBounds(54, 27, 326, 21);
		lblNewLabel.setFont(new Font("NotoSansCJKr", Font.PLAIN, 15));
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("리뷰를 작성해주세요.");
		lblNewLabel_1.setBounds(54, 153, 234, 21);
		lblNewLabel_1.setFont(new Font("NotoSansCJKr", Font.PLAIN, 15));
		contentPanel.add(lblNewLabel_1);
		
		//댕숲 로고 
		ImageIcon img = new ImageIcon("img/allergy_dog.png");
		setIconImage(img.getImage());
		setTitle("댕숲");
		
		// 취소버튼
		JButton cancelBtn = new JButton("취소");
		cancelBtn.setBackground(Color.DARK_GRAY);
		cancelBtn.setForeground(Color.WHITE);
		cancelBtn.setFont(new Font("Dialog", Font.PLAIN, 20));
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "취소되었습니다.", "", JOptionPane.PLAIN_MESSAGE);
				okButtonAction();
			}
		});
		cancelBtn.setBounds(54, 554, 121, 54);
		contentPanel.add(cancelBtn);

		// 등록버튼
		JButton insertReviewBtn = new JButton("등록");
		insertReviewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				starPoint = starPointField.getText();
				reviewText = reviewTextField.getText();
				
				if(starPoint.equals("1") || starPoint.equals("2") || starPoint.equals("3") || starPoint.equals("4") || starPoint.equals("5")) {
					JOptionPane.showMessageDialog(null,"리뷰가 등록되었습니다.", "", JOptionPane.PLAIN_MESSAGE);
					createSP();
					createRT();
					okButtonAction();
				}else {
					JOptionPane.showMessageDialog(null,"1~5까지의 숫자만 입력하세요.", "", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		insertReviewBtn.setForeground(Color.WHITE);
		insertReviewBtn.setBackground(new Color(0, 153, 255));
		insertReviewBtn.setFont(new Font("NotoSansCJKr", Font.PLAIN, 20));
		insertReviewBtn.setBounds(246, 554, 121, 54);
		contentPanel.add(insertReviewBtn);
		
		
	}

	// 별점, 리뷰텍스트 게터
	public String getStarPoint() {
		return starPoint;
	}

	public String getReviewText() {
		return reviewText;
	}
	
	public void setStarPoint(String star) {
		this.starPoint = star;
	}
	public void setReviewText(String view) {
		this.reviewText = view;
	}

	//JDialog 종료
	private void okButtonAction() {
		Window win = SwingUtilities.getWindowAncestor(this);
		if (win != null) {
			win.dispose();
		}
	}

	public void createSP() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("starPoint.txt");
			fw.write(getStarPoint());
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
	}
	
	public void createRT() {
		FileWriter fw = null;
		String Data = "";
		try {
			fw = new FileWriter("reviewText.txt");
			fw.write(getReviewText());
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

	}
}
