class Solution {
    public boolean isValid(String s) {
    
    Stack<Character> stackBrakets = new Stack<>();
    HashMap<Character, Character> dictBrakets = new HashMap<>();

    dictBrakets.put('(', ')');
    dictBrakets.put('[', ']');
    dictBrakets.put('{', '}');

    for(int i = 0; i < s.length(); i++)
    {
        char c = s.charAt(i);

        if(c == '(' || c == '[' || c == '{')
            stackBrakets.push(dictBrakets.get(c));

        else
        {
            if(stackBrakets.isEmpty() || c != stackBrakets.peek())
                return false;
            
            else
                stackBrakets.pop();
        }
    }

    return stackBrakets.isEmpty(); 

    }
}
