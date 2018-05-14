package java.item003;

public class FieldSingleton {
	// 最も単純
	
	public static final FieldSingleton INSTANCE = new FieldSingleton();
	
	// コンストラクタはprivateでアクセス制限
	private FieldSingleton() {}

	public void method() {
	// 任意の処理
	}
}
