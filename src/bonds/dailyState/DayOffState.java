package bonds.dailyState;

public interface DayOffState {
    void printStateInfo();

    void handleTime(DayOffContext context, int hour);
}
