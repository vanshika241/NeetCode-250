//Reverse String 
 public void reverseString(char[] s) {
        int i=0;
        int j = s.length-1;
        while(i<=j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

//Valid Palindrome
// public boolean isPal(StringBuilder s , int idx){
    //     if(idx >=s.length()/2)return true;
    //     if(s.charAt(idx) != s.charAt(s.length()-1-idx))return false;
    //     return isPal(s,idx+1);
    // }
    public boolean isPalindrome(String s) {
        // StringBuilder str = new StringBuilder();
        // for(int i=0;i<s.length();i++){
        //     if(Character.isLetterOrDigit(s.charAt(i))){
        //         str.append(Character.toLowerCase(s.charAt(i)));
        //     }
        // }
        // return isPal(str,0);
        int i=0;
        int j = s.length()-1;
        while(i<=j){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if(!Character.isLetterOrDigit(ch1)){
                i++;
            }
            else if(!Character.isLetterOrDigit(ch2)){
                j--;
            }
            else{
                if(Character.toLowerCase(ch1) != Character.toLowerCase(ch2)){
                 return false;
                 }
                 
                    i++;
                    j--;
                 
            }

        }
        return true;
    }
//Valid Palindrome 2
 public boolean checkPal(String s , int i , int j){
        
        while(i <=j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
         int i=0;
        int j = s.length()-1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return checkPal(s, i + 1, j) || checkPal(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true; 
    }
//Merge Strings Alternatively 
public String mergeAlternately(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int i=0;
        int j =0;
        StringBuilder ans = new StringBuilder("");
        while(i<n1 && j<n2){
            ans.append(word1.charAt(i));
            ans.append(word2.charAt(j));
            i++;
            j++;

        }

        while(i<n1){
            ans.append(word1.charAt(i));
            i++;
        }

        while(j<n2){
            ans.append(word2.charAt(j));
            j++;
        }
        return ans.toString();
    }

//Merge Sorted Array
public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j= n-1;
        int last = m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]<=nums2[j]){
                nums1[last] = nums2[j];
                j--;
                last--;
            }
            else{
                nums1[last] = nums1[i];
                i--;
                last--;
            }
        }

        while(j>=0){
            nums1[last] = nums2[j];
                j--;
                last--;
        }

    }

//Remove Duplicates from Sorted Array
   public int removeDuplicates(int[] nums) {
        int idx = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] != nums[idx]){
                nums[idx+1] = nums[i];
                idx++;
            }
        }
        return idx+1;
    }

// 3 sum 
 public List<List<Integer>> threeSum(int[] nums) {
    //     HashSet<List<Integer>> ans = new HashSet<>();
    //     int n = nums.length;
    //     for(int i=0;i<n;i++){
    //         HashMap<Integer,Integer> mp = new HashMap<>();
    //         for(int j=i+1;j<n;j++){
    //             int third = -(nums[i]+nums[j]);
    //             if(mp.containsKey(third)){
    //                 List<Integer> curr = Arrays.asList(nums[i],nums[j],third);
    //                 Collections.sort(curr);
    //                 ans.add(curr);
    //             }
    //                 mp.put(nums[j],j);

                
    //         }
    //     }

    //    List<List<Integer>> res = new ArrayList<>(ans);
    //    return res;

     Arrays.sort(nums);
     int n = nums.length;
     List<List<Integer>> res = new ArrayList<>();
     for(int i=0;i<n;i++){
        if(i>0 && nums[i] == nums[i-1]){
            continue;
        }

        int j=i+1;
        int k = n-1;
        while(j<k){
            int sum = nums[i]+nums[j]+nums[k];
            if(sum == 0){
                List<Integer> curr = Arrays.asList(nums[i],nums[j],nums[k]);
                res.add(curr);
                j++;
                k--;
                while(j<k && nums[j] == nums[j-1])j++;
                while(j<k && nums[k] == nums[k+1])k--;
            }
            else if(sum <0){
                j++;
            }
            else{
                k--;
            }
        }
     }

     return res;
    
    }

