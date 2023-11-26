import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wordly {
    String WORD = "";
    String[] POLE;
    List<String> NONLETTERS = new ArrayList<>();
    boolean notFilled = true;


    public Wordly() {
        System.out.println("слово: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        this.WORD = input;
        this.POLE = new String[this.WORD.length()];
        startGame();
    }

    void startGame(){
        moreSpace();
        newPole(POLE);
        outPut(POLE);
        while (notFilled) {
            System.out.println("буква: ");
            Scanner scanner = new Scanner(System.in);
            String LETTER = scanner.nextLine();
            tryLetter(LETTER);
            changeFill();
        }
        System.out.println();
        System.out.println("YOU WIN!");
    }

    void tryLetter(String letter) {
        System.out.println();
        if (WORD.contains(letter)) {
            System.out.println("буква есть!");
            System.out.println("ваше поле:");
            updatePole(letter);
            outPut(POLE);

        } else {
            System.out.println("буквы нет!");
            System.out.println("ваше поле:");
            outPut(POLE);
            this.NONLETTERS.add(letter);
        }
    }

    void updatePole(String letter) {
        int index = WORD.indexOf(letter);
        POLE[index] = letter;
    }

    void changeFill() {
        int notFill = 0;
        for (int i = 0; i < POLE.length; i++) {
            if (POLE[i] == "_") {
                notFill += 1;
            }
        }
        if (notFill == 0) {
            notFilled = false;
        }
    }


    void outPut(String[] pole) {
        System.out.print("   ");
        for (int i = 0; i < pole.length; i++) {
            System.out.print(pole[i] + " ");
        }
        System.out.println();
    }

    void newPole(String[] pole) {
        for (int i = 0; i < pole.length; i++) {
            pole[i] = "_";
        }
    }


    void moreSpace() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}
