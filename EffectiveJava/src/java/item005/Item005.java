package java.item005;

public class Item005 {
	/* 項目005：不必要なオブジェクトの生成を避ける */
	
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

	
	// オートボクシングの悪い例
	public void autoBoxing() {
		Long sum = 0L;
		
		for (long i = 0; i <= Integer.MAX_VALUE; i ++) {
			// ここで毎回int型に自動ボクシング
			// 毎回不要なLong型がインスタンス化される
			sum += 1;
		}
		System.out.println(sum);
		// sumをlong型に変えるとパフォーマンス 43.2 sec が 6.8 sec に改善
	}
	
}
