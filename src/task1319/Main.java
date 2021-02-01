package task1319;

public class Main {
    public static void main(String[] args) {
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1)
            return -1;
        int[] network = new int[n];
        int counter = 1;
        for (int[] connection : connections) {
            int a = connection[0], b = connection[1];
            if (network[a] == 0 && network[b] == 0) {
                network[a] = counter;
                network[b] = counter;
                counter++;
            } else if (network[a] != 0 && network[b] == 0) {
                network[b] = network[a];
            } else if (network[a] == 0 && network[b] != 0) {
                network[a] = network[b];
            } else if (network[a] != network[b]) {
                int min = Math.min(network[a], network[b]);
                int max = Math.max(network[a], network[b]);
                for (int i = 0; i < network.length; i++) {
                    if (network[i] == max)
                        network[i] = min;
                    else if (network[i] > max) {
                        network[i]--;
                    }
                }
                counter--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (network[i] == 0)
                network[i] = counter++;
        }
        return counter - 2;
    }
}