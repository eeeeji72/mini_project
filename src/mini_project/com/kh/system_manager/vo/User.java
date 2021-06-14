package mini_project.com.kh.system_manager.vo;

import java.io.File;
import java.util.ArrayList;

public class User {
	
	private String userID;
	private String name;
	private String userPassword;
	private String address;
	private String phone;
	private String dogName;
	
	ArrayList<String> userFile = new ArrayList<String>();
	
	public User() {
		
		userFile.add("황은지");
		userFile.add("김효은");
		userFile.add("강혜린");
		userFile.add("이세영");
		userFile.add("황진석");
		userFile.add("황구");
		
	}
	
	public User(String name,String userID, String userPassword, String address, String phone, String dogName) {
		super();
		this.name = name;
		this.userID = userID;
		this.userPassword = userPassword;
		this.address = address;
		this.phone = phone;
		this.dogName = dogName;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDogName() {
		return dogName;
	}
	public void setDogName(String dogName) {
		this.dogName = dogName;
	}
	
	public ArrayList<String> getUserFile() {
		return userFile;
	}

	public void setUserFile(ArrayList<String> userFile) {
		this.userFile = userFile;
	}
	
	public void addUserFile(String str) {
		userFile.add(str);
	}
	
	public void deleteUserFile(String str) {
		for(String s : userFile) {
			if(s.equals(str)) {
				userFile.remove(s);
			}
		}
	}
	
	public boolean checkDuplication(String userName) {
		
		boolean isDuplicated = false;
		
		File file = new File(".");
		File[] dir = file.listFiles();
		
		for(File f : dir) {
			System.out.println(f.getName());
			if (f.getName().equals(userName+".txt")) {
				isDuplicated = true;
			}
		}
		
		return isDuplicated;
	}

	@Override
	public String toString() {
		StringBuilder information = new StringBuilder();
		
		information.append("이름:" + name + "\s");
		information.append("/ 아이디 : " + userID + "\s");
		information.append("/ 비밀번호 : " + userPassword + "\s");
		information.append("/ 주소 : " + address + "\s");
		information.append("/ 연락처 : " + phone + "\s");
		information.append("/ 반려견 이름 : " + dogName);
		
		return information.toString();
	}
	
}