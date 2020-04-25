package jp.composite;

import jp.visitor.ListableVisitor;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Making root entity");
            Directory rootdir = new Directory("root");
            Directory bindir = new Directory("bin");
            Directory tmpdir = new Directory("tmp");
            Directory usrdir = new Directory("usr");
            rootdir.add(bindir);
            rootdir.add(tmpdir);
            rootdir.add(usrdir);
            bindir.add(new File("vi", 10000));
            bindir.add(new File("latex", 20000));
            // compositeパターンの場合
            rootdir.printList();
            // visitorパターンの場合
            rootdir.accept(new ListableVisitor());

            System.out.println(" ");
            System.out.println("Making root entity");
            Directory yuki = new Directory("yuki");
            Directory maiko = new Directory("maiko");
            Directory takao = new Directory("akao");
            Directory toru = new Directory("toru");
            usrdir.add(yuki);
            usrdir.add(maiko);
            usrdir.add(takao);
            usrdir.add(toru);
            yuki.add(new File("Diary", 100));
            yuki.add(new File("composit Java", 200));
            maiko.add(new File("memo", 50));
            toru.add(new File("ngame", 10000));
            takao.add(new File("magazine", 4000));
            // compositeパターンの場合
            rootdir.printList();
            // visitorパターンの場合
            rootdir.accept(new ListableVisitor());
        } catch (FileTreatmentException e) {
            e.getStackTrace();
        }
        
    }
}