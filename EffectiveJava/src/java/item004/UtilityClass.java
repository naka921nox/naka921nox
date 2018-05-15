package java.item004;

public class UtilityClass {
	/* 項目004：private のコンストラクタでインスタンス化不可能を強制する */
	
	// コンストラクタはprivateでアクセス制限
	private UtilityClass() {
		// AssertionError 必須ではないが意図せぬ呼び出しを防止できる。
		throw new AssertionError();
	}

	public void method() {
	// 任意の処理
	}
}
