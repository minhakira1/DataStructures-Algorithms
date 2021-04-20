class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
         if(coordinates.length==2)
            return true;
        for(int i=0;i<coordinates.length-2;i++) {
            if((coordinates[i+1][1]-coordinates[i][1])*(coordinates[i+2][0] - coordinates[i+1][0])!=(coordinates[i+2][1]-coordinates[i+1][1])*(coordinates[i+1][0] - coordinates[i][0]) )
                return false;
        }
        return true;
    }
    //solution
    //3 diem thang hang hsg a =  Ay10/Ax10 ==  Ay21/Ax21
    //(y1-y0)(x2-x1) == (y2-y1)(x1-x0)
}
