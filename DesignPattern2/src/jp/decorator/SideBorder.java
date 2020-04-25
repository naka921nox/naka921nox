package jp.decorator;

public class SideBorder extends Border {
    private char ch;
    public SideBorder(Display display, char ch) {
        super(display);
        this.ch = ch;
    }

    public int getColumns() {
        return 1 + display.getColumns() + 1;
    }

    public int getRows() {
        return display.getRows();
    }
    public String getRowText(int row) {
        return ch + display.getRowText(row) + ch;
    }
}