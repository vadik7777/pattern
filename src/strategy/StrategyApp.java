package strategy;

import java.util.Arrays;

/**
 *
 * @author Вадик
 */
public class StrategyApp {
    public static void main(String[] args) {
        StrategyClient client = new StrategyClient();
        int arr[]={3,1,5,9,7};
        
        Strategy strategy = new SelectionSortStrategy(arr);
        client.setStrategy(strategy);
        client.performOperation();
        
        strategy = new BubleSortStrategy(arr);
        client.setStrategy(strategy);
        client.performOperation();
        
        strategy = new InsertSortStrategy(arr);
        client.setStrategy(strategy);
        client.performOperation();
    }
}
class StrategyClient{
    private Strategy strategy;
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public void performOperation(){
        strategy.operation();
    }
}
interface Strategy {
    void operation();
}
class SelectionSortStrategy implements Strategy {
    int[] arr;
    public SelectionSortStrategy(int[] arr) {
        this.arr = arr;
    }
    public void operation() {
        System.out.println("Сортировка выборками");
        System.out.println("до: "+Arrays.toString(arr));
        for (int barier = 0; barier < arr.length - 1; barier++) {
            for (int i = barier + 1; i < arr.length; i++) {
                if (arr[i] < arr[barier]) {
                    int tmp = arr[i];
                    arr[i] = arr[barier];
                    arr[barier] = tmp;
                }
            }
        }
         System.out.println("после: "+Arrays.toString(arr));
    }
}
class BubleSortStrategy implements Strategy {
    int[] arr;
    public BubleSortStrategy(int[] arr) {
        this.arr = arr;
    }
    public void operation() {
        System.out.println("Сортировка методом пузырька");
        System.out.println("до: "+Arrays.toString(arr));
        for (int barier = arr.length - 1; barier >= 0; barier--) {
            for (int i = 0; i < barier; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
        }
        System.out.println("после: "+Arrays.toString(arr));
    }
}
class InsertSortStrategy implements Strategy {
    int[] arr;
    public InsertSortStrategy(int[] arr) {
        this.arr = arr;
    }
    public void operation() {
        System.out.println("Сортировка вставками");
        System.out.println("до: "+Arrays.toString(arr));
        for (int barier = 1; barier < arr.length; barier++) {
            int index = barier;
            while (index - 1 >= 0 && arr[index] < arr[index - 1]) {
                int tmp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = tmp;
                index--;
            }
        }
        System.out.println("после: "+Arrays.toString(arr));
    }
}
