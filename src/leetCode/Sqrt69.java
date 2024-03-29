package leetCode;

public class Sqrt69 {
    // https://leetcode.com/problems/sqrtx/
    public static void main(String[] args) {
//        int x = 4;
//        int x = 16;
//        int x = 25;
        int x = 24;
//        int x = 36;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {

        if (x == 0 || x == 1) {
            return x;
        }
        int left = 0;
        int right = x;

        int currentMid;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            currentMid = x / mid;

            if (currentMid == mid) {
                // sqrt found
                return mid;
            } else if (currentMid < mid) {
                // sqrt value is left side of current mid, so decrease right
                right = mid - 1;
            } else {
                // sqrt value is right side of current mid, so increase left
                left = mid + 1;
            }

        }
        return right;
    }
}
