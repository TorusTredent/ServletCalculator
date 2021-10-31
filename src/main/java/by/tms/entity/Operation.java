package by.tms.entity;

public class Operation {
    private int id;
    private String num1;
    private String num2;
    private String operation;
    private String result;
    private int user_id;

    public Operation() {
    }

    public Operation(String num1, String num2, String operation, int user_id) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
        this.user_id = user_id;
    }

    public Operation(String num1, String num2, String operation, String result) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
        this.result = result;
    }

    public Operation(String num1, String num2, String operation, String result, int user_id) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
        this.result = result;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
