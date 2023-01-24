// Implement fib which takes in an integer n and returns the nth Fibonacci number.
// The Fibonacci sequence is 0,1,1,2,3,5,8,13,21,....
public static int fib(int n) {
    if (n <= 2) {
        return n
    } else {
        return fib(n-1) + fib(n-2)
    }
}

public static int fib2(int n, int k, int f0, int f1) {
    if (n == k) {
        return f1
    } else {
        return fib2(n, k+1, f1, f0+f1)
    }
}
