class Solution {
    public String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1 || numRows >= s.length()) return s;

        StringBuilder sb = new StringBuilder(s.length()); // avoid resize overhead
        int totalSkip = 2 * (numRows - 1);

        for (int row = 0; row < numRows; row++) {
            int i = row;
            int downSkip = totalSkip - 2 * row;
            int upSkip = 2 * row;
            boolean down = true;

            while (i < s.length()) {
                sb.append(s.charAt(i));
                if (row == 0 || row == numRows - 1) {
                    i += totalSkip;  // only one type of skip for top/bottom row
                } else {
                    if (down && downSkip > 0) {
                        i += downSkip;
                    } else if (!down && upSkip > 0) {
                        i += upSkip;
                    }
                    down = !down;
                }
            }
        }

        return sb.toString();
    }
}