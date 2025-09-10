class Solution {
      public boolean canTalk(HashSet<Integer> a, HashSet<Integer> b) {
        for (Integer val : a) {
            if (b.contains(val)) return true;
        }
        return false;
    }
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
         int m = languages.length;

        HashSet<Integer>[] users = new HashSet[m];
        for (int i = 0; i < m; i++) {
            users[i] = new HashSet<>();
            for (int lang : languages[i]) {
                users[i].add(lang);
            }
        }
        int minTeachings = Integer.MAX_VALUE;

        for (int lang = 1; lang <= n; lang++) {
            int count = 0;
            boolean[] learnt = new boolean[m]; 
            for (int[] friends : friendships) {
                int a = friends[0] - 1; 
                int b = friends[1] - 1;

                if (canTalk(users[a], users[b])) continue;
                if (!users[a].contains(lang) && !learnt[a]) {
                    learnt[a] = true;
                    count++;
                }
                if (!users[b].contains(lang) && !learnt[b]) {
                    learnt[b] = true;
                    count++;
                }
            }

            minTeachings = Math.min(minTeachings, count);
        }

        return minTeachings;
    }
}