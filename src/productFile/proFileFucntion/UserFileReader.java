package productFile.proFileFucntion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

import mini_project.com.kh.system_manager.vo.User;

public class UserFileReader {
	
	BufferedReader reader;
	
	public User fileToUser(String fileName) {
		
		User user = new User();
		String file = fileName;
		
		boolean isTxt = true;
		for (int i = 0 ; i < fileName.length(); i++) {
			if((file.charAt(i))=='.') {
				break;
			}else {
				isTxt = false;
			}
		}
		
		if (!isTxt) {
			file += ".txt";
		}
		
		try {
			reader = new BufferedReader(new FileReader(file));
			
			user.setName(reader.readLine());
			user.setUserID(reader.readLine());
			user.setUserPassword(reader.readLine());
			user.setAddress(reader.readLine());
			user.setPhone(reader.readLine());
			user.setDogName(reader.readLine());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return user;
		
	}
	

}
