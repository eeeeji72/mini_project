package mini_project.com.kh.system_manager.ip;

import java.util.List;

import mini_project.com.kh.system_manager.exceptions.ObjectNotFoundException;
import mini_project.com.kh.system_manager.exceptions.OverLappedException;
import mini_project.com.kh.system_manager.vo.Product;


public interface ProductInterface {
	

	public List<Product> search();
	
	public Product search(String pCode);
	
	public void loadProduct(String pFileName);
	
	public void addProdcut(Product product) throws OverLappedException;
	
	public void deleteProduct(String pCode) throws ObjectNotFoundException;
	
	public void saveProductFile(String pFileName);
	
	public void refresh(Product product) throws ObjectNotFoundException;
	
}
