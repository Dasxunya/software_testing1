import java.util.Arrays;
import java.lang.Override;

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
        System.out.println(hash);

        int index = hash % size;
        int started_index = index;
        int i = 0;
        while (data[index] != null && !data[index].equals(key)) {
            i++;
            index = switch (this.hashingMode) {
                case STRINGS_LINEAR_PROBING -> (index + i) % size;
                case STRINGS_QUADRATIC_PROBING -> (started_index + i * i) % size;
                case STRINGS_DOUBLE_HASHING -> (started_index + i * hash2(key)) % size;
            };

            if (i == size) {
                throw new RuntimeException("Hash table is full");
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
                case STRINGS_LINEAR_PROBING -> (index + i) % size;
                case STRINGS_QUADRATIC_PROBING -> (started_index + i * i) % size;
                case STRINGS_DOUBLE_HASHING -> (started_index + i * hash2(key)) % size;
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
                case STRINGS_LINEAR_PROBING -> (index + i) % size;
                case STRINGS_QUADRATIC_PROBING -> (started_index + i * i) % size;
                case STRINGS_DOUBLE_HASHING -> (started_index + i * hash2(key)) % size;
            };
            if (i == size) {
                return;
            }
        }
        data[index] = null;
        probes[index] = 0;
    }


    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash * 29 + key.charAt(i)) % size;
        }
        return hash;
    }

    private int hash2(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + key.charAt(i)) % size;
        }
        return hash;
    }

    public int[] getProbes() {
        return probes;
    }

    public void clearProbes() {
        Arrays.fill(probes, 0);
    }
}