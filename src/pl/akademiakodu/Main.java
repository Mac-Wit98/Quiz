package pl.akademiakodu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends JFrame {
    //ma zawierać pytania
    // ma zawierać 2 przyciski tak i nie
    private  JButton buttonYes;
    private  JButton buttonNo;
    private  JLabel labelQuestion;

    public Main(){
        super("Milionerzy"); //Ustawia tytuø okna
        setSize(500,500); // Ustawia wielkość okna
        setDefaultCloseOperation(1); // Sprawia że  działa przycisk exit
        setVisible(true); //Sprawia, że okno jest widoczne
        buttonYes = new JButton("Tak");
        buttonNo = new JButton("Nie");
        labelQuestion = new JLabel("Czy Polska leży w Europie?",0);
        add(labelQuestion);     //Metoda
        add(buttonYes);         //metoda
        add(buttonNo);          //metoda

        setLayout(new GridLayout(3,1));
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main main = new Main();
            }
        });
        //Main main = new Main();
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
