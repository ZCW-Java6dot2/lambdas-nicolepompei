import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Person {
    List<Person> roster;



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


    CheckPerson checkPerson = new CheckPerson() {
        public boolean test(Person p) {
            return p.getAge() >= 18;
        }
    };

    public static void printPersons(List<Person> roster, CheckPerson checkPerson) {
        for (Person p : roster) {
            if (checkPerson.test(p)) {
                p.printPerson();
            }
        }
    }





}