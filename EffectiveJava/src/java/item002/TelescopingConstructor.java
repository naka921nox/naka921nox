package java.item002;

public class TelescopingConstructor {
	
	// 氏名：必須項目
	private String name = null;
	// 住所：任意項目
	private String address = null;
	// 電話番号
 	private String tel = null; 

 	public TelescopingConstructor(String name) {
 		this (name, null, null);
 	}
 	
 	public TelescopingConstructor(String name, String address) {
 		this (name, address, null);
 	}
 	
 	public TelescopingConstructor(String name, String address, String tel) {
 		this.name = name;
 		this.address = address;
 		this.tel = tel;
 	}
}
