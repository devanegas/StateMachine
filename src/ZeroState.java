import java.util.Scanner;

public class ZeroState implements State {
    Calculator calculator;

    public ZeroState(Calculator calculator){
        this.calculator = calculator;
    }

    public void getChar(){
        Character curr;
        Scanner cin = new Scanner(System.in);
        System.out.printf(">: ");
        curr = cin.next().charAt(0);

        if(curr.equals('=')){
            getResult();
        }
        else if(curr.equals('1') || curr.equals('2') || curr.equals('3') || curr.equals('4') || curr.equals('5') || curr.equals('6') || curr.equals('7') || curr.equals('8') || curr.equals('9') || curr.equals('.')) {
            calculator.firstList += curr;
            calculator.setState(calculator.getFirstInput());
        }
        else{
            System.out.println("0");
        }
    }

    @Override
    public void getResult() {
        System.out.println("0");
        calculator.result = 0.0;
    }

    @Override
    public void delete() {
        System.out.println("0");
    }
}
