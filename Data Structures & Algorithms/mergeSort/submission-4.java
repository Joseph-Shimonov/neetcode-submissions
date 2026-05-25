// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    // for the merge sort algo, we have the recursive function
    // and we also have the merge function


    public List<Pair> mergeSort(List<Pair> pairs) {
        if (pairs == null) {
            return null;
        }
        return mergeSortHelper(pairs, 0, pairs.size()-1);
    }

    // this is the function that will actually do the recursive call
    public List<Pair> mergeSortHelper(List<Pair> pairs, int start, int end) {
        if (start < end) {
            // get the mid point
            int mid = (start + end) / 2;

            // recurse over the left side
            mergeSortHelper(pairs, start, mid);

            // recurse over the right side
            mergeSortHelper(pairs, mid+1, end);

            // merge the two sides
            merge(pairs, start, mid, end);
        }

        return pairs;

    }

    public void merge(List<Pair> pairs, int start, int mid, int end) {
        // we don't want to affect the actual list, so we will put it in a temp list
        List<Pair> left = new ArrayList<>(pairs.subList(start, mid+1));
        List<Pair> right = new ArrayList<>(pairs.subList(mid+1, end+1));

        // set the pointer for the left side
        int i = 0;

        // set the pointer for the right side
        int j = 0;

        // set the pointer for the array
        int k = start;

        // merge the two sorted halves into the original array
        while (i < left.size() && j < right.size()) {
            if (left.get(i).key <= right.get(j).key) {
                pairs.set(k++, left.get(i++));
            } else {
                pairs.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            pairs.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            pairs.set(k++, right.get(j++));
        }

    }
}
