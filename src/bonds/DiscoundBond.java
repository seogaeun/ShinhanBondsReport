package bonds;

import java.util.Date;



/**
 * DiscountBond 클래스는 채권 이자 지급 방법 중 할인채 계산을 제공하는 클래스입니다.
 */
public class DiscoundBond implements Bond {
    private int purchasePrice = 0;
    private int interestCalculationPeriod = 0;
    private double couponRate = 0;
    private int faceValue = 0;
    private Date maturityDate = new Date();
    private Date purchaseDate = new Date();
    private int investmentAmount = 0;


    /**
     * DiscountBond의 생성자입니다.
     *
     * @param purchasePrice             채권 구매 가격
     * @param interestCalculationPeriod 이자 계산 기간 (년)
     * @param couponRate                쿠폰 이율 (%)
     * @param faceValue                 액면 가격
     * @param maturityDate              만기일
     * @param purchaseDate              구매일
     * @param investmentAmount          투자 금액
     */

    public DiscoundBond(int purchasePrice, int interestCalculationPeriod, double couponRate, int faceValue, Date maturityDate, Date purchaseDate, int investmentAmount) {
        this.purchasePrice = purchasePrice;
        this.interestCalculationPeriod = interestCalculationPeriod;
        this.couponRate = couponRate;
        this.faceValue = faceValue;
        this.maturityDate = maturityDate;
        this.purchaseDate = purchaseDate;
        this.investmentAmount = investmentAmount;
    }


    /**
     * 보유 수량 및 매수일자 설정 함수
     * <p>
     * 고객의 계산 편의를 위해 보유 수량 및 매수일자만 입력하는 함수를 제공합니다.
     */
    @Override
    public void setCustomerInfo(Date purchaseDate, int investmentAmount) {
        this.purchaseDate = purchaseDate;
        this.investmentAmount = investmentAmount;
    }

    /**
     * 단순 이자 계산 함수
     * <p>
     * 할인채의 단순 이자는 항상 0입니다.
     */
    @Override
    public void calculateSimpleInterestAmount() {
        double simpleInterest = 0;
        System.out.println("단순 이자: " + simpleInterest);
        System.out.println(" 할인채의 단순 이자는 0이므로 항상 0입니다. ");
    }

    /**
     * 세전 원금액 계산 함수
     * <p>
     * 할인채의 세전 원금액을 계산하고 출력합니다.
     */
    @Override
    public void calculatePreTaxPrincipalAmount() {
        double discountRate = 0.3; // 할인율
        double preTaxPrincipalAmount = purchasePrice - (purchasePrice * discountRate);
        System.out.println("세전 원금액: " + preTaxPrincipalAmount);
    }

    /**
     * 수익률 계산 함수
     * <p>
     * 할인채의 수익률을 계산하고 출력합니다.
     */
    @Override
    public void calculateYield() {
        double yield = ((faceValue - purchasePrice) / purchasePrice) * 100;
        System.out.println("수익률: " + yield + "% (할인률 기반)");
    }

    /**
     * 잔여일 계산 함수
     * <p>
     * 만기일까지 남은 기간을 계산하고 출력합니다.
     */
    @Override
    public void calculateRemainMaturity() {
        Date currentDate = new Date(); // 현재 날짜 예시
        long timeDifferenceMillis = maturityDate.getTime() - currentDate.getTime();
        long timeDifferenceDays = timeDifferenceMillis / (24 * 60 * 60 * 1000);
        System.out.println("만기까지 남은 기간 (일): " + timeDifferenceDays);
    }

    /**
     * 투자 기간 계산 함수
     * <p>
     * 투자 기간을 계산하고 출력합니다.
     */
    @Override
    public void calculateInvestmentPeriod() {
        long timeDifferenceMillis = maturityDate.getTime() - purchaseDate.getTime();
        long timeDifferenceDays = timeDifferenceMillis / (24 * 60 * 60 * 1000);
        System.out.println("투자 기간 (일): " + timeDifferenceDays);
    }

    /**
     * 연간 이자 지급액 함수
     * <p>
     * 할인채는 이자를 지급하지 않으므로 항상 0입니다.
     */
    @Override
    public void calculateYearInterestPayment() {
        double annualInterestPayment = 0; // 할인채는 이자를 지급하지 않으므로 항상 0입니다.
        System.out.println("연간 이자 지급액: " + annualInterestPayment);
        System.out.println(" 할인채는 이자를 지급하지 않으므로 항상 0입니다. ");
    }
}
