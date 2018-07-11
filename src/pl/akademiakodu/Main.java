package pl.akademiakodu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends JFrame implements ActionListener {
    //ma zawierać pytania
    // ma zawierać 2 przyciski tak i nie
    private JButton buttonYes;
    private JButton buttonNo;
    private JLabel labelQuestion;
    // zmienna, która jest typu interfasowego
    // co oznacza, z emusi to tej zmiennej przekazać klasę
    // która będzie implementowała interfejs QuestionGenerator
    // mówimy oólnie o typie, ale nie mówi konkretnie o klasie
    // podajemy kategorie do, której bedzie należeć klasa
    private QuestionGenerator questionGenerator;
    private  int currentQuestion=0;
    private  int numberOfPoints = 0;
    //List apytań
    private List<Question> questionList = new ArrayList<>();


    public void setQuestionGenerator(QuestionGenerator questionGenerator) {
        //ustawiamy zmienną z 21 20 linijki na tą, która jest podana w argumencie metody
        this.questionGenerator = questionGenerator;
        // tutaj zakłądamy, że już mamy obiekt jakiejś klasy
        // na etapie pisania kodu nie wiemy kompletnie jaka to będzie klasa
        // tylko wiemy, że musi implementować interfejs QuestionGenerator
        // wypełniamy listę pytaniami, które są generowane za pomoca metody generateQuestion
        questionList = questionGenerator.generatorQuestions();
    }
    public Main() {
        super("Milionerzy"); //Ustawia tytuø okna
        createDefaultComponents();
        labelQuestion = new JLabel(questionList.get(0).getContent(),0);
        // label ustawiamy na 1 pytanie, które zostało wygenerowane przez questionGenerator
        add(labelQuestion);     //Metoda//dodajemy do frame naszą label
        add(buttonYes);         //metoda// dodajemy do frame nas zprzycisk
        add(buttonNo);          //metoda// dodajemy przycisk nie
        setLayout(new GridLayout(3, 1));// ukłąd naszego okna, 3  w pionie, 1 w poziomie
    }

    private void createDefaultComponents() {
        setSize(500, 500); // Ustawia wielkość okna
        setDefaultCloseOperation(1); // Sprawia że  działa przycisk exit
        setVisible(true); //Sprawia, że okno jest widoczne
        setQuestionGenerator(new SimpleQuestionGenerator());
        // ustawiamy konkretną klasę, która będzie nam generować pytania
        // za pomocą new NazwaKlasy mozemy podmienić nas zgenertor za pomocą 1 linijki kodu
        buttonYes = new JButton("Tak");// tworzymy button z napisem Tak
        buttonNo = new JButton("Nie");// tworzymy button z napisem Nie
        buttonYes.addActionListener(this);//this wskazuje na obiekt w którym jest , na rzecz, którego w tym momencie wołany jest konstruktor
        //Listener ma być obiekt Main, czyli okno
        buttonNo.addActionListener(this);
    }

    public static void main(String[] args) {
        //odpalenie okn a w wątku
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // stworzenie nowej zmiennej typu Main = nowego okna
                Main main = new Main();
            }
        });
    }
    //Ta metoda jest wywołna gdy klinkniemy na przycisk, albo yes, albo no
    @Override
    public void actionPerformed(ActionEvent e) {
        // Kolejne pytanie musi się mieścić w liście
        if (currentQuestion < questionList.size()) {
            JButton clikedButton = (JButton) e.getSource();
            Question currenQuestion = questionList.get(this.currentQuestion);
            if(clikedButton==buttonYes
                    && currenQuestion.isCorrect()
                    ){
                numberOfPoints++;
            }
            if(clikedButton == buttonNo
                    && !currenQuestion.isCorrect()
                    ){
                numberOfPoints++;
            }
        }
        if(questionList.size()>currentQuestion+1) {
            labelQuestion.setText(questionList.get(++currentQuestion).getContent());
            System.out.println("Kliknięto mnie!");
        }
        else {
            JOptionPane.showMessageDialog(this,"Koniec quizu zdobyłeś "+numberOfPoints+" punktów");
            buttonNo.setEnabled(false);
            buttonYes.setEnabled(false);
        }
    }
}
