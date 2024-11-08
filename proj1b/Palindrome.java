public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    private boolean helper(Deque<Character> d) {
        while (d.size() >= 2) {
            if (d.removeFirst() != d.removeLast()) {
                return false;
            } else {
                return helper(d);
            }
        }
        return true;
    }

    private boolean helper2(Deque<Character> d, CharacterComparator cc) {
        while (d.size() >= 2) {
            if (!cc.equalChars(d.removeFirst(), d.removeLast())) {
                return false;
            } else {
                return helper2(d, cc);
            }
        }
        return true;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> d = wordToDeque(word);
        return helper(d);
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d = wordToDeque(word);
        return helper2(d, cc);
    }
}
