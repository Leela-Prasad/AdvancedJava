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








Lambda Expressions are anonymous code block which can be passed to a method as a parameter, and then execute with in that method. Here we are passing processing task where the data resides.

Before Java 8 we cannot pass any code block as a parameter to a method.

An anonymous code block is a lambda expression when it implements a functional interface.

A functional interface should contain only one abstract method.

*** This Lambda Expression will avoid of creating classes around the code blocks.

In Groovy these Lambdas are called as Closures.

Lambda Expression:

parameters -> body

Parameters:
(String s, Integer i) -> body
(s,i) -> body // Here we don’t need to mention datatypes as it is inferred from functional interface.
myString -> body //If we have a single parameter then () are not needed.
() -> body // when there are no parameters.


Arrow:
Here Arrow separates Parameters from body(i.e., code block).
(s,i) -> {
 …
}

Body:

(s,i) -> {
 System.out.println(“Hello ” + s);
 System.out.println(“You are number “ + i);
}


If there is a single line in the body then return statement is not needed.

someInteger -> {
  someInteger + 7;
}

If there is only one line in the body then {} are not needed.

someInteger -> someInteger + 7;

someInteger -> System.out.println(someInteger);


Predefined Functional Interfaces:
These Predefined Functional Interfaces are classified into 4 types.
1. Consumer
2. Supplier
3. Function
4. Predicate


1. Consumer 
   Takes a single argument and doesn’t produce result.
   Default method is accept()
   
Consumer<T>

Consumer<String>
public void someMethod(String s)

BiConsumer<T,U>

BiConsumer<String, Integer>
public void someMethod(String s, Integer i)   

2. Supplier 
No argument and produces result.
Default method is get()

Supplier<T>

Supplier<String>
public String someMethod()

3. Function 
Takes a single argument and produces result.
Default method is apply()

Function<T,R>

Function<Integer,String>
public String someMethod(Integer i)


BiFunction<T,U,R>

BiFunction<String, Boolean, Integer>
public Integer someMethod(String s, Boolean b)

4. Predicate 
Takes a single argument and produces Boolean result.
Default method is test()

Predicate<T>

Predicate<String>
public Boolean someMethod(String s)

BiPredicate<T,U>

BiPredicate<String,Integer>
public Boolean someMethod(String s, Integer i)


*** All Iterable types now have a new function forEach() which will accept a consumer functional interface type.

*** In a lambda we cannot change variables defined in the enclosing scope i.e., we cannot change variables which are outside of code block.

Double total=0d;
myScores.forEach(score -> {
  total+= score;   // not possible.
})
return total;

*** Here we cannot change total and score variable inside lambda expression and forEach function is taking consumer as the parameter it cannot return any value.
so to change the values we need a special object called streams.

Streams:
A stream is a sequence of objects which can be manipulated through operations.
Streams are of 2 types.
1. sequential stream
2. parallel stream
in sequential stream the objects will come in a sequence.
in parallel streams we will get objects from different threads.

reduce:
Reduce function is used to reduce all the stream objects to a single value.
reduce(Double identity, BinaryOperator<Double> accumulator);

Here identity is the initial value.
BinaryOperator is a functional interface of special BiFunction<T,T,T>
Here BiFunction will take input and output of SAME type, whereas normal function can produce output in different type.

Calculating total of myStreams collection.
myScores.stream().reduce(0d, (a,b) -> a+b)

filter:
filter method is used to filter out some of the elements in the stream.
myScores.stream().filter(testCriteria).forEach(s-> System.out.println(s));

map:
map method is used to modify elements in the stream
map(Function<Double, ?> mapper)

e.g.: double each element in the stream by 2
map will accept Function 
myScores.stream().map((d) -> d*2).forEach(s-> System.out.println(s));

collect:
collect method is used to convert a stream to collection.
collect(Collector<Double,?> collector)

myStream.collect(Collectors.toList());

toMap(Function<Book,?> keyMapper, Function<Book,?> valueMapper);
myStream.collect(Collectors.toMap(b -> b.getId(), b -> b));

Method References:
If we have any existing method which will be a one of the following
consumer
supplier
predicate
function 
then that can be written with Method reference.

e.g.: 
public boolean isItLowerThan50(Double d) {
  return (d<50);
}

Above method is a predicate so this can be written with method reference
examManager.printSelectedScores(examManager::isItLowerThan50);
instead of
examManager.printSelectedScores(d -> d<50);


s -> System.out.println(s);

Here println is a consumer so we can write as 
System.out::println

We are referencing these methods with object references as there are not static methods
If we have static method then we can reference with class name.

public static boolean isItLowerThan50(Double d) {
  return (d<50);
}

examManager.printSelectedScores(ExamManager::isItLowerThan50);





There are 2 Objects
1. Logger
2. Appenders

Logger object will generate the Logging events
and these logging events are generated by below statements
log.debug(“”);
log.info(“”);

Logging Events contains below information
Level
Message that needs to be logged
Source i.e., class name where the event is generated.
Time
Other information like exception trace etc.

Appenders will catch these log events and publish it to destination like console or file or database etc.

Appenders are mentioned in a configuration file and can be changed at runtime.

*** If there is no Appender for a specific log event then that log will be lost.

For a log event there can be multiple appenders 
e.g.: a log event can be written to console and file at the same time.

Appenders publish the log events to the destination based on 2 factors.
1. source of the event i.e., which class in our application generated the event.
2. Level of severity of event.

Logging Levels
FATAL
ERROR
WARN
INFO
DEBUG
TRACE


** If log4j configuration file is not provided then the default behaviour is logging ONLY ERRORS TO CONSOLE.
ERROR StatusLogger No log4j2 configuration file found. Using default configuration: logging only errors to the console.

Log4j file
<Configuration status="INFO">
<Appenders>
</Appenders>
<Loggers>
<Logger name="LoggingExample" level="INFO">
  <AppenderRef ref="STDOUT"/>
</Logger>
<Root level="INFO">
  <AppenderRef ref="file" level=“INFO”/>
  <AppenderRef ref="STDOUT" level="ERROR"/>
</Root>
</Loggers>
</Configuration>

Here the status attribute in configuration node sets the Global Logger level, if any appender not defined the level then this global Logging Level will be taken.

*** If you don’t mention the status attribute the then default Global Logger Level will be ERROR.

In Logger node we should define one Root Logger and we can have 0 to many different loggers in the logger node.

Here Root logger also defines a global log level INFO which can be overridden in appender ref nodes.


If you see there is a logger which will log events from LoggingExample but log events from this class will be printed twice for Error and Fatal.
This is because these Error and Fatal events are received by both Logger and Root Logger,so to suppress the log events reaching to root logger we need to turn off additivity. i.e., additivity="false"
<Logger name="LoggingExample" level="INFO" additivity="false">
  <AppenderRef ref="STDOUT"/>
</Logger>

(or)
don’t mention appender ref so that root logger will take care of logging those events.
<Logger name="LoggingExample" level="INFO" />

Logging Facades:
When we have common libraries or frameworks like spring, hibernate which will used across projects then the question is which logging framework this common libraries or frameworks should use
suppose log4j is most common and if they log4j then applications which uses JUL as their logging framework will fail, so address these issues we have Logging Facades which will redirect to respective frameworks at runtime.
These facades will check whether we have log4j jar in the class path or not if it there then the logging facades will work with log4j, if it is not there then the logging facades will work with JUL.

Below are the logging facades available:
1. apache commons logging.
2. slf4j
3. JBOSS Logging.


-Djava.util.logging.config.file=“${project_loc}/logging.properties”





Thread - A single flow of code within an application.
Process - A running application.

Each Process has its own memory.
one process can’t use memory of other process 
Threads within a process share that process memory.

Process is a heavy weight task compared to a Thread.
A computer cannot run all threads at the same time, it can process one thread at a time.


Premetive Multi scheduler will decide which thread to run.
Process will manage this scheduling.


Modern Collections are Not Thread safe because we will have performance degredation for  single threaded applications

means if there is 
a method to add elements into collection
a method to get size of the collection
a method to iterate over collection

Then if you don’t write synchronise blocks we will get a collection which is corrupted.
Collections.add is not thread safe i.e., processor will execute only some lines of code in add method and it may inter leave and give the processing power to other thread which leads to collection corruption.

collection.size method will not give you correct result because in the middle of size method another thread may add an element to a collection.

So if we add synchronize block then size method will be blocked until element is added or 
add method will be blocked until size method is completed.

when we iterate a collection and an element is added during the iteration i.e., if the collection size is changed then we will get concurrent modification exception.
so we have synchronize this block also.


For List only we have a special class which is THREAD SAFE.
CopyOnWriteArrayList
this class will create a new array list by copying the contents when there is a modification to the collection.

so above 3 scenarios we can avoid synchronise blocks by using CopyOnWriteArrayList

For Other types we have to use below methods.
Collections.synchronizedList
Collections.synchronizedMap
Collections.synchronizedSet

*** These synchronised class types will have synchronized keyword on every method.


Servlet object will be created only once so we should ensure servlet is thread safe.

Controller objects are created only once by spring framework, so we need to understand that the service objects which are used are thread safe.


DeadLock:
Dead lock will occur when one thread obtained a lock on an object and is not releasing that lock, other threads cannot executes method which needs the same lock.

To avoid this Deadlock we can use 
wait and notifyAll

if the thread is obtaining a lock for a long time then it can go into wait state for some time, so that other threads which are waiting for the same lock can get a chance to execute.
wait()


Once other threads execute it can notify threads which are wait state.
notify will make the threads to change state from wait state to running state, if it gets cpu time to execute.

Notify is not harmful as it wake up the thread and ask them to try to execute.

notify will only wake up one random thread
notifyAll will wake up all threads waiting for the same thread.

Since there is no harm it is recommended to use notifyAll


Thread Interruption:
To terminate a thread which is running before it finishes its normal process we use Thread interruption.

We have a thread that is long running and we might terminate that when user press cancel button.
We should terminate the thread in a safe way i.e., we should release resources and synchronization locks. For this we will use interruption so that the thread responds to the interruption by closing all the resources and releasing synchronization locks that it has.

Thread.interrupt() - will interrupt the thread.
Thread.interrupted() - will return true/false whether the thread is interrupted or not.

Calling Thread.interrupt() will set a flag stating that the thread is interrupted.


*** If a Thread interruption occurs in a NESTED CALL then we should inform about this Thread interruption to the caller method also because
Thread interruption flag is cleared when 
Thread.interrupted() method is evaluated to true
(or)
when InterruptedException is handled 

*** so it is our responsibility to let caller to know about this interruption by setting the interruption flag using the below code.
Thread.currentThread().interrupt();


This is the reason why wait, sleep methods throw an interrupted exception stating that interruption occurs and leave the developer to ignore or handle that exception by cleaning up resources.

notify will throw interruptedException as it cannot join interrupted thread.


Thread Pools
If you are creating many SHORT lived threads then creation of thread will have performance impact, in this case we can use thread pools.

Thread Pools types
1. Fixed Thread Pool - this will create fixed number of threads before executing the threads.
2. CachedThreadPool - It will create Threads on demand. when a thread is completed and returned to the pool it will keep this thread upto 60 seconds and after that it will destroy the thread.
3.SingleThreadExecutor - This is similar to creating one thread in FixedThreadPool


ExecutorService pool = Executors.newFixedThreadPool(30);

There are 2 methods which are used to shutdown ExecutorService
pool.shutdown();
pool.shutdownNow();

shutdown will close the pool gracefully i.e., it will allow any threads to complete before it closes.
shutdownNow will stop all the threads immediately.


Problem with synchronised block is we can acquire lock and release lock in ONLY SYNCHRONIZED BLOCK.

Reentrant lock can be used to acquire lock in one method and release lock in another method.
private Lock lock = new ReentrantLock();
lock.lock();
lock.unlock();

In our example we have 
wait and notifyAll in add customers method
and wait notifyAll in remove customers method

if we invoke notifyAll in add customers method then it will wake all threads means 
add customers method threads and remove customers method threads, this is slightly inefficient.

and wait() and notifyAll() are not clear for which method they are notifying, no readability.
