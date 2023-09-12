package bonds;

import java.util.Date;

public class CompoundBond implements Bond {
    private int purchasePrice = 0;
    private int interestCalculationPeriod = 0;
    private double couponRate = 0;
    private int faceValue = 0;
    private Date maturityDate = new Date();
    private Date purchaseDate = new Date();
    private int investmentAmount = 0;

    // 생성자
    public CompoundBond(int purchasePrice,int interestCalculationPeriod,double couponRate,int faceValue,Date maturityDate, Date purchaseDate,int investmentAmount) {
        this.purchasePrice = purchasePrice;
        this.interestCalculationPeriod = interestCalculationPeriod;
        this.couponRate = couponRate;
        this.faceValue =faceValue;
        this.maturityDate =maturityDate;
        this.purchaseDate = purchaseDate;
        this.investmentAmount = investmentAmount;
    }


    //얘를 빌더로 분리하자
    @Override
    public void setCustomerInfo(Date purchaseDate, int investmentAmount) {
        this.purchaseDate = purchaseDate;
        this.investmentAmount = investmentAmount;
    }

    @Override
    public void calculateSimpleInterestAmount() {
        // 단순 이자 계산
        double simpleInterest = (investmentAmount * couponRate * interestCalculationPeriod) / 100;
        System.out.println("단순 이자: " + simpleInterest);
    }

    @Override
    public void calculatePreTaxPrincipalAmount() {
        // 세전 원금액 계산
        double preTaxPrincipalAmount = purchasePrice - (faceValue * couponRate);
        System.out.println("세전 원금액: " + preTaxPrincipalAmount);
    }

    @Override
    public void calculateYield() {
        // 수익률 계산
        double yield = (faceValue * couponRate + (faceValue - purchasePrice)) / purchasePrice;
        System.out.println("수익률: " + (yield * 100) + "%");
    }

    @Override
    public void calculateRemainMaturity() {
        // 만기까지 남은 기간 계산
        Date currentDate = new Date(); // 현재 날짜 예시
        long timeDifferenceMillis = maturityDate.getTime() - currentDate.getTime();
        long timeDifferenceDays = timeDifferenceMillis / (24 * 60 * 60 * 1000);
        long remainMaturityDays = timeDifferenceDays; // 예시로 현재 날짜까지의 일수로 계산
        System.out.println("만기까지 남은 기간 (일): " + remainMaturityDays);
    }

    @Override
    public void calculateInvestmentPeriod() {
        // 투자 기간 계산
        long timeDifferenceMillis = maturityDate.getTime() - purchaseDate.getTime();
        long timeDifferenceDays = timeDifferenceMillis / (24 * 60 * 60 * 1000);
        long investmentPeriodDays = timeDifferenceDays; // 예시로 현재 날짜까지의 일수로 계산
        System.out.println("투자 기간 (일): " + investmentPeriodDays);
    }

    @Override
    public void calculateYearInterestPayment() {
        // 연간 이자 지급액 계산
        double annualInterestPayment = faceValue * couponRate;
        System.out.println("연간 이자 지급액: " + annualInterestPayment);
    }
}
