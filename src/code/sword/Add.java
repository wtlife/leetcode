package code.sword;

/**
 * @Desc 66.Add
 * @date 2020/9/6
 */
public class Add {
    public int add(int a, int b) {

        while (b!=0){
            int c = (a & b) << 1;
            a = a ^ b;
            b = c;
        }

        return a;
    }
}
