package jp.factoryMethod.idcard;

import java.util.ArrayList;
import java.util.List;

import jp.factoryMethod.framework.*;

public class IDCardFactory extends Factory {

    private List<String> owners = new ArrayList<>();

    @Override
    protected Product createProduct(String owner) {
        // TODO Auto-generated method stub
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        // TODO Auto-generated method stub
        owners.add(((IDCard)product).getOwner());

    }
    public List<String> getOwners() {
        return owners;
    }
}