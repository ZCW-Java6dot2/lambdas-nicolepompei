
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class PersonTest {
    private Person pompy;
    private Person kyle;
    List<Person> roster;

    @Before
    public void setUp(){
        roster = new ArrayList<>();
        pompy = new Person("Pompy", LocalDate.of(1994, 3, 28), Person.Sex.FEMALE, "pompy@pompy.com");
        kyle = new Person("Kyle", LocalDate.of(1992, 2, 17), Person.Sex.FEMALE, "kyle@kyle.com");
        roster.add(pompy);
        roster.add(kyle);
    }


    @Test
    public void testAgePompy(){
        int expected = 26;
        int actual = pompy.getAge();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testAgeKyle(){
        int expected = 28;
        int actual = kyle.getAge();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printPerson(){
        pompy.printPerson();
    }

    @Test
    public void pompyGenderTest(){
        Person.Sex expected = Person.Sex.FEMALE;
        Person.Sex actual = pompy.getGender();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void pompyEmailTest(){
        String expected = "pompy@pompy.com";
        String actual = pompy.getEmailAddress();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void pompyBirthdayTest(){
        LocalDate expected = LocalDate.of(1994, 3, 28);
        LocalDate actual = pompy.getBirthday();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void pompyGetName(){
        String expected = "Pompy";
        String actual = pompy.getName();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void printPersonsOlderThanTest(){

        Person.printPersonsOlderThan(roster, 25);
    }

    @Test
    public void printPersonWithinAgeRange(){

        Person.printPersonsWithinAgeRange(roster, 25,50);
    }

    @Test
    public void checkPersonEligibleToVoteTest(){
      Person.printPersonsWithPredicate(roster,
              p -> p.getAge() >= 18
      );

    }

    @Test
    public void processPersonsTest(){
        Person.processPersons(roster, p -> p.getAge() >= 18,
                    p-> p.printPerson()
        );
    }

    @Test
    public void processPersonsWithFunctionTest(){

        //retrieves the email address from each member contained in roster who is eligible to vote and then prints it
        Person.processPersonsWithFunction(roster,
                p -> p.getAge() >= 18,
                p-> p.getEmailAddress(),
                email -> System.out.println(email)
        );
    }

    @Test
    public void processElementsTest(){


        //This method invocation performs the following actions:
        //
        //Obtains a source of objects from the collection source. In this example, it obtains a source of Person objects from the collection roster. Notice that the collection roster, which is a collection of type List, is also an object of type Iterable.
        //Filters objects that match the Predicate object tester. In this example, the Predicate object is a lambda expression that specifies which members would be eligible to vote.
        //Maps each filtered object to a value as specified by the Function object mapper. In this example, the Function object is a lambda expression that returns the e-mail address of a member.
        //Performs an action on each mapped object as specified by the Consumer object block. In this example, the Consumer object is a lambda expression that prints a string, which is the e-mail address returned by the Function object.


        Person.processElements(roster,
        p -> p.getAge() >= 18,
        p -> p.getEmailAddress(),
        email -> System.out.println(email)
        );

    }

    @Test
    public void aggregateProcessTest(){
        Person.aggregateProcessElements(roster);
    }


}



