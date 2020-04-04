package code.daybyday;

public class DistributeCandies {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        if (candies == 0) {
            return res;
        }
        int times = 0;
        while (candies > 0) {
            for (int i = 0; i < res.length; i++) {
                int num = i + 1;
                int count = num + (times * num_people);
                if (candies >= count) {
                    res[i] = res[i] + count;

                } else if (candies > 0 && candies < count) {
                    res[i] = res[i] + candies;
                    return res;

                }
                candies = candies - count;
            }
            times++;
        }

        return res;
    }
}
