package mini_project.com.kh.system_manager.exceptions;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class OverLappedException extends Exception{

	public void popUpException() {
		
		JOptionPane.showMessageDialog(null, "ERROR! 중복된 데이터가 존재합니다!.");
		
	}

	@Override
	public String toString() {
		
		
		return super.toString() + "ERROR! 중복된 데이터가 존재합니다! ";
	}
	
	
	
}
