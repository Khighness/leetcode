/**
 * <p> Project: Algorithm </P>
 * <p> Package: PACKAGE_NAME </p>
 * <p> FileName: Test3 <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/26
 */

public class Test3 {
    public static void main(String[] args) {
        func1();
        func2();
    }

    public static void func1() {
        System.out.println(5);
        Integer integer1 = 5;
        Integer integer2 = Integer.valueOf("5");
        Integer integer3 = Integer.parseInt("5");
        Integer integer4 = new Integer(5);

        System.out.println("integer1 == integer2 : " + (integer1 == integer2) );
        System.out.println("integer1 == integer3 : " + (integer1 == integer3) );
        System.out.println("integer1 == integer4 : " + (integer1 == integer4) );
    }

    public static void func2() {
        System.out.println(130);
        Integer integer1 = 130;
        Integer integer2 = Integer.valueOf("130");
        Integer integer3 = Integer.parseInt("130");
        Integer integer4 = new Integer(130);

        System.out.println("integer1 == integer2 : " + (integer1 == integer2) );
        System.out.println("integer1 == integer3 : " + (integer1 == integer3) );
        System.out.println("integer1 == integer4 : " + (integer1 == integer4) );
    }
}
