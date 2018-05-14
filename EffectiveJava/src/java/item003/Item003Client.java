package java.item003;

public class Item003Client {
	/* 項目003：private のコンストラクタか enum 型でシングルトン特性を強制する */
	// それぞれのメリットは各クラスに記載
	
	// 単純なシングルトン呼び出し
	FieldSingleton fs = FieldSingleton.INSTANCE;
	
	// staticファクトリーシングルトン呼び出し
	StaticFactorySingleton sfs = StaticFactorySingleton.getInstance();
	
	// Enumシングルトン呼び出し
	EnumSingleton es = EnumSingleton.INSTANCE;

}
