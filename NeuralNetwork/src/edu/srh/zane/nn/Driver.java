package edu.srh.zane.nn;

public class Driver {

	public static void main(String[] args) {
		int[][][] data = Perceptron.AND_DATA;
		double[]weights = Perceptron.INITIAL_WEIGHTS;
		Driver driver = new Driver();
		Perceptron perceptron = new Perceptron();

		int epocNumber = 0;
		boolean errorFlag = true;
		double error = 0;
		double[]adjustedWeights = null;
		
		while(errorFlag) {
			driver.printHeading(epocNumber++);
			errorFlag = false;
			error = 0;
			for (int i = 0; i < data.length; i++) {
				double weightedSum = perceptron.calculateWeightedSum(data[i][0], weights);
				int result = perceptron.applyActivationFunction(weightedSum);
				error = data[i][1][0] - result;
				if(error!=0)
					errorFlag = true;
				adjustedWeights = perceptron.adjustWeights(data[i][0], weights, error);
				driver.printVector(data[i], weights, result, error, weightedSum, adjustedWeights);
				weights = adjustedWeights;
			}
		}
	}


	public void printVector(int[][]data, double[]weights, int result, double error, double weightedSum,
			double[]adjustedWeights) {
		print("   " + String.format("%.2f", weights[0]) + "  |  " + String.format("%.2f", weights[1]));
		print(" | " + data[0][0] + "  |  " + data[0][1] + " | " + data[1][0] + "  |  " + result);
		print(" | " + error + "  |  " + String.format("%.2f", weightedSum) + " | ");
		println(String.format("%.2f", adjustedWeights[0]) + " | " + String.format("%.2f", adjustedWeights[1]));
	}


	public void printHeading(int epocNumber) {
		String equals = "===========================================";
		println("\n "+equals+" EPOCH # " + epocNumber + " " + equals );
		print("   ");
		print(" w1  |  w2  |  x1  |  x2  | ");
		print(" Target Result  |  Result  |  Error  |  Weighted Sum  | ");
		print(" adjusted w1  |  adjusted w2  ");
		println("");
		println("----------------------------------------------------");
	}


	public void print(Object o) {
		System.out.print(o);
	}


	public void println(Object o) {
		System.out.println(o);
	}
}
