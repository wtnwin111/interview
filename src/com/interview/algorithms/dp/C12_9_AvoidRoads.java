package com.interview.algorithms.dp;

/**
 * Created_By: zouzhile
 * Date: 4/2/14
 * Time: 5:46 PM
 *
 * Problem URL: http://community.topcoder.com/stat?c=problem_statement&pm=1889&rd=4709
 *
 * In the city, roads are arranged in a grid pattern. Each point on the grid represents a corner where two blocks meet.
 * The points are connected by line segments which represent the various street blocks.
 * Using the cartesian coordinate system, we can assign a pair of integers to each corner as shown below.
 *
 * You are standing at the corner with coordinates 0,0. Your destination is at corner width,height.
 * You will return the number of distinct paths that lead to your destination.
 * Each path must use exactly width+height blocks.
 * In addition, the city has declared certain street blocks untraversable.
 * These blocks may not be a part of any path.
 * You will be given a String[] bad describing which blocks are bad.
 * If (quotes for clarity) "a b c d" is an element of bad,
 * it means the block from corner a,b to corner c,d is untraversable.
 */

public class C12_9_AvoidRoads {

    class Counter {
        long count = 0;

        public void increase() {
            this.count ++ ;
        }

        public long value() {
            return this.count;
        }
    }

    public long numWays(int width, int height, String[] bad){
        // fromX, fromY, toX, toY
        boolean[][][][] blocks = new boolean[width+1][height+1][width+1][height+1];
        for(String block : bad) {
            String[] points = block.split("\\s+");
            //symmetrically set the bad way
            blocks[Integer.parseInt(points[0])][Integer.parseInt(points[1])][Integer.parseInt(points[2])][Integer.parseInt(points[3])] = true;
            blocks[Integer.parseInt(points[2])][Integer.parseInt(points[3])][Integer.parseInt(points[0])][Integer.parseInt(points[1])] = true;
        }
        Counter counter = new Counter();
        this.numWays(width, height, blocks, counter, 0, 0);
        return counter.value();
    }

    public void numWays(int width, int height, boolean[][][][] blocks, Counter counter, int currentX, int currentY) {
        // Each path must use exactly width+height blocks.
        // This means you can walk up or right to reach destination
        if(currentX > width || currentY > height)
            return;

        if(currentX == width && currentY == height) {
            counter.increase();
        } else {
            if(currentY + 1 <= height && blocks[currentX][currentY][currentX][currentY+1] == false) {
                // go up
                numWays(width, height, blocks, counter, currentX, currentY + 1);
            }

            if(currentX + 1 <= width && blocks[currentX][currentY][currentX + 1][currentY] == false) {
                // go right
                numWays(width, height, blocks, counter, currentX + 1, currentY);
            }
        }
    }
}
