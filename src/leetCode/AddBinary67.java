package leetCode;

public class AddBinary67 {

    public static void main(String[] args) {
        //https://leetcode.com/problems/add-binary/
        // Given two binary strings a and b, return their sum as a binary string.
        String a = "111101", b = "1011";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {

        // 111101
        //   1011
        //----------
        //1001000
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
