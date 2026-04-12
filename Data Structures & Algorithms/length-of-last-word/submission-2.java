class Solution {
    public int lengthOfLastWord(String s) {

        String[] arrayOfWords = s.split("\\s+");
        int idxLastWord = arrayOfWords.length - 1;

        return arrayOfWords[idxLastWord].length();
    }
}