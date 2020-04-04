package jp.adapter.extend;

public class PrintBanner extends Banner implements Print{

    public PrintBanner(String str) {
        super(str);
    }

    @Override
    public void printWeak() {
        showWithParan();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}