public class OffByN implements CharacterComparator {
    private  int n;     // difference

    public OffByN(int N) {
        n = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int d = x - y;
        return Math.abs(d) == n;
    }
}
