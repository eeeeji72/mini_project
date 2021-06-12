package mini_project.com.kh.system_manager.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import mini_project.com.kh.product.ProductMain;
import mini_project.com.kh.system_manager.dao.ProductManagement;

import javax.swing.JLabel;
import javax.swing.JMenu;

public class Manager_MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;

	// 메뉴의 제목을 담아두는 String 타입 배열
	final String[] menuTitle = { "HOME", "CUSTOMER", "PRODUCT", "BOARD", "SERVICE" };

	// 메뉴객체를 저장하고 관리하기 위한 JMenuItem 타입의 객체배열
	JMenuItem[] items = new JMenuItem[menuTitle.length]; // items 객체 배열의 크기는 menuTitle 의 길이와 동일하게 설정

	// JFrame 생성
	JFrame frame = null;

	// ManagerMenu 생성자
	public Manager_MainMenu() {

		frame = new JFrame();
		// 프레임 아이콘 이미지 설정
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image icon = toolkit.getImage("img/d.png");
		frame.setIconImage(icon);

		// 프레임 타이틀 설정
		frame.setTitle("관리자 메뉴");
		// 프레임 크기 설정
		frame.setSize(1350,900);
		// 배경화면 색상 설정
		frame.setBackground(new Color(160, 242, 196));
		// 가시 상태 설정
		frame.setVisible(true);

		// 라벨 생성 및 이미지 적용
		ImageIcon image = new ImageIcon("img/d.png");
		JLabel label = new JLabel(image);

		// 보더레이아웃 중앙에 부착
		frame.getContentPane().add(label, BorderLayout.CENTER);

		// 메뉴 설정 실행
		setMenu();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);

	}

	// 메뉴 설정
	void setMenu() {

		// 메뉴를 담을 JMenuBar 객체 생성
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		// menu를 해당 프레임의 메뉴바로 설정

		// 보조 클래스 listener
		MenuListener listener = new MenuListener();

		// JMenuItemm 타입의 객체배열 items 의 길이 만큼 반복하는 for 반복문
		for (int i = 0; i < items.length; i++) {
			// items 의 'i 번째 인덱스'에 'menuTitle 의 i 번째 인덱스에 있는 문자열을 이름을 갖는' JemnuItem 을 담음
			items[i] = new JMenuItem(menuTitle[i]);
			// items 의 'i 번째 인덱스'에 담긴 메뉴 객체의 액션 리스너를 listener 로 등록
			items[i].addActionListener(listener);
			// items 의 'i 번째 인덱스'에 담긴 메뉴 객체를 menu에 더함
			menu.add(items[i]);
		}
		// for 반복문 종료

		// 메뉴바에 메뉴를 등록
		menuBar.add(menu);

		// 메뉴바를 프레임에 더함
		frame.setJMenuBar(menuBar);

	}

	// 버튼을 누른 이벤트가 발생하였을때 작동할 액션리스너 인터페이스의 추상 메소드

	class MenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// 액션 발생시킨 객체 e 로부터 어떤 액션이 발생했는지를 String 형 type 에 저장
			String type = e.getActionCommand();

			// switch case 시작
			switch (type) {

			case "HOME":
				return;
			case "CUSTOMER":
				new selectWindow();
				break;
			case "PRODUCT":
			    ProductManagement pm = new ProductManagement();
			    pm.clickEvent();
				break;
			case "BOARD":
//				new borad();
				break;
			case "SERIVCE":
//				new Manager_ServiceMenu();
				break;
			default:
				if (type == null || type.equals("")) {
					JOptionPane.showMessageDialog(null, "정상적으로 작동이 아닙니다!.");
					return;
				} else {
					break;
				}

			}
			// switch case 종료

		}
	}

}

class selectWindow extends JFrame implements ActionListener,WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	JLabel label = null;
	JButton bUService , bUManagement;
	
	selectWindow() {
		setTitle("실행할 기능 선택");
		setBackground(new Color(160, 242, 196));
		bUService = new JButton("userService");
		bUManagement = new JButton("userManagement");
		bUService.setSize(100,100);
		bUManagement.setSize(100,100);
		
		bUService.setHorizontalAlignment(SwingConstants.CENTER);
		bUManagement.setHorizontalAlignment(SwingConstants.CENTER);
		bUService.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductMain();
				dispose();
			}
		});
		
		bUManagement.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				new Manager_UserManagerMent();
				dispose();
			}});
		
		add(bUService,BorderLayout.CENTER);
		add(bUManagement,BorderLayout.EAST);
		setSize(300,200);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	


}