package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/25 20:08
 * @apiNote 627. 性别反转
 */

/**
 * Problem:
 * 给定一个 salary 表，如下所示，有 m = 男性 和 f = 女性 的值。交换所有的 f 和 m 值（例如，将所有 f 值更改为 m，反之亦然）。要求只使用一个更新（Update）语句，并且没有中间的临时表。
 *
 * 例如：
 * | id | name | sex | salary |
 * |----|------|-----|--------|
 * | 1  | A    | m   | 2500   |
 * | 2  | B    | f   | 1500   |
 * | 3  | C    | m   | 5500   |
 * | 4  | D    | f   | 500    |
 *
 * 运行你所编写的更新语句之后，将会得到以下表:
 * | id | name | sex | salary |
 * |----|------|-----|--------|
 * | 1  | A    | f   | 2500   |
 * | 2  | B    | m   | 1500   |
 * | 3  | C    | f   | 5500   |
 * | 4  | D    | m   | 500    |
 *
 */

public class T627 {

    /**
     * CASE...WHEN
     */
    private static String SQL1 =
            "UPDATE salary SET" +
            "    sex = CASE sex" +
            "        WHEN 'm' THEN 'f'" +
            "        ELSE 'm'" +
            "    END;";

    /**
     * IF()
     */
    private static String SQL2 =
            "update salary set sex=IF(sex='f','m','f')";

    /**
     * CHAR
     */
    private static String SQL3 =
            "update salary set sex = char(ascii('m') + ascii('f') - ascii(sex))";

}
