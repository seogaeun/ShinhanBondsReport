package creator;

import bonds.Bond;
import bonds.DiscoundBond;

import java.util.Date;

/**
 * 이 클래스는 할인채(Bond) 객체를 생성하는 팩토리입니다.
 */
public class DiscoundBondFactory extends BondFactory {

    /**
     * 할인채 객체를 생성하고 반환합니다.
     *
     * @return 생성된 할인채 객체
     */
    @Override
    public Bond createBond() {
        int purchasePrice = 0; // 채권 구매 가격
        int interestCalculationPeriod = 0; // 이자 계산 기간 (년)
        double couponRate = 0; // 액면이자율 (%)
        int faceValue = 0; // 액면 가격
        Date purchaseDate = new Date(); // 채권을 구매한 날짜
        Date maturityDate = new Date(); // 채권 만기일
        int investmentAmount = 1000; // 투자 금액 (예시: 1000)

        // DiscoundBond 객체를 생성하여 반환
        return new DiscoundBond(purchasePrice, interestCalculationPeriod, couponRate, faceValue, maturityDate, purchaseDate, investmentAmount);
    }
}
