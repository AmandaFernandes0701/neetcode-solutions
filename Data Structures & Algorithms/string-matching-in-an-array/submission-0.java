class Solution {
    public List<String> stringMatching(String[] words) {

        List<String> listResult = new ArrayList<>();
        
        for(int i = 0; i < words.length - 1; i++)
        {
            for(int j = i + 1; j < words.length; j++)
            {
                // se j é substring
                if(words[i].contains(words[j]) && !listResult.contains(words[j]))
                    listResult.add(words[j]);

                // se i é substring
                if(words[j].contains(words[i]) && !listResult.contains(words[i]))
                    listResult.add(words[i]);
            }
        }
        return listResult;
    }
}