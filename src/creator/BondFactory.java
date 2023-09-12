/**
 * BondFactory는 채권(Bond) 객체를 생성하는 추상 팩토리 클래스입니다.
 * 파생 클래스에서 실제 채권 객체를 생성하는 메서드(createBond)를 구현해야 합니다.
 */
package creator;

import bonds.Bond;

public abstract class BondFactory {
    /**
     * 채권 객체를 생성하고 반환하는 추상 메서드입니다.
     *
     * @return 생성된 채권 객체
     */
    public abstract Bond createBond();
}
