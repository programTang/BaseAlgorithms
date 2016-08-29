package org.tj.study.enumtest;

/**
 * Created by 001 on 16/8/22.
 */
public enum  Weekday {
    Monday(1),Tuesday(2),Wednesday(3),Thuresday(4),Friday(5),Saturday(6),Sunday(7);
    int value;

    private Weekday(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Weekday{" +
                "value=" + value +
                '}';
    }
}

class Test{
    public static void main(String[] args) {
        Weekday weekday = Weekday.valueOf("Wednesday");
        System.out.println(weekday.getValue());

        Weekday[] weekdays = Weekday.values();
        for (Weekday weekday1:weekdays){

        }

    }
}