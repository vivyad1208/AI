package edu.srh.dzone;

import java.util.List;

/**
 * Calculates the weighted sums of the input neurons' outputs.
 */
public final class WeightedSumFunction implements InputSummingFunction {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double collectOutput(List<Connection> inputConnections) {
		double weightedSum = 0d;
		for (Connection connection : inputConnections) {
			weightedSum += connection.getWeightedInput();
		}
		return weightedSum;
	}
}
