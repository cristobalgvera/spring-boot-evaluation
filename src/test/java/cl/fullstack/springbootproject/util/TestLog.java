package cl.fullstack.springbootproject.util;

import org.springframework.stereotype.Component;

@Component
public class TestLog {
    private String currentTest;

    public void start() {
        StringBuilder stringBuilder = new StringBuilder("***** TEST:  START *****\n");
        stringBuilder.insert(12, currentTest);
        System.out.println(stringBuilder.toString());
    }

    public void finish() {
        StringBuilder stringBuilder = new StringBuilder("\n***** TEST:  FINISH *****");
        stringBuilder.insert(13, currentTest);
        System.out.println(stringBuilder.toString());
    }

    public void message(Object log) {
        StringBuilder stringBuilder = new StringBuilder(">INFO: ");
        stringBuilder.append(log);
        System.out.println(stringBuilder.toString());
    }

    public void warning(Object log) {
        StringBuilder stringBuilder = new StringBuilder("> WARN: ");
        stringBuilder.append(log);
        System.err.print(stringBuilder);
    }

    public String getCurrentTest() {
        return currentTest;
    }

    public void setCurrentTest(String currentTest) {
        this.currentTest = currentTest;
    }
}
