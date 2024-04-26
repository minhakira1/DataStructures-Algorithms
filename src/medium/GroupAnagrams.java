package medium;

import java.util.*;

public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> anagramGroups = new HashMap<>();

    for (String string : strs) {
      char[] chars = string.toCharArray();
      Arrays.sort(chars);
      String text = new String(chars);

      if (anagramGroups.containsKey(text)) {
        anagramGroups.get(text).add(string);
      } else {
        List<String> group = new ArrayList<>();
        group.add(string);
        anagramGroups.put(text, group);
      }
    }

    return new ArrayList<>(anagramGroups.values());
  }
}
