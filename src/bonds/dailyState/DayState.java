package bonds.dailyState;

/**
 * DayState 클래스는 채권 시장이 개장했을 때 (9:00~17:00)의 상태를 나타내는 클래스입니다.
 */
public class DayState implements DayOffState {
    private static DayState instance = new DayState();

    private DayState() {}

    /**
     * DayState의 인스턴스를 반환합니다.
     *
     * @return DayState 인스턴스
     */
    public static DayState getInstance() {
        return instance;
    }

    /**
     * 현재 상태에 대한 정보를 출력합니다.
     */
    @Override
    public void printStateInfo() {
        System.out.println("현재 장내 채권 시장 운영 시간입니다. 자세한 문의사항은 지점을 방문해주세요.");
    }

    /**
     * 시간 변화에 따라 채권 시장의 운영 시간을 확인하고, 운영 시간 외일 경우 상태를 변경합니다.
     *
     * @param context 상태 변경 및 관리를 위한 컨텍스트
     * @param hour    현재 시간(시간)
     */
    @Override
    public void handleTime(DayOffContext context, int hour) {
        if (hour < 9 || hour >= 17) {
            context.changeState(OffState.getInstance());
        }
    }
}
