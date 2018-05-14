package java.item003;

public class StaticFactorySingleton {
	// 基本的にはFieldSingletonと同じ。シングルトンであるかどうか動的に決定可能。
	
	private static final StaticFactorySingleton INSTANCE = new StaticFactorySingleton();

	// コンストラクタはprivateでアクセス制限
	private StaticFactorySingleton() {
	}
	
	// 使用者はこのメソッドでインスタンスを呼び出す
	public static StaticFactorySingleton getInstance() {
		return INSTANCE;
	}
	
	public void anyMethod() {
		// 任意の処理
	}
}
