package java.item003;

public enum EnumSingleton {
	// ほかの2つのシングルトンクラスはシリアライズ可能にした場合、
	// デシリアライズするとつどインスタンスが生成される
	
	// EnumSingletonはシリアライズ可能であるため最善
	
	INSTANCE;
	
	public void anyMethod() {
		// 任意の処理
	}
}
