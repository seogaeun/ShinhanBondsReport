package bonds.dailyState;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * DayOffContext 클래스는 채권 시장의 운영 시간(9:00 ~ 17:00)에 따른
 * 상태를 관리하고 출력하는 매서드들을 제공합니다.
 */
public class DayOffContext {
    private DayOffState currentState;
    private Calendar calendar;
    Date date = new Date();

    // 출력 형식 지정을 위한 SimpleDateFormat 객체 생성
    SimpleDateFormat sdf = new SimpleDateFormat("HH"); // "HH"는 시간을 24시간 형식으로 표시합니다.

    /**
     * DayOffContext 클래스의 생성자입니다.
     * 현재 시간을 기준으로 채권 시장의 운영 시간에 따른 상태를 초기화합니다.
     */
    public DayOffContext() {
        calendar = Calendar.getInstance();
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        currentState = currentHour >= 9 && currentHour < 17 ? DayState.getInstance() : OffState.getInstance();
    }

    /**
     * 현재 채권 시장의 운영 시간에 따른 상태를 변경합니다.
     *
     * @param newState 변경할 상태
     */
    public void changeState(DayOffState newState) {
        currentState = newState;
    }

    /**
     * 현재 채권 시장의 운영 시간에 따른 상태에 대한 정보를 출력합니다.
     */
    public void printStateInfo() {
        currentState.printStateInfo();
    }

    /**
     * 시간 경과를 처리하고 현재 채권 시장의 운영 시간에 따른 상태에 따라 작업을 수행합니다.
     */
    public void tick() {
        calendar.add(Calendar.HOUR_OF_DAY, 1); // 1시간 경과
        String formattedHour = sdf.format(date);
        int hour = Integer.parseInt(formattedHour);
        currentState.handleTime(this, hour);
    }
}
