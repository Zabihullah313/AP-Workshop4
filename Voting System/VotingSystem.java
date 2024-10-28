import java.util.ArrayList;
import java.util.Objects;

public class VotingSystem {
    private ArrayList<Voting> votingList = new ArrayList<>();

    public void createVoting(String question, boolean isAnonymous, int type, ArrayList<String> choices) {
        Voting voting = new Voting(type, question, isAnonymous);
        choices.forEach(voting::createChoice);
        votingList.add(voting);
    }

    public Voting getVoting(int index) {
        return votingList.get(index);
    }

    public ArrayList<Voting> getVotingList() {
        return votingList;
    }

    public void printResults(int index) {
        votingList.get(index).printResults();
    }

    public void printVoters(int index) {
        votingList.get(index).printVoters();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VotingSystem that = (VotingSystem) o;
        return Objects.equals(votingList, that.votingList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(votingList);
    }

    public void printVoting(int index) {
        Voting voting = votingList.get(index);
        System.out.println("Question: " + voting.question);
        voting.getChoices().forEach(System.out::println);
    }
}
