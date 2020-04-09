package jp.builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class HTMLBuilder extends Builder {
    private String fileName;
    private PrintWriter writer;

    @Override
    public void makeTitle(String title) {
        // TODO Auto-generated method stub
        fileName = title + ".html";
        try {
            writer = new PrintWriter(new FileWriter(fileName));
        } catch (IOException e) {
            e.getStackTrace();
        }
        writer.println("<html><head><title>" + title + "</title></head></body>");
        // タイトルを出力
        writer.println("<h1>" + title + "</h1>");
    }

    @Override
    public void makeString(String str) {
        // TODO Auto-generated method stub
        writer.println("<p>" + str + "</p>");
    }

    @Override
    public void makeItems(String[] items) {
        // TODO Auto-generated method stub
        IntStream.range(0, items.length).forEach(i -> writer.println("<li>" + items[i] + "</li>"));
        writer.println("</ui>");
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
       writer.println("</body></html>");
       writer.close();

    }
    public String getResult() {
        return fileName;
    }
}