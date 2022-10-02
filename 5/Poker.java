import java.util.*;

class Poker {
    static String[] deck = { "cA", "cK", "cQ", "cJ", "c10", "c9", "c8", "c7", "c6",
            "c5", "c4", "c3", "c2", // Clovers
            "pA", "pK", "pQ", "pJ", "p10", "p9", "p8", "p7", "p6",
            "p5", "p4", "p3", "p2", // Pickes
            "hA", "hK", "hQ", "hJ", "h10", "h9", "h8", "h7", "h6",
            "h5", "h4", "h3", "h2", // Hearts
            "dA", "dK", "dQ", "dJ", "d10", "d9", "d8", "d7", "d6",
            "d5", "d4", "d3", "d2" }; // Diamonds
    static String[][] player_combinations = new String[0][5];
    static String[][] opponent_combinations = new String[0][5];

    public static void main(String[] args) {
        String[] cards = { "c2", "c3", "c4", "c5", "c6", "c7" };
        Poker p = new Poker(); // This statement requires knowledge about Object-Oriented Programming (more in
                               // CS2)
        // Example to validate your implementation of method deleteCards
        String[] discard = { "c4" };
        String[] newCards = p.discard_cards(cards, discard);
        System.out.println(Arrays.toString(newCards));
        // The following call must print the following combination (order of the
        // elements inside the combination does not matter):
        // "c2", "c3", "c5", "c6", "c7"
        // Example to validate your implementation of method possible_hands
        p.possible_hands(cards, new String[0]);
        // The following call must print the following combinations (order of
        // combinations and/or elements inside the combinations do not matter):
        // "c2", "c3", "c4", "c5", "c6"
        // "c2", "c3", "c4", "c5", "c7"
        // "c2", "c3", "c4", "c6", "c7"
        // "c2", "c3", "c5", "c6", "c7"
        // "c2", "c4", "c5", "c6", "c7"
        // "c3", "c4", "c5", "c6", "c7"
        System.out.println(Arrays.deepToString(Poker.player_combinations));
        // Example to validate your implementation of method possible_hands_opponent
        String[] cardsOnCommunity = { "c2", "c3", "c4" };
        String[] cardsAvailable = { "c2", "c3", "c4", "c5", "c6", "c7" };
        p.possible_hands_opponent(cardsAvailable, cardsOnCommunity, new String[0]);
        // The following call must print the following combinations (order of
        // combinations and/or elements inside the combinations do not matter):
        // "c2", "c3", "c4", "c5", "c6"
        // "c2", "c3", "c4", "c5", "c7"
        // "c2", "c3", "c4", "c6", "c7"
        System.out.println(Arrays.deepToString(Poker.opponent_combinations));

    }

    // Exercise 1
    public String[] discard_cards(String[] initialCards, String[] cardsToDiscard) {
        // stopper
        if (cardsToDiscard.length == 0) {
            return initialCards;
        }

        // search for cards that in cardsToDiscard and initialCards
        int initCardsLength = initialCards.length;
        for (int i = 0; i < initCardsLength; i++)
            if (initialCards[i].equals(cardsToDiscard[0]))
                return discard_cards(remove_element_stringArray(initialCards, i),
                        remove_element_stringArray(cardsToDiscard, 0));

        return discard_cards(initialCards, remove_element_stringArray(cardsToDiscard, 0));
    }

