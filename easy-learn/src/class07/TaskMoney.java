package class07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 一组任务，两个属性，本金和利润
 * 你有初始金额和完成K个任务的量，但是任务只能串行完成，求怎样获得最大利润
 */

public class TaskMoney {

    static int FinalProfits(int W, int K, int[] costs, int[] profits) {
        //W本金 K任务数

        PriorityQueue<Node> costQueue = new PriorityQueue<>(new MinCost());
        PriorityQueue<Node> profitQueue = new PriorityQueue<>(new MaxProfit());

        for (int i = 0; i < costs.length; i++) {
            costQueue.add(new Node(costs[i], profits[i]));
        }

        for (int i = 0; i < K; i++) {
            while (!costQueue.isEmpty() && costQueue.peek().cost <= W) {
                profitQueue.add(costQueue.poll());
            }
            if (profitQueue.peek().cost > W) {
                return W;
            }

            W += profitQueue.poll().cost + profitQueue.poll().profit;
        }
        return W;
    }

    static class Node {
        int cost;
        int profit;

        public Node(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    static class MinCost implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost - o2.cost;
        }
    }

    static class MaxProfit implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.profit - o1.profit;
        }
    }

}
