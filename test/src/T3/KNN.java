package T3;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ahqmrf on 11/1/2016.
 */
public class KNN {
    private String trainingSetFilePath;
    private String testDataFilePath;
    private int valueOfK;
    private ArrayList<Data> trainingDataList;
    private ArrayList<Data> testDataList;
    private ArrayList<Integer> originalResult;

    public KNN() {
        this.valueOfK = 1;
        trainingSetFilePath = "E:\\Eclipse\\workspace\\test\\src\\T3\\train.txt";
        testDataFilePath = "E:\\Eclipse\\workspace\\test\\src\\T3\\test.txt";
        trainingDataList = new ArrayList<>();
        testDataList = new ArrayList<>();
        originalResult = new ArrayList<>();
    }

    public void retrieveTrainingSet() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(trainingSetFilePath));
            String line;
            try {
                while((line = reader.readLine()) != null) {
                    //System.out.println(line);
                    Data data = new Data();
                    String attributes[] = line.split("\t");
                    data.setCategoryID(Integer.parseInt(attributes[0]));
                    data.setPetalWidth(Double.parseDouble(attributes[1]));
                    data.setPetalLength(Double.parseDouble(attributes[2]));
                    data.setSepalWidth(Double.parseDouble(attributes[3]));
                    data.setSepalLength(Double.parseDouble(attributes[4]));
                    data.setCategory(attributes[5]);
                    trainingDataList.add(data);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void retrieveTestData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(testDataFilePath));
            String line;
            try {
                while((line = reader.readLine()) != null) {
                    Data data = new Data();
                    String attributes[] = line.split("\t");
                    data.setCategoryID(Integer.parseInt(attributes[0]));
                    data.setPetalWidth(Double.parseDouble(attributes[1]));
                    data.setPetalLength(Double.parseDouble(attributes[2]));
                    data.setSepalWidth(Double.parseDouble(attributes[3]));
                    data.setSepalLength(Double.parseDouble(attributes[4]));
                    data.setCategory(attributes[5]);
                    testDataList.add(data);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void retrieveOriginalResult() {
        for (int i = 0; i < testDataList.size(); i++) {
            originalResult.add(testDataList.get(i).getCategoryID());
        }
    }

    public void prepareData() {
        retrieveTrainingSet();
        retrieveTestData();
        retrieveOriginalResult();
    }

    public int getResult(Data data) {
        for (int i = 0; i < trainingDataList.size(); i++) {
            trainingDataList.get(i).setToCompareTo(data);
        }
        Collections.sort(trainingDataList);
        int countOne = 0, countTwo = 0, countThree = 0;
        for (int i = 0; i < Math.min(valueOfK, trainingDataList.size()); i++) {
            if(trainingDataList.get(i).getCategoryID() == 1) countOne++;
            if(trainingDataList.get(i).getCategoryID() == 2) countTwo++;
            if(trainingDataList.get(i).getCategoryID() == 3) countThree++;
        }
        if(countOne >= countTwo && countOne >= countThree) return 1;
        if(countTwo >= countOne && countTwo >= countThree) return 2;
        return 3;
    }

    public ArrayList<Integer> getFoundResult() {
        ArrayList<Integer> currentResult = new ArrayList<>();
        for (int i = 0; i < testDataList.size(); i++) {
            currentResult.add(getResult(testDataList.get(i)));
        }
        return currentResult;
    }

    public double getAccuracy(ArrayList<Integer> foundResult) {
        double total = testDataList.size();
        double matched = 0.0;
        for (int i = 0; i < originalResult.size(); i++) {
            if(foundResult.get(i) == originalResult.get(i)) matched += 1.0;
        }
        return matched / total * 100.0;
    }

    public double getAccuracy() {
        return getAccuracy(getFoundResult());
    }

    public String getTrainingSetFilePath() {
        return trainingSetFilePath;
    }

    public void setTrainingSetFilePath(String trainingSetFilePath) {
        this.trainingSetFilePath = trainingSetFilePath;
    }

    public String getTestDataFilePath() {
        return testDataFilePath;
    }

    public void setTestDataFilePath(String testDataFilePath) {
        this.testDataFilePath = testDataFilePath;
    }


    public int getValueOfK() {
        return valueOfK;
    }

    public void setValueOfK(int valueOfK) {
        this.valueOfK = valueOfK;
    }

    public ArrayList<Data> getTrainingDataList() {
        return trainingDataList;
    }

    public void setTrainingDataList(ArrayList<Data> trainingDataList) {
        this.trainingDataList = trainingDataList;
    }

    public ArrayList<Data> getTestDataList() {
        return testDataList;
    }

    public void setTestDataList(ArrayList<Data> testDataList) {
        this.testDataList = testDataList;
    }
}
