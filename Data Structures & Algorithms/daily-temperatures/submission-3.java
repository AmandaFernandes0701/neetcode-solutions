class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

/*
temperatures = [30,38,30,36,35,40,28]
                 0  1  2  3  4  5  6

arrayResult = [1,4,1,2,1,0,0]
               0 1 2 3 4 5 6
currNum = 28

28,6
40,5
*/

    Stack<TemperatureIndex> stackTemp = new Stack<>();
    int[] arrayResult = new int[temperatures.length];

    for(int i = 0; i < temperatures.length; i++)
    {
        int temperature = temperatures[i];

        while(!stackTemp.isEmpty() && temperature > stackTemp.peek().temperature)
        {
            TemperatureIndex tempPeek = stackTemp.pop();
            arrayResult[tempPeek.index] = i - tempPeek.index;
        }

        stackTemp.push(new TemperatureIndex(temperature, i));
    }

    return arrayResult;
        
    }

    public record TemperatureIndex(int temperature, int index) {}
}
