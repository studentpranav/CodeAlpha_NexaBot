 public class IntentDetector {

    public String detectIntent(String message) {

        message = message.toLowerCase().trim();

        // Greeting
        if (containsAny(message,
                "hello", "hi", "hey", "good morning",
                "good afternoon", "good evening")) {
            return "hello";
        }

        // Java
        if (containsAny(message,
                "java", "java language", "learn java",
                "java programming")) {
            return "java";
        }

        // OOP
        if (containsAny(message,
                "oops", "oop", "object oriented",
                "object-oriented", "encapsulation",
                "inheritance", "polymorphism", "abstraction")) {
            return "oops";
        }

        // Internship
        if (containsAny(message,
                "internship", "intern", "internship opportunity",
                "training")) {
            return "internship";
        }

        // Placement
        if (containsAny(message,
                "placement", "placements", "job",
                "job preparation", "placement preparation",
                "placement tips", "career")) {
            return "placement";
        }

        // Projects
        if (containsAny(message,
                "project", "projects", "project idea",
                "project ideas", "portfolio")) {
            return "project";
        }

        // Help
        if (containsAny(message,
                "help", "what can you do",
                "how can you help")) {
            return "help";
        }

        // Goodbye
        if (containsAny(message,
                "bye", "goodbye", "exit", "quit")) {
            return "bye";
        }

        return "unknown";
    }

    private boolean containsAny(String message, String... keywords) {

        for (String keyword : keywords) {

            if (message.contains(keyword)) {
                return true;
            }
        }

        return false;
    }
}