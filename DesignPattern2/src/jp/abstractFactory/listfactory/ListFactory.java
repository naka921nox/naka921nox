package jp.abstractFactory.listfactory;

import jp.abstractFactory.factory.Factory;
import jp.abstractFactory.factory.Link;
import jp.abstractFactory.factory.Page;
import jp.abstractFactory.factory.Tray;

public class ListFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        // TODO Auto-generated method stub
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        // TODO Auto-generated method stub
        return new ListPage(title, author);
    }
}