package bonds.dailyState;

public class DayState implements DayOffState {
    private static DayState instance = new DayState();

    private DayState() {}

    public static DayState getInstance() {
        return instance;
    }

    @Override
    public void printStateInfo() {
        System.out.println("현재 장내 채권시장 운영 시간입니다. 자세한 문의사항은 지점을 방문해주세요");
    }



    @Override
    public void handleTime(DayOffContext context, int hour) {
        if (hour < 9 || hour >= 17) {
            context.changeState(OffState.getInstance());
        }
    }
}
