package edu.srh.dzone.nn;

import java.util.List;

public interface InputSummingFunction {

	/**
	 * Performs calculations based on the output values of the input neurons.
	 * 
	 * @param inputConnections
	 *            neuron's input connections
	 * @return total input for the neuron having the input connections
	 */
	double collectOutput(List<Connection> inputConnections);

}
