package jp.abstractFactory.listfactory;

import java.io.BufferedReader;
import java.util.Iterator;

import jp.abstractFactory.factory.Item;
import jp.abstractFactory.factory.Link;
import jp.abstractFactory.factory.Tray;

public class ListTray extends Tray {

    public ListTray(String caption) {
        super(caption);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String makeHTML() {
        // TODO Auto-generated method stub
        StringBuffer buffer = new StringBuffer();
        buffer.append("<li>\n");
        buffer.append(caption + "\n");
        buffer.append("<ul>\n");
        Iterator it = tray.iterator();
        while(it.hasNext()) {
            Item item = (Item)it.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</ul>\n");
        buffer.append("</li>\n");
        return buffer.toString();
    }
    
}