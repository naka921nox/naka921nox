package jp.visitor;

import jp.composite.File;

import java.util.Iterator;

import jp.composite.Directory;
import jp.composite.Entry;

public class ListableVisitor extends Visitor {
    public String currentdir = "";

    @Override
	public void visit(File file) {
		// TODO Auto-generated method stub
		System.out.println(currentdir + "/" + file);
	}

	@Override
	public void visit(Directory directory) {
		// TODO Auto-generated method stub
        System.out.println(currentdir + "/" + directory);
        String savedir = currentdir;
        currentdir = currentdir + "/" + directory.getName();
		Iterator it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = (Entry)it.next();
			entry.accept(this);
		}
		currentdir = savedir;
    }
   
}