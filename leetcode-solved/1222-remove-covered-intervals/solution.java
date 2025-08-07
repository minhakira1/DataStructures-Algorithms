class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int result = intervals.length;
        // Sắp xếp mảng sử dụng Comparator
        Arrays.sort(intervals, (a, b) -> {
            // So sánh phần tử đầu tiên (chỉ mục 0)
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // Sắp xếp tăng dần
            } else {
                // Nếu phần tử đầu tiên bằng nhau, so sánh phần tử thứ hai
                return Integer.compare(b[1], a[1]); // Sắp xếp giảm dần
            }
        });
        int l = intervals[0][0], r = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (r < interval[1]) {
                l = interval[0];
                r = interval[1];
                continue;
            }
            if (l <= interval[0] && r >= interval[0]) {
                result--;
            }
        }
        return result;
    }
}
