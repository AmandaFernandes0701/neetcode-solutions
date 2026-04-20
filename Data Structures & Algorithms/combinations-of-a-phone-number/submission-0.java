class Solution {

    private List<String> resultList = new ArrayList<>();
    
    private final Map<Character, String> mapLetters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {

        if(digits.isEmpty()) return resultList;

        findAllCombinations(digits, new StringBuilder(), 0);

        return resultList;   
    }

    public void findAllCombinations(String digits, StringBuilder sb, int index)
    {
        if(index == digits.length())
        {
            resultList.add(sb.toString());
            return;
        }

        String letras = mapLetters.get(digits.charAt(index));

        for(char letra : letras.toCharArray())
        {
            sb.append(letra);
            findAllCombinations(digits, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
