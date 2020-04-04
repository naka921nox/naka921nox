package jp.adapter.extend;

import jp.adapter.Banner;

public class ExtendPrintBanner extends Banner implements ExtendPrint{

    public ExtendPrintBanner(String str) {
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