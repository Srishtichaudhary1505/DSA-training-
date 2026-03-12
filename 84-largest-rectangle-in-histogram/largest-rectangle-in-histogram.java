class Solution {
    static class Pair
    {
        int key ;
        int val ;
        Pair(int key , int val)
        {
            this.key = key ;
            this.val = val ;
        }
    }

    public static int[] NSL_Solve(int[] arr)
    {
        Stack<Pair> stack = new Stack<>() ;
        int[] ans = new int[arr.length] ;
        int n = arr.length ;
        for(int i = 0 ; i < n ; i++)
        {
            if(stack.isEmpty())
            {
                ans[i] = -1;
            }
            else if(!stack.isEmpty() && stack.peek().val < arr[i])
            {
                ans[i] = stack.peek().key ;
            }
            else if(!stack.isEmpty() && stack.peek().val >= arr[i])
            {
                while(!stack.isEmpty() && stack.peek().val >= arr[i])
                {
                    stack.pop() ;
                }
                if(stack.isEmpty())
                {
                    ans[i] = -1 ;
                }
                else
                {
                    ans[i] = stack.peek().key ;
                }
            }
            stack.push(new Pair(i,arr[i])) ;
        }
        return ans ;
    }

    public static int[] NSR_Solve(int[] arr)
    {
        Stack<Pair> stack = new Stack<>() ;
        int[] ans = new int[arr.length] ;
        int n = arr.length ;
        for(int i = n-1 ; i >= 0 ; i--)
        {
            if(stack.isEmpty())
            {
                ans[i] = n;
            }
            else if(!stack.isEmpty() && stack.peek().val < arr[i])
            {
                ans[i] = stack.peek().key ;
            }
            else if(!stack.isEmpty() && stack.peek().val >= arr[i])
            {
                while(!stack.isEmpty() && stack.peek().val >= arr[i])
                {
                    stack.pop() ;
                }
                if(stack.isEmpty())
                {
                    ans[i] = n ;
                }
                else
                {
                    ans[i] = stack.peek().key ;
                }
            }
            stack.push(new Pair(i,arr[i])) ;
        }
        return ans ;
    }
    public int largestRectangleArea(int[] heights) {
        int[] NSL = NSL_Solve(heights) ;
        int[] NSR = NSR_Solve(heights) ;
        int maxArea = 0 ;
        int n = heights.length ;
        for(int i = 0 ; i < n ; i++)
        {
            maxArea = Math.max(maxArea, (NSR[i]-NSL[i]-1)*heights[i]) ;
        }
        return maxArea ;
    }
}