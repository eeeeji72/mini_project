package mini_project.com.kh.review;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ReviewMain extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ReviewMain frame = new ReviewMain();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
	/**
	 * Create the frame.
	 */
	
	public ReviewMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(160, 242, 196));
		ImageIcon img = new ImageIcon("img/allergy_dog.png");
		setIconImage(img.getImage());
		setContentPane(contentPane);
		setTitle("댕숲");

		// 버튼 구현
		JButton canCreBtn = new JButton("작성 가능한 리뷰");
		canCreBtn.setFont(new Font("NotoSansCJKr", Font.BOLD, 20));
		canCreBtn.setForeground(Color.WHITE);
		canCreBtn.setBackground(new Color(0, 153, 255));
		canCreBtn.setBounds(152, 158, 252, 122);
		canCreBtn.addMouseListener(new MouseAdapter() {
			
			//작성 가능한 리뷰
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				CanCreateReview canCreDialog = new CanCreateReview();
				canCreDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				canCreDialog.setVisible(true);
			}
			
		});
		contentPane.add(canCreBtn);

		JButton createdBtn = new JButton("작성한 리뷰");
		createdBtn.setFont(new Font("NotoSansCJKr", Font.BOLD, 20));
		createdBtn.setForeground(Color.WHITE);
		createdBtn.setBackground(Color.DARK_GRAY);
		createdBtn.setBounds(553, 158, 252, 122);
		createdBtn.addActionListener(new ActionListener() {

			//작성한 리뷰 
			@Override
			public void actionPerformed(ActionEvent e) {
				CreatedList CLdialog = new CreatedList();
				CLdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				CLdialog.setVisible(true);

			}
		});
		contentPane.add(createdBtn);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
