class Solution {
    // BFS conaldev
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000"))
            return 0;
        Set<String> visited = new HashSet<String>(Arrays.asList(deadends));
        if (visited.contains("0000"))
            return -1;
        Queue<String> queuePaths = new LinkedList<String>();
        queuePaths.offer("0000");
 
        visited.add("0000");
        int counter = 0;
        while (!queuePaths.isEmpty()) {
            int length = queuePaths.size();
            // loop each number string in a row step
            while (length > 0) {
                String current = queuePaths.poll();
                for (int i = 0; i < 4; i++) {
                    char ch = current.charAt(i);
                    // turn 2 direction up and down
                    String upStr = current.substring(0, i) + (ch == '9' ? 0 : (ch - '0' + 1))
                            + current.substring(i + 1);
                    String downStr = current.substring(0, i) + (ch == '0' ? 9 : (ch - '0' - 1))
                            + current.substring(i + 1);
 
                    if (upStr.equals(target) || downStr.equals(target))
                        return counter + 1;
 
                    if (visited.add(upStr)) {
                        queuePaths.offer(upStr);
                    }
                    if (visited.add(downStr)) {
                        queuePaths.offer(downStr);
                    }
                }
                --length;
            }
            ++counter;
        }
        return -1;
    }
}
