class Solution {

    // A classe mutável para guardar o estado
    public class PairLetterCount {
        public char letter;
        public int count;

        public PairLetterCount(char letter) {
            this.letter = letter; // Uso do 'this' obrigatório aqui
            this.count = 1;
        }
    }

    public int compress(char[] chars) {
        if (chars.length == 0) return 0;

        Stack<PairLetterCount> stack = new Stack<>();

        // 1. FASE DE LEITURA E EMPILHAMENTO
        // Usamos um for-each limpo. A Stack resolve o agrupamento sozinha!
        for (char c : chars) {
            if (!stack.isEmpty() && stack.peek().letter == c) {
                // Se a letra atual é igual ao topo, só incrementamos o contador
                stack.peek().count++;
            } else {
                // Se mudou de letra (ou tá vazia), empurramos um novo grupo
                stack.push(new PairLetterCount(c));
            }
        }

        // 2. FASE DE ESCRITA (Reconstruindo o array original in-place)
        int writeIdx = 0; // Ponteiro de onde vamos escrever no array chars
        
        // Magia do Java: iterar sobre uma Stack com 'for' normal 
        // lê ela da base até o topo (a ordem certinha da string!)
        for (PairLetterCount pair : stack) {
            
            // Escrevemos a letra
            chars[writeIdx] = pair.letter;
            writeIdx++;

            // Se tiver mais de 1, precisamos escrever o número dígito por dígito
            if (pair.count > 1) {
                // Converte o número para texto (ex: 12 vira "12")
                String countStr = Integer.toString(pair.count);
                
                // Escreve cada caractere do número no array
                for (char digit : countStr.toCharArray()) {
                    chars[writeIdx] = digit;
                    writeIdx++;
                }
            }
        }

        // O writeIdx parou exatamente no novo tamanho do array!
        return writeIdx;
    }
}