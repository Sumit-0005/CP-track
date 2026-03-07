class Solution {
    public int minFlips(String s) {
        int n = s.length();                     // length of original string
        String t = s + s;                        // doubled string – contains every rotation
        int count0 = 0, count1 = 0;               // mismatches for pattern0 (starting with 0) and pattern1

        // ---------- first window (shift = 0) ----------
        for (int j = 0; j < n; j++) {
            char expected = t.charAt(j);          // character at position j in the first window

            // compare with pattern0 (even positions '0', odd positions '1')
            if (expected != (j % 2 == 0 ? '0' : '1')) count0++;
            // compare with pattern1 (even positions '1', odd positions '0')
            if (expected != (j % 2 == 0 ? '1' : '0')) count1++;
        }

        int min_flips = Math.min(count0, count1); // best for the initial window

        // ---------- slide the window n-1 more times ----------
        for (int i = 1; i < n; i++) {
            // character that leaves the window (was at the beginning of previous window)
            char old_char = t.charAt(i - 1);
            // character that enters the window (becomes the last character of new window)
            char new_char = t.charAt(i + n - 1);

            // contribution of old_char in the *previous* window:
            // it was at position 0, so for pattern0 it contributed if it was not '0'
            int contrib0 = (old_char != '0') ? 1 : 0;
            // for pattern1 it contributed if it was not '1'
            int contrib1 = (old_char != '1') ? 1 : 0;
            boolean last_pos_char = ((n - 1) % 2 == 0);
            int new_contrib0 = (new_char != (last_pos_char ? '0' : '1')) ? 1 : 0;
            int new_contrib1 = (new_char != (last_pos_char ? '1' : '0')) ? 1 : 0;
            count0 = (n - 1) - (count0 - contrib0) + new_contrib0;
            count1 = (n - 1) - (count1 - contrib1) + new_contrib1;

            // keep the global minimum
            min_flips = Math.min(min_flips, Math.min(count0, count1));
        }

        return min_flips;
    }
}