// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        // create some output
        List<List<Pair>> output = new ArrayList<>();

        // edge case
        if (pairs == null) {
            return output;
        }

        // now let's iterate thru pairs
        for (int i = 0; i < pairs.size(); i++) {

            // get the index to the left of i
            int j = i-1;

            // let's do some comparisons - this is where the while loop comes to play
            // we want to compare the key for j and j+1 (not i). if j is bigger than j+1, we switch
            // otherwise, we move on
            //System.out.println(j + " " + pairs.get(j).key + " " + pairs.get(j+1).key);
            while (j >= 0 && pairs.get(j).key > pairs.get(j+1).key) {
                System.out.println(j + " " + pairs.get(j).key + " " + pairs.get(j+1).key);

                // if we made it to this point, we know that we can make a switch
                // make a temp Pair
                Pair temp = pairs.get(j);
                pairs.set(j, pairs.get(j+1));
                pairs.set(j+1, temp);

                // finally, let's decrement j
                j--;
            }
            
            // add the new iteration of pairs to the output
            List<Pair> cloneList = new ArrayList<>(pairs);
            output.add(cloneList);

        }

        // finally, return
        return output;
    }
}
