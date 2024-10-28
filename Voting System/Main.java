import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        VotingSystem votingSystem = new VotingSystem();
        //We give an Example for US 2024 election
        ArrayList<String> choices = new ArrayList<>();
        choices.add("Donald Trump");
        choices.add("Kamala Harris");
        votingSystem.createVoting("Which person do you vote?", false, 0, choices);

        Person person1 = new Person("Ali", "Hussaini");
        Person person2 = new Person("Zabihullah", "Mohammadi");


        ArrayList<String> votes = new ArrayList<>();
        votes.add("Donald Trump");
        votingSystem.getVoting(0).vote(person1, votes);
        votingSystem.getVoting(0).vote(person2, votes);


        votingSystem.printResults(0);

    }
}