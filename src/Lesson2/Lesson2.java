package Lesson2;

public class Lesson2 {

    public static void fillList(NumberList<Number> list, boolean useDouble,boolean useInteger){
        for (int i=0; i<5;i++){
            if (useInteger){
            list.add(i);
            }
            if (useDouble) {
                list.add(i + 0.1);
            }
        }
    }
    public static void main(String[] args) {
        NumberList<Number> list = new NumberList<Number>(Number.class);

        // Заполним список целыми и дробными
        fillList(list,true,true);
        System.out.println("Работа метода add:");
        System.out.println(list);
        System.out.println("-----------------------");

        list.add(1);
        System.out.println("Работа метода contains: ");
        System.out.println(list.contains(1));
        System.out.println(list.contains(2));
        System.out.println("-----------------------");

        list.remove();
        System.out.println("Работа метода remove: ");
        System.out.println(list);
        System.out.println("-----------------------");

        // Заполним список целыми и дробными
        fillList(list,true,true);
        System.out.println("Работа метода getDouble: ");
        try {
            System.out.println(list.getDouble(0));
            System.out.println(list.getDouble(1));
        } catch (Exception e){
            System.out.println(e.getMessage());
        };
        System.out.println("-----------------------");

        System.out.println("Работа метода sumIntegers: ");
        try {
            System.out.println(list.sumIntegers());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        };
        list.remove();

        // Заполним список только целыми
        fillList(list,false,true);
        System.out.println(list.sumIntegers());
        System.out.println("-----------------------");

    }
}
