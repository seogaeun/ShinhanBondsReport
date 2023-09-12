package bonds.dailyState;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DayOffContext {
    private DayOffState currentState;
    private Calendar calendar;
    Date date = new Date();
    // 출력 형식 지정을 위한 SimpleDateFormat 객체 생성
    SimpleDateFormat sdf = new SimpleDateFormat("HH"); // "HH"는 시간을 24시간 형식으로 표시합니다.

    public DayOffContext() {
        calendar = Calendar.getInstance();
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        currentState = currentHour >= 9 && currentHour < 17 ? DayState.getInstance() : OffState.getInstance();
    }

    public void changeState(DayOffState newState) {
        currentState = newState;
    }

    public void printStateInfo() {
        currentState.printStateInfo();
    }

    public void tick() {
        calendar.add(Calendar.HOUR_OF_DAY, 1); // 1시간 경과
        String formattedHour = sdf.format(date);
        int hour = Integer.parseInt(formattedHour);
        currentState.handleTime(this, hour);
    }
}
