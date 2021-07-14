import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * <p> Project: Algorithm </P>
 * <p> Package: PACKAGE_NAME </p>
 * <p> FileName: Test4 <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/27
 */

public class Test4 {
    public static void main(String[] args) {
        BigInteger i1 = new BigInteger("10900");
        BigInteger i2 = new BigInteger("3");
        System.out.println(i1.divide(i2));

        BigDecimal d1 = new BigDecimal("10");
        BigDecimal d2 = new BigDecimal("333.333");
        System.out.println(d2.divide(d1));
    }
}
