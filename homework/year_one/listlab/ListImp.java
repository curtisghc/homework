package List;
public class ListImp{
    public static void main(String[] args){

        MyList<Integer> a = new MyList<Integer>();
        a.add(9);
        a.add(8);
        a.add(7);
        a.add(6);
        a.add(5);
        a.add(4);
        a.add(3);
        a.add(2);
        a.add(1);
        a.add(0);
        a.add(-1);
        a.add(-2);

        System.out.println(a.get(0));

    }
}
