class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int maxBottlesDrunk = numBottles;
        int emptyBottles = numBottles;
        while (emptyBottles >= numExchange) {
            emptyBottles = emptyBottles - numExchange + 1;
            maxBottlesDrunk += 1;
            numExchange += 1;
        }
        return maxBottlesDrunk;
    }
}
