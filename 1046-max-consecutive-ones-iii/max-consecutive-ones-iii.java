class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int i=0;
        int j=0;
        int curr_sum=0;
        int ans=0;
// edge case
         int Zero=0;
         for(int a=0;a<nums.length;a++)
         {
            if(nums[a]==0)
            Zero++;
         }
         if (Zero<k) return nums.length;
        while( j<n){
        curr_sum+=nums[j];
        if(j-i+1-curr_sum>k)
        {
            curr_sum-=nums[i];
            i++;

        }
        else if(j-i+1-curr_sum==k)
        {
            ans=Math.max(ans,j-i+1);
        }
        j++;
    }
     return ans;
}
 }