class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        Stack<Integer> stackSandwiches = new Stack<>();

        for(int i = sandwiches.length - 1; i >= 0; i--)
            stackSandwiches.push(sandwiches[i]);

        Queue<Integer> queueStudents = new LinkedList<>();

        for(int student : students)
            queueStudents.add(student);

        int count = 0;

        while(!queueStudents.isEmpty() && count <= queueStudents.size())
        {
            if(queueStudents.peek() == stackSandwiches.peek())
            {
                count = 0;
                queueStudents.poll();
                stackSandwiches.pop();
            }
            else
            {
                int student = queueStudents.poll();
                queueStudents.add(student);
                count++;
            }
        }

        return queueStudents.size();
        
    }
}