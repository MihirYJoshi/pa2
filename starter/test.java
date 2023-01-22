public class test {
    public static void main(String[] args) {
        MyArrayList<String> list1 = new MyArrayList<String>(-1);
        
        for (int i = 0; i < list1.data.length; i++){
            System.out.println(list1.data[i]);
        }
        System.out.println("     ");
        System.out.println(list1.getCapacity());
        System.out.println(list1.size);
    }
}
