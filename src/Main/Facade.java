package Main;

import bonds.Bond;
import bonds.dailyState.DayOffContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Facade 클래스는 파사드 패턴을 사용하여 복잡한 작업을 단순화한 클래스입니다.
 * 이 클래스를 사용하여 투자 리포트를 생성하고 채권 시장 운영 상태를 확인할 수 있습니다.
 */
public class Facade {
    private Bond bond;
    private DayOffContext context;
    Date date = new Date();
    // 출력 형식 지정을 위한 SimpleDateFormat 객체 생성
    SimpleDateFormat sdf = new SimpleDateFormat("HH"); // "HH"는 시간을 24시간 형식으로 표시합니다.

    // 결과 출력
    String formattedHour = sdf.format(date);
    int hour = Integer.parseInt(formattedHour);

    /**
     * Facade 클래스의 생성자입니다.
     *
     * @param bond 채권 객체
     */
    public Facade(Bond bond) {
        this.bond = bond;
        context = new DayOffContext();
    }

    /**
     * 채권 시장 운영 상태를 확인하고 출력합니다.
     */
    public void checkMarketStatus() {

        // 채권 시장 운영 상태를 확인하고 출력합니다.
        context.tick();
        context.printStateInfo();
    }

    /**
     * 고객의 투자 리포트를 생성하고 출력합니다.
     *
     * @param purchaseDate       채권 구매 일자
     * @param investmentAmount   투자 금액
     */
    public void reportAll(Date purchaseDate, int investmentAmount) {
        System.out.println(hour + "시 고객님이 투자하신 " + bond + " 리포트입니다");

        // Bond 객체에 purchaseDate와 investmentAmount를 설정합니다.
        bond.setCustomerInfo(purchaseDate, investmentAmount);

        // Bond 객체의 계산 메서드를 호출하여 리포트를 생성하고 출력합니다.
        bond.calculateSimpleInterestAmount();
        bond.calculatePreTaxPrincipalAmount();
        bond.calculateYield();
        bond.calculateRemainMaturity();
        bond.calculateInvestmentPeriod();
        bond.calculateYearInterestPayment();
        checkMarketStatus();
    }
}
