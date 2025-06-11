//Concatenation of Array
 public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2*n];
        for(int i=0;i<n;i++){
            ans[i] = nums[i];
            ans[i+n] = nums[i];
        }
        return ans;
    }

//Contains Duplicate
public boolean containsDuplicate(int[] nums) {
        // HashMap<Integer,Integer> mp = new HashMap<>();
        // for(int num : nums){
        //     if(!mp.containsKey(num)){
        //         mp.put(num , 1);
        //     }
        //     else{
        //         mp.put(num , mp.get(num)+1);
        //     }
        // }

        // for(Map.Entry<Integer,Integer> e : mp.entrySet()){
        //     if(e.getValue()>1)return true;
        // }
        // return false;
         
        // for(int i=0;i<nums.length;i++){
        //     int cnt = 0;
        //     for(int j=i;j<nums.length;j++){
        //       if(nums[j] == nums[i])cnt++;
        //     }
        //     if(cnt >1)return true;
        // }
        // return false;

        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }

//Valid Anagram
public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;
        HashMap<Character , Integer> mp = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!mp.containsKey(ch)){
                mp.put(ch , 1);
            }
            else{
                mp.put(ch , mp.get(ch)+1);
            }
        }
        
        for(int i=0;i<t.length();i++){
             char ch = t.charAt(i);
            if(mp.containsKey(ch)){
                mp.put(ch , mp.get(ch)-1);
            }
            else{
                mp.put(ch ,1);
            }
        }

        for(Map.Entry<Character , Integer> e:mp.entrySet()){
            if(e.getValue() != 0){
                  return false;
            }
        }
        return true;
    }

//Two Sum 
public int[] twoSum(int[] nums, int target) {
        // for(int i=0;i<nums.length-1;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //     if(nums[j]+nums[i] == target){
        //         return new int[]{i,j};
        //     }
        //     }
        // }
        // return new int[]{-1,-1};

        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int rem = target - nums[i];
            if(mp.containsKey(rem)){
                return new int[]{mp.get(rem),i};
            }
            else{
                mp.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }

//Longest Common Prefix
public String longestCommonPrefix(String[] strs) {
        // if(strs.length == 1)return strs[0];
        // StringBuilder ans = new StringBuilder("");
        // TreeMap<Character,Integer> mp  = new TreeMap<>();
        // String s = strs[0];
        // for(int i=0;i<s.length();i++){
        //     mp.put(s.charAt(i),1);
        // }

        // for(int i=1;i<strs.length;i++){
        //     String curr = strs[i];
        //     for(int id=0;id<curr.length();id++){
        //        if(mp.containsKey(curr.charAt(id))){
        //         mp.put(curr.charAt(id) , mp.get(curr.charAt(id))+1);
        //        }
        //        else{
        //           break;
        //        }
        // }
        
        // for(Map.Entry<Character,Integer> e : mp.entrySet()){
        //     if(e.getValue() == strs.length){
        //         ans.append(e.getKey());
        //     }
        // }
        // }

        // return ans.toString();

        if(strs.length == 0)return "";
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(prefix) != 0){
               prefix = prefix.substring(0,prefix.length()-1);
               if(prefix.length() == 0)return "";
            }
        }
        return prefix;
    }

//Group Anagrams
 public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , List<String>> mp = new HashMap<>();

        for(String s : strs){
            char arr[] = s.toCharArray();
            Arrays.sort(arr);
            String word = new String(arr);
            if(!mp.containsKey(word)){
                List<String> newList = new ArrayList<>();
                 newList.add(s);
                mp.put(word,newList);
            }
            else{
               mp.get(word).add(s);
            }
        }
       
       List<List<String>> ans = new ArrayList<>();
       for(Map.Entry<String , List<String>> e : mp.entrySet()){
          ans.add(e.getValue());
       }

       return ans;

    }
//Remove Element6
 public int removeElement(int[] nums, int val) {
        int idx = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                nums[idx] = nums[i];
                idx++;
            }
        }

        return idx;
    }

