package easy;

public class NumberofStudentsUnabletoEatLunch {
  public static int countStudents(int[] students, int[] sandwiches) {
    int count1Students = 0, count0Students = 0;
    for (int student : students) {
      if (student == 0) {
        count0Students++;
      } else {
        count1Students++;
      }
    }
    for (int sandwich : sandwiches) {
      if ((sandwich == 0 && count0Students == 0)
              || (sandwich == 1 && count1Students == 0))
        break;
      if (sandwich == 0)
        count0Students--;
      else
        count1Students--;
    }
    return count0Students + count1Students;
  }
}
