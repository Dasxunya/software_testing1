package part2;

import java.util.Arrays;

public class OpenAddressingHashTable {

    private final String[] data;
    private final int[] probes;
    private final int size;

    private final HashingMode hashingMode;

    public OpenAddressingHashTable(int size, HashingMode hashingMode) {
        this.data = new String[size];
        this.probes = new int[size];
        this.size = size;
        this.hashingMode = hashingMode;
    }

    public void put(String key) {
        int hash = hash(key);

//        System.out.println(hash); //показать хэш ключа

        int index = hash % size;
        int started_index = index;
        int i = 0;
        while (data[index] != null && !data[index].equals(key)) {
            i++;
            index = switch (this.hashingMode) {
                case STRINGS_LINEAR_PROBING -> (started_index + i) % size;
                case STRINGS_QUADRATIC_PROBING -> (started_index + i * i) % size;
            };

            if (i == size) {
                System.out.println(Arrays.toString(data));
                throw new UnsupportedOperationException("Hash table is full");
            }
        }

        data[index] = key;
        probes[index]++;
    }

    public String get(String key) {
        int hash = hash(key);
        int index = hash % size;
        int i = 0;
        int started_index = index;

        while (data[index] != null && !data[index].equals(key)) {
            i++;
            index = switch (this.hashingMode) {
                case STRINGS_LINEAR_PROBING -> (started_index + i) % size;
                case STRINGS_QUADRATIC_PROBING -> (started_index + i * i) % size;
            };
            if (i == size) {
                return null;
            }
        }
        return data[index];
    }

    public void remove(String key) {
        int hash = hash(key);
        int index = hash % size;
        int i = 0;
        int started_index = index;

        while (data[index] != null && !data[index].equals(key)) {
            i++;
            index = switch (this.hashingMode) {
                case STRINGS_LINEAR_PROBING -> (started_index + i) % size;
                case STRINGS_QUADRATIC_PROBING -> (started_index + i * i) % size;
            };
            if (i == size) {
                return;
            }
        }
        data[index] = null;
        probes[index] = 0;
    }


    private int hash(String key) {
        int sum = 0b0;
        for (int i = 0; i < key.length(); i++) {
            if (i != 0){
                sum = sum * 16;
            }
            int binaryKey = Integer.parseInt(Integer.toBinaryString(key.charAt(key.length() - i - 1)), 2);
            sum = sum + binaryKey;
            System.out.println(sum);
        }
        int hash = sum;
        hash = hash % size;
        return hash;
    }

    public int[] getProbes() {
        return probes;
    }

    public String[] getData() {
        return data;
    }

    public void clearProbes() {
        Arrays.fill(probes, 0);
    }

    public void clearData() {
        Arrays.fill(data, null);
    }
}