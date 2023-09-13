package creator;

import bonds.Bond;
import bonds.CompoundBond;

import java.util.Date;

/**
 * CompoundBondFactory는 복리채(Bond) 객체를 생성하는 팩토리 클래스입니다.
 */
public class CompoundBondFactory extends BondFactory {

    /**
     * 복리채 객체를 생성하고 반환합니다.
     *
     * @return 생성된 복리채 객체
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

        // CompoundBond 객체를 생성하여 반환
        return new CompoundBond(purchasePrice, interestCalculationPeriod, couponRate, faceValue, maturityDate, purchaseDate, investmentAmount);
    }
}
