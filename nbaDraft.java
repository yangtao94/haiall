import java.lang.reflect.Array;

import java.util.*;

/**
 * Created by Yangtao on 7/19/2017.
 */
public class nbaDraft {

    public void nextUp(int[] selected, int[] pool) {
    }

    public static boolean didYouWin(int[] mine, int[] winning) {
        Arrays.sort(mine);
        Arrays.sort(winning);
        return Arrays.equals(mine, winning);

    }

    public static int[] getSubset(int[] input, int[] subset) {
        int[] result = new int[subset.length];
        for (int i = 0; i < subset.length; i++)
            result[i] = input[subset[i]];
        //System.out.println(Arrays.toString(result));
        return result;
    }

    public static void generateCombi(int[] hello) {
        //generate the winning combination
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 14; i++) {
            list.add(i);


        }
        Random num = new Random();

        for (int i = 0; i < hello.length; i++) {
            int index = num.nextInt(list.size());
            hello[i] = list.remove(index);
        }


    }
    public static int[] rankSort(ArrayList<Integer> array) {

            ArrayList<Integer> newArray = new ArrayList<>();
        for ( int a : array) {
            newArray.add(a);
        }
        //System.out.println(newArray.toString());
            Collections.sort(newArray);
        //System.out.println(newArray.toString());

        ArrayList<Integer> copyArray = new ArrayList<>();
        for (int k : newArray) {
            copyArray.add(k);
        }

            int[] rank = new int[14];
        for (int i = 0; i < 14; i++) {
              if (newArray.get(i) == array.get(i)) {
                    rank[i] = 14-i;
                    break;
                }



                    rank[i] = newArray.indexOf(array.get(i));



        }
        //System.out.println(Arrays.toString(rank));
        return rank;
        }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to:\n");
        System.out.println("1. Test draft\n");
        System.out.println("2. Create your own draft\n");

        String choice = sc.nextLine();
        String[] initial;
        switch (choice) {
            case "1":  initial = new String[]{"Celtics","Lakers","76ers","Suns","Kings","Magic",
                    "Timberwolves","Knicks","Mavericks","Kings","Hornets","Pistons","Nuggets","Heat"};
                break;
            case "2": System.out.println("Enter 14 Teams below in order of Best to Worst Odds:");
                initial = new String[14];
                //Scanner sc = new Scanner(System.in);
                int haha = 0;
                while (sc.hasNextLine() && haha < 14) {
                    String lol = (String) sc.nextLine();
                    initial[haha++] = lol;

                }
                break;
            default: initial = new String[14];
                     System.out.println("Keyed in wrong bruh");
                     System.exit(1);
                break;
        }



        System.out.println(Arrays.toString(initial));





        ArrayList<Integer> orderAscending = new ArrayList<>(14);

        int[] winningCombination = new int[4];

        generateCombi(winningCombination);

       // System.out.print(Arrays.toString(winningCombination));


        //Generate combination
        List<int[]> possibleCombination = new ArrayList<>();

        //14 ping pong balls
        int[] combination = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        //System.out.print(Arrays.toString(combination));
        int k = 4;
        int[] s = new int[k];

        if (k <= combination.length) {
            //first index sequence
            for (int i = 0; (s[i] = i) < k - 1; i++)
                possibleCombination.add(getSubset(combination, s));

            for (; ; ) {
                int i;
                //find position of item that can be incremented
                for (i = k - 1; i >= 0 && s[i] == combination.length - k + i; i--) ;

                if (i < 0) {
                    break;
                }
                s[i]++;     //increment the item
                //fill up remaining items
                for (++i; i < k; i++) {
                    s[i] = s[i - 1] + 1;

                }
                possibleCombination.add(getSubset(combination, s));

            }

        }

        possibleCombination.remove(0);

        possibleCombination.remove(0);

        possibleCombination.remove(0);

        possibleCombination.remove(possibleCombination.size() - 1);
        int[] weird = {1, 2, 3, 4};
        possibleCombination.add(0, weird);
        //System.out.println(Arrays.toString(possibleCombination.get(1)));


        //shuffle the arraylist
        List<int[]> allocator = new ArrayList<>();
        for (int[] numbers : possibleCombination) {
            allocator.add(numbers.clone());

        }

        Collections.shuffle(allocator);
        //System.out.println(allocator.size());
        //settle the draft picks
        List<int[]> firstPick = new ArrayList<>(allocator.subList(0, 250)); //250
        List<int[]> secondPick = new ArrayList<>(allocator.subList(250, 449)); //199
        List<int[]> thirdPick = new ArrayList<>(allocator.subList(449, 605)); //156
        List<int[]> fourthPick = new ArrayList<>(allocator.subList(605, 724)); //119
        List<int[]> fifthPick = new ArrayList<>(allocator.subList(724, 812)); //88
        List<int[]> sixthPick = new ArrayList<>(allocator.subList(812, 875)); //63
        List<int[]> seventhPick = new ArrayList<>(allocator.subList(875, 918)); //43
        List<int[]> eighthPick = new ArrayList<>(allocator.subList(918, 946)); //28
        List<int[]> ninthPick = new ArrayList<>(allocator.subList(946, 963)); //17
        List<int[]> tenthPick = new ArrayList<>(allocator.subList(963, 974)); //11
        List<int[]> p11thPick = new ArrayList<>(allocator.subList(974, 982)); //8
        List<int[]> p12thPick = new ArrayList<>(allocator.subList(982, 989)); //7
        List<int[]> p13thPick = new ArrayList<>(allocator.subList(989, 995)); //6
        List<int[]> p14thPick = new ArrayList<>(allocator.subList(995, 1000)); //5

        List<List<int[]>> lol = new ArrayList<>();


        lol.add(firstPick);
        lol.add(secondPick);
        lol.add(thirdPick);
        lol.add(fourthPick);
        lol.add(fifthPick);
        lol.add(sixthPick);
        lol.add(seventhPick);
        lol.add(eighthPick);
        lol.add(ninthPick);
        lol.add(tenthPick);
        lol.add(p11thPick);
        lol.add(p12thPick);
        lol.add(p13thPick);
        lol.add(p14thPick);
        int first = 0;
        int second = -1;
        int third = -1;
        //System.out.println(Arrays.toString(winningCombination));
        List<List<int[]>> copy = new ArrayList<>();
        for (List<int[]> index : lol) {
            copy.add(index);

        }
        List<List<int[]>> toRemove = new ArrayList<>();
        for (List<int[]> p : copy) {

            for (int[] comb : p) {
                if (didYouWin(winningCombination, comb)) {
                    first = copy.indexOf(p);
                    toRemove.add(p);
                }

            }

        }
        copy.removeAll(toRemove);
        //System.out.println("Congratulations, the first pick goes to Player"+Integer.toString(first));
        //draw again to determine second drafting order
        int[] picking2nd = new int[4];

        do {
            generateCombi(picking2nd);
        } while (didYouWin(winningCombination, picking2nd));

        int second_size = 0;
        while (second == -1) {
            for (List<int[]> p : copy) {

                for (int[] comb : p) {
                    if (didYouWin(picking2nd, comb)) {
                        second = copy.indexOf(p);
                        second_size = p.size();
                        toRemove.add(p);
                    }
                    //lol.remove(p);
                }

            }
            //if none match, then generate the number again
            do {
                generateCombi(picking2nd);
                //continue generating until it is different from the first winning combination
            } while (didYouWin(winningCombination, picking2nd));

        }

        copy.removeAll(toRemove);
        //check with original arraylist
        for (List<int[]> p : lol) {
            if (second_size == p.size()) {
                //determine who gets to pick second in the original array
                second = lol.indexOf(p);

            }
        }
        //System.out.println("Congratulations, the second pick goes to Player"+Integer.toString(second));

        //draw again to determine third drafting order
        int[] picking3rd = new int[4];

        do {
            generateCombi(picking3rd);
            //must be different from first AND second
        } while (didYouWin(winningCombination, picking3rd) || didYouWin(picking2nd, picking3rd));
        int third_size = 0;
        while (third == -1) {
            for (List<int[]> p : copy) {

                for (int[] comb : p) {
                    if (didYouWin(picking3rd, comb)) {
                        third = copy.indexOf(p);
                        third_size = p.size();
                        toRemove.add(p);
                    }
                    //lol.remove(p);
                }

            }
            //if none match, then generate once again
            do {
                generateCombi(picking3rd);
            } while (didYouWin(winningCombination, picking3rd) || didYouWin(picking2nd, picking3rd));

        }
        copy.removeAll(toRemove);

        for (List<int[]> p : lol) {
            if (third_size == p.size()) {
                //determine who gets to pick second in the original array
                third = lol.indexOf(p);

            }
        }
      // System.out.println("Congratulations, the third pick goes to Player"+Integer.toString(third));

        //consolidate the rest of the draft order
        //ArrayList<Integer> remainingSize = new ArrayList<>(11);
        int[] remainingSize = new int[11];
        int i = 0;
        //ArrayList<Integer> remainingOrder = new ArrayList<>(11);

        for (List<int[]> p : copy) {
            remainingSize[i++] = p.size();

        }
        //System.out.println("ARRAY SIZE:"+Integer.toString(remainingSize.length));
        Arrays.sort(remainingSize);

        //convert to Hashtable

        //TreeMap so that the keys are sorted (Integers here)
        TreeMap<Integer, Integer> draftOrder = new TreeMap<>();
        draftOrder.put(1,lol.get(first).size());
        draftOrder.put(2,lol.get(second).size());
        draftOrder.put(3,lol.get(third).size());


     
        for (int j = 0; j < 11; j++) {
            int filler = 4 + 10- j;
            draftOrder.put(filler,remainingSize[j]);

        }
        Set set = draftOrder.entrySet();
        // Get an iterator
        Iterator hi = set.iterator();
        // Display elements

        while(hi.hasNext()) {
            Map.Entry me = (Map.Entry) hi.next();
            orderAscending.add((int) me.getValue()) ;




        }


        int [] magic = rankSort(orderAscending);

        ArrayList<String> finalOrder = new ArrayList<>();

        for (int u = 0 ; u < 14; u++) {
            //int ok = 14-u;
            int magics = magic[magic.length-1-u];

            if (!initial[13-magics].equals("X")) {
                    finalOrder.add(initial[13-magics]);
            }



        }

        int size = finalOrder.size();
        System.out.println("Press Any Key to begin lottery");
        Scanner startLottery = new Scanner(System.in);

        if (startLottery.hasNextLine()) {
            for (String a : finalOrder) {


                if (size > 3) {
                    System.out.println("The " + Integer.toString(size) + "th pick belongs to Team:" + a);

                }
                if (size == 3) System.out.println("The " + Integer.toString(size) + "rd pick belongs to Team:" + a);
                if (size == 2) System.out.println("The " + Integer.toString(size) + "nd pick belongs to Team:" + a);
                if (size == 1) System.out.println("The " + Integer.toString(size) + "st pick belongs to Team:" + a);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    System.out.println("lol");
                    System.exit(1);
                }
                size--;


            }
        }


    }
}














