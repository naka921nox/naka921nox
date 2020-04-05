package jp.factoryMethod.framework;

public abstract class Factory {
    public final Product create(String owaner) {
        Product p = createProduct(owaner);
        registerProduct(p);
        return p;
    }
    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);
}