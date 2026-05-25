class Solution {

    public String encode(List<String> strs) {
        // edge case
        if (strs == null) {
            return null;
        }

        // use a string builder
        StringBuilder sb = new StringBuilder();

        // iterate over the list
        for (String str: strs) {
            sb.append(str.length()).append("#").append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        // create the output
        List<String> list = new ArrayList<>();
        char[] arr = str.toCharArray();

        // edge case
        if (str == null) {
            return list;
        }

        int left = 0;
        while (left < str.length()) {
            //StringBuilder sb = new StringBuilder();

            int right = left;
            while (arr[right] != '#') {
                //sb.append(arr[right++]);
                right++;
            }
            int length = Integer.valueOf(str.substring(left, right));
            left = right + 1 + length;
            list.add(str.substring(right+1, left));
            // left = right+1;
            // list.add(sb.toString());
        }
        return list;
    }
}
