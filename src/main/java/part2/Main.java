package part2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        HashingMode hm = HashingMode.STRINGS_QUADRATIC_PROBING;
        OpenAddressingHashTable oaht = new OpenAddressingHashTable(29, hm);
        oaht.put("acc");
        oaht.put("abc");
//        oaht.remove("acc"); //удаление элемента
        System.out.println(Arrays.toString(oaht.getData()));
//        String getted = oaht.get("acc");
//        System.out.println(getted);
    }
}
