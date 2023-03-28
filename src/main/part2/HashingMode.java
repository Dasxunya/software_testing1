public enum HashingMode {
    STRINGS_LINEAR_PROBING(0),
    STRINGS_QUADRATIC_PROBING(1),
    STRINGS_DOUBLE_HASHING(2);

    private final int equal;

    HashingMode(int equal) {
        this.equal = equal;
    }

    public int getEqual() {
        return equal;
    }
}
