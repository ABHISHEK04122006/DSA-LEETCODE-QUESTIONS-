class Solution {
    public int removeDuplicates(int[] nums) {
        int c = 2;
         int n = nums.length;
         if (n <= 2) return n;  
       
        for(int i= 2;i<n;i++){
            if(nums[i] != nums[c-2]){
             nums[c]=nums[i];
          c++;
            }
        }
        return c;
    }
}