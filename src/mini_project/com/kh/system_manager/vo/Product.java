package mini_project.com.kh.system_manager.vo;

import java.util.ArrayList;

public class Product {
	
	private String pCode; // 상품 식별코드
	private String pBrand; // 상품 브랜드명
	private String pName; // 상품명
	private String pPrice; // 상품 가격
	private String pType; // 상품 종류
	private String pInfo; // 상품 정보
	private String pImage; //
	
	private ArrayList<String> productFile = new ArrayList<String>();
	
	
	public Product() {
		
		productFile.add("PA0000");
		productFile.add("PA0121");
		productFile.add("PB0129");
		productFile.add("PB0173");
		productFile.add("PC1000");
		productFile.add("PC2001");
		productFile.add("PD2131");
		productFile.add("PD5706");
		productFile.add("PE7110");
		productFile.add("PE8890");
	}
	
	public Product(String pCode,String pBrand, String pName, String pPrice, String pType, String pInfo, String pImage) {
		super();
		this.pCode = pCode;
		this.pBrand = pBrand;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pType = pType;
		this.pInfo = pInfo;
		this.pImage = pImage;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getpBrand() {
		return pBrand;
	}
	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpPrice() {
		return pPrice;
	}
	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}
	public String getpType() {
		return pType;
	}
	public void setpType(String pType) {
		this.pType = pType;
	}
	
	public String getpInfo() {
		return pInfo;
	}

	public void setpInfo(String pIntro) {
		this.pInfo = pIntro;
	}
	
	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	
	

	public ArrayList<String> getProductFile() {
		return productFile;
	}

	public void setProductFile(ArrayList<String> pFiles) {
		this.productFile = pFiles;
	}
	
	public void addProductFile(String str) {
		productFile.add(str);
	}
	public void deleteProductFIle(String str) {
		
		for(String s : productFile) {
			if(s.equals(str)) {
				productFile.remove(s);
			}
		}
	}

	@Override
	public String toString() {
		
		StringBuilder info = new StringBuilder();
		
		info.append(pCode+"\s");
		info.append(pBrand+"\s");
		info.append(pName+"\s");
		info.append(pPrice+"\s");
		info.append(pType+"\s");
		info.append(pInfo+"\s");
		info.append(pImage+"\s");
		
		return info.toString();
	}
	
	
}