// Two Sum II - Input Array Is Sorted
public int[] twoSum(int[] numbers, int target) {
        int i =0;
        int j = numbers.length-1;
        while(i<=j){
            int sum = numbers[i]+numbers[j];
            if(sum == target){
                return new int[]{i+1,j+1};
            }
            else if(sum > target){
                j--;
            }
            else{
                i++;
            }
        }
        return new int[]{-1,-1};
    }

//4 sum
  public List<List<Integer>> fourSum(int[] nums, int target) {
      /* List<List<Integer>> ans = new ArrayList<>();
          int n = nums.length;
          Arrays.sort(nums);
          for(int i=0;i<n-3;i++){
                        if (i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j=i+1;j<n-2;j++){
              //while (i>0 && nums[i] == nums[i-1])continue;
              while (j>i+1&& nums[j] == nums[j-1])continue;
              int k = j+1;
              int l = n-1;
              while (k<l) {
                int sum = nums[i];
                sum += nums[j];
                sum += nums[k];
                sum += nums[l];
                if (sum == target) {
                  List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],nums[k]);
                  ans.add(temp);
                  k++;
                  l--;
                  while (k<l && nums[k] == nums[k-1])k++;
                  while (k<l && nums[l] == nums[l+1])l--;
                }
                else if (sum<target) {
                  k++;
                }
                else{
                  l--;
                }
              }

                
             
            }
          }
          return ans; */

           List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n < 4) return ans; // Edge case: If less than 4 elements, return empty list.

        Arrays.sort(nums); // Sort the array to enable two-pointer technique.

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates for `i`.

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // Skip duplicates for `j`.

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l]; // Use `long` to prevent overflow.

                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;

                        // Skip duplicates for `k` and `l`.
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return ans;
    }

//Rotate Array
 public void reverse(int nums[], int i , int j){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        if(k == 0)return;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }

//Container with most water
public int maxArea(int[] height) {
        int maxarea = 0;
        int i=0;
        int j = height.length-1;
        while(i<j){
            int h = Math.min(height[i],height[j]);
            int w = j-i;
            int area = h*w;
            maxarea = Math.max(maxarea, area);
            if(height[i]<=height[j]){
                i++;
            }
            else{
               j--;
            }
        }
        return maxarea;
    }

//Boats to save people
public int numRescueBoats(int[] people, int limit) {
        int cnt = 0;
        Arrays.sort(people);
        int i=0;
        int j = people.length-1;
        while(i <= j){
            if(people[i]+people[j] <= limit ){
                i++;
                
            }
                j--;
                cnt++;
            
        }
        return cnt;
    }
//Trapping Rain water
public int trap(int[] height) {
        int n = height.length;
        // int leftMax [] = new int[n];
        // int rightMax [] = new int[n];
        // leftMax[0] = height[0];
        // for(int i=1;i<n;i++){
        //     leftMax[i] = Math.max(leftMax[i-1],height[i]);
        // }

        //  rightMax[n-1] = height[n-1];
        // for(int i=n-2;i>=0;i--){
        //     rightMax[i] = Math.max(rightMax[i+1],height[i]);
        // }

        // int totalWater = 0;
        // for(int i=0;i<n;i++){
        //     int minH = Math.min(rightMax[i],leftMax[i]);
        //     int water = minH-height[i];
        //     totalWater += water;
        // }
        // return totalWater;

        //2 pointer - 

        int leftmax = -1;
        int rightmax = -1;
        int totalWater = 0;
        int i=0;
        int j =n-1;
        while(i <=j){
            leftmax = Math.max(leftmax,height[i]);
            rightmax = Math.max(rightmax,height[j]);

            if(leftmax<rightmax){
                totalWater += leftmax-height[i];
                i++;
            }
            else{
                 totalWater += rightmax-height[j];
                 j--;
            }


        }
        return totalWater;
    }
