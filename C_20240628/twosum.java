import java.util.HashMap;

class TwoSum {
    public static int[] solution(int[] nums, int target) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];
            if (memo.containsKey(needed)) {
                return new int[] { memo.get(needed), i };
            }
            memo.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = solution(nums, target);
        if (result[0] != -1) {
            System.out.println("[" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No solution found.");
        }
    }
}
