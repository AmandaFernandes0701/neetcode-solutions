class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> numsStack = new Stack<>();

        for(String s : tokens)
        {
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
            {
                int num2 = numsStack.pop();
                int num1 = numsStack.pop();

                switch(s)
                {
                    case "+": 
                        numsStack.push(num1 + num2);
                        break;

                    case "-":
                        numsStack.push(num1 - num2);
                        break;

                    case "*":
                        numsStack.push(num1 * num2);
                        break;
                    case "/":
                        numsStack.push(num1 / num2);
                        break;
                }
            }
            else
            {
                int num = Integer.parseInt(s);
                numsStack.push(num);
            }
        }

        return numsStack.pop();     
    }
}
