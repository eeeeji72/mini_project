package mini_project.com.kh.system_manager.manager;

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
import productFile.proFileFucntion.BuildFile;
import productFile.proFileFucntion.ProFileReader;

@SuppressWarnings("serial")
public class ProductManagement extends JFrame implements ActionListener {

	BuildFile buildFile;
	
	Product pro = new Product();
	ArrayList<String> pFiles = new Product().getProductFile();
	private JButton setPic = null;
	private JFrame frame;
	private JList proJList;
	private DefaultListModel model;

	private String[] labelTitels = { "상품식별코드", "브랜드", "이름", "가격", "종류", "정보", "이미지" };

	private Image productImg = null;

	private JButton btnAdd, btnDelete, btnSearch, btnModify;
	private JTextField txtCode, txtBrand, txtName, txtPrice, txtType, txtInfo, txtImage;

	private JLabel[] labels = new JLabel[labelTitels.length];

	public ProductManagement() {


		frame = new JFrame("상품 관리 창");

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image icon = toolkit.getImage("img/d.png");
		frame.setIconImage(icon);

		printList();

		JPanel mainPanel = new JPanel();

		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(new GridLayout(7, 1));

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

		txtCode = new JTextField("제품코드");
		txtBrand = new JTextField("브랜드");
		txtName = new JTextField("제품명");
		txtPrice = new JTextField("가격");
		txtType = new JTextField("종류");
		txtInfo = new JTextField("정보");
		txtImage = new JTextField("이미지");

		fieldPanel.add(txtCode);
		fieldPanel.add(txtBrand);
		fieldPanel.add(txtName);
		fieldPanel.add(txtPrice);
		fieldPanel.add(txtType);
		fieldPanel.add(txtInfo);
		fieldPanel.add(txtImage);

		resetField();

		JPanel imgPanel = new JPanel();

		/*
		 * setPic = new JButton("사진 설정");
		 * 
		 * setPic.addActionListener(e -> {
		 * 
		 * JFileChooser jfc = new JFileChooser();
		 * 
		 * jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		 * 
		 * jfc.showDialog(this, null);
		 * 
		 * File file = jfc.getSelectedFile(); String fileName = file.getName(); String
		 * fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1); if
		 * (fileExtension.equals("jpg") || fileExtension.equals("png") ||
		 * fileExtension.equals("bpm")) { imgPathTxt.setText(file == null ? "" :
		 * file.getPath()); } else { JOptionPane.showMessageDialog(null,
		 * "정상적인 작동이 아닙니다!"); } });
		 */

		imgPanel.setLayout(new BorderLayout());
		imgPanel.add(txtImage, BorderLayout.CENTER);
//		imgPanel.add(setPic, BorderLayout.EAST);
		fieldPanel.add(imgPanel);

		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(labelPanel, BorderLayout.WEST);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		mainPanel.add(fieldPanel, BorderLayout.CENTER);

		JLabel listLabel = new JLabel("");
		listLabel.setBackground(new Color(100, 100, 100));
		listLabel.setForeground(new Color(50, 50, 50));

		JScrollPane total_List_Scroll = new JScrollPane();
		total_List_Scroll.setViewportView(proJList);
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

	private void addProduct() throws OverLappedException {

		String code = txtCode.getText().trim();
		String brand = txtBrand.getText().trim();
		String name = txtName.getText().trim();
		String price = txtPrice.getText().trim();
		String type = txtType.getText().trim();
		String info = txtInfo.getText().trim();
		String image = txtImage.getText().trim();

		Product pro = new Product(code, brand, name, price, type, info, image);

		buildFile = new BuildFile();
		buildFile.fileBuilder(pro);

		pro.addProductFile(code);
		JOptionPane.showInternalMessageDialog(null, "성공적으로 상품을 추가 했습니다!");
		
		resetField();
		printList();
	}

	public void clickEvent() {

		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);
		btnSearch.addActionListener(this);
		btnModify.addActionListener(this);

		proJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object action = e.getSource();

		if (action == btnAdd) {
			try {
				addProduct();
			} catch (OverLappedException e2) {
				e2.printStackTrace();
			}
		} else if (action == btnDelete) {
			try {
				deleteProduct();
			} catch (ObjectNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (action == btnSearch) {
			try {
				searchProduct();
			} catch (ObjectNotFoundException e1) {
				e1.printStackTrace();
			}
		} else if (action == btnModify) {
			modifyFile();
		} else {
			System.out.println("실패");
		}

	}

	private void searchProduct() throws ObjectNotFoundException {

		String targetCode = txtCode.getText().toString();

		boolean hasFound = true;

		for (String s : pFiles) {
			if (s.equals(targetCode)) {
				hasFound = true;
				break;
			}
			hasFound = false;
		}

		if (hasFound) {

			ProFileReader pfr = new ProFileReader();
			Product p = pfr.fileToProduct(targetCode);

			JOptionPane.showMessageDialog(null, "찾았습니다!");

			loadProToTextField(p);

		} else {
			JOptionPane.showMessageDialog(null, "찾지 못했습니다.");
		}

	}

	private void deleteProduct() throws ObjectNotFoundException {

		String targetCode = txtCode.getText();

		boolean hasFound = true;

		for (String s : pFiles) {
			if (s.equals(targetCode)) {
				pro.deleteProductFIle(s);
				hasFound = true;
				break;
			}
			hasFound = false;
		}

		if (hasFound) {
			
			File file = new File(targetCode+".txt"); 
			file.delete();
			
			if(!file.exists()) {
				JOptionPane.showMessageDialog(null, "삭제됐습니다!");
			}

		} else {
			JOptionPane.showMessageDialog(null, "찾지 못했습니다.");
		}
		

	}

	private void resetField() {

		txtCode.setText("");
		txtBrand.setText("");
		txtName.setText("");
		txtPrice.setText("");
		txtType.setText("");
		txtInfo.setText("");
		txtImage.setText("");

	}

	private void modifyFile() {

		
		String code = txtCode.getText().trim();
		String brand = txtBrand.getText().trim();
		String name = txtName.getText().trim();
		String price = txtPrice.getText().trim();
		String type = txtType.getText().trim();
		String info = txtInfo.getText().trim();
		String image = txtImage.getText().trim();

		Product pro = new Product(code, brand, name, price, type, info, image);
		
		BuildFile bf = new BuildFile();
		bf.fileBuilder(pro);
		
		JOptionPane.showMessageDialog(null, "반영됐습니다.");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void printList() {


		proJList = new JList(new DefaultListModel());

		model = (DefaultListModel) proJList.getModel();

		Product[] pros = new Product[pFiles.size()];

		File pf;

		for (int i = 0; i < pFiles.size(); i++) {
//			pf = new File(pFiles.get(i)+".txt");
			pros[i] = new ProFileReader().fileToProduct(pFiles.get(i));
			model.add(i, pros[i]);
		}
		/*
		 * int iCount = 0; for( Product p : pros) { model.add(iCount++, p); }
		 */
		proJList = new JList(model);

	}

	private void loadProToTextField(Product p) {

		txtCode.setText(p.getpCode());
		txtBrand.setText(p.getpBrand());
		txtName.setText(p.getpName());
		txtPrice.setText(p.getpPrice());
		txtType.setText(p.getpType());
		txtInfo.setText(p.getpInfo());
		txtImage.setText(p.getpImage());

	}

}
