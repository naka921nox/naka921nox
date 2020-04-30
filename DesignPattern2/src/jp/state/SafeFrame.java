package jp.state;

import java.awt.Frame;
import java.awt.Label;
import java.awt.Color;
import java.awt.Button;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;


public class SafeFrame extends Frame implements ActionListener, Context {

    private TextField textClock = new TextField(60);
    private TextArea textScreen = new TextArea(1,60);
    private Button buttonUse = new Button("金庫使用");
    private Button buttonAlarm = new Button("非常ベル");
    private Button buttonPhone = new Button("通常通話");
    private Button buttonExit = new Button("終了");

    private State state = DayState.getInstance();

    public SafeFrame(String title) {
        super(title);
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);
        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);
        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);
        add(panel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
        buttonUse.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        if (e.getSource() == buttonUse) {
            state.doUse(this);
        } else if (e.getSource() == buttonAlarm) {
            state.doAlarm(this);
        } else if (e.getSource() == buttonPhone) {
            state.doPhone(this);
        } else if (e.getSource() == buttonExit) {
            System.exit(0);
        } else {
            System.out.println("?");
        }

    }

    @Override
    public void setClock(int hour) {
        // TODO Auto-generated method stub
        String clockstring = "現在時刻は";
        if (hour < 10) {
            clockstring += "0" + hour + ":00";
        } else {
            clockstring += hour + ":00";
        }
        System.out.println(clockstring);
        textClock.setText(clockstring);
        state.doClock(this, hour);
    }

    @Override
    public void changeState(State state) {
        // TODO Auto-generated method stub
        System.out.println(this.state + "から" + state + "へ状態が変化しました。");
        this.state = state;
    }
    
    @Override
    public void callSecurityCenter(String msg) {
        // TODO Auto-generated method stub
        textScreen.append("call! " + msg + "\n");
    }

    @Override
    public void recordLog(String msg) {
        // TODO Auto-generated method stub
        textScreen.append("recording... " + msg + "\n");
    }

}