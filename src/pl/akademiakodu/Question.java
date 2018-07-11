package pl.akademiakodu;
// klasa question, która jest odpowiedzialna za przechowywani ekonkretnego pytania
// Pytanie tylko ma opcje tak albo nie
public class Question {
    // treßc pytania
    private String content;
    //czy TAK jets poprawne
    private boolean isCorrect;
    // konstruktor 2 parametrowy
    public Question(String content, boolean isCorrect) {
        this.content = content;
        this.isCorrect = isCorrect;
    }
    // getter otrzymuje pytania
    public String getContent() {
        return content;
    }
    // setter zamienia treść pytania
    public void setContent(String content) {
        this.content = content;
    }
// geeter dla boolean
    public boolean isCorrect() {
        return isCorrect;
    }
// setter dla boolean
    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override // odpowiedź dla kompilatora
    // wyświetla czytelną treść pytania, wygenerował IntelIJ
    public String toString() {
        return "Question{" +
                "content='" + content + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }

}
