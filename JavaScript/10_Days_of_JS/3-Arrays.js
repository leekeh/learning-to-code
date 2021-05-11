/**
*   Return the second largest number in the array.
*   @param {Number[]} nums - An array of numbers.
*   @return {Number} The second largest number in the array.
**/
function getSecondLargest(nums) {
    
    //find the largest value
    let largest = nums[0];
    let largesti = 0;
    for (var i = 0; i < nums.length; i++){
        if (nums[i] > largest) {
            largest = nums[i];
            largesti = i;
        }
    }
    
    //remove instances of largest value
    for (var i=0; i < nums.length; i++) {
        if (nums[i]==largest) {
            nums.splice(i, 1);
            i--;
        }
    }
    
    //find and return the largest remaining value
    let secondLargest = nums[0];
    for (var i=0; i < nums.length; i++) {
        if (nums[i] > secondLargest) {
            secondLargest = nums[i];
        }
    }
    
    return secondLargest;
    
}

