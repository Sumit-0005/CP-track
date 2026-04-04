class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) return encodedText;
        
        int n = encodedText.length();
        int cols = n / rows;
        
        char[][] matrix = new char[rows][cols];
        int idx = 0;
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                matrix[r][c] = encodedText.charAt(idx++);

        StringBuilder sb = new StringBuilder();
        
        for (int startCol = 0; startCol < cols; startCol++) {
            int r = 0, c = startCol;
            while (r < rows && c < cols) {
                sb.append(matrix[r][c]);
                r++;
                c++;
            }
        }
        
        String result = sb.toString();
        int end = result.length() - 1;
        while (end >= 0 && result.charAt(end) == ' ') end--;
        return result.substring(0, end + 1);
    }
}