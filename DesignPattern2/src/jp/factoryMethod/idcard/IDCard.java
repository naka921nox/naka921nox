package jp.factoryMethod.idcard;

import jp.factoryMethod.framework.*;

public class IDCard extends Product {

    private String owner;
    IDCard(String owner) {
        System.out.println(owner + "のカードを作ります");
        this.owner = owner;
    }

	@Override
	public void use() {
		// TODO Auto-generated method stub
        System.out.println(owner + "のカードを使います");
    }
    public String getOwner() {
        return owner;
    }
}
