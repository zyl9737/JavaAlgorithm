package me.icemoon.leetcodeweek;

/**
 * @author Yulong
 * @create 2025/4/13
 * @description 3514.不同XOR三元组的数目II
 */
public class double154_03 {
    public static int uniqueXorTriplets(int[] nums) {
        int mx = 0;
        for (int num : nums) {
            mx = Math.max(mx, num);
        }
        int u = 1 << (32 - Integer.numberOfLeadingZeros(mx));
        boolean[] has = new boolean[u];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                has[nums[i] ^ nums[j]] = true;
            }
        }
        boolean[] has3 = new boolean[u];
        for (int xy = 0; xy < u; xy++) {
            if (!has[xy]) continue;
            for (int z : nums) {
                has3[xy ^ z] = true;
            }
        }
        int ans = 0;
        for (boolean b : has3) {
            if (b) ans++;
        }
       return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3};
        System.out.println(uniqueXorTriplets(nums));
    }
}
