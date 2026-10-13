package controlflowstatements;

/**
 * Labeled loops are loops that have a label.
 * <ul>
 *   <li>{@code label} - keyword</li>
 *   <li>{@code loop} - loop</li>
 *   <li>{@code break label} - keyword</li>
 *   <li>{@code continue label} - keyword</li>
 * </ul>
 */
public class LabeledLoops {
    /*
    
    * label: outer
    * for(String animal : animals) {
    *   System.out.println("animal -> " + animal);
    *   label: inner
    *   for(int i = 0; i < animals.length; i++) {
    *     if (animals[i].equals("bird")) {
    *       continue; // break out of the outer loop
    *     }
    */
    public static void main(String[] args) {

        String animals[] = {"dog", "cat", "bird", "fish", "horse"};

        outer: 
        for(String animal : animals) {
            System.out.println("animal -> " + animal);
            inner: 
            for(int i = 0; i < animals.length; i++) {
                if (animals[i].equals("bird")) {
                    continue; // break out of the outer loop
                }
                System.out.println(animal);
            }
        }
    }

}
