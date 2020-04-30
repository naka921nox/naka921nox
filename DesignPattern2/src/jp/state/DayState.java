package jp.state;

public class DayState implements State {
    private static DayState singleton = new DayState();
    private DayState(){};

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        // TODO Auto-generated method stub
        if (hour < 9 || 17 <= hour) {
            context.changeState(NightState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        // TODO Auto-generated method stub
        context.recordLog("金庫使用(昼間)");
    }

    @Override
    public void doAlarm(Context context) {
        // TODO Auto-generated method stub
        context.callSecurityCenter("非常ベル(昼間)");
    }

    @Override
    public void doPhone(Context context) {
        // TODO Auto-generated method stub
        context.callSecurityCenter("通常の通話(昼間)");
    }

    public String toString() {
        return "[昼間]";
    }

}