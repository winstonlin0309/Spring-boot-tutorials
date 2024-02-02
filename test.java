public class test {
    public interface myInterface {
        
        public int sum(int i, int j);
    }

    public static class myInterfaceImpl implements myInterface {
        public int sum(int i, int j) {
            return i+j;
        }
    }

    public static void main(String[] args) {
        myInterface i1 = (i,j) -> {
            return i*i+j*j;
        };

        System.out.println(i1.sum(1, 2));
    }
}
