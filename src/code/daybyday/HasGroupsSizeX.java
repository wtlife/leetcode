package code.daybyday;

public class HasGroupsSizeX {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[1000];
        for (int value : deck) {
            count[value]++;
        }
        int g = -1;
        for (int value : count) {
            if (value > 0) {
                if (g == -1) {
                    g = value;
                } else {
                    g = gcd(g, value);
                }
            }
        }
        return g >= 2;
    }

    int gcd(int i, int j) {
        return i == 0 ? j : gcd(j % i, i);
    }
}
