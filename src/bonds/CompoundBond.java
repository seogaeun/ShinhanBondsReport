package bonds;

import java.util.Date;

/**
 * CompoundBond 클래스는 채권 이자 지급 방법 중 복리채 계산을 제공하는 클래스입니다.
 */
public class CompoundBond implements Bond {
    private int purchasePrice = 0;
    private int interestCalculationPeriod = 0;
    private double couponRate = 0;
    private int faceValue = 0;
    private Date maturityDate = new Date();
    private Date purchaseDate = new Date();
    private int investmentAmount = 0;

    /**
     * CompoundBond의 생성자입니다.
     *
     * @param purchasePrice             채권 구매 가격
     * @param interestCalculationPeriod 이자 계산 기간 (년)
     * @param couponRate                쿠폰 이율 (%)
     * @param faceValue                 액면 가격
     * @param maturityDate              만기일
     * @param purchaseDate              구매일
     * @param investmentAmount          투자 금액
     */
    public CompoundBond(int purchasePrice, int interestCalculationPeriod, double couponRate, int faceValue, Date maturityDate, Date purchaseDate, int investmentAmount) {
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
     *
     * 고객의 계산 편의를 위해 보유 수량 및 매수일자만 입력하는 함수를 제공합니다.
     *
     */
    @Override
    public void setCustomerInfo(Date purchaseDate, int investmentAmount) {
        this.purchaseDate = purchaseDate;
        this.investmentAmount = investmentAmount;
    }

    /**
     * 복리이자 계산 함수
     *
     * 복리 이자를 계산하고 출력합니다.
     * <p>
     * 복리 이자 공식: A = P(1 + r/n)^(nt) - P
     * 여기서 A는 총 수익, P는 원금, r은 연간 이율, n은 이자 계산 빈도, t는 기간입니다.
     */
    @Override
    public void calculateSimpleInterestAmount() {
        double principal = investmentAmount; // 원금
        double annualInterestRate = couponRate / 100; // 연간 이율
        double interestCalculationFrequency = interestCalculationPeriod; // 이자 계산 빈도
        double periodInYears = (maturityDate.getTime() - purchaseDate.getTime()) / (365 * 24 * 60 * 60 * 1000); // 기간 (년)

        double totalInterest = principal * Math.pow(1 + annualInterestRate / interestCalculationFrequency, interestCalculationFrequency * periodInYears) - principal;
        System.out.println("복리 이자: " + totalInterest);
    }

    /**
     *세전 원리금액 계산 함수
     *
     * 원금(매수금) + 복리 이자의 합을 통해
     * 세전 원리금액을 계산하고 출력합니다.
     */
    @Override
    public void calculatePreTaxPrincipalAmount() {
        double preTaxPrincipalAmount = purchasePrice + calculateAccruedInterest();
        System.out.println("세전 원금액: " + preTaxPrincipalAmount);
    }

    /**
     * 수익률 계산 함수
     *
     * 수익률을 계산하고 출력합니다.
     * <p>
     * 수익률 공식: Yield = (A / P) * 100
     * 여기서 A는 총 수익, P는 원금입니다.
     * 여기서는 세전 수익률로 계산하고 있습니다.
     */
    @Override
    public void calculateYield() {
        double principal = purchasePrice; // 원금
        double totalInterest = calculateAccruedInterest(); // 총 수익

        double yield = (totalInterest / principal) * 100;
        System.out.println("수익률: " + yield + "%");
    }

    /**
     *
     * 잔여일 계산 함수
     *
     * 만기일 - 현재일의 차를 통해
     * 만기까지 남은 기간을 계산하고 출력합니다.
     */
    @Override
    public void calculateRemainMaturity() {
        Date currentDate = new Date();
        long timeDifferenceMillis = maturityDate.getTime() - currentDate.getTime();
        long timeDifferenceDays = timeDifferenceMillis / (24 * 60 * 60 * 1000);
        System.out.println("만기까지 남은 기간 (일): " + timeDifferenceDays);
    }

    /**
     * 투자 기간 계산 함수
     *
     * 만기일 - 매수일의 차를 통해
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
     *
     * 연간 이자 지급액을 계산하고 출력합니다.
     * 연간 이자 지급액 = 복리 이자
     */
    @Override
    public void calculateYearInterestPayment() {
        double annualInterestPayment = calculateAccruedInterest();
        System.out.println("연간 이자 지급액: " + annualInterestPayment);
    }

    /**
     * 복리 이자를 계산하는 함수입니다.
     *
     * @return 복리 이자 금액
     */
    private double calculateAccruedInterest() {
        double accruedInterest = purchasePrice;
        for (int i = 0; i < interestCalculationPeriod; i++) {
            accruedInterest += accruedInterest * couponRate / 100;
        }
        return accruedInterest - purchasePrice;
    }
}
