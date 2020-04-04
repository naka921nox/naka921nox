package jp.adapter.delegate;

import jp.adapter.Banner;

public class DelegatePrintBanner extends DelegatePrint{
    private Banner banner;

    public DelegatePrintBanner(String str) {
        this.banner = new Banner(str);
    }

    public void printWeak() {
        banner.showWithParan();
    }

    public void printStrong() {
        banner.showWithAster();
    }
}