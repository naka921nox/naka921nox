package jp.adapter;

import jp.adapter.extend.ExtendPrint;
import jp.adapter.extend.ExtendPrintBanner;
import jp.adapter.delegate.DelegatePrint;
import jp.adapter.delegate.DelegatePrintBanner;


public class Main {
    public static void main(String[] args) {
        execExtend();
        execDelegate();
    }

    private static void execExtend() {
        ExtendPrint p = new ExtendPrintBanner("ExtendWorld!");
        p.printWeak();
        p.printStrong();
    }

    private static void execDelegate() {
        DelegatePrint p = new DelegatePrintBanner("DelegateWorld!");
        p.printWeak();
        p.printStrong();
    }
}
