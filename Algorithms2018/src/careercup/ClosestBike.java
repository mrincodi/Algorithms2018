package careercup;

public class ClosestBike {


    public static int calculateDistanceBleed(int[][] parkingLot, int manPosRow, int manPosCol) {
        // the man is standing outside the parking lot. Can't reach any bike.
        int minDistance = Integer.MAX_VALUE - 1;
    	if (manPosRow > parkingLot.length -1 || manPosCol > parkingLot[0].length - 1)
    		return minDistance;

        // The man is sitting on a bike
        if (parkingLot[manPosRow][manPosCol] == 1)
            return 0;

        // Mark the parkingLot location as visited
        parkingLot[manPosRow][manPosCol] = -1;

        // man can move DOWN
        if (manPosRow > 0 && parkingLot[manPosRow - 1][manPosCol] != -1) {
            minDistance = Math.min(minDistance, 1 + calculateDistanceBleed(parkingLot, manPosRow - 1, manPosCol));
        }

        // man can move UP
        if (manPosRow < parkingLot.length - 1 && parkingLot[manPosRow + 1][manPosCol] != -1) {
            minDistance = Math.min(minDistance, 1 + calculateDistanceBleed(parkingLot, manPosRow + 1, manPosCol));
        }

        // man can move LEFT
        if (manPosCol > 0 && parkingLot[manPosRow][manPosCol - 1] != -1) {
            minDistance = Math.min(minDistance, 1 + calculateDistanceBleed(parkingLot, manPosRow, manPosCol - 1));
        }

        // man can move RIGHT
        if (manPosCol < parkingLot[0].length - 1 && parkingLot[manPosRow][manPosCol + 1] != -1) {
            minDistance = Math.min(minDistance, 1 + calculateDistanceBleed(parkingLot, manPosRow, manPosCol + 1));
        }

        return minDistance;
    }




    public static int calculateDistanceBetter(int[][] parkingLot, int manPosRow, int manPosCol) {
    	if (manPosRow > parkingLot.length -1 || manPosCol > parkingLot[0].length - 1)
    		return Integer.MAX_VALUE;

        // The man is already sitting on a bike. No need to check further.
        if (parkingLot[manPosRow][manPosCol] == 1)
            return 0;

        int minDistance = 1;
        while (minDistance < parkingLot.length + parkingLot[0].length) {
            for (int i = 0; i < minDistance; i++) {
                if (manPosRow + i < parkingLot.length && manPosCol + (minDistance - i) < parkingLot[0].length) {
                    // check SE
                    if (parkingLot[manPosRow + i][manPosCol + (minDistance - i)] == 1)
                        return minDistance;
                }

                if (manPosRow + i < parkingLot.length && manPosCol - (minDistance - i) > 0) {
                    // check SW
                    if (parkingLot[manPosRow + i][manPosCol - (minDistance - i)] == 1)
                        return minDistance;
                }

                if (manPosRow - i > 0 && manPosCol + (minDistance - i) < parkingLot[0].length) {
                    // check NE
                    if (parkingLot[manPosRow - i][manPosCol + (minDistance - i)] == 1)
                        return minDistance;
                }

                if (manPosRow - i > 0 && manPosCol - (minDistance - i) > 0) {
                    // check NW
                    if (parkingLot[manPosRow - i][manPosCol - (minDistance - i)] == 1)
                        return minDistance;
                }
            }
            minDistance++;
        }

        return Integer.MAX_VALUE;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
