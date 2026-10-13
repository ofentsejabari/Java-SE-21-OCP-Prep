package methods;

/**
 * In Java method declarations, a specifier is a keyword that gives extra rules/meaning to the method.

<p>Common method specifiers are:

<ul>
    <li>public, protected, private → access specifiers (who can call the method)</li>
    <li>static → method belongs to the class, not an object</li>
    <li>final → method cannot be overridden</li>
    <li>abstract → method has no body (must be implemented in subclass)</li>
    <li>synchronized → only one thread at a time can execute it on the same object/lock</li>
    <li>native → method implemented in non-Java code</li>
    <li>strictfp → strict floating-point behavior</li>
</ul>

<p>Example:
<pre>
public static final void printInfo() { ... }
</pre>

<p>Here:
<ul>
    <li>public = accessible everywhere</li>
    <li>static = class method</li>
    <li>final = cannot be overridden</li>
    <li>void is not a specifier; it is the return type.</li>
</ul>
*/
public class Methods {

}
