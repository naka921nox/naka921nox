package jp.abstractFactory;

import jp.abstractFactory.factory.Factory;
import jp.abstractFactory.factory.Link;
import jp.abstractFactory.factory.Page;
import jp.abstractFactory.factory.Tray;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            usage();            
            System.exit(0);
        }
        Factory factory = Factory.getFactory(args[0]);
        Link asahi = factory.createLink("あさひしんぶん", "リンク");
        Link yahoo = factory.createLink("やふー", "リンク");

        Tray traynews = factory.createTray("新聞");
        traynews.add(asahi);

        Tray traysearch = factory.createTray("サーチエンジン");
        traynews.add(yahoo);
        
        Page page = factory.createPage("りんくぺーじ", "著者");
        page.add(traynews);
        page.add(traysearch);
        page.output();
       }
    public static void usage() {
        System.out.println("Usage: java Main class.name.of.ConcreteFactory");
    }

}