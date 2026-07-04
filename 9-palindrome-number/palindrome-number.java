// Solution by aryankpandey

class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are never palindrome
        if (x < 0) return false;

        // If number ends with 0, it can't be palindrome (except 0 itself)
        if (x != 0 && x % 10 == 0) return false;

        int reversedHalf = 0;

        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // For even length: x == reversedHalf
        // For odd length: x == reversedHalf/10
        return (x == reversedHalf || x == reversedHalf / 10);
    }
}