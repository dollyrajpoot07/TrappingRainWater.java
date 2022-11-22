// Trapping Rain Water
// Given an array of N non-negative integers arr[] representing an elevation map where the width of each bar 
// is 1, compute how much water it is able to trap after raining.

// Examples:  
// Input: arr[] = {2, 0, 2}
// Output: 2
// Explanation: The structure is like below.
// We can trap 2 units of water in the middle gap.

// Input: arr[]   = {3, 0, 2, 0, 4}
// Output: 7
// Explanation: Structure is like below.
// We can trap “3 units” of water between 3 and 2,
// “1 unit” on top of bar 2 and “3 units” between 2 and 4.

// Input: arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
// Output: 6
// Explanation: The structure is like below.
// Trap “1 unit” between first 1 and 2, “4 units” between
// first 2 and 3 and “1 unit” between second last 1 and last 2

public class TrappingRainWater {

    public static int maxWater(int arr[], int n) {
        int size = n - 1;
        int prev = arr[0];

        int prev_index = 0;
        int water = 0;

        int temp = 0;
        for (int i = 1; i <= size; i++) {

            if (arr[i] >= prev) {
                prev = arr[i];
                prev_index = i;

                temp = 0;
            } else {

                water += prev - arr[i];

                temp += prev - arr[i];
            }
        }

        if (prev_index < size) {

            water -= temp;

            prev = arr[size];

            for (int i = size; i >= prev_index; i--) {

                if (arr[i] >= prev) {
                    prev = arr[i];
                } else {
                    water += prev - arr[i];
                }
            }
        }

        return water;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int N = arr.length;
        System.out.print(maxWater(arr, N));
    }
}
