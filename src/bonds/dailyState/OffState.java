package bonds.dailyState;

public class OffState implements DayOffState {
    private static OffState instance = new OffState();

    private OffState() {}

    public static OffState getInstance() {
        return instance;
    }

    @Override
    public void printStateInfo() {
        System.out.println("장내 채권 시장은 휴장 시간입니다. 이 시간에는 채권 거래를 할 수 없습니다.");
    }


    @Override
    public void handleTime(DayOffContext context, int hour) {
        if (hour >= 9 && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }
}
