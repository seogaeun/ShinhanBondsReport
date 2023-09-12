package bonds;

import java.util.Date;

/**
 * Bond 인터페이스는 이자 지급 방법에 따른 채권(단리, 복리, 이표, 할인채)을 분류하고 계산 및 정보 관련 메서드를 정의합니다.
 */
public interface Bond {

    /**
     * 구매 날짜와 투자 금액을 포함하는 고객 정보를 설정합니다.
     *
     * @param purchaseDate      구매 날짜.
     * @param investmentAmount 투자 금액.
     */
    void setCustomerInfo(Date purchaseDate, int investmentAmount);

    /**
     * 단순 이자 금액을 계산하고 출력합니다.
     */
    void calculateSimpleInterestAmount();

    /**
     * 세전 원금 금액을 계산하고 출력합니다.
     */
    void calculatePreTaxPrincipalAmount();

    /**
     * 수익률을 계산하고 출력합니다.
     */
    void calculateYield();

    /**
     * 남은 만기 기간을 계산하고 출력합니다.
     */
    void calculateRemainMaturity();

    /**
     * 투자 기간을 계산하고 출력합니다.
     */
    void calculateInvestmentPeriod();

    /**
     * 연간 이자 지급액을 계산하고 출력합니다.
     */
    void calculateYearInterestPayment();
}
