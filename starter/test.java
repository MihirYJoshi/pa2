public class test {
    public static void main(String[] args) {
        MyArrayList<Integer> list1 = new MyArrayList<Integer>(1);
        list1.append(5);
        list1.append(7);


        for (int i = 0; i < list1.data.length; i++){
            System.out.println(list1.data[i]);
        }
        System.out.println("     ");
        System.out.println(list1.getCapacity());
        System.out.println(list1.size);
    }
}
