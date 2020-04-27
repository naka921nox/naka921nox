package jp.facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageWriter {
    public PageWriter() {
    }
    public static void makeWelcomePage(String mailaddr, String fileName) {
        try {
            Properties mailprop = Database.getProperties("maildata");
            String userName = mailprop.getProperty(mailaddr);
            HtmlWriter writer = new HtmlWriter(new FileWriter(fileName));
            writer.title("Welocme to " + userName + "'s page!");
            writer.paragraph(userName + "のページへようこそ。");
            writer.paragraph("メール待っていますね");
            writer.mailto(mailaddr, userName);
            writer.close();
            System.out.println(fileName + " is created for " + mailaddr + " (" + userName + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}