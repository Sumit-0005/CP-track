class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int leftCount = 0;
        int rightCount = 0;
        int spacesCount = 0;
        for(char ch : moves.toCharArray()){
            if(ch == '_')   spacesCount++;
            if(ch == 'L')   leftCount++;
            if(ch == 'R')    rightCount++;
        }

        if(leftCount > rightCount){
            return leftCount + spacesCount - rightCount;
        } else{
            return rightCount + spacesCount - leftCount;
        } 
    }
}