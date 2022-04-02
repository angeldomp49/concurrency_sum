package online.makechtec.practices;

import java.util.List;
import java.util.concurrent.RecursiveAction;

class Sum extends RecursiveAction{

    private double low = 0;
    private double high = 0;
    private double answer = 0;

    private int first = 0;
    private int last = 0;

    private List<Double> items = null;

    public Sum(List<Double> items){
        this.items = items;
        this.first = 0;
        this.last = items.size();
    }

    public double getAnswer(){
        return answer;
    }


    public double sumLow(){
        double sum = 0;
        for(int i = 0; i < ((items.size()/2) -1); i++){
            sum += items.get(i);
        }

        return sum;
    }

    public double sumHigh(){
        double sum = 0;
        for(int i = (items.size()/2); i < (items.size() -1); i++){
            sum += items.get(i);
        }

        return sum;
    }

    @Override
    protected void compute() {
        // TODO Auto-generated method stub
        
    }

}
