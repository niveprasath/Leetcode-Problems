class Solution {
    public int majorityElement(int[] nums) {
     int n = nums.length;
     int count =0;
     int can=0;
     for(int i=0;i<n;i++) {
        if(count==0){
            can=nums[i];
        }
        if(can==nums[i]){
            count++;
        }
        else{
            count--;
        }
     }   
     return can;
    }
}