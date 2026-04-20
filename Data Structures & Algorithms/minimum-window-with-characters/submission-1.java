class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return "";

        HashMap<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> windowFreq = new HashMap<>();
        int left = 0, right = 0;
        
        // Quantas letras únicas do target já completamos a frequência na janela atual
        int validChars = 0; 
        int requiredChars = tFreq.size(); // Total de letras únicas que precisamos

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            // 1. Expande a janela adicionando a letra da direita
            char rightChar = s.charAt(right);
            windowFreq.put(rightChar, windowFreq.getOrDefault(rightChar, 0) + 1);

            // 2. Se a letra faz parte do target e atingiu a frequência exata, marcamos como válida
            // O .intValue() previne bugs de cache de objetos Integer no Java
            if (tFreq.containsKey(rightChar) && windowFreq.get(rightChar).intValue() == tFreq.get(rightChar).intValue()) {
                validChars++;
            }

            // 3. Enquanto a janela for VÁLIDA (temos tudo o que precisamos), tentamos encolher
            while (validChars == requiredChars) {
                
                // Salva o menor tamanho encontrado até agora
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Letra que vamos remover da esquerda para encolher a janela
                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

                // Se removemos uma letra importante e ficamos devendo, a janela deixa de ser válida
                if (tFreq.containsKey(leftChar) && windowFreq.get(leftChar) < tFreq.get(leftChar)) {
                    validChars--;
                }
                
                left++; // Encolhe efetivamente o ponteiro
            }
            
            right++; // Expande efetivamente o ponteiro
        }

        // Se minLen nunca mudou, é porque não achou nenhuma janela válida
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}