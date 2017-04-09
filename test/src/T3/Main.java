package T3;
/**
 * Created by ahqmrf on 11/1/2016.
 */
public class Main {
    public static void main(String[] args) {
        KNN knn = new KNN();
        knn.prepareData();
        for (int i = 1; i < 132; i += 2) {
            knn.setValueOfK(i);
            System.out.println(knn.getAccuracy()+"value of k is"+i);
        }
    }
}
