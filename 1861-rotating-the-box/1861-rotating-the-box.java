class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;
        for (int i = 0; i < n; i++) {
            int right = m - 1;
            for (int left = m - 1; left >= 0; left--) {
                if (box[i][left] == '*') {
                    right = left - 1;
                }
                else if (box[i][left] == '#') {
                    char temp = box[i][left];
                    box[i][left] = box[i][right];
                    box[i][right] = temp;
                    right--;
                }
            }
        }
        char[][] result = new char[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][n - 1 - i] = box[i][j];
            }
        }
        return result;
    }
}