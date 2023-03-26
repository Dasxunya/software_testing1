import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TanFunctionTest {

    @Test
    @DisplayName("The Java library function was taken as a standard")
    void tangentTest() {
        /*Check positive and negative equals*/
        assertEquals(Math.tan(1), TanFunction.tangent(1, 0.0001), 0.0001);
        assertEquals(Math.tan(-1), TanFunction.tangent(-1, 0.0001), 0.0001);

        /*Check centre*/
        assertEquals(Math.tan(0), TanFunction.tangent(0, 0.0001), 0.0001);

        /*Big (+)&(-) equals next to PI / 2*/
        assertEquals(Math.tan(Math.PI / 2 - 0.01), TanFunction.tangent(Math.PI / 2 - 0.01, 0.001), 0.001);
        assertEquals(Math.tan(-(Math.PI / 2) + 0.01), TanFunction.tangent(-(Math.PI / 2) + 0.01, 0.001), 0.001);

        /*Something from Double*/
        assertEquals(Math.tan(0.5786), TanFunction.tangent(0.5786, 0.0001), 0.0001);
        assertEquals(Math.tan(-0.5786), TanFunction.tangent(-0.5786, 0.0001), 0.0001);

        /*Next to 0*/
        assertEquals(Math.tan(0.00001), TanFunction.tangent(0.00001, 0.000001), 0.000001);
        assertEquals(Math.tan(-0.00001), TanFunction.tangent(-0.00001, 0.000001), 0.000001);
    }

    @Test
    @DisplayName("Test for epsilon value")
    void epsTest() {
        double getTanFromPos = TanFunction.tangent(0.276, 0.001);
        assertEquals(Math.tan(0.276), getTanFromPos, 0.0000001);
        assertEquals(Math.tan(0.276), getTanFromPos, 0.001);
        assertEquals(Math.tan(0.276), getTanFromPos, 0.01);
        assertEquals(Math.tan(0.276), getTanFromPos, 0.1);

        double getTanFromNeg = TanFunction.tangent(-0.937, 0.001);
        assertEquals(Math.tan(-0.937), getTanFromNeg, 0.0000001);
        assertEquals(Math.tan(-0.937), getTanFromNeg, 0.001);
        assertEquals(Math.tan(-0.937), getTanFromNeg, 0.01);
        assertEquals(Math.tan(-0.937), getTanFromNeg, 0.1);
    }

    @Test
    @DisplayName("Throws testing for x values")
    void throwXTest() {
        UnsupportedOperationException heightX = assertThrows(UnsupportedOperationException.class, () -> TanFunction.tangent(Math.PI / 2, 0.001));
        UnsupportedOperationException lowX = assertThrows(UnsupportedOperationException.class, () -> TanFunction.tangent(-Math.PI / 2, 0.001));
        UnsupportedOperationException moreGap = assertThrows(UnsupportedOperationException.class, () -> TanFunction.tangent(4, 0.001));
        UnsupportedOperationException lessGap = assertThrows(UnsupportedOperationException.class, () -> TanFunction.tangent(-4, 0.001));

        assertTrue(heightX.getMessage().contains("x должен удовлетворять условию: abs(x) <= PI / 2"));
        assertTrue(lowX.getMessage().contains("x должен удовлетворять условию: abs(x) <= PI / 2"));
        assertTrue(moreGap.getMessage().contains("x должен удовлетворять условию: abs(x) <= PI / 2"));
        assertTrue(lessGap.getMessage().contains("x должен удовлетворять условию: abs(x) <= PI / 2"));
    }

    @Test
    @DisplayName("Throws testing for epsilon values")
    void throwEpsTest() {
        UnsupportedOperationException heightEps = assertThrows(UnsupportedOperationException.class, () -> TanFunction.tangent(0.347, 0));
        UnsupportedOperationException lowEps = assertThrows(UnsupportedOperationException.class, () -> TanFunction.tangent(0.347, 1));
        UnsupportedOperationException moreGap = assertThrows(UnsupportedOperationException.class, () -> TanFunction.tangent(0.347, 1.00000001));
        UnsupportedOperationException lessGap = assertThrows(UnsupportedOperationException.class, () -> TanFunction.tangent(0.347, -0.0000001));

        assertTrue(heightEps.getMessage().contains("Проверьте заданную точность (eps), ее значение не должно выходить за промежуток [0;1]"));
        assertTrue(lowEps.getMessage().contains("Проверьте заданную точность (eps), ее значение не должно выходить за промежуток [0;1]"));
        assertTrue(moreGap.getMessage().contains("Проверьте заданную точность (eps), ее значение не должно выходить за промежуток [0;1]"));
        assertTrue(lessGap.getMessage().contains("Проверьте заданную точность (eps), ее значение не должно выходить за промежуток [0;1]"));
    }
}