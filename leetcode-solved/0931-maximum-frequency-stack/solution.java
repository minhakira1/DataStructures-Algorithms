class FreqStack {
    HashMap<Integer, Integer> freq;
    HashMap<Integer, Stack<Integer>> group;
    int maxFreq;
    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int updateFreq = freq.getOrDefault(val, 0)+1;
        freq.put(val, updateFreq);

       if (!group.containsKey(updateFreq)) {
            group.put(updateFreq, new Stack<>());
        }
        group.get(updateFreq).push(val);       

        maxFreq = Math.max(maxFreq, updateFreq);
    }
    
    public int pop() {
        int valToPop = group.get(maxFreq).pop();

        //decrement the frequency of the popped value
        freq.put(valToPop,  freq.get(valToPop)-1);

        //check if there is no maxFreq value left
        if(group.get(maxFreq).isEmpty()){
            maxFreq--;
        }

        // bài toán sai trường hợp lẽ ra phải update lại valToPut giảm xuống ở group hashmmap
        // nếu không pop lần tiếp theo nếu trong case maxFreq-- đó rỗng dẫn đến lỗi
        //while (maxFreq > 0 && group.get(maxFreq).isEmpty()) {
          //      maxFreq--;
            //}

         return valToPop;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
