package java.item005;

public class Item005 {
	/* 項目004：不必要なオブジェクトの生成を避ける */
	
	// NGケース：同一オブジェクトを二重に作成
	// こんなことは初心者でもやらないはずだが。
	String test = new String("hoge");
	
	// ふつうはこう。
	// 文字列リテラルのインスタンスは再利用される。
	String test2 = "hoge";

	// 次はブール値
	// 都度インスタンス化される例。
	// Java9以降ではDeprecated
	Boolean isTest = new Boolean("true");
	
	// ふつうはこう。
	Boolean isTest2 = Boolean.valueOf("true");

	
	
}
