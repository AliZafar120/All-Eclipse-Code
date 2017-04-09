package T3;

/**
 * Created by ahqmrf on 11/1/2016.
 */
public class Data implements Comparable<Data> {

    final static String CATEGORY_NAMES[] ={"Setosa", "Versicolor", "Verginica"};

    private String category;
    private int categoryID;

    private double sepalLength;
    private double sepalWidth;
    private double petalLength;
    private double petalWidth;

    private Data toCompareTo;

    public Data() {
        category = CATEGORY_NAMES[0];
        categoryID = 1;
        sepalLength = 1.0;
        sepalWidth = 1.0;
        petalLength = 1.0;
        petalWidth = 1.0;
    }

    public Data(double petalWidth, double petalLength, double sepalWidth, double sepalLength) {
        this.petalWidth = petalWidth;
        this.petalLength = petalLength;
        this.sepalWidth = sepalWidth;
        this.sepalLength = sepalLength;
        this.toCompareTo = new Data();
    }

    public double euclideanDistance(Data first, Data second) {
        double petalWidthDifference =Math.pow( first.petalWidth - second.petalWidth,2);
        double petalLengthDifference = Math.pow(first.petalLength - second.petalLength,2);
        double sepalLengthDifference =Math.pow( first.sepalLength - second.sepalLength,2);
        double sepalWidthDifference = Math.pow(first.sepalWidth - second.sepalWidth,2);

        return Math.sqrt(petalWidthDifference + petalLengthDifference + sepalWidthDifference + sepalLengthDifference);
    }

    public int compareTo(Data other) {
        double distanceWithThis = euclideanDistance(this, this.toCompareTo);
        double distanceWithOther = euclideanDistance(other, this.toCompareTo);
        return Double.compare(distanceWithThis, distanceWithOther);
    }

    public Data getToCompareTo() {
        return toCompareTo;
    }

    public void setToCompareTo(Data toCompareTo) {
        this.toCompareTo = toCompareTo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public double getSepalLength() {
        return sepalLength;
    }

    public void setSepalLength(double sepalLength) {
        this.sepalLength = sepalLength;
    }

    public double getSepalWidth() {
        return sepalWidth;
    }

    public void setSepalWidth(double sepalWidth) {
        this.sepalWidth = sepalWidth;
    }

    public double getPetalLength() {
        return petalLength;
    }

    public void setPetalLength(double petalLength) {
        this.petalLength = petalLength;
    }

    public double getPetalWidth() {
        return petalWidth;
    }

    public void setPetalWidth(double petalWidth) {
        this.petalWidth = petalWidth;
    }

}
