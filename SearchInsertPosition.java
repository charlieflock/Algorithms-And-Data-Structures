
package soln;

class SearchInsertPosition {
        public int searchInsert(int[] nums, int target){//of course, we coud just do a linear search, but that isn't optimal
        int left = 0;
        int right = nums.length - 1;
        
        //Considering edge cases
        if(nums.length == 0 || target < nums[left])
            return 0;
        else if (target > nums[right])
            return right + 1;
        
        //Now considering all other cases
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target)
                return mid;
            else if(target > nums[mid]){
                left = mid + 1;
                if(nums[left] > target) //Identifying if the target # was between mid & mid + 1
                    return left;
            }
            else{
                right = mid -1 ;     
                if(nums[right] < target) //Identifying if the target # was between mid & mid - 1
                    return mid; //(same as right + 1)
            }
        }
        throw new IllegalArgumentException("Flow of control should not have reached here");
    } 
}
