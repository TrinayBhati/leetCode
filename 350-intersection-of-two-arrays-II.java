class Solution { 

    // approach using arrays tho it's not optimal

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0; int j = 0 ; int k = 0;

        int result[] = new int[Math.min(nums1.length, nums2.length)];
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]){
                result[k] = nums1[i];
            }
            else if(nums1[i] < nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        return Arrays.copyOfRange(result , 0 , k); // this copies the values in result array
    }
}

//=========================================================================================

// Sort both input arrays nums1 and nums2.
// Initialize three pointers i, j and k to 0.
// Use a while loop to iterate through both arrays as long as i is less than the length of nums1 and j is less than the length of nums2.
// Compare the elements at the current positions of the pointers i and j for both arrays.
// If they are equal, add that element to the result array and increment the pointers i, j and k.
// If the element at the pointer i of the first array is less than the element at the pointer j of the second array, increment the pointer i.
// If the element at the pointer i of the first array is greater than the element at the pointer j of the second array, increment the pointer j.
// Return the result array by copying the range of the result array from index 0 to index k which is the index of the last element added to the array.

//===========================================================================================

class Solution {

    // solution using hashmap

    public int[] intersect(int[] nums1, int[] nums2) {
         HashMap<Integer, Integer> myMap = new HashMap<>();
        for(int num : nums1){ 
            myMap.put(num, myMap.getOrDefault(num, 0) +1);
        }
        List<Integer> myList = new ArrayList<>();
        for(int num : nums2){
            if(myMap.containsKey(num) && myMap.get(num) >0){
    myList.add(num);
    myMap.put(num, myMap.get(num)-1);
    }
        }
        int[] res = new int[myList.size()];
        for(int i = 0; i< myList.size(); i++){
            res[i] = myList.get(i);
        }
        return res;

    }
}

//==============================================================
// Create a hashmap to store the frequency of each element in the first array nums1.
// Iterate through the second array nums2, and for each element, check if it exists in the hashmap and its frequency is greater than 0. If it does, add the element to the result array, decrement its frequency in the hashmap and continue.
// Create a new integer array res with the same size as the result list and copy elements from the result list to the res array.
// Return the res array