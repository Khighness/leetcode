package top.parak.Practice.Vivo;

/**
 * @author KHighness
 * @since 2021-05-22
 */

public class Fraction {
    /** 分子 */
    private int numerator;
    /** 分母 */
    private int denominator;
    /** 是否为正 */
    private boolean isPositive;

    /**
     * 构造函数
     * @param numerator 分子
     * @param denominator 分母
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0)
            throw new IllegalArgumentException("Denominator cannot be zero");
        this.denominator = denominator;
        processAfterUpdate();
    }

    /**
     * set the value of the numerator
     * @param numerator 分子
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * set the value of the denominator
     * @param denominator 分母
     */
    public void setDenominator(int denominator) {
        if (denominator == 0)
            throw new IllegalArgumentException("Denominator cannot be zero");
        this.denominator = denominator;
    }

    /**
     * get the value of the numerator
     * @return 分子
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * get the value of the denominator
     * @return 分母
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Convert fractions to double
     * @return 小数
     */
    public double toDouble() {
        double ans =  numerator * 1.0 / denominator;
        return isPositive ? ans : -1 * ans;
    }

    /**
     * Add this fraction to r's fraction
     * @param r 相加因子
     */
    public void plus(Fraction r) {
        setNumerator(this.getNumerator() * r.getDenominator() + this.getDenominator() * r.getNumerator());
        setDenominator(this.getDenominator() * r.getDenominator());
        processAfterUpdate();
    }

    /**
     * Subtract this fraction to r's fraction
     * @param r 相减因子
     */
    public void subtract(Fraction r) {
        setNumerator(this.getNumerator() * r.getDenominator() - this.getDenominator() * r.getNumerator());
        setDenominator(this.getDenominator() * r.getDenominator());
        processAfterUpdate();
    }

    /**
     * Multiply this fraction to r's fraction
     * @param r 相乘因子
     */
    public void multiply(Fraction r) {
        setNumerator(this.getNumerator() * r.getNumerator());
        setDenominator(this.getDenominator() * r.getDenominator());
        processAfterUpdate();
    }

    /**
     * This fraction divided by r's fraction
     * @param r 相除因子
     */
    public void divide(Fraction r) {
        setNumerator(this.getNumerator() * r.getDenominator());
        setDenominator(this.getDenominator() * r.getNumerator());
        processAfterUpdate();
    }

    /**
     * get the reciprocal of the fraction
     * <p>For example you will get -3/4 if the fraction is -4/3
     * @return 分数的倒数
     */
    public Fraction getReciprocal() {
        if (isPositive) return new Fraction(getDenominator(), getNumerator());
        else return new Fraction(-1 * getDenominator(), getNumerator());
    }

    /**
     * get the String of the fraction
     * <p>Representing fraction as a string like "1", "1/2" or "-3/4"
     * @return 分数的字符串
     */
    public String toString() {
        if (getNumerator() == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int n = Math.abs(getNumerator()), m = Math.abs(getDenominator());
        if (!isPositive) sb.append('-');
        if (m == 1)
            sb.append(n);
        else
            sb.append(n).append('/').append(m);
        return sb.toString();
    }

    /**
     * simply process after the update operation
     */
    private void processAfterUpdate() {
        int n = numerator, m = denominator;
        this.isPositive = n >= 0 && m >= 0;
        final int val = getMaxFactor(n, m);
        this.numerator /= val;
        this.denominator /= val;
    }

    /**
     * calculate the maximum common factor
     * @return 最大公因数
     */
    private int getMaxFactor(int n, int m) {
        int k = 0;
        // let n >= m
        if (n < m) {
            k = n; n = m; m = k;
        }
        while (m != 0) {
            if (n == m) {
                return n;
            } else {
                k = n % m;
                n = m;
                m = k;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(3, 4);
        System.out.println(f1);
        System.out.println(f1.toDouble());
        Fraction f2 = f1.getReciprocal();
        System.out.println(f2);
        Fraction f3 = new Fraction(1, 4);
        f1.plus(f3);
        System.out.println(f1);
        Fraction f4 = new Fraction(2, 4);
        System.out.println(f4.getDenominator());
    }
}
