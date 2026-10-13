package basics.variable;

/**
 * OCP notes: Variables and their types in Java.
 *
 * <p>A variable is a named memory location that stores a value. Its type determines
 * what data can be stored, allowed operations, and memory usage.
 *
 * <p>General form:
 * {@code type variableName = value;}
 * Example:
 * {@code int age = 25;}
 *
 * <p>Primitive types (store actual value):
 * <ul>
 *   <li>{@code byte}, {@code short}, {@code int}, {@code long}</li>
 *   <li>{@code float}, {@code double}</li>
 *   <li>{@code char}</li>
 *   <li>{@code boolean}</li>
 * </ul>
 *
 * <p>Reference types (store object reference):
 * {@code String}, arrays, and class types (for example {@code Scanner}).
 *
 * <p>Variable categories by scope:
 * <ul>
 *   <li>Local variable: declared inside a method/block; must be initialized before use.</li>
 *   <li>Instance variable: non-static field; belongs to each object instance.</li>
 *   <li>Static variable: class field declared with {@code static}; shared across instances.</li>
 * </ul>
 *
 * <p>Exam essentials:
 * <ul>
 *   <li>Java is strongly typed; declarations require a type.</li>
 *   <li>{@code var} is allowed only for local variable type inference.</li>
 *   <li>{@code var} is not allowed for fields, parameters, or return types.</li>
 *   <li>Default values apply to fields, not to local variables.</li>
 * </ul>
 * 
 * <p>Variable naming conventions:
 * <ul>
 *   <li>Variables names must start with a letter or underscore or dollar sign.</li>
 *   <li>Variables names can only contain letters, numbers, and underscores.</li>
 *   <li>Variables names cannot be a reserved word.</li>
 *   <li>Variables names are case-sensitive.</li>
 *   <li>Variables names should be descriptive.</li>
 *   <li>Variables names should be camelCase.</li>
 * </ul>
 */
public class Variables {
    public static void main(String[] args) {
        /**
         * Valid and invalid variable names:
         */
    }

}
