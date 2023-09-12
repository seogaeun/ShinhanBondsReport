package Main;

import bonds.Bond;
import bonds.SimpleBond;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Main 클래스는 채권 투자 및 시장 운영 상태 확인을 위한 메인 애플리케이션 클래스입니다.
 */
public class Main {
    public static void main(String[] args) throws ParseException {

        String myString = "20500101";
        SimpleDateFormat dtFormat = new SimpleDateFormat("yyyyMMdd");
        Date maturityDate = dtFormat.parse(myString);

        Date purchaseDate = new Date(); // 예시: 구매일자 (현재 날짜)
        int investmentAmount = 1000; // 예시: 투자 금액
;



        // 채권 생성 및 초기화
        Bond bond = new SimpleBond(100, 100, 10, 10, maturityDate, purchaseDate, investmentAmount);
        // Facade 클래스를 사용하여 각 계산 메서드 호출
        Facade myBond = new Facade(bond);

        //매수일자 및 매수량에 따른 고객 채권 리포트 생성
        myBond.reportAll(purchaseDate, 1);
    }
}
