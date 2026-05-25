// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        if (pairs == null) {
            return new ArrayList<Pair>();
        }

        quickSortHelper(pairs, 0, pairs.size()-1);
        return pairs;
    }

    public void quickSortHelper(List<Pair> pairs, int start, int end) {
        if (end - start + 1 <= 1) {
            return;
        }

        // get the last element - we will use this to base our pivot
        Pair pivot = pairs.get(end);

        // get the left pointer - this will start at the start
        int left = start;

        // iterate thru the pairs from the start to the end - partition
        for (int i = start; i < end; i++) {
            // compare the value at i to the value at the pivot spot
            if (pairs.get(i).key < pivot.key) {
                // at this point, we know that the ith key is less than
                // the pivot key. swap the left and the ith spots
                swap(pairs, left, i);
                left++;
            }
        }

        // move the pivot element in between left and right
        pairs.set(end, pairs.get(left));
        pairs.set(left, pivot);

        // recurse left side
        quickSortHelper(pairs, start, left-1);

        // recurse right side
        quickSortHelper(pairs, left+1, end);
    }

    public void swap(List<Pair> pairs, int left, int i) {
        Pair temp = pairs.get(left);
        pairs.set(left, pairs.get(i));
        pairs.set(i, temp);
    }
}
