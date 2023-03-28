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

        double get_sin = sin(x, eps / 1000);
        double get_cos = cos(x, eps / 1000);
        return get_sin / get_cos;
    }

    public static double sin(double x, double epsilon) {
        double result = 0;
        double term = x;
        int n = 1;
        while (Math.abs(term) >= epsilon) {
            result += term;
            term = -term * x * x / (2 * n) / (2 * n + 1);
            n++;
        }
        return result;
    }

    public static double cos(double x, double epsilon){
        double term = 1.0;
        double sum = 0.0;
        int i = 0;
        while (Math.abs(term) > epsilon) {
            term = Math.pow(-1, i) * Math.pow(x, 2 * i) / factorial(2 * i);
            sum += term;
            i++;
        }
        return sum;
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

//    public static double tangent(double x, double eps) {
//        if (Math.abs(x) >= Math.PI / 2) {
//            throw new UnsupportedOperationException("x должен удовлетворять условию: abs(x) <= PI / 2");
//        }
//
//        if (eps >= 1 || eps <= 0) {
//            throw new UnsupportedOperationException("Проверьте заданную точность (eps), ее значение не должно выходить за промежуток [0;1]");
//        }
//
//        double res = 0.0;
//        double prev = res;
//        if (x == 0) return res;
//
//        for (double n = 1.0; n == 1.0 || Math.abs(Math.abs(res) - Math.abs(prev)) > eps; n = n + 1.0) {
//            prev = res;
//            res = res + ((getBernulli(n * 2) * Math.pow(-4, n) * (1 - Math.pow(4, n))) / (getFactorial(2 * n))) * Math.pow(x, 2 * n - 1);
//        }
//        return res;
//    }
//
    //FIXME: rewrite without recursive and will be done
//    public static double getBernulli(double n) {
//        double getted_bernulli, bernulli, sum = 0.0;
//
//        if (n == 0) {
//            return 1.0;
//        } else if (n == 1) {
//            bernulli = -1.0 / 2.0;
//            return bernulli;
//        } else if (n % 2 != 0) {
//            return 0.0;
//        }
//
//        double coeff = -(1.0 / (n + 1.0));
//
//        /*подсчет суммы произведений для числа бернулли*/
//        for (int k = 0; k < n; k++) {
//            double c = getFactorial(n + 1) / (getFactorial(k) * getFactorial(n + 1 - k));
//
//
//            getted_bernulli = getBernulli(k);
//            sum += c * getted_bernulli;
//        }
//        bernulli = coeff * sum;
//        return bernulli;
//    }
//
//
//    private static double getFactorial(double f) {
//        if (f == 0) return 1.0;
//        double result = 1.0;
//        for (int i = 1; i <= f; i++) {
//            result = result * i;
//        }
//        return result;
//    }
}