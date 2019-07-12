Generics are used to solve 2 problems
To make our code more type safe during compilation.
To avoid casting issues i.e., no casting is needed when we use Generics as it is automatically Inferred from the types that we defined at the runtime.

Generic Class
public class MyClass<Type1,Type2,Type3,..>
public class StringWorker<T,U>

Generic Method
public <E> void someMethod(E myvalue)
public <E> E void someMethod(E myvalue)

Generic Method syntax is inline definition rather than class level definition.
These methods can work with any type of object and we define object type when we call the method rather than when we instantiate the class.

*** This format is useful for static methods where we will not instantiate class, which will create an independent Generic Method.


If we want both parameters of a method to be same type then we can write like this
public static <A> A someMethod(A s1, A s2);

Below Generic Method is invalid because we can’t write a code in a Generic method at design time to return type of A.

public <A,B> A invalidMethod(B myvalue);


Here in design time we can’t write like this.
public <A,B> A invalidMethod(B myvalue) {
  A myVariable = new A();
}

A workaround can be but this is not usual.
public <A,B> B anotherMethod(A my value, B ignore)


Dealing with Generics Warning:
1. Understand the warning.
2. Use a type safe alternative.
3. Accept the warning, if you don’t have an option i.e., if framework doesn’t have Class with accepts Generics.
4. Test thoroughly.

Type Erasure:
This means that the Generic code we have written will be removed and add type casting during compilation of code to byte code AS JVM DOESN’T KNOW ANYTHING ABOUT GENERICS.

This Generics are useful to write type safe code during the design time and there is NO PERFORMANCE IMPACT if you use Generics as that will be removed and type casts will be added during compilation.

List<Integer> myList = new ArrayList<Integer>();
myList.add(123);
myList.add(456);
Integer item1 = myList.get(0);
Integer item2 = myList.get(1);

This code will be converted to below code and is given to JVM.
List myList = new ArrayList();
myList.add(123);
myList.add(456);
Integer item1 = (Integer)myList.get(0);
Integer item2 = (Integer)myList.get(1);


Generic Wildcards:
Flexible Collections
1. Provide an interface as the parameterised type.
2. Use subclasses
3. Use wildcards
   a. Unbounded Wildcard
   b. Bounded Wildcard

example:
Customer - super class
Individual - sub class of Customer
Company - sub class of Customer

1. Provide an interface as the parameterised type.
List<CustomerInterface> customers = new ArrayList<CustomerInterface>();
to this list we can add both Individual and company objects.

2. Use subclasses
List<Number> myNumbers = new ArrayList<Number>();
To this list we can add any sub class of Number i.e., Integer, Float, Double , Long ,Bigdecimal etc

3a. Unbounded Wildcards

public static void checkSize(List<?> someList) {

}

However below statement is INVALID.
List<?> myList = new ArrayList<?>();

3b. Bounded Wildcards
public static void checkSize(List<? extends CustomerInterface> someList) {

}

Here we can pass subclasses of CustomerInterface.

public static void checkSize(List<? extends Number> someList) {

}

Here we can pass subclasses of Number.

public static <t> void sort(List<T> list, Comparator<? super T> c)
Here we can pass either T or super class object.

Here super will allow only T or super class and it will not allow child classes. this is useful when we want to allow only that class.
