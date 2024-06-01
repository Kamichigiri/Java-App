package javaoop;

import java.util.ArrayList;
import java.util.List;

//import com.google.common.collect.ArrayListMultimap;

public class CharPattern {

    List<Integer> checker1 = new ArrayList<>();
    List<Integer> checker2 = new ArrayList<>();


    public boolean patternCheck(String fst, String lst) {
        if (fst.length() != lst.length()) {
            return false;
        }
        checker1 = getPattern(fst);
        checker2 = getPattern(lst);
    
        // Compare the two lists
        return checker1.equals(checker2);
    }

    public List<Integer> getPattern(String chk){
        List<Integer> checker = new ArrayList<>();
        
        int count = 1;

        // Populate checker for first string
        for (int i = 1; i < chk.length(); i++) {
            if (chk.charAt(i - 1) == chk.charAt(i)) {
                count++;
            } else {
                checker.add(count);
                count = 1;
            }
        }
        checker.add(count); // Add the last count

        return checker;

    }
}
    

   

