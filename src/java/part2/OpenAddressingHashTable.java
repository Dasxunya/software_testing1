package part2;

import java.util.Arrays;

public class OpenAddressingHashTable {

    private String[] data;
    private int[] probes;
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
                case STRINGS_DOUBLE_HASHING -> (started_index + i * hash2(key)) % size;
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
                case STRINGS_DOUBLE_HASHING -> (started_index + i * hash2(key)) % size;
            };
            if (i == size) {
                return null;
            }
        }
        return data[index];
    }

    public String remove(String key) {
        int hash = hash(key);
        int index = hash % size;
        int i = 0;
        int started_index = index;

        while (data[index] != null && !data[index].equals(key)) {
            i++;
            index = switch (this.hashingMode) {
                case STRINGS_LINEAR_PROBING -> (started_index + i) % size;
                case STRINGS_QUADRATIC_PROBING -> (started_index + i * i) % size;
                case STRINGS_DOUBLE_HASHING -> (started_index + i * hash2(key)) % size;
            };
            if (i == size) {
                return key;
            }
        }
        data[index] = null;
        probes[index] = 0;
        return key;
    }


    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash * 29 + key.charAt(i)) % size;
        }
        return hash;
    }

    private int hash2(String key) {
        /*вторая хэш-функция для определения смещения при разрешении коллизий*/
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + key.charAt(i)) % size;
        }
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