public class IntList {
    int first;
    IntList rest;

    public IntList(int f, IntList intlist) {
        first = f;
        rest = intlist;
    }

    public int size() {
        int s = 0;

        if (this.rest == null) {
            return 1;
        } else {
            return 1 + this.rest.size();
        }
    }

    public int get(int k) {
        if (k == 0) {
            return this.first;
        } else {
            return this.rest.get(k - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println("test");

        IntList a = new IntList(1, null);
        a.rest = new IntList(2, null);

        System.out.println(a.get(0));
    }
}