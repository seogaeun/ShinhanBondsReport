package creator;

import bonds.Bond;
import bonds.SimpleBond;

import java.util.Date;

public class SimpleBondFactory  extends BondFactory {
    @Override
    public Bond createBond() {
        int purchasePrice = 0;
        int interestCalculationPeriod = 0;
        double couponRate = 0;
        int faceValue = 0;
        Date purchaseDate = new Date(); //채권을 사들인 일시
        Date maturityDate = new Date(); // 만기 일시
        int investmentAmount = 1000; // 예시: 투자 금액을 1000으로 설정
        return new SimpleBond(purchasePrice,interestCalculationPeriod,couponRate,faceValue,maturityDate,purchaseDate, investmentAmount);
    }
}
