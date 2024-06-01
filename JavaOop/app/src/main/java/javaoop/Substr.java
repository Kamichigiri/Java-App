package javaoop;

public class Substr {

    protected String checker;

    public void setString(String setter){
        this.checker = setter;
        checker = checker.toLowerCase();
        System.out.println(checker);
    }

    public boolean isSubstr(String check){

        int lengths = check.length();
        check = check.toLowerCase();

        for (int i = 0; i <= checker.length() - lengths; i++) {
            if (check.equals(checker.substring(i, i + lengths))) {
                return true;
            }
        }

        return false;
    }

}
