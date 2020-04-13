package jp.abstractFactory.factory;

public abstract class Factory {
    public static Factory getFactory(String className) {
        Factory factory = null;
        try {
            factory = (Factory)Class.forName(className).newInstance();
        } catch (ClassNotFoundException e){ 
            System.err.println(className +  "クラスが見つかりません");
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        return factory;
    }
    public abstract Link createLink(String caption, String url);
    public abstract Tray createTray(String caption);
    public abstract Page createPage(String title, String author);

}