import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Counter {
    private Map<Character, Integer> charCounter = new HashMap<>();
    private Map<String, Integer> wordCounter = new HashMap<>();
    private int digitCounter = 0; // Thêm biến để đếm số lượng chữ số

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your content: ");
        String content = scanner.nextLine();

        Counter counter = new Counter();
        counter.analyze(content);
        counter.display();
    }

    public void display() {
        System.out.println("Word Count: " + wordCounter);
        System.out.println("Character Count: " + charCounter);
        System.out.println("Digit Count: " + digitCounter); // Hiển thị số chữ số
    }

    public void analyze(String content) {
        for (char ch : content.toCharArray()) {
            if (Character.isSpaceChar(ch)) continue;
            if (Character.isDigit(ch)) {
                digitCounter++; // Tăng số lượng chữ số
            } else {
                charCounter.put(ch, charCounter.getOrDefault(ch, 0) + 1);
            }
        }

        Scanner tokenizer = new Scanner(content);
        while (tokenizer.hasNext()) {
            String token = tokenizer.next();
            wordCounter.put(token, wordCounter.getOrDefault(token, 0) + 1);
        }
        tokenizer.close();
    }
}
