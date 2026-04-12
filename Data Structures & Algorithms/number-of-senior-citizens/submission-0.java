class Solution {
    public int countSeniors(String[] details) {

        // 0 --> 9 (numero de telefone)
        // 10 --> gender
        // 11 e 12 --> idade

        int count = 0;

        for(String s : details)
        {
            int idade = Integer.parseInt(s.substring(11, 13));
            if(idade > 60) count++;
        }

        return count;      
    }
}