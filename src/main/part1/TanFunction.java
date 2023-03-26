package part1;

public class TanFunction {
    /**
     * Реализация функции тангенса как разложение в ряд тейлора
     */
    public static double tangent(double x, double eps) {
        if (Math.abs(x) >= Math.PI / 2) {
            throw new UnsupportedOperationException("x должен удовлетворять условию: abs(x) <= PI / 2");
        }

        if (eps >= 1 || eps <= 0) {
            throw new UnsupportedOperationException("Проверьте заданную точность (eps), ее значение не должно выходить за промежуток [0;1]");
        }

        double res = 0.0;
        double prev = res;
        if (x == 0) return res;

        for (int n = 1; n == 1 || Math.abs(res - prev) > eps; n++) {
            prev = res;
            res = res + (getBernulli(n * 2) * Math.pow(-4, n) * (1 - Math.pow(4, n))) / (getFactorial(2 * n));
        }
        return res;
    }

    private static double getBernulli(double n) {
        double getted_bernulli, bernulli, sum = 0.0;

        if (n == 0) return 1;
        if (n == 1) {
            bernulli = -1.0 / 2.0;
            return bernulli;
        } else if (n % 2 != 0) {
            return 0;
        }

        double coeff = -(1 / (n + 1));

        /*подсчет суммы произведений для числа бернулли*/
        for (int k = 0; k < n; k++) {
            double c = getFactorial(n + 1) / (getFactorial(k) * getFactorial(n + 1 - k));
            getted_bernulli = getBernulli(k);
            sum += c * getted_bernulli;
        }
        bernulli = coeff * sum;
        return bernulli;
    }


    private static double getFactorial(double f) {
        double result = 1.0;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }
}