public class Main {
    public static void main(String[] args) {
        HashingMode hm = HashingMode.STRINGS_QUADRATIC_PROBING;
        OpenAddressingHashTable oaht = new OpenAddressingHashTable(29, hm);
        oaht.put("acc");
        oaht.put("abc");
    }
}
