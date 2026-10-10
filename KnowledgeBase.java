 import java.util.HashMap;
import java.util.Map;

public class KnowledgeBase {

    private Map<String, String> responses;

    public KnowledgeBase() {

        responses = new HashMap<>();

        responses.put("hello",
                "Hello! 👋 I am NexaBot. How can I help you?");

        responses.put("java",
                "Java is a high-level, object-oriented programming language widely used for application development.");

        responses.put("oops",
                "OOP stands for Object-Oriented Programming. Its four main concepts are Encapsulation, Inheritance, Polymorphism and Abstraction.");

        responses.put("internship",
                "An internship helps you gain practical experience, improve technical skills and understand real-world software development.");

        responses.put("placement",
                "For placements, focus on DSA, OOP, DBMS, Operating Systems, Computer Networks, projects, aptitude and communication skills.");

        responses.put("project",
                "Projects help you apply programming concepts to real-world problems and strengthen your portfolio.");

        responses.put("help",
                "I can answer questions about Java, OOP, internships, placements and projects.");

        responses.put("bye",
                "Goodbye! 👋 Keep learning and keep building amazing projects!");

    }

    public String getResponse(String intent) {

        return responses.getOrDefault(
                intent,
                "Sorry, I don't know the answer to that yet. 🤔"
        );
    }
}