package jp.visitor;

import jp.composite.File;
import jp.composite.Directory;

public abstract class Visitor {
   public abstract void visit(File file);
   public abstract void visit(Directory directory);
}