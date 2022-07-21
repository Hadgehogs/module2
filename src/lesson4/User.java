package lesson4;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int Number;
    private List<Integer> numberList;

    public List<Integer> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public User(int number) {
        Number = number;
    }
}
