package mini_project.com.kh.system_manager.exceptions;

@SuppressWarnings("serial")
public class ObjectNotFoundException extends Exception{

	@Override
	public String toString() {
		return super.toString() + "해당되는 객체가 없습니다.";
	}

	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
	}

	
}
