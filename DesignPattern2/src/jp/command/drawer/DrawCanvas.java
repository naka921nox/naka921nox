package jp.command.drawer;

import java.awt.*;

import jp.command.command.MacroCommand;

public class DrawCanvas extends Canvas implements Drawable {

    /**
     * uid
     */
    private static final long serialVersionUID = 1L;

    private Color color = Color.RED;

    private int redius = 6;

    private MacroCommand history;

    public DrawCanvas (int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.WHITE);
        this.history = history;
    }

    public void print(Graphics g) {
        history.execute();
    }

    @Override
    public void draw(int x, int y) {
        // TODO Auto-generated method stub
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillRect(x - redius, y - redius, redius * 2, redius * 2);
    }
    
}