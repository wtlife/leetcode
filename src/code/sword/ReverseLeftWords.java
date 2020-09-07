package code.sword;

/**
 * @Desc 58-2.ReverseLeftWords
 * @date 2020/9/4
 */
public class ReverseLeftWords {

     public String reverseLeftWords(String s, int n) {
          return s.substring(n, s.length()) + s.substring(0, n);
     }

}
