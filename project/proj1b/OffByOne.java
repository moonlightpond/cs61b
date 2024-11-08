public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        int d = x - y;
        return Math.abs(d) == 1;
    }
}
