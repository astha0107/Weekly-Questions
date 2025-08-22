package week6;
public class miserenims {
    public static void main(String[] args) {
        System.out.println(misereNim(new int[]{3, 4, 5})); 
        System.out.println(misereNim(new int[]{1, 1, 1})); 
        System.out.println(misereNim(new int[]{1, 1, 2}));
    }
    public static boolean misereNim(int[] heaps) {
        int a = heaps[0], b = heaps[1], c = heaps[2];

        
        if (a == 1 && b == 1 && c == 1) {
            return false; 
        }

        
        int xor = a ^ b ^ c;
        return xor != 0;
    }
}
