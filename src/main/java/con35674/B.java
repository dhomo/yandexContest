package con35674;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

class Vacancy {
    private final int maxCount; // сколько кандидатов готовы принять
    private final ArrayList<Candidate> candidatsList = new ArrayList<>();
    private Candidate worstCandidate;

    public Vacancy(int maxCount) {
        this.maxCount = maxCount;
    }

    private boolean isWorst(Candidate candidate) {
        return worstCandidate == null
                || candidate.resolve < worstCandidate.resolve
                || (candidate.resolve == worstCandidate.resolve && candidate.penalty > worstCandidate.penalty);
    }

    public boolean add(Candidate candidate) {
        if (maxCount <= 0) return false;

        if (candidatsList.size() >= maxCount) {
            if (isWorst(candidate)) {
                return false;
            }
            candidatsList.remove(worstCandidate);
            candidatsList.add(candidate);
            worstCandidate = candidate;
        } else {
            candidatsList.add(candidate);
            if (isWorst(candidate)) {
                worstCandidate = candidate;
            }
        }
        return true;
    }

    public ArrayList<String> getAllCandidatesName() {
        ArrayList<String> result = new ArrayList<>();
        candidatsList.forEach(candidate -> result.add(candidate.name));
        return result;
    }
}

class Candidate {
    public String name;
    public int resolve; // количество решенных задач
    public int penalty; // штрафные баллы

    public Candidate(String name, int resolve, int penalty) {
        this.name = name;
        this.resolve = resolve;
        this.penalty = penalty;
    }
}

public class B {
    static HashMap<String, Vacancy> vacancies = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("[,\n]");

        int n = scan.nextInt(); // парсим вакансии
        for (int i = 0; i < n; i++) {
            String position = scan.next();
            int maxCount = scan.nextInt();
            vacancies.put(position, new Vacancy(maxCount));
        }
        n = scan.nextInt(); //  парсим кандидатов
        for (int i = 0; i < n; i++) {
            String name = scan.next();
            String vacancyName = scan.next();
            int resolve = scan.nextInt();
            int penalty = scan.nextInt();
            vacancies.get(vacancyName).add(new Candidate(name, resolve, penalty));
        }
        printCandidatesNames();
    }

    public static void printCandidatesNames() {
        TreeSet<String> candidatesNames = new TreeSet<>();
        vacancies.forEach((k, v) -> candidatesNames.addAll(v.getAllCandidatesName()));
        candidatesNames.forEach(System.out::println);
    }
}

