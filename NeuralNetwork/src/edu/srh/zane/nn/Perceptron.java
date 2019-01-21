package edu.srh.zane.nn;

public class Perceptron {

	public static final int[][][] AND_DATA = {
		{
			{0,0} , {0}
		},
		{
			{0,1} , {0}
		},
		{
			{1,0} , {0}
		},
		{
			{1,1} , {1}
		}
	};


	public static final double LEARNING_RATE = 0.05;

	public static final double[] INITIAL_WEIGHTS = { Math.random(), Math.random()};


	public double calculateWeightedSum(int[]data, double[]weights) {
		double weightedSum = 0;
		for (int i = 0; i < data.length; i++) {
			weightedSum += data[i] * weights[i];
		}
		return weightedSum;
	}

	public int applyActivationFunction(double weightedSum) {
		return weightedSum > 1 ? 1 : 0;
	}

	public double[] adjustWeights(int[]data, double[]weights, double error) {
		double[] adjustedweights = new double[weights.length];
		for (int i = 0; i < data.length; i++) {
			adjustedweights[i] = error * LEARNING_RATE * data[i] + weights[i];
		}
		return adjustedweights;
	}
}
