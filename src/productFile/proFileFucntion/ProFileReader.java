package productFile.proFileFucntion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import mini_project.com.kh.system_manager.vo.Product;

public class ProFileReader {
	
	BufferedReader reader;
	
	public Product fileToProduct(String fileName) {
		
		Product product = new Product();
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
			reader = new BufferedReader(new FileReader(file,Charset.forName("UTF-8")));
			
			product.setpCode(reader.readLine());
			product.setpBrand(reader.readLine());
			product.setpName(reader.readLine());
			product.setpPrice(reader.readLine());
			product.setpType(reader.readLine());
			product.setpInfo(reader.readLine());
			product.setpImage(reader.readLine());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return product;
		
	}
	
	/*public void fileModifier(File file) {
		
		String line = "";
		String content = "";
		
		int index = 0;
		String[] property = {};
		try {
			BufferedReader br = new BufferedReader(new FileReader(file.getName()));
			while((line = br.readLine()) != null) {
				content += line + "\n";
			}
			br.close();
			
			StringTokenizer stk = new StringTokenizer(content);
			
			while(stk.hasMoreTokens()) {
				property[index++]= stk.nextToken();
			}
			
			int iTarget = 0;
			JOptionPane.showInputDialog(iTarget,"어떤 내역을 수정하시겠습니까? \n 1. 상품 코드 | 2. 브랜드명 | 3. 상품명 | 4. 가격 " +
												"\n5. 상품 종류 | 6. 상품정보 | 7. 상품이미지");
			
			String mod = null;
			switch(iTarget) {
			
			case 1:
				JOptionPane.showInputDialog( mod,"수정 내역: 코드명 / 이전 내용 :" + property[iTarget]);
				property[iTarget] = mod;
				break;
			case 2:
				JOptionPane.showInputDialog( mod,"수정 내역: 브랜드 / 이전 내용 :" + property[iTarget]);
				property[iTarget] = mod;
				break;
			case 3:
				JOptionPane.showInputDialog( mod,"수정 내역: 상품명 / 이전 내용 :" + property[iTarget]);
				property[iTarget] = mod;
				break;
			case 4:
				JOptionPane.showInputDialog( mod,"수정 내역: 가격 / 이전 내용 :" + property[iTarget]);
				property[iTarget] = mod;
				break;
			case 5:
				JOptionPane.showInputDialog( mod,"수정 내역: 상품종류 / 이전 내용 :" + property[iTarget]);
				property[iTarget] = mod;
				break;
			case 6:
				JOptionPane.showInputDialog( mod,"수정 내역: 상품정보 / 이전 내용 :" + property[iTarget]);
				property[iTarget] = mod;
				break;
			case 7:
				JOptionPane.showInputDialog( mod,"수정 내역: 상품이미지 / 이전 내용 :" + property[iTarget]);
				property[iTarget] = mod;
				break;
				
			}
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			
			for( String s : property) {
				
				bw.write(s+"\n");
			}
			
			bw.flush();
			
			JOptionPane.showMessageDialog(null, "수정 완료!");
			bw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

}