//Majority Element 
public int majorityElement(int[] nums) {
        // HashMap<Integer,Integer> mp = new HashMap<>();
        // for(int num : nums){
        //     if(!mp.containsKey(num)){
        //         mp.put(num , 1);
        //     }
        //     else{
        //         mp.put(num,mp.get(num)+1);
        //     }
        // }

        // for(Map.Entry<Integer,Integer> e :mp.entrySet()){
        //     if(e.getValue()>nums.length/2){
        //         return e.getKey();
        //     }
        // }
        // return -1;

        int cnt = 0;
        int el = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(cnt == 0){
              cnt = 1;
              el = nums[i];
            }
            else if(nums[i] == el){
                cnt++;
            }
            else{
                cnt--;
            }
        }
         cnt = 0;
        for(int i=0;i<nums.length;i++){
         if(nums[i] == el)cnt++;
        }

        if(cnt >nums.length/2){
            return el;
        }
        return -1;
    }

//Sort an array
public void merge(int arr[], int low , int mid,int high){
        int i=low;
        int j= mid+1;
        ArrayList<Integer> curr = new ArrayList<>();
        while(i<=mid && j<=high){
            if(arr[i]<=arr[j]){
                curr.add(arr[i]);
                i++;

            }
            else{
                curr.add(arr[j]);
                j++;
            }
        }

        while(i<=mid){
            curr.add(arr[i]);
                i++;
        }

        while(j<=high){
            curr.add(arr[j]);
                j++;
        }

        for(int idx=low;idx<=high;idx++){
            arr[idx] = curr.get(idx-low);
        }

    }
    public  void mergeSort(int arr[], int low , int high){
        if(low>=high){
            return;
        }
        int mid = low+(high-low)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr, low, mid,high);
    }
    public int[] sortArray(int[] nums) {
        // Arrays.sort(nums);
        // return nums;

         mergeSort(nums,0,nums.length-1);
         return nums;


    }
//Sort Colors 
public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        while(mid<=high){
            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                mid++;
                low++;
            }
            else if(nums[mid] == 2){
                 int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
            else{
                mid++;
            }
        }

        
    }

//Valid Sudoku
public boolean isValidSudoku(char[][] board) {
        HashSet<String> s = new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] =='.')continue;
                //row
                if(!s.add(board[i][j] +" in row "+ i)){
                    return false;
                }
                //col
                if(!s.add(board[i][j] +" in col "+ j)){
                    return false;
                }
                //sub box - 3*3
                if(!s.add(board[i][j] +" in sub "+ i/3 + j/3)){
                    return false;
                }
            }
            
        }
        return true;
    }

//Range sum Query 2D Immutable 
// class NumMatrix {

//     // private int matrix[][];
//     private int submat[][];

//     public NumMatrix(int[][] matrix) {
//         // this.matrix = matrix;
//         int rows = matrix.length;
//         int cols = matrix[0].length;
//         submat = new int[rows+1][cols+1];
//         for(int i=0;i<rows;i++){
//             int prefix = 0;
//             for(int j=0;j<cols;j++){
//                 prefix += submat[i][j];
//                 int above = submat[i][j+1];
//                 submat[i+1][j+1] = prefix + above;
//             }
//         }

//     }
    
//     public int sumRegion(int row1, int col1, int row2, int col2) {
//         // int sum = 0;
//         // for(int i = row1;i<=row2;i++){
//         //     for(int j = col1;j<=col2;j++){
//         //         sum += matrix[i][j];
//         //     }
//         // }
//         // return sum;

//         row1++;
//         col1++;
//         row2++;
//         col2++;
//         int bottomRight = submat[row2][col2];
//         int above = submat[row1 - 1][col2];
//         int left = submat[row2][col1 - 1];
//         int topLeft = submat[row1 - 1][col1 - 1];
//         return bottomRight-above-left+topLeft;
//     }
// }

// /**
//  * Your NumMatrix object will be instantiated and called as such:
//  * NumMatrix obj = new NumMatrix(matrix);
//  * int param_1 = obj.sumRegion(row1,col1,row2,col2);
//  */


public class NumMatrix {

    private int[][] sumMat;

    public NumMatrix(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        sumMat = new int[ROWS + 1][COLS + 1];

        for (int r = 0; r < ROWS; r++) {
            int prefix = 0;
            for (int c = 0; c < COLS; c++) {
                prefix += matrix[r][c];
                int above = sumMat[r][c + 1];
                sumMat[r + 1][c + 1] = prefix + above;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;
        int bottomRight = sumMat[row2][col2];
        int above = sumMat[row1 - 1][col2];
        int left = sumMat[row2][col1 - 1];
        int topLeft = sumMat[row1 - 1][col1 - 1];
        return bottomRight - above - left + topLeft;
    }
}

//Longest common Subsequence 
public int longestConsecutive(int[] nums) {
        
        int n = nums.length;
        // if(n == 0)return 0;
        // Arrays.sort(nums);
        // int cnt = 1;
        // int max = 1;
        // for(int i=1;i<n;i++){
        //     if(nums[i] == nums[i-1])continue;
        //     if(nums[i] == nums[i-1]+1){
        //         cnt++;
        //         max = Math.max(max,cnt);
        //     }
        //     else{
        //     cnt = 1;
        //     }
        // }
        // return max;

        HashSet<Integer> s = new HashSet<>();
        for(int num : nums)s.add(num);
         
         int max = 0;
        for(int num : s){
            if(!s.contains(num-1)){
                int curr = num;
                int cnt = 1;
                while(s.contains(curr+1)){
                    cnt++;
                    curr++;
                }
                max = Math.max(cnt,max);
            }
        }
        return max;
    }

//Best time to buy and sell stock 2 
public int maxProfit(int[] prices) {
        int total = 0;

        for(int i=1;i<prices.length;i++){
            int cost = prices[i]-prices[i-1];
            if(cost >0){
                total += cost;
            }
        }
        return total;
    }

//Majority Element 2 
 public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        // HashMap<Integer,Integer> mp = new HashMap<>();
        // for(int num : nums){
        //     if(!mp.containsKey(num)){
        //         mp.put(num,1);
        //     }
        //     else{
        //         mp.put(num , mp.get(num)+1);
        //     }
        // }
        // for(Map.Entry<Integer,Integer> e:mp.entrySet()){
        //     if(e.getValue()>nums.length/3){
        //         ans.add(e.getKey());
        //     }
        // }
        // if(mp.isEmpty()){
        //     ans.add(-1);
        // }
        // return ans;

        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;
        int cnt1 = 0;
        int cnt2 = 0;
        for(int num : nums){
            if(cnt1 == 0 && num != el2 ){
                el1 = num;
                cnt1 = 1;
            }
            else if(cnt2 == 0 && num != el1){
                el2 = num;
                cnt2 = 1;
            }
            else if(num == el1){
                cnt1++;
            }
            else if(num == el2){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }

        }

        cnt1 = 0;
        cnt2 =0;
        for(int num : nums){
            if(num == el1)cnt1++;
            if(num == el2)cnt2++;
        }
        if(cnt1>nums.length/3){
            ans.add(el1);
        }
         if(cnt2>nums.length/3){
            ans.add(el2);
        }
        return ans;
    }

//Subarray sum equals K
 public int subarraySum(int[] nums, int k) {
       HashMap<Integer,Integer> mp = new HashMap<>();
       mp.put(0,1);
       int sum = 0;
       int cnt = 0;
       for(int num:nums){
         sum += num;
         int rem = sum-k;
         if(mp.containsKey(rem)){
            cnt += mp.get(rem);
         }
         if(!mp.containsKey(sum)){
            mp.put(sum , 1);
         }
         else{
            mp.put(sum , mp.get(sum)+1);
         }
       }
       return cnt;
    }

//Find Missing positive 
public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i=0;
        while(i<n){
            int correctIdx = nums[i]-1;
            if(correctIdx >= 0 && correctIdx<n && nums[i] != nums[correctIdx]){
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            }
            else{
                i++;
            }
        }

        for(int idx=0;idx<n;idx++){
            if(nums[idx] != idx+1){
                return idx+1;
            }
        }
        return n+1;
    }
