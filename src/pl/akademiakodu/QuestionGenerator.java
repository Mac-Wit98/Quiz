package pl.akademiakodu;

import java.util.List;
//interfejs
// Służy do pomocy w odwoływaniu się do klas zawierających pytania
public interface QuestionGenerator {
    //metoda która ma zwracać nam listę pytań w jakiś sposób
    List<Question> generatorQuestions();
}
