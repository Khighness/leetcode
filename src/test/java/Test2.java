/**
 * <p> Project: Algorithm </P>
 * <p> Package: PACKAGE_NAME </p>
 * <p> FileName: Test2 <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/26
 */

public class Test2 {
    public static void main(String[] args) {
        System.out.print(func1());
        System.out.print(func2());
    }

    public static int func1() {
        int i = 5;
        try {
            return i;
        } catch (Exception e) {
            return i;
        } finally {
            i += 5;
        }
    }

    public static StringBuffer func2() {
        StringBuffer s =new StringBuffer("K");
        try {
            return s;
        } catch (Exception e) {
            return s;
        } finally {
            s.append("K");
        }
    }
}
