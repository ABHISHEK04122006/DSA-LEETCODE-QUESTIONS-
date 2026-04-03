class Solution {
List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
       helper(0,nums, new ArrayList<>());
        return res;   
    }
    public void helper(int i , int[] nums , List<Integer> sublist){
        if(i==nums.length){
            res.add(new ArrayList<>(sublist));
            return;
        }
        sublist.add(nums[i]);
        helper(i+1,nums,sublist);
        sublist.remove(sublist.size() - 1);
        helper(i+1, nums , sublist);
    }
}