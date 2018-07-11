package pl.akademiakodu;

import java.util.ArrayList;
import java.util.List;
/*
    klasa która implementuje interfejs
    dzięki temu może być traktowana jako typ SimpleQuestionGenerator
    ale też jako typ QuestionGenerator
 */
public class SimpleQuestionGenerator implements QuestionGenerator{
    // implementacja tej metody
    @Override
    public List<Question> generatorQuestions() {
        List<Question> questionList = new ArrayList<>();
        questionList.add(new Question("Czy Polska leży w Europie", true));
        questionList.add(new Question("Czy 2+5=8>", false));
        questionList.add(new Question("Czy 2^10 = 1024?", true));
        questionList.add(new Question("Czy Chopin urodził się w Warszawie", false));
        return questionList;
    }
}
