
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Voting {
    private int type; // 0 for one vote, 1 for multi votes
    String question;
    private HashMap<String, HashSet<Vote>> choices;
    private boolean isAnonymous;
    private ArrayList<Person> voters;


    public Voting(int type, String question, boolean isAnonymous) {
        this.type = type;
        this.question = question;
        this.isAnonymous = isAnonymous;
        this.choices = new HashMap<>();
        this.voters = new ArrayList<>();
    }

    public ArrayList<String> getChoices() {
        return new ArrayList<>(choices.keySet());
    }

    public void createChoice(String choice) {
        choices.putIfAbsent(choice, new HashSet<>());
    }


    public void vote(Person voter, ArrayList<String> voterChoices) {
        if (isAnonymous) {
            System.out.println("This is an anonymous voting. Use the correct method.");
            return;
        }

        if (voters.contains(voter)) {
            System.out.println("This voter has already voted.");
            return;
        }

        for (String choice : voterChoices) {
            if (choices.containsKey(choice)) {
                choices.get(choice).add(new Vote(voter, java.time.LocalDate.now().toString()));
            }
        }
        voters.add(voter);
    }


    public void vote(Person person) {
        if (!isAnonymous) {
            System.out.println("This is not an anonymous voting. Use the correct method.");
            return;
        }

        Random random = new Random();
        ArrayList<String> availableChoices = getChoices();
        String randomChoice = availableChoices.get(random.nextInt(availableChoices.size()));
        choices.get(randomChoice).add(new Vote(person, java.time.LocalDate.now().toString()));
    }


    public void printResults() {
        System.out.println("Voting results for: " + question);
        choices.forEach((choice, votes) -> System.out.println(choice + ": " + votes.size() + " votes"));
    }


    public void printVoters() {
        if (isAnonymous) {
            System.out.println("This is an anonymous voting. Cannot display voter list.");
            return;
        }

        System.out.println("Voters for each option in voting: " + question);
        choices.forEach((choice, votes) -> {
            System.out.print(choice + ": ");
            votes.forEach(vote -> System.out.print(vote.getVoter() + ", "));
            System.out.println();
        });
    }
}