import java.util.HashMap;

/* Find first recurring character in a string. */

public class FirstRecurringCharacter {
    
    public static char first_recurring_char(String st){
        char[] ch = st.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i<ch.length; i++){
            if(map.containsKey(ch[i])){
                return ch[i];
            } else {
                map.put(ch[i], 1);
            }
        }
        return '0';
    }
    
    public static void main(String args[]) {
        

        System.out.println("Recurring: " + first_recurring_char("tahsht"));
    }
}
