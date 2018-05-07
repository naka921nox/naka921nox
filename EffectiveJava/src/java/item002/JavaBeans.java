package java.item002;

public class JavaBeans {

	// 氏名：必須項目
	private String name = null;
	// 住所：任意項目
	private String address = null;
	// 電話番号
	private String tel = null;
	
	// 以下アクセサ
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	// コンストラクタ
	public JavaBeans() {
	}
}
