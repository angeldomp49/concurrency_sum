package online.makechtec.practices;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class TwoTasks extends RecursiveAction{

    private static final long threshold = 350;

    public double result = 0;

    private List<Double> items;
    private int start;
    private int end;

    public TwoTasks(List<Double> items, int start, int end) {
        this.items = items;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {

        if( (this.end - this.start) <= TwoTasks.threshold ){
            this.result = this.task();
        }
        else{
            int mid = (this.start + this.end) / 2;
            TwoTasks left = new TwoTasks(this.items, this.start, mid);
            TwoTasks right = new TwoTasks(this.items, mid, this.end);
            left.fork();
            right.compute();
            left.join();
            this.result = left.result + right.result;
        }
        
    }

    private double task(){
        double result = 0;

        for(int i = start; i < end; i++) {
            double item = items.get(i);

            double t = Math.pow(item, 1.767888);
            t = Math.sqrt(t);
            t = Math.pow(t, -0.587);
            t = Math.sin(t);
            t = Math.sin(t);
            
            try{
                Thread.sleep(1);
            }catch(Exception e){
                e.printStackTrace();
            }

            result += t;
        }

        return result;
    }
    
}
