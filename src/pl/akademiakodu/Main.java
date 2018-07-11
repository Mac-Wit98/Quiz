package pl.akademiakodu;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends JFrame {
    //ma zawierać pytania
    // ma zawierać 2 przyciski tak i nie

    public Main(){
        super("Milionerzy"); //Ustawia tytuø okna
        setSize(500,500); // Ustawia wielkość okna
        setDefaultCloseOperation(1); // Sprawia że  działa przycisk exit
        setVisible(true); //Sprawia, że widać okno
    }
    public static void main(String[] args) {
        Main main = new Main();
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
