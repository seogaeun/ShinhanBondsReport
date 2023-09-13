package bonds.dailyState;

/**
 * OffState 클래스는 장내 채권 시장이 운영하지 않을 때의 상태를 나타내는 클래스입니다.
 */
public class OffState implements DayOffState {
    private static OffState instance = new OffState();

    private OffState() {}

    /**
     * OffState(장 마감)의 인스턴스를 반환합니다.
     *
     * @return OffState(장 마감) 인스턴스
     */
    public static OffState getInstance() {
        return instance;
    }

    /**
     * 현재 상태에 대한 정보를 출력합니다.
     */
    @Override
    public void printStateInfo() {
        System.out.println("장내 채권 시장은 휴장 시간입니다. 이 시간에는 채권 거래를 할 수 없습니다.");
        System.out.println("장 운영에 관해 문의 사항이 있으신 경우 신한알파의 챗봇 서비스를 이용해주세요.");

    }

    /**
     * 시간 변화에 따라 채권 시장의 운영 시간을 확인하고, 운영 시간 내일 경우(9:00 ~ 17:00) 상태를 변경합니다.
     *
     * @param context 상태 변경 및 관리를 위한 컨텍스트
     * @param hour    현재 시간(시간)
     */
    @Override
    public void handleTime(DayOffContext context, int hour) {
        if (hour >= 9 && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }
}
