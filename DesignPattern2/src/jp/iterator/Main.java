package jp.iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf();
        bookShelf.appendBook(new Book("ドラゴンボール"));
        bookShelf.appendBook(new Book("幽遊白書"));
        bookShelf.appendBook(new Book("スラムダンク"));
        bookShelf.appendBook(new Book("キン肉マン"));
        bookShelf.appendBook(new Book("ワンピース"));
        bookShelf.appendBook(new Book("ナルト"));
        Iterator it = bookShelf.iterator();
        while(it.hasNext()) {
            Book book = (Book)it.next();
            System.out.println(book.getName());
        }
    }

}