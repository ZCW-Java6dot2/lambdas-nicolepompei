
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PersonTest {
    private Person pompy;
    private Person kyle;
    List<Person> people;

    @Before
    public void setUp(){
        people = new ArrayList<>();
        pompy = new Person("Pompy", LocalDate.of(1994, 3, 28), Person.Sex.FEMALE, "pompy@pompy.com");
        kyle = new Person("Kyle", LocalDate.of(1992, 2, 17), Person.Sex.FEMALE, "kyle@kyle.com");
        people.add(pompy);
        people.add(kyle);
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

        Person.printPersonsOlderThan(people, 25);
    }

    @Test
    public void printPersonWithinAgeRange(){

        Person.printPersonsWithinAgeRange(people, 25,50);
    }

    @Test
    public void checkPersonEligibleToVoteTest(){
      Person.printPersons(people, pompy.checkPerson);

    }



}



