public class test {
    public static void main(String[] args) {
        MyArrayList<Integer> list1 = new MyArrayList<Integer>(3);
        list1.append(5);
        list1.append(4);
        list1.append(3);
        list1.append(null);
        System.out.println(list1.getCapacity());
        System.out.println(list1.size);
        for (int i = 0; i < list1.data.length; i++){
            System.out.println(list1.data[i]);
        }
    }
}
