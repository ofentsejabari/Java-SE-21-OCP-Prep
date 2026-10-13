package oop.sealedClasses;
/**
 * Sealed classes in Java
 * A sealed class (or interface) is one whose direct subclasses are restricted: you declare exactly which types may extend (or implement) it. That gives you a closed, known hierarchy instead of “anyone can subclass anywhere.”

    <p> Why they exist
    <ul>
        <li>Design: You model a fixed set of variants (e.g. expression types in a compiler, payment kinds) without opening the type to arbitrary subclasses.</li>
        <li>Pattern matching: The compiler can reason that switch on a sealed type’s subtypes is exhaustive when you cover all permitted subtypes.</li>
    </ul>   

    Design: You model a fixed set of variants (e.g. expression types in a compiler, payment kinds) without opening the type to arbitrary subclasses.
    Pattern matching: The compiler can reason that switch on a sealed type’s subtypes is exhaustive when you cover all permitted subtypes.

    How you write them
    public sealed class Animal permits Cat, Dog { }
    public final class Cat extends Animal { }
    public final class Dog extends Animal { }
    sealed on the superclass (or superinterface).
    permits lists the only allowed direct subclasses; they must be accessible (often same module, or same package if not exported).
    Rules for permitted subclasses
    Each permitted subtype must declare how open it is:

    Modifier	Meaning
    final: No further subclasses.
    sealed: This type is also sealed (nested hierarchy).
    non-sealed : Subclassing is open again below this type.
    
    Sealed interfaces
    Same idea: sealed interface Shape permits Circle, Rectangle { } — only Circle and Rectangle may directly implement Shape.

    Compared to final
    final class: nobody can extend it (one implementation only).
    sealed class: only listed types may extend it (several implementations, but a closed set).
    This feature is central in modern Java for algebraic-style type hierarchies and for exhaustive switches in newer pattern-matching switch. Your oop/sealedClasses examples in the course are a good place to see permits and final/non-sealed together.
    
* 
 */

public sealed class Animals permits Cat, Sheep {

}
