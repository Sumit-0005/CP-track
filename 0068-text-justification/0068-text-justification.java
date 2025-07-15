class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int start = 0;
        while (start < words.length) {
            int width = words[start].length(), letters = width, end = start;
            while (end + 1 < words.length && width + 1 + words[end + 1].length() <= maxWidth) {
                width += 1 + words[++end].length();
                letters += words[end].length();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(words[start++]);
            if (end == words.length - 1 || start > end) {
                while (start <= end) {
                    sb.append(' ');
                    sb.append(words[start++]);
                }
                while (sb.length() < maxWidth) sb.append(' ');
            } else {
                int baseSpace = (maxWidth - letters) / (end - start + 1);
                int bonusSpace = (maxWidth - letters) % (end - start + 1);
                while (start <= end) {
                    for (int i = 0; i < baseSpace; i++) sb.append(' ');
                    if (bonusSpace-- > 0) sb.append(' ');
                    sb.append(words[start++]);
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
}