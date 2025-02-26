//## Problem2 Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach in three sentences only
// approach: by nature when you divide a roatted array at any point, atleast one side of the 2 pieces is sorted. We will try to identify if the target is between the sorted array. if it is then the search is moved to the sorted side. otherwise the other side.


class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length==0)
        {
            return -1;
        }
        int low =0;
        int high = nums.length-1;
        int mid;

        while(low<=high)
        {
            mid =low + (high-low)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(nums[low]<= nums[mid])
            {
                if(nums[low]<=target && nums[mid]>=target)
                {
                    high = mid-1;
                }
                else
                {
                    low = mid+1;
                }
            }
            else
            {
                if(nums[mid]<=target && nums[high]>=target)
                {
                    low=mid+1;
                }
                else
                {
                    high =mid-1;
                }
            }
        }
        return -1;
    }
}