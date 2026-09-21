class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] arr = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        // Merge both arrays
        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] < nums2[j]) {
                arr[k] = nums1[i];
                i++;
            } else {
                arr[k] = nums2[j];
                j++;
            }

            k++;
        }

        // Remaining elements of nums1
        while (i < nums1.length) {
            arr[k] = nums1[i];
            i++;
            k++;
        }

        // Remaining elements of nums2
        while (j < nums2.length) {
            arr[k] = nums2[j];
            j++;
            k++;
        }

        int n = arr.length;

        // Odd length
        if (n % 2 != 0) {
            return arr[n / 2];
        }

        // Even length
        return (arr[n / 2 - 1] + arr[n / 2]) / 2.0;
    }
}