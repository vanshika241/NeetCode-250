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
