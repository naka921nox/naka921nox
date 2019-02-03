package java.item007;

/* 項目007 ファイナライザを避ける */

public class Item007 {
    // Javaのfinallaizaはいつ実行されるかが定かではない
    // 即時実効性がなく、JVMの実装依存
    // finallaizaに頼らずにリソース開放する→明示的終了メソッドを作る
    Foo foo = new Foo();

    //　
    public void test() {
        try {
            // 処理
        } finally {
            // 明示的終了処理
            foo.terminate();
        }

    }
    // クラス定義
    public class Foo {
        
        // 明示的終了処理
        public void terminate () {}

    }
    
}

