package productFile.proFileFucntion;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

import javax.swing.JOptionPane;

import mini_project.com.kh.system_manager.exceptions.OverLappedException;
import mini_project.com.kh.system_manager.vo.Product;
import mini_project.com.kh.system_manager.vo.User;

public class BuildFile {

	File dir;
	File[] files;

//	private static final String dirPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "productFile" + File.separator;

	public void fileBuilder(Product p) {

		File file = new File(p.getpCode() + ".txt");

		try {
			FileWriter fw = new FileWriter(file);

			fw.write(p.getpCode() + "\n");
			fw.write(p.getpBrand() + "\n");
			fw.write(p.getpName() + "\n");
			fw.write(p.getpPrice() + "\n");
			fw.write(p.getpType() + "\n");
			fw.write(p.getpInfo() + "\n");
			fw.write(p.getpImage() + "\n");

			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void userFileBuilder(User u) {

		File file = new File(u.getUserID() + ".txt");

		try {
			FileWriter fw = new FileWriter(file);

			fw.write(u.getName() + "\n");
			fw.write(u.getUserID() + "\n");
			fw.write(u.getUserPassword() + "\n");
			fw.write(u.getAddress() + "\n");
			fw.write(u.getPhone() + "\n");
			fw.write(u.getDogName() + "\n");

			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
