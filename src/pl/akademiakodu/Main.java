package pl.akademiakodu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Question> questionList = new ArrayList<>();

        questionList.add(new Question("Czy Polska leży w Europie", true));
        questionList.add(new Question("Czy 2+5=7>", false));
        questionList.add(new Question("Czy 2^10 = 1024?", true));
        questionList.add(new Question("Czy Chopin urodził się w Warszawie", false));

        int numberOfPoints = 0 ;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Milionerzy: Odpowiadaj tak bądź nie na pytania");
        for (Question question: questionList) {
            System.out.println(question.getContent());
            String answer = scanner.next();
            if ((answer.equals("tak") && question.isCorrect())
                    || (answer.equals("nie") && !question.isCorrect())
                    ){
                numberOfPoints++;
            }
        }
        System.out.println("Zdobyłeś "+numberOfPoints+" punktów");

    }
}
