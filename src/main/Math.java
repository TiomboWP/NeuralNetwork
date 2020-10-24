package main;

public class Math {

    public static double calcActivation(Layer layer, Neuron neuron){
        double activation = 0;
        double sum = 0;
        for(Neuron tmpNeuron : layer.getNeurons()){
            sum += tmpNeuron.activation*tmpNeuron.weight;
        }
        sum += neuron.bias;
        activation = sigmoid(sum);
        return activation;
    }

    public static double sigmoid(double sum){
        return 1D/(1D+java.lang.Math.pow(java.lang.Math.E, -sum));
    }

}
