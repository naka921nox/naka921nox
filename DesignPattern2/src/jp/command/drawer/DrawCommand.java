package jp.command.drawer;

import java.awt.Point;

import jp.command.command.Command;

public class DrawCommand implements Command{

    protected Drawable drawable;

    private Point position;

    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        drawable.draw(position.x, position.y);
    }
    
}