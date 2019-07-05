package week2.src.Lab2;

public class human {
    private int weight;
    private float height;
    private float result;

    public human(int weight, float height, float result){
        this.weight = weight;
        this.height = height;
        this.result = result;
    }

    public void setResult(float result){
        this.result = result;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    public void setHeight(float height){
        this.height = height;
    }

    public float getResult() {
        return result;
    }
}
