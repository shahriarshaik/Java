public class settest {
    public static void main(String[] args) {
        Set<Integer> set = new Set<>(0);
        System.out.println("lagde set \n\n\n\n");
        set.insert(set, 2);
        System.out.println("størrelse etter insert: " + set.size());
        set.insert(set, 5);
        System.out.println("størrelse etter insert: " + set.size());
        set.insert(set, 1);
        System.out.println("størrelse etter insert: " + set.size());
        System.out.println("satte inn 2, 5, 1 i set \n\n\n");
        System.out.println(set.contains(set, 3));
        System.out.println(set.contains(set, 2));
        System.out.println(set.contains(set, 5));
        System.out.println("kjørte contains på dem \n\n\n");
        System.out.println("set.data: " + set.data);
        try {
            System.out.println("set.rightChild.data: " + set.rightChild.data);
        } catch (Exception e) {
            System.out.println("kjørte ikke rightchild");
        }
        try {
            System.out.println("set.leftChild.data: " + set.leftChild.data);
        } catch (Exception e) {
            System.out.println("kjørte ikke leftchild");
        }
        System.out.println("skal fjerne 5 og 2");
        // set.remove(set, 0);

        set.remove(set, 5);
        System.out.println("remover 5...: " + set.size);
        set.remove(set, 2);
        System.out.println("remover 2...: " + set.size);
        set.remove(set, 1);
        System.out.println("remover 1...: " + set.size);

        // System.out.println(set.remove(set, 5));
        System.out.println("siste linje med kode");
    }
}
