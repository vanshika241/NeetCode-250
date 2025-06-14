//Sliding Window Maximum
public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();
        int i=0;
        int j =0;
        int idx = 0;
        while(j<n){
            while(!dq.isEmpty() && dq.peekLast() < nums[j]){
                 dq.removeLast();
               
            }
            dq.addLast(nums[j]);
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                ans[idx] = dq.peekFirst();
                idx++;
                if(nums[i] == dq.peekFirst()){
                    dq.removeFirst();
                    
                }
                i++;
                j++;

            }
            
            
        }
        return ans;
    }
