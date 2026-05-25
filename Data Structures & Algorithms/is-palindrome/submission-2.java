class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() < 2) {
            return true;
        } 

        //convert to char array
        char[] arr = s.toCharArray();

        // left adn right pointers
        int left = 0;
        int right = arr.length - 1;

        // while loop
        while (left < right) {
            // check if arr[left] is letter or digit 
            while (left < right && !Character.isLetterOrDigit(arr[left])) {
                left++;
            }
            // check if arr[right] is letter or digit
            while (left < right && !Character.isLetterOrDigit(arr[right])) {
                right--;
            }

            // check if arr[left] != arr[right]
            if (Character.toLowerCase(arr[left]) != Character.toLowerCase(arr[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
