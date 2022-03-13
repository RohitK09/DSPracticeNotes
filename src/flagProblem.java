class Solution1 {
    public void sortColors(int[] nums) {
        int p0 = 0; //boundary of zero
        int end = nums.length-1;
        int curr = 0;
        
        while(curr<= end) { // stop after we have reached 2 from the end 
            if(nums[curr] == 0) {
                swap(p0,curr,nums);
                curr++;
                p0++;
            }  
            else if(nums[curr] ==2) {
                swap(curr,end,nums);
                end--;
            }else {
                curr++;
            }
        }
    }
    private void swap(int a, int b, int[] arr) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
}