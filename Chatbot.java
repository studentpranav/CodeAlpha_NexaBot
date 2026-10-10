public class Chatbot {

    private IntentDetector intentDetector;
    private KnowledgeBase knowledgeBase;

    public Chatbot() {
        intentDetector = new IntentDetector();
        knowledgeBase = new KnowledgeBase();
    }

    public String getResponse(String userMessage) {

        String intent = intentDetector.detectIntent(userMessage);

        return knowledgeBase.getResponse(intent);
    }
}