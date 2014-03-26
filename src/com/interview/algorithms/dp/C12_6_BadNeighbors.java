package com.interview.algorithms.dp;

/**
 * Created_By: zouzhile
 * Date: 3/25/14
 * Time: 8:57 PM

 The old song declares "Go ahead and hate your neighbor", and the residents of Onetinville have taken those words to heart.
 Every resident hates his next-door neighbors on both sides.
 Nobody is willing to live farther away from the town's well than his neighbors,
 so the town has been arranged in a big circle around the well.
 Unfortunately, the town's well is in disrepair and needs to be restored.
 You have been hired to collect donations for the Save Our Well fund.

 Each of the town's residents is willing to donate a certain amount, as specified in the int[] donations,
 which is listed in clockwise order around the well.
 However, nobody is willing to contribute to a fund to which his neighbor has also contributed.
 Next-door neighbors are always listed consecutively in donations,
 except that the first and last entries in donations are also for next-door neighbors.
 You must calculate and return the maximum amount of donations that can be collected.
 */
public class C12_6_BadNeighbors {

    public int maxDonations(int[] donations, int from, int to) {
        int max = Integer.MIN_VALUE;

        if(to - from < 3) {
            if(from == 0 && to == donations.length - 1) { // donations[from..to] is the donations array itself
                for(int i = from + 1; i <= to; i++)
                    if(donations[i] > max)
                        max = donations[i];
            } else { // donations[from..to] is a sub array of donations
                if(from == to) // length 1
                    max = donations[from];
                else if (from + 1 == to)
                    max = donations[from] > donations[to] ? donations[from] : donations[to];
                else {
                    max = donations[from] + donations[to] > donations[from + 1] ?
                            donations[from] + donations[to] : donations[from + 1];
                }
            }
            return max;
        }
        // select the "from" donation
        if(from == 0 && to == donations.length - 1)
            max = donations[from] + maxDonations(donations, from + 2, to - 1);
        else
            max = donations[from] + maxDonations(donations, from + 2, to);

        // don't select "from" donation
        int max1 = maxDonations(donations, from + 1, to);
        return (max > max1 ? max : max1);
    }
}