    // Exercise 2
    public void possible_hands(String[] cardsAvailable, String[] cardsOnHands) {
        // Write your code below
        // stopper
        if (cardsOnHands.length == 5) {
            player_combinations = add_element_2Darray(player_combinations, cardsOnHands);
            // System.out.println(Arrays.toString(cardsOnHands));
            return;
        }
        ArrayList<String> cardsOnHandsList = Array2ArrayList(cardsOnHands);

        int cardsAmount = cardsAvailable.length;
        int index = cardsOnHands.length;
        int handSizeMax = 5;

        for (int i = index; i < cardsAmount; i++) {
            // requirement eliminates basicly the ones that are not sorted
            boolean requirement = cardsAmount - i + 1 > handSizeMax - index;
            if ((!cardsOnHandsList.contains(cardsAvailable[i])) && requirement) {
                cardsOnHandsList.add(cardsAvailable[i]);
                possible_hands(cardsAvailable, ArrayList2Array(cardsOnHandsList));
            } else
                continue;
            cardsOnHandsList.remove(cardsOnHandsList.size() - 1);

        }

        return;
        // Write your code above
    }

    // Exercise 3
    public void possible_hands_opponent(String[] cardsAvailable, String[] cardsOnCommunity, String[] cardsOnHands) {
        // Write your code below
        // stopper
        if (cardsOnHands.length == 5) {
            boolean communityUsedEnough = communityUsedChecker(cardsOnCommunity, cardsOnHands);
            if (communityUsedEnough) {
                opponent_combinations = add_element_2Darray(opponent_combinations, cardsOnHands);
                // System.out.println(Arrays.toString(cardsOnHands));
            }
            // System.out.println(Arrays.toString(cardsOnHands));
            return;
        }
        ArrayList<String> cardsOnHandsList = Array2ArrayList(cardsOnHands);

        int cardsAmount = cardsAvailable.length;
        int index = cardsOnHands.length;
        int handSizeMax = 5;

        for (int i = index; i < cardsAmount; i++) {
            // requirement eliminates basicly the ones that are not sorted
            boolean requirement = cardsAmount - i + 1 > handSizeMax - index;
            if ((!cardsOnHandsList.contains(cardsAvailable[i])) && requirement) {
                cardsOnHandsList.add(cardsAvailable[i]);
                possible_hands_opponent(cardsAvailable, cardsOnCommunity, ArrayList2Array(cardsOnHandsList));
            } else
                continue;
            cardsOnHandsList.remove(cardsOnHandsList.size() - 1);
        }

        return;
        // Write your code above
    }

    public static boolean communityUsedChecker(String[] cardsOnCommunity, String[] cardsOnHands) {
        int counter = 0;
        for (int i = 0; i < cardsOnHands.length; i++) {
            for (int j = 0; j < cardsOnCommunity.length; j++) {
                if (cardsOnHands[i].equals(cardsOnCommunity[j])) {
                    counter++;
                }
            }
        }
        if (counter < 3)
            return false;
        else
            return true;
    }

    // Method to add a new element into a 2D array (array of array of String)
    public static String[][] add_element_2Darray(String[][] oldArray, String[] newElement) {
        int elements = oldArray.length;
        String[][] newArray = new String[elements + 1][5];
        if (oldArray.length > 0) {
            for (int i = 0; i < elements; i++) {
                newArray[i] = oldArray[i];
            }
            newArray[elements] = newElement;
        } else
            newArray[0] = newElement;
        return newArray;
    }

    // code related to Exercise 1
    public static String[] remove_element_stringArray(String[] oldArray, int indexOfTheElement) {
        int elements = oldArray.length;
        String[] newArray = new String[elements - 1];
        // if we found the card we want to discard, the right side should be 1 unit
        // closer
        int found = 0;
        for (int i = 0; i < elements; i++) {
            if (i == indexOfTheElement) {
                found = 1;
                continue;
            } else {
                newArray[i - found] = oldArray[i];
            }
        }
        return newArray;
    }

    // Method to "transform" an array into an ArrayList (both containing String)
    public static ArrayList<String> Array2ArrayList(String[] array) {
        return new ArrayList<String>(Arrays.asList(array));
    }

    // Method to "transform" an ArrayList into an array (both containing String)
    public static String[] ArrayList2Array(ArrayList<String> strList) {
        String[] array = strList.toArray(new String[0]);
        return array;
    }
}
