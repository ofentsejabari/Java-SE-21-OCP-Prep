package oop.record;

/**
 *  A record is a shorthand for an immutable, value-based data class with canonical constructor,
 *  component accessors (no get prefix), and correct equals/hashCode/toString generated automatically.
 * 
 * KEY features:
 * 1. Immutable - The data cannot be changed after it is created.
 * 2. Value-based - The data is compared based on the values of the fields, not the reference.
 * 3. Canonical constructor - The constructor is generated automatically with the fields as parameters.
 * 4. Component accessors - The fields are accessed using the names of the fields, not the get prefix.
 * 5. Correct equals/hashCode/toString - The equals/hashCode/toString methods are generated automatically.
 * 6. Nested record class - are implicitly static
 * 
 * Example:
 * <pre>
 * public record Person(String name, int age) {
 * }
 * </pre>
 * 
 * Example:
 * <pre>
 * public record Person(String name, int age) {
 *     public String getName() {
 *         return name;
 *     }
 * }
 * </pre>
 * 
 */

public record Person(String name, int age)  {

    //-- Compact constructor — validation/normalization; no parameter list; fields are assigned automatically after the block:
    public Person {
        if (age < 0) throw new IllegalArgumentException("age");
        name = name.trim();
    }

    // -- Default constructor — no-arg constructor that chains to canonical constructor:
    public Person() {
        this(null, 0);  // must chain to canonical constructor
    }

    // -- Explicit canonical constructor — full constructor with the same signature as the header:(Redundant)
    // public Person(String name, int age) {
    //     this.name = name;
    //     this.age = age;
    // }

}
