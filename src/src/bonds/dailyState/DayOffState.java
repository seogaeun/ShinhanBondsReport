package bonds.dailyState;

/**
 * DayOffState 인터페이스는 채권 시장의 운영 시간에 따른 상태를 정의하는데 사용됩니다.
 */
public interface DayOffState {
    /**
     * 현재 상태에 대한 정보를 출력합니다.
     */
    void printStateInfo();

    /**
     * 시간 변화에 따라 채권 시장의 운영 시간을 확인하고, 상태를 변경할 수 있도록 합니다.
     *
     * @param context 상태 변경 및 관리를 위한 컨텍스트
     * @param hour    현재 시간(시간)
     */
    void handleTime(DayOffContext context, int hour);
}
