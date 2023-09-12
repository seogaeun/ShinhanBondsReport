package Main;

import bonds.Bond;
import bonds.CompoundBond;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        // 채권 생성 및 초기화
        Date purchaseDate = new Date(); // 예시: 구매일자 (현재 날짜)
        int investmentAmount = 1000; // 예시: 투자 금액

        String myString = "20500101";
        SimpleDateFormat dtFormat = new SimpleDateFormat("yyyyMMdd");
        Date mydate = dtFormat.parse(myString);

        Bond bond = new CompoundBond(10,100,10,10,mydate,purchaseDate, investmentAmount);

        // Facade 클래스를 사용하여 각 계산 메서드 호출
        Facade myBond = new Facade(bond);


        myBond.reportAll(mydate,1);


    }
}
