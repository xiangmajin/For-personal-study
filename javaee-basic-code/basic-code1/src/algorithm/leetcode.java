package algorithm;

class Solution {
    public static void main(String[] args) {

    }
    public int removeElement(int[] nums, int val) {
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                k++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i+1>=nums.length) break;
            if(nums[i]==val){
                nums[i]=nums[i+1];
                nums[i+1]=val;
            }
        }
        return k;
    }
}