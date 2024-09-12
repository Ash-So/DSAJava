class Solution {
	public long maximumSubarraySum(int[] nums, int k) {
		Map<Integer, Long> map = new HashMap<>();
		Long ans = null;
		long prefixSum = 0;
		for (int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			int a = nums[i];
			int b1 = a + k, b2 = a - k;

			Long val = map.getOrDefault(b1, null);
			if (val != null) {
				ans = ans == null ? prefixSum - val + b1 : Math.max(ans, prefixSum - val + b1);
			}
			val = map.getOrDefault(b2, null);
			if (val != null) {
				ans = ans == null ? prefixSum - val + b2 : Math.max(ans, prefixSum - val + b2);
			}

			map.put(a, Math.min(prefixSum, map.getOrDefault(a, Long.MAX_VALUE)));

		}
		return ans == null ? 0 : ans;
	}
}