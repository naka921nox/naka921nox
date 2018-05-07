package java.item002;

public class Item002Client {
	/* 項目002：数多くのコンストラクタパラメータに直面した時にはビルダーを検討する */

	/* TelescopingConstructorパターンの呼び出し */
	// デメリット：コンストラクタがパターンごとに必要になってしまう
	TelescopingConstructor tc1 = new TelescopingConstructor("山田太郎");
	TelescopingConstructor tc2 = new TelescopingConstructor("山田太郎", "東京");
	// デメリット：引数の型が同じ場合に順序を誤る可能性がある
	// NG
	TelescopingConstructor tc3 = new TelescopingConstructor("山田太郎", "03-xxxx-xxxx", "東京");
	// OK
	TelescopingConstructor tc4 = new TelescopingConstructor("山田太郎", "東京", "03-xxxx-xxxx");

	// JavaBeanパターンの呼び出し
	public void callJavaBeans() {
		// インスタンスの生成
		JavaBeans jb = new JavaBeans();
		
		// 各種Setterの呼び出し
		jb.setAddress("東京");
		jb.setTel("03-xxxx-xxxx");
		// ここで処理を中断すると不整合な状態のJavaBeansができてしまう。
		// 必須であるはずの氏名が入力されない。など。
		jb.setName("山田太郎");

	}

	// Builderパターンの呼び出し
	BuilderPattern bp1 = new BuilderPattern.Builder("山田太郎").build();
	BuilderPattern bp2 = new BuilderPattern.Builder("山田太郎").setAddress("東京").build();
	BuilderPattern bp3 = new BuilderPattern.Builder("山田太郎").setAddress("東京").setTel("03-xxxx-xxxx").build();

}
