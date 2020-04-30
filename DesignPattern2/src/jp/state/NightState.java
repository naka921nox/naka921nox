package jp.state;

public class NightState implements State {
    private static NightState singleton = new NightState();
    private NightState(){};

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        // TODO Auto-generated method stub
        if (hour >= 9 && 17 > hour) {
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        // TODO Auto-generated method stub
        context.recordLog("非常：夜間の金庫使用");
    }

    @Override
    public void doAlarm(Context context) {
        // TODO Auto-generated method stub
        context.callSecurityCenter("非常ベル(夜間)");
    }

    @Override
    public void doPhone(Context context) {
        // TODO Auto-generated method stub
        context.callSecurityCenter("夜間の通話録音");
    }
    
    public String toString() {
        return "[夜間]";
    }

}