import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public class Cell{
        int row;
        int col;
        int height;
        public Cell(int row,int col,int height)
        {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
    public static int trapRainWater(int[][] heights) {
        if(heights.length==0||heights[0].length==0)
            return 0;
        Comparator<Cell> com = new Comparator<Cell>() {
            public int compare(Cell a1,Cell a2) {
                return a1.height - a2.height;
            }
        };
        PriorityQueue<Cell> queue = new PriorityQueue<>(com);
        int horizon = heights[0].length;
        int vertical = heights.length;
        boolean[][] visited = new boolean[vertical][horizon];
        for (int i = 0; i < vertical; i++) {
            visited[i][0] =true;
            visited[i][horizon-1]=true;
            queue.offer(new Cell(i,0,heights[i][0]));
            queue.offer(new Cell(i,horizon-1,heights[i][horizon-1]));
        }
        for (int i = 0; i < horizon; i++) {
            visited[0][i] = true;
            visited[vertical-1][i] = true;
            queue.offer(new Cell(0,i,heights[0][i]));
            queue.offer(new Cell(vertical-1, i, heights[vertical-1][i]));
        }
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int sum = 0;
        while(!queue.isEmpty())
        {
            Cell cell = queue.poll();
            for (int[] dir : dirs) {
                int row = cell.row+dir[0];
                int col = cell.col+dir[1];
                if(row>=0&&row<vertical&&col>=0&&col<horizon&&!visited[row][col])
                {
                    visited[row][col] = true;
                    sum += Math.max(0, cell.height-heights[row][col]);
                    queue.offer(new Cell(row,col,Math.max(cell.height, heights[row][col])));
                }
                
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int [][]heightMap = {{9,9,9,9,9,9,8,9,9,9,9},{9,0,0,0,0,0,1,0,0,0,9},{9,0,0,0,0,0,0,0,0,0,9},{9,0,0,0,0,0,0,0,0,0,9},{9,9,9,9,9,9,9,9,9,9,9}};
        System.out.println(trapRainWater(heightMap));
    }
}