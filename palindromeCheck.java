class Solution {
    
  public boolean palindromeCheck(String s) {
    // your code goes here
    int n = s.length();
    return palindrome(s, 0, n - 1);
  }

  public boolean palindrome(String s, int left, int right) {

    if (left >= right) return true;

    if (s.charAt(left) != s.charAt(right)) {
      return false;
    }

    return palindrome(s, left + 1, right - 1);
  }
}
