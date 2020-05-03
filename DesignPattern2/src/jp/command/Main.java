package jp.command;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import jp.command.command.Command;
import jp.command.command.MacroCommand;
import jp.command.drawer.DrawCanvas;
import jp.command.drawer.DrawCommand;

import java.awt.event.*;

public class Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener {

    /**
     * UID
     */
    private static final long serialVersionUID = 1L;

    private MacroCommand history = new MacroCommand();

    private DrawCanvas canvas = new DrawCanvas(400, 400, history);

    private JButton clearButton = new JButton("clear");

    public Main(String title) {
        super(title);

        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        clearButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        Command cmd = new DrawCommand(canvas, e.getPoint());
        history.appand(cmd);
        cmd.execute();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // nothing
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == clearButton) {
            history.clear();
            canvas.repaint();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // nothing
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // nothing
    }
    @Override
    public void windowIconified(WindowEvent e) {
        // nothing
    }
    @Override
    public void windowDeiconified(WindowEvent e) {
        // nothing
    }
    @Override
    public void windowActivated(WindowEvent e) {
        // nothing
    }
    @Override
    public void windowDeactivated(WindowEvent e) {
        // nothing
    }
}