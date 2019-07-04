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

    public void setWeight(int weight){
        this.weight = weight;
    }

    public void setHeight(float height){
        this.height = height;
    }

    public float getResult(int select){
        if(select == 1) {
            result = (float)weight / (height * height);
        }
        else if(select == 2) {
            result = (float)weight * 703 / (height* height);
        }
        return result;
    }
}
