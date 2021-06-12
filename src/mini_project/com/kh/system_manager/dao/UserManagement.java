package mini_project.com.kh.system_manager.dao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import mini_project.com.kh.system_manager.exceptions.ObjectNotFoundException;
import mini_project.com.kh.system_manager.exceptions.OverLappedException;
import mini_project.com.kh.system_manager.vo.Product;
import mini_project.com.kh.system_manager.vo.User;
import productFile.proFileFucntion.BuildFile;
import productFile.proFileFucntion.ProFileReader;
import productFile.proFileFucntion.UserFileReader;

@SuppressWarnings("serial")
public class UserManagement extends JFrame implements ActionListener {

	BuildFile buildFile;
	
	User use = new User();
	ArrayList<String> uFiles = new User().getUserFile();
	private JFrame frame;
	private JList useJList;
	private DefaultListModel model;

	private String[] labelTitels = { "아이디", "이름", "비밀번호", "주소", "연락처", "반려견이름"};


	private JButton btnAdd, btnDelete, btnSearch, btnModify;
	private JTextField txtName, txtID,txtPassword, txtAddress, txtPhone, txtDogName;

	private JLabel[] labels = new JLabel[labelTitels.length];

	public UserManagement() {

		frame = new JFrame("유저 관리 창");

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image icon = toolkit.getImage("img/d.png");
		frame.setIconImage(icon);

		printList();

		JPanel mainPanel = new JPanel();

		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(new GridLayout(6, 1));

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 4));

		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(labels.length, 1));

		for (int k = 0; k < labels.length; k++) {
			labels[k] = new JLabel(labelTitels[k]);
			labels[k].setHorizontalAlignment(SwingConstants.CENTER);
			labelPanel.add(labels[k]);
		}

		btnAdd = new JButton("추가");
		btnDelete = new JButton("삭제");
		btnSearch = new JButton("검색");
		btnModify = new JButton("수정");

		buttonPanel.add(btnAdd);
		buttonPanel.add(btnDelete);
		buttonPanel.add(btnSearch);
		buttonPanel.add(btnModify);

		txtName = new JTextField("");
		txtID = new JTextField("");
		txtPassword = new JTextField("");
		txtAddress = new JTextField("");
		txtPhone = new JTextField("");
		txtDogName = new JTextField("");

		fieldPanel.add(txtName);
		fieldPanel.add(txtID);
		fieldPanel.add(txtPassword);
		fieldPanel.add(txtAddress);
		fieldPanel.add(txtPhone);
		fieldPanel.add(txtDogName);

		resetField();

		JPanel imgPanel = new JPanel();

		imgPanel.setLayout(new BorderLayout());
		imgPanel.add(txtDogName, BorderLayout.CENTER);
		fieldPanel.add(imgPanel);

		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(labelPanel, BorderLayout.WEST);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		mainPanel.add(fieldPanel, BorderLayout.CENTER);

		JLabel listLabel = new JLabel("");
		listLabel.setBackground(new Color(100, 100, 100));
		listLabel.setForeground(new Color(50, 50, 50));

		JScrollPane total_List_Scroll = new JScrollPane();
		total_List_Scroll.setViewportView(useJList);
		JPanel listScreen = new JPanel();
		clickEvent();
		listScreen.setLayout(new BorderLayout());
		listScreen.add(listLabel, BorderLayout.NORTH);
		listScreen.add(total_List_Scroll);

		frame.setPreferredSize(new Dimension(600, 400));
		JPanel container = new JPanel();

		container.setLayout(new BorderLayout());

		container.setSize(frame.getPreferredSize());
		container.add(mainPanel, BorderLayout.SOUTH);
		container.add(listScreen);
		container.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		container.setBackground(new Color(160, 242, 196));
		printList();
		frame.add(container, BorderLayout.CENTER);

		frame.setVisible(true);
		frame.setSize(1200, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBackground(new Color(160, 242, 196));

	}


	public void clickEvent() {

		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);
		btnSearch.addActionListener(this);
		btnModify.addActionListener(this);

		useJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object action = e.getSource();

		if (action == btnAdd) {
			try {
				addUser();
			} catch (OverLappedException e2) {
				e2.printStackTrace();
			}
		} else if (action == btnDelete) {
			try {
				deleteUser();
			} catch (ObjectNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (action == btnSearch) {
			try {
				searchUser();
			} catch (ObjectNotFoundException e1) {
				e1.printStackTrace();
			}
		} else if (action == btnModify) {
			modifyFile();
		} else {
			System.out.println("실패");
		}

	}
	
	private void addUser() throws OverLappedException {

		String name = txtName.getText().trim();
		String id = txtID.getText().trim();
		String password = txtPassword.getText().trim();
		String address = txtAddress.getText().trim();
		String phone = txtPhone.getText().trim();
		String dog = txtDogName.getText().trim();

		User user = new User(name, id, password,address, phone ,dog);

		buildFile = new BuildFile();
		buildFile.userFileBuilder(user);

		user.addUserFile(name);
		JOptionPane.showInternalMessageDialog(null, "성공적으로 상품을 추가 했습니다!");
		
		resetField();
		printList();
	}

	private void searchUser() throws ObjectNotFoundException {

		String targetName = txtName.getText().toString();

		boolean hasFound = true;

		for (String s : uFiles) {
			if (s.equals(targetName)) {
				hasFound = true;
				break;
			}
			hasFound = false;
		}

		if (hasFound) {

			UserFileReader pfr = new UserFileReader();
			User u = pfr.fileToUser(targetName);

			JOptionPane.showMessageDialog(null, "찾았습니다!");

			loadUserToTextField(u);

		} else {
			JOptionPane.showMessageDialog(null, "찾지 못했습니다.");
		}

	}

	private void deleteUser() throws ObjectNotFoundException {

		String targetName = txtName.getText();

		boolean hasFound = true;

		for (String s : uFiles) {
			if (s.equals(targetName)) {
				use.deleteUserFile(targetName);
				hasFound = true;
				break;
			}
			hasFound = false;
		}

		if (hasFound) {
			
			File file = new File(targetName+".txt"); 
			file.delete();
			
			if(!file.exists()) {
				JOptionPane.showMessageDialog(null, "삭제됐습니다!");
			}

		} else {
			JOptionPane.showMessageDialog(null, "찾지 못했습니다.");
		}
		

	}

	private void resetField() {

		txtID.setText("");
		txtName.setText("");
		txtPassword.setText("");
		txtAddress.setText("");
		txtPhone.setText("");
		txtDogName.setText("");

	}

	private void modifyFile() {

		
		String name = txtName.getText().trim();
		String id = txtID.getText().trim();
		String password = txtPassword.getText().trim();
		String address = txtAddress.getText().trim();
		String phone = txtPhone.getText().trim();
		String dog = txtDogName.getText().trim();

		User us = new User( name, id , password, address , phone ,dog);
		
		BuildFile bf = new BuildFile();
		bf.userFileBuilder(us);
		
		JOptionPane.showMessageDialog(null, "반영됐습니다.");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void printList() {


		useJList = new JList(new DefaultListModel());

		model = (DefaultListModel) useJList.getModel();

		User[] uses = new User[uFiles.size()];


		for (int i = 0; i < uFiles.size(); i++) {
			uses[i] = new UserFileReader().fileToUser(uFiles.get(i));
			model.add(i, uses[i]);
		}
		
		useJList = new JList(model);

	}

	private void loadUserToTextField(User u) {
		
		txtName.setText(u.getName());
		txtID.setText(u.getUserID());
		txtPassword.setText(u.getUserPassword());
		txtAddress.setText(u.getAddress());
		txtPhone.setText(u.getPhone());
		txtDogName.setText(u.getDogName());

	}

}
