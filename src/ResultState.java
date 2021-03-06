import java.util.Scanner;

public class ResultState implements State {
    Calculator calculator;

    public ResultState(Calculator calculator){
        this.calculator = calculator;
    }

    public void getChar() {
        Character curr;
        Scanner cin = new Scanner(System.in);
        System.out.printf(">: ");
        curr = cin.next().charAt(0);

        if(curr.equals('=')){
            getResult();
        } else if (curr.equals('d')) {
            delete();
        }else if (curr.equals('1') || curr.equals('2') || curr.equals('3') || curr.equals('4') || curr.equals('5') || curr.equals('6') || curr.equals('7') || curr.equals('8') || curr.equals('9') || curr.equals('.')) {
            calculator.firstList = "";
            calculator.secondList = "";
            calculator.firstList += curr;
            calculator.setState(calculator.getFirstInput());
        } else if (curr.equals('n')) {
            Double negated = calculator.negate(calculator.result);
            calculator.result = negated;

        } else if (curr.equals('+') && calculator.secondList.length()> 0 || curr.equals('-') && calculator.secondList.length()> 0 || curr.equals('*') && calculator.secondList.length()> 0 || curr.equals('/') && calculator.secondList.length()> 0 || curr.equals('x') && calculator.secondList.length()> 0){
            calculator.setState(calculator.getSecondInput());
            calculator.operation = curr;
            calculator.firstList = calculator.result.toString();
            calculator.secondList = "";

        }

    }


    @Override
    public void getResult() {
        calculator.firstList = calculator.result.toString();
        if (calculator.operation == '+') {
            calculator.result = calculator.add(Double.parseDouble(calculator.firstList), Double.parseDouble(calculator.secondList));
        } else if (calculator.operation == '-') {
            calculator.result = calculator.subtract(Double.parseDouble(calculator.firstList), Double.parseDouble(calculator.secondList));
        } else if (calculator.operation == '*' || calculator.operation == 'x') {
            calculator.result = calculator.multiply(Double.parseDouble(calculator.firstList), Double.parseDouble(calculator.secondList));
        } else if (calculator.operation == '/') {
            calculator.result = calculator.divide(Double.parseDouble(calculator.firstList), Double.parseDouble(calculator.secondList));
        }

        System.out.println("Your current result >: " + calculator.result);
    }

    @Override
    public void delete() {
        calculator.firstList = "";
        calculator.result = 0.0;
        calculator.secondList = "";
        calculator.setState(calculator.getZeroState());
    }
}
