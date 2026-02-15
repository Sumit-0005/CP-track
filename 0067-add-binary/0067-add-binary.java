class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        String output = "";
        while(i>=0 || j>=0){
        int sum = carry;
        if(i>=0) sum += a.charAt(i--) - '0';
        if(j>=0) sum += b.charAt(j--) - '0';
        carry = sum > 1 ? 1 : 0;
        output = (sum%2) + output;
        }
        if(carry != 0) output = carry + output;
        return output;
    }
}