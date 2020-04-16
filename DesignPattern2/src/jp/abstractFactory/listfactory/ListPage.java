package jp.abstractFactory.listfactory;

import java.io.BufferedReader;
import java.util.Iterator;

import jp.abstractFactory.factory.Item;
import jp.abstractFactory.factory.Link;
import jp.abstractFactory.factory.Page;
import jp.abstractFactory.factory.Tray;

public class ListPage extends Page {

    public ListPage(String title, String author) {
        super(title, author);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String makeHTML() {
        // TODO Auto-generated method stub
        StringBuffer buffer = new StringBuffer();
        buffer.append("<html><head>" + title + "</title></head>\n");
        buffer.append("<body>\n");
        buffer.append("<h1>" + title + "</h1>\n");
        buffer.append("<ul>\n");
        Iterator it = content.iterator();
        while(it.hasNext()) {
            Item item = (Item)it.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</ul>\n");
        buffer.append("<hr><address>" + author + "</address>");
        buffer.append("</body></html>\n");
        return buffer.toString();
    }
    
}