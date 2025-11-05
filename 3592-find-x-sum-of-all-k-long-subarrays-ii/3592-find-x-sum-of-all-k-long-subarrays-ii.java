class Pair {
    long count;
    int num;
    Pair(long c, int n) { count = c; num = n; }
}

class PairComparator implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        if (a.count != b.count)
            return Long.compare(b.count, a.count);
        return Integer.compare(b.num, a.num);
    }
}

class Solution {
    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] result = new long[n - k + 1];
        Map<Integer, Long> numCount = new HashMap<>();

        TreeSet<Pair> top = new TreeSet<>(new PairComparator());
        TreeSet<Pair> bottom = new TreeSet<>(new PairComparator());

        long runningSum = 0;

        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            long count = numCount.getOrDefault(num, 0L);

            if (count > 0) {
                Pair oldPair = new Pair(count, num);
                if (top.contains(oldPair)) {
                    top.remove(oldPair);
                    runningSum -= count * num;
                } else {
                    bottom.remove(oldPair);
                }
            }

            count++;
            numCount.put(num, count);
            Pair newPair = new Pair(count, num);
            
            top.add(newPair);
            runningSum += count * num;

            if (top.size() > x) {
                Pair smallest = top.last();
                top.remove(smallest);
                runningSum -= smallest.count * smallest.num;
                bottom.add(smallest);
            }

            if (i >= k) {
                int oldNum = nums[i - k];
                long oldCount = numCount.get(oldNum);

                Pair oldPair = new Pair(oldCount, oldNum);
                if (top.contains(oldPair)) {
                    top.remove(oldPair);
                    runningSum -= oldCount * oldNum;
                } else {
                    bottom.remove(oldPair);
                }

                oldCount--;
                numCount.put(oldNum, oldCount);

                if (oldCount > 0) {
                    Pair updatedPair = new Pair(oldCount, oldNum);
                    bottom.add(updatedPair);
                } else {
                    numCount.remove(oldNum);
                }

                if (top.size() < x && !bottom.isEmpty()) {
                    Pair best = bottom.first();
                    bottom.remove(best);
                    top.add(best);
                    runningSum += best.count * best.num;
                }
            }

            if (i >= k - 1) {
                result[i - k + 1] = runningSum;
            }
        }
        return result;
    }
}
