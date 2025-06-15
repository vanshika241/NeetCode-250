//Longest substring without repeating character
public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0, j = 0;
        int len = 0;
        HashMap<Character, Integer> mp = new HashMap<>();

        while (j < n) {
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);

            if (mp.size() == j - i + 1) {
                len = Math.max(len, j - i + 1);
                j++;
            }
            else if (mp.size() < j - i + 1) {
                while (mp.size() < j - i + 1) {
                    mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                    if (mp.get(s.charAt(i)) == 0) {
                        mp.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }

        return len;
    }
//Permutation of string
    public boolean checkInclusion(String ana, String s) {
        int n = s.length();
        int k = ana.length();

        if (k > n) return false;

        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < ana.length(); i++) {
            mp.put(ana.charAt(i), mp.getOrDefault(ana.charAt(i), 0) + 1);
        }

        int i = 0, j = 0, cnt = mp.size();

        while (j < n) {
            char ch = s.charAt(j);
            if (mp.containsKey(ch)) {
                mp.put(ch, mp.get(ch) - 1);
                if (mp.get(ch) == 0) {
                    cnt--;
                }
            }

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (cnt == 0) {
                    return true;
                }

                char left = s.charAt(i);
                if (mp.containsKey(left)) {
                    mp.put(left, mp.get(left) + 1);
                    if (mp.get(left) == 1) {
                        cnt++;
                    }
                }

                i++;
                j++;
            }
        }

        return false;
    }

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
