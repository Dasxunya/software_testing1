package part2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OpenAddressingHashTableTest {
    private static final int arraySize = 29;
    int position;
    HashingMode hm1 = HashingMode.STRINGS_LINEAR_PROBING; //0th mode
    HashingMode hm2 = HashingMode.STRINGS_QUADRATIC_PROBING; //1st mode

    @Test
    @DisplayName("Test adding data in hashTable")
    void put() {
        /*putting <size> different values in 0th, 1st and 2nd modes*/
        OpenAddressingHashTable oaht1 = new OpenAddressingHashTable(arraySize, hm1);

        oaht1.put("a");
        oaht1.put("b");
        oaht1.put("c");
        oaht1.put("d");
        oaht1.put("e");
        oaht1.put("f");
        oaht1.put("g");
        oaht1.put("h");
        oaht1.put("j");
        oaht1.put("k");
        oaht1.put("l");
        oaht1.put("m");
        oaht1.put("n");
        oaht1.put("o");
        oaht1.put("p");
        oaht1.put("q");
        oaht1.put("r");
        oaht1.put("s");
        oaht1.put("t");
        oaht1.put("u");
        oaht1.put("v");
        oaht1.put("w");
        oaht1.put("x");
        oaht1.put("y");
        oaht1.put("z");
        oaht1.put("it");
        oaht1.put("ma");
        oaht1.put("m");
        oaht1.put("c");


        //проверили что при подаче разных значений нашли место каждому и в массиве присутствия
        // элемента на опр. позиции все места = 1 --> их сумма равна размеру массива
        int actualSum1 = Arrays.stream(oaht1.getProbes()).sum();

        /*putting <size> identical without collision values in 0th, 1st and 2nd modes (change mode in 15-17 lines)*/
        OpenAddressingHashTable oaht2 = new OpenAddressingHashTable(arraySize, hm1);
        oaht2.clearProbes();
        oaht2.clearData();
        oaht2.put("a");
        for (int i = 0; i < oaht2.getProbes().length; i++) {
            if (oaht2.getProbes()[i] != 0) {
                position = i;
                break;
            }
        }
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");
        oaht2.put("a");

        int aCounts = oaht2.getProbes()[position];
        String aValue = oaht2.getData()[position];

        /*putting <size> identical with collision values in 0th, 1st and 2nd modes (change mode in 15-17 lines)*/
        OpenAddressingHashTable oaht3 = new OpenAddressingHashTable(arraySize, hm1);
        oaht3.put("acc");
        oaht3.put("abc");
        oaht3.put("c");
        oaht3.put("rdc");
        oaht3.put("ac");
        oaht3.put("bc");
        oaht3.put("cc");
        oaht3.put("dc");
        oaht3.put("ec");
        oaht3.put("fc");
        oaht3.put("gc");
        oaht3.put("hc");
        oaht3.put("ic");
        oaht3.put("jc");
        oaht3.put("kc");
        oaht3.put("lc");
        oaht3.put("mc");
        oaht3.put("nc");
        oaht3.put("oc");
        oaht3.put("pc");
        oaht3.put("qc");
        oaht3.put("rc");
        oaht3.put("sc");
        oaht3.put("tc");
        oaht3.put("uc");
        oaht3.put("vc");
        oaht3.put("wc");
        oaht3.put("xc");
        oaht3.put("yc");

        int actualSum3 = Arrays.stream(oaht3.getProbes()).sum();

        /*too many values*/
        OpenAddressingHashTable oaht4 = new OpenAddressingHashTable(arraySize, hm1);
        oaht4.put("acc");
        oaht4.put("abc");
        oaht4.put("c");
        oaht4.put("rdc");
        oaht4.put("ac");
        oaht4.put("bc");
        oaht4.put("cc");
        oaht4.put("dc");
        oaht4.put("ec");
        oaht4.put("fc");
        oaht4.put("gc");
        oaht4.put("hc");
        oaht4.put("ic");
        oaht4.put("jc");
        oaht4.put("kc");
        oaht4.put("lc");
        oaht4.put("mc");
        oaht4.put("nc");
        oaht4.put("oc");
        oaht4.put("pc");
        oaht4.put("qc");
        oaht4.put("rc");
        oaht4.put("sc");
        oaht4.put("tc");
        oaht4.put("uc");
        oaht4.put("vc");
        oaht4.put("wc");
        oaht4.put("xc");
        oaht4.put("yc");


        /*checking*/
        assertEquals(arraySize, actualSum1, "вставка 29 различных значений");

        assertEquals(arraySize, aCounts, "вставка 29 одинаковых значений без коллизий");
        assertEquals("a", aValue, "проверка значения в массиве значений на позиции, выданной 'а'");
        assertEquals(arraySize, actualSum3, "вставка 29 разных значений с коллизиями");

        UnsupportedOperationException tooMany = assertThrows(UnsupportedOperationException.class, () ->
                oaht4.put("fgc"));
        assertTrue(tooMany.getMessage().contains("Hash table is full"));

    }

    @Test
    @DisplayName("Test getting data from hashTable")
    void get() {

        OpenAddressingHashTable oaht1 = new OpenAddressingHashTable(arraySize, hm1);
        oaht1.put("a");
        oaht1.put("b");
        oaht1.put("c");
        oaht1.put("d");
        String getted1 = oaht1.get("c");

        OpenAddressingHashTable oaht2 = new OpenAddressingHashTable(arraySize, hm1);
        oaht2.put("ac");
        oaht2.put("ebc");
        oaht2.put("dc");
        oaht2.put("adc");
        String getted2 = oaht2.get("dc");

        OpenAddressingHashTable oaht3 = new OpenAddressingHashTable(arraySize, hm1);
        oaht3.put("acc");
        oaht3.put("abc");
        oaht3.put("c");
        oaht3.put("rdc");
        oaht3.put("ac");
        oaht3.put("bc");
        oaht3.put("cc");
        oaht3.put("dc");
        oaht3.put("ec");
        oaht3.put("fc");
        oaht3.put("gc");
        oaht3.put("hc");
        oaht3.put("ic");
        oaht3.put("jc");
        oaht3.put("kc");
        oaht3.put("lc");
        oaht3.put("mc");
        oaht3.put("nc");
        oaht3.put("oc");
        oaht3.put("pc");
        oaht3.put("qc");
        oaht3.put("rc");
        oaht3.put("sc");
        oaht3.put("tc");
        oaht3.put("uc");
        oaht3.put("vc");
        oaht3.put("wc");
        oaht3.put("xc");
        oaht3.put("yc");
        String getted3 = oaht3.get("rdc");

        assertEquals("c", getted1, "слегка заполненый массив без коллизий");
        assertEquals("dc", getted2, "слегка заполненый массив с коллизиями");
        assertEquals("rdc", getted3, "целиком заполненый массив с коллизиями");

    }

    @Test
    void remove() {
        OpenAddressingHashTable oaht1 = new OpenAddressingHashTable(arraySize, hm1);
        oaht1.put("a");
        oaht1.put("b");
        oaht1.put("c");
        oaht1.put("d");
        oaht1.remove("c");
        boolean contained1 = Arrays.asList(oaht1.getData()).contains("c");

        OpenAddressingHashTable oaht2 = new OpenAddressingHashTable(arraySize, hm1);
        oaht2.put("ac");
        oaht2.put("ebc");
        oaht2.put("dc");
        oaht2.put("adc");
        oaht2.remove("ebc");
        boolean contained2 = Arrays.asList(oaht2.getData()).contains("c");

        OpenAddressingHashTable oaht3 = new OpenAddressingHashTable(arraySize, hm1);
        oaht3.put("acc");
        oaht3.put("abc");
        oaht3.put("c");
        oaht3.put("rdc");
        oaht3.put("ac");
        oaht3.put("bc");
        oaht3.put("cc");
        oaht3.put("dc");
        oaht3.put("ec");
        oaht3.put("fc");
        oaht3.put("gc");
        oaht3.put("hc");
        oaht3.put("ic");
        oaht3.put("jc");
        oaht3.put("kc");
        oaht3.put("lc");
        oaht3.put("mc");
        oaht3.put("nc");
        oaht3.put("oc");
        oaht3.put("pc");
        oaht3.put("qc");
        oaht3.put("rc");
        oaht3.put("sc");
        oaht3.put("tc");
        oaht3.put("uc");
        oaht3.put("vc");
        oaht3.put("wc");
        oaht3.put("xc");
        oaht3.put("yc");
        oaht3.remove("rdc");
        boolean contained3 = Arrays.asList(oaht3.getData()).contains("rdc");

        assertFalse(contained1);
        assertFalse(contained2);
        assertFalse(contained3);
    }


    @Test
    @DisplayName("Mode testing")
    public void enumModeTesting() {
        assertEquals(0, hm1.getEqual());
        assertEquals(1, hm2.getEqual());
    }

    @Test
    @DisplayName("Unique methods testing")
    public void otherTesting() {
        OpenAddressingHashTable oaht1 = new OpenAddressingHashTable(arraySize, hm2);

        oaht1.put("a");
        oaht1.put("abc");

        int actualSum1 = Arrays.stream(oaht1.getProbes()).sum();
        String getted1 = oaht1.get("abc");
        oaht1.remove("abc");
        int actualSum2 = Arrays.stream(oaht1.getProbes()).sum();

        /**/
        assertEquals(2, actualSum1);
        assertEquals("abc", getted1);
        assertEquals(1, actualSum2);
        /**/

        OpenAddressingHashTable oaht2 = new OpenAddressingHashTable(arraySize, hm1);

        oaht2.put("a");
        oaht2.put("abc");

        int actualSum21 = Arrays.stream(oaht2.getProbes()).sum();
        String getted2 = oaht2.get("abc");
        oaht2.remove("abc");
        int actualSum22 = Arrays.stream(oaht2.getProbes()).sum();

        /**/
        assertEquals("abc", getted2);
        assertEquals(2, actualSum21);
        assertEquals(1, actualSum22);
        /**/
    }

    @Test
    @DisplayName("Check null return")
    public void nullTesting(){
        OpenAddressingHashTable oaht3 = new OpenAddressingHashTable(arraySize, hm1);
        oaht3.put("acc");
        oaht3.put("abc");
        oaht3.put("c");
        oaht3.put("rdc");
        oaht3.put("ac");
        oaht3.put("bc");
        oaht3.put("cc");
        oaht3.put("dc");
        oaht3.put("ec");
        oaht3.put("fc");
        oaht3.put("gc");
        oaht3.put("hc");
        oaht3.put("ic");
        oaht3.put("jc");
        oaht3.put("kc");
        oaht3.put("lc");
        oaht3.put("mc");
        oaht3.put("nc");
        oaht3.put("oc");
        oaht3.put("pc");
        oaht3.put("qc");
        oaht3.put("rc");
        oaht3.put("sc");
        oaht3.put("tc");
        oaht3.put("uc");
        oaht3.put("vc");
        oaht3.put("wc");
        oaht3.put("xc");
        oaht3.put("yc");

        String gettedValue = oaht3.get("adf");
        assertNull(gettedValue);
    }
}