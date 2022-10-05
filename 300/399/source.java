import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Assign id for each variable and counting a number of variables
        HashMap<String, Integer> variableIdMap = new HashMap<>();
        int numberOfVariable = buildVariableIdMap(equations, variableIdMap);

        // Build a two dimension array that contains all the result can be made by equations
        double[][] costMap = initializeCostMap(numberOfVariable);

        // Visit all the equations and update the array
        buildResultMap(equations, values, variableIdMap, costMap);

        // Read queries and find a result from the array
        return answerQueries(queries, variableIdMap, costMap);
    }

    private int buildVariableIdMap(List<List<String>> equations, HashMap<String, Integer> variableIdMap) {
        int numberOfVariable = 0;

        for (List<String> equation : equations) {
            for (String variable : equation) {
                if (!variableIdMap.containsKey(variable)) {
                    variableIdMap.put(variable, numberOfVariable);
                    numberOfVariable++;
                }
            }
        }

        return numberOfVariable;
    }

    private double[][] initializeCostMap(int numberOfVariable) {
        double[][] costMap = new double[numberOfVariable][numberOfVariable];

        for (int posM = 0; posM < numberOfVariable; posM++) {
            Arrays.fill(costMap[posM], -1.0);
        }

        return costMap;
    }

    private void buildResultMap(List<List<String>> equations, double[] values,
            HashMap<String, Integer> variableIdMap, double[][] costMap) {
        int numberOfVariable = variableIdMap.size();

        for (int cursor = 0; cursor < values.length; cursor++) {
            List<String> equation = equations.get(cursor);
            int node0 = variableIdMap.get(equation.get(0));
            int node1 = variableIdMap.get(equation.get(1));
            double value = values[cursor];
            updateCostMap(costMap, numberOfVariable, node0, node1, value);
        }
    }

    private void updateCostMap(double[][] costMap, int numberOfVariable, int node0, int node1, double value) {
        costMap[node0][node1] = value;
        costMap[node1][node0] = 1 / value;

        for (int oldNode = 0; oldNode < numberOfVariable; oldNode++) {
            if (oldNode != node1) {
                if ((costMap[oldNode][node0] != -1.0) && (costMap[oldNode][node1] == -1)) {
                    double newValue = costMap[oldNode][node0] * costMap[node0][node1];
                    costMap[oldNode][node1] = newValue;
                    updateCostMap(costMap, numberOfVariable, oldNode, node1, newValue);
                }
                if ((costMap[node1][oldNode] != -1.0) && (costMap[node0][oldNode] == -1)) {
                    double newValue = costMap[node0][node1] * costMap[node1][oldNode];
                    costMap[node0][oldNode] = newValue;
                    updateCostMap(costMap, numberOfVariable, node0, oldNode, newValue);
                }
            }
            if (oldNode != node0) {
                if ((costMap[oldNode][node1] != -1.0) && (costMap[oldNode][node0] == -1)) {
                    double newValue = costMap[oldNode][node1] * costMap[node1][node0];
                    costMap[oldNode][node0] = newValue;
                    updateCostMap(costMap, numberOfVariable, oldNode, node0, newValue);
                }
                if ((costMap[node0][oldNode] != -1.0) && (costMap[node1][oldNode] == -1)) {
                    double newValue = costMap[node1][node0] * costMap[node0][oldNode];
                    costMap[node1][oldNode] = newValue;
                    updateCostMap(costMap, numberOfVariable, node1, oldNode, newValue);
                }
            }
        }
    }

    private double[] answerQueries(List<List<String>> queries, HashMap<String, Integer> variableIdMap,
            double[][] costMap) {
        double[] results = new double[queries.size()];

        for (int cursor = 0; cursor < results.length; cursor++) {
            List<String> query = queries.get(cursor);

            if (variableIdMap.containsKey(query.get(0)) && variableIdMap.containsKey(query.get(1))) {
                int var0Id = variableIdMap.get(query.get(0));
                int var1Id = variableIdMap.get(query.get(1));
                results[cursor] = costMap[var0Id][var1Id];
            } else {
                results[cursor] = -1;
            }
        }

        return results;
    }
}
