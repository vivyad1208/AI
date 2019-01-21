package edu.srh.dzone.nn;

public interface Connection {

	double getWeight();

	void setWeight(double weight);
	
	double getInput();

	double getWeightedInput();

	Object getFromNeuron();

	Object getToNeuron();
}
