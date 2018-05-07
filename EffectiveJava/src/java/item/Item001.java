package java.item;

public class Item001 {
	/* 項目001：コンストラクタの代わりに static ファクトリーメソッドを検討する */

	/* インスタンス */
	private static Item001 item001 = new Item001();

	private Item001() {

	}
	// シングルトンパターンのこと。
	// 命名ルールとしてシングルトンの場合のstaticメソッドはgetInstance
    public static Item001 getInstance() {
        return item001;
    }

}
