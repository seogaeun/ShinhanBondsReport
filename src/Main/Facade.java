package Main;

import bonds.Bond;
import bonds.dailyState.DayOffContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Facade {
    private Bond bond;
    private DayOffContext context;
    Date date = new Date();
    // 출력 형식 지정을 위한 SimpleDateFormat 객체 생성
    SimpleDateFormat sdf = new SimpleDateFormat("HH"); // "HH"는 시간을 24시간 형식으로 표시합니다.

    // 결과 출력
    String formattedHour = sdf.format(date);
    int hour = Integer.parseInt(formattedHour);

    public Facade(Bond bond) {
        this.bond = bond;
        context = new DayOffContext();
    }

    public void reportAll(Date purchaseDate, int investmentAmount) {
        System.out.println(hour+"시 고객님이 투자하신 " + bond + " 리포트입니다");

        // Bond 객체에 purchaseDate와 investmentAmount를 설정합니다.
        bond.setCustomerInfo(purchaseDate, investmentAmount);

        // Bond 객체의 계산 메서드를 호출합니다.
        bond.calculateSimpleInterestAmount();
        bond.calculatePreTaxPrincipalAmount();
        bond.calculateYield();
        bond.calculateRemainMaturity();
        bond.calculateInvestmentPeriod();
        bond.calculateYearInterestPayment();

        // runSimulation 함수를 호출하여 시뮬레이션 실행
        runSimulation();
    }

    public void runSimulation() {
        context.tick();
        context.printStateInfo();
    }
}
