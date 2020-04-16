package jp.builder;

public class Director {
    private Builder builder;
    public Director(Builder builder) {
        this.builder = builder;
    }
    public void construct() {
        builder.makeTitle("Greeting");
        builder.makeString("おはよう");
        builder.makeItems(new String[]{
            "おはようございます",
            "こんにちは。",
        });
        builder.makeString("夜に");
        builder.makeItems(new String[] {
            "こんばんは",
            "おやすみなさい",
            "さようなら。"
        });
        builder.close();
    }

}