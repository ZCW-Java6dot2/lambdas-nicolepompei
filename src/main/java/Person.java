import com.sun.codemodel.internal.JForEach;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Person {
    List<Person> roster;
    Person p;



    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public Person() {
        this.name = "";
        this.birthday = LocalDate.now();
        this.gender = null;
        this.emailAddress = "";
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        Period currentAge = Period.between(birthday, currentDate);
        return currentAge.getYears();
    }

    public void printPerson() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }


//    public boolean test(Person p) {
//        boolean isFemale;
//        isFemale = p.gender.equals(Sex.FEMALE);
//        return isFemale;
//    }


    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }


    public static void printPersonsWithinAgeRange(
            List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    //one of the arguments is an anonymous class that filters members that are 18+


    CheckPerson checkPerson = (Person p) ->
            p.getAge() >= 18;



    public static void printPersonsWithPredicate(
            List<Person> roster, Predicate<Person> tester) {
                for(Person p: roster){
                    if(tester.test(p)){
                        p.printPerson();
                    }
                }
             }

    public static void processPersons(List<Person> roster, Predicate<Person> tester,
                                      Consumer<Person> block){
                 for (Person p : roster){
                     if(tester.test(p)){
                         block.accept(p);
            }
        }
    }

    public static void processPersonsWithFunction(
            List<Person> roster,
            Predicate<Person> tester,
            Function<Person, String> mapper,
            Consumer<String> block){
            for (Person p : roster){
                if(tester.test(p)){
                    String data = mapper.apply(p);
                    block.accept(data);
                }
            }
    }

    //generic version of processPersonsWithFunction that accepts a collection that contains elements of any data type as a paramter
    public static <X,Y> void processElements(
        Iterable<X> source,
        Predicate<X> tester,
        Function<X,Y> mapper,
        Consumer<Y> block){
        for(X p : source){
            if(tester.test(p)){
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    //aggregate operation that accepts lambdas as paramters

    public static void aggregateProcessElements(List<Person> roster) {
        roster.stream()
                .filter(
                        p -> p.getAge() >= 18)
                .map(p -> p.getEmailAddress())
                .forEach(email -> System.out.println(email));

    }






}