package bonds;
import java.util.Date;
// Bond 인터페이스


public interface Bond {
    void setCustomerInfo(Date purchaseDate, int investmentAmount);
    void calculateSimpleInterestAmount();
    void calculatePreTaxPrincipalAmount();
    void calculateYield();
    void calculateRemainMaturity();
    void calculateInvestmentPeriod();
    void calculateYearInterestPayment();


}