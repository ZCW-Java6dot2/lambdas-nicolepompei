public class CheckPersonEligibleToVote implements CheckPerson{
    @Override
    public boolean test(Person p) {
        return p.getAge() >= 18;
    }
}
