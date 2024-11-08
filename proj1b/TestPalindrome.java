import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //this class once you've created your Palindrome class.

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("abcba"));
        assertFalse(palindrome.isPalindrome("aA"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(" "));
    }

    @Test
    public void testIsPalindrome2() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("abcba", cc));
        assertFalse(palindrome.isPalindrome("aA", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome(" ", cc));
    }

    @Test
    public void testOffByN() {
        CharacterComparator c = new OffByN(2);
        assertTrue(c.equalChars('a', 'c'));
        assertTrue(c.equalChars('c', 'a'));
        assertFalse(c.equalChars('a', 'b'));
    }

}
