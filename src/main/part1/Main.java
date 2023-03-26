package part1;

public class Main {
    public static void main(String[] args) {
        double x = 1;
        double eps = 0.0001;
        double res = TanFunction.tangent(x, eps);
        System.out.println(res);
    }
}


