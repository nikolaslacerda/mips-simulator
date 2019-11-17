package controller;

public class AluControl {

    private static AluControl instance;
    private String result;

    public AluControl() {
        this.result = "";
    }

    public static AluControl getInstance() {
        if (instance == null) {
            instance = new AluControl();
        }
        return instance;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
