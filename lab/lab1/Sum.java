public class Sum {
    public static void main(String[] args) {
        System.out.println("Sum up all the command-line arguments (assuming they are all integers)");

        int s = 0;
        for (int i = 0; i < args.length; i++) {
            s += Integer.parseInt(args[i]);
        }
        System.out.println(s);
    }
}