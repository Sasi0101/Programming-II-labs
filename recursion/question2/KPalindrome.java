import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.recursion.PalindromeChecker;


public class KPalindrome implements PalindromeChecker {

    /*//Just to test
    public static void main(String[] args){
        KPalindrome check = new KPalindrome();
        String a = "apple";
        if(check.isKPalindrome(a, 3)){
            System.out.println("YAY");
        }
        else System.out.println("NO");
    }
    */

    /**
     *
     * @param s the word to check
     * @param k max amount of letters to remove
     * @return whether String s is a k palindrome
     */
    public boolean isKPalindrome(String s, int k) {
        return lettersToChange(s, reverse(s), s.length(), reverse(s).length())/2 <= k;
    }

    /**
     * Check if either of them are 0 and than if 2 letters are the same than we skip that else we return the minimum letters needed to change
     * @param f the word
     * @param s the reversed word
     * @param m length of the word
     * @param n length of the word
     * @return the letters needed to be taken out *2
     */
    public int lettersToChange(String f, String s, int m, int n){
        if(m==0) return n;
        if(n==0) return m;
        if(f.charAt(m-1) == s.charAt(n-1)) return lettersToChange(f, s, m-1, n-1);
        return  1+Math.min(lettersToChange(f,s,m-1,n), lettersToChange(f,s,m,n-1));
    }

    /**
     * reverse the string by using StringBuilder
     * @param s is the word to be reversed
     * @return the reversed word
     */
    public String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

}
