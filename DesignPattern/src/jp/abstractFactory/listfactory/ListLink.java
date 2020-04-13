package jp.abstractFactory.listfactory;

import jp.abstractFactory.factory.Link;

public class ListLink extends Link {

    public ListLink(String caption, String url) {
        super(caption, url);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String makeHTML() {
        // TODO Auto-generated method stub
        return " <li><a href=\"" + url + "\" >" + caption + "</a></li>\n";
    }
    
}