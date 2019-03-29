import java.util.Scanner;

public class FirstInput implements State{
    Calculator calculator;

    public FirstInput(Calculator calculator){
        this.calculator = calculator;
    }

    public void getChar() {
        Character curr;
        Scanner cin = new Scanner(System.in);
        System.out.printf("Calculate: ");
        curr = cin.next().charAt(0);

        if(curr.equals('=')){
            getResult();
        }
        else if(curr.equals('+') || curr.equals('-') || curr.equals('*') || curr.equals('/') || curr.equals('x')) {
            calculator.operation = curr;
            calculator.setState(calculator.getSecondInput());

        }
        else if(curr.equals('1') || curr.equals('2') || curr.equals('3') || curr.equals('4') || curr.equals('5') || curr.equals('6') || curr.equals('7') || curr.equals('8') || curr.equals('9') || curr.equals('0')){
            calculator.firstList += curr;
            calculator.setState(calculator.getFirstInput());
        }
    }


    @Override
    public void getResult() {
        System.out.println(calculator.firstList);
    }

    @Override
    public void delete() {
        calculator.firstList = "";
        calculator.secondList = "";
        calculator.setState(calculator.getZeroState());
    }
}