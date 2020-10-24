package main;

import main.mnist.MnistImageFile;
import main.mnist.MnistLabelFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    static ArrayList<Layer> layers = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        int[] layerCount = new int[6];

        layerCount[0] = 784;
        layerCount[1] = 392;
        layerCount[2] = 196;
        layerCount[3] = 98;
        layerCount[4] = 49;
        layerCount[5] = 10;

        Random r = new Random();

        for(int i = 0; i< layerCount.length; i++){

            Layer layer = new Layer();

            for (int j = 0; j < layerCount[i]; j++) {
                layer.getNeurons().add(new Neuron(r.nextDouble(),0));
            }

            layers.add(layer);

        }

        String path = new File("").getAbsolutePath();
        MnistImageFile image = new MnistImageFile(path + "/res/train-images.idx3-ubyte", "rw");
        MnistLabelFile label = new MnistLabelFile(path + "/res/train-labels.idx1-ubyte", "rw");

        Layer first = layers.get(0);
        Layer second = layers.get(1);
        Layer third = layers.get(2);
        Layer fourth = layers.get(3);
        Layer fifth = layers.get(4);
        Layer sixth = layers.get(5);
        int start = 0; int end = 10;

        for (int i = start; i < end; i++) {


            for(int j = 0; j < first.getNeurons().size(); j++){
                first.getNeurons().get(j).activation = (float)((double)image.read()/256D);
            }

            for(int j = 0; j < first.getNeurons().size(); j++){
                if(first.getNeurons().get(j).activation > 0.8){
                    System.out.print("▩");
                }else if(first.getNeurons().get(j).activation > 0.6){
                    System.out.print("▦");
                }else if(first.getNeurons().get(j).activation > 0.4){
                    System.out.print("▨");
                }else if(first.getNeurons().get(j).activation > 0.2){
                    System.out.print("▥");
                }else{
                    System.out.print("◟");
                }
                if((j+1)%28==0){
                    System.out.println();
                }
            }

            for(Neuron neuron : second.getNeurons()){
                neuron.activation = Math.calcActivation(first, neuron);
            }
            for(Neuron neuron : third.getNeurons()){
                neuron.activation = Math.calcActivation(first, neuron);
            }
            for(Neuron neuron : fourth.getNeurons()){
                neuron.activation = Math.calcActivation(first, neuron);
            }
            for(Neuron neuron : fifth.getNeurons()){
                neuron.activation = Math.calcActivation(first, neuron);
            }
            for(Neuron neuron : sixth.getNeurons()){
                neuron.activation = Math.calcActivation(first, neuron);
                System.out.println("--" + neuron.activation);
            }
            System.out.println("Guess: " + label.readLabel());
        }
            //■□▩▦▨▥▢





        while (true);

    }

}
