import java.util.Scanner;

public class SecondInput implements State {
    Calculator calculator;

    public SecondInput(Calculator calculator){
        this.calculator = calculator;
    }

    public void getChar() {
        Character curr;
        Scanner cin = new Scanner(System.in);
        System.out.printf(">: ");
        curr = cin.next().charAt(0);

        if(curr.equals('=') && calculator.secondList.length()>0){
            getResult();
        } else if (curr.equals('1') || curr.equals('2') || curr.equals('3') || curr.equals('4') || curr.equals('5') || curr.equals('6') || curr.equals('7') || curr.equals('8') || curr.equals('9') || curr.equals('0')) {
            calculator.secondList += curr;
            calculator.setState(calculator.getSecondInput());
        } else if (curr.equals('n')) {
            Double negated = calculator.negate(Double.parseDouble(calculator.secondList));
            calculator.secondList = negated.toString();

        } else if (curr.equals('+') && calculator.secondList.length()> 0 || curr.equals('-') && calculator.secondList.length()> 0 || curr.equals('*') && calculator.secondList.length()> 0 || curr.equals('/') && calculator.secondList.length()> 0 || curr.equals('x') && calculator.secondList.length()> 0) {
            if (calculator.operation == '+') {
                calculator.result = calculator.add(Double.parseDouble(calculator.firstList), Double.parseDouble(calculator.secondList));
            } else if (calculator.operation == '-') {
                calculator.result = calculator.subtract(Double.parseDouble(calculator.firstList), Double.parseDouble(calculator.secondList));
            } else if (calculator.operation == '*' || calculator.operation == 'x') {
                calculator.result = calculator.multiply(Double.parseDouble(calculator.firstList), Double.parseDouble(calculator.secondList));
            } else if (calculator.operation == '/') {
                calculator.result = calculator.divide(Double.parseDouble(calculator.firstList), Double.parseDouble(calculator.secondList));
            }
            calculator.operation = curr;
            calculator.firstList = calculator.result.toString();
            calculator.secondList = "";
            calculator.setState(calculator.getSecondInput());

            System.out.println(calculator.result);

        }

    }


    @Override
    public void getResult() {
        calculator.setState(calculator.getResultState());
        //calculator.firstList = calculator.result.toString();
        if (calculator.operation == '+') {
            calculator.result = calculator.add(Double.parseDouble(calculator.firstList), Double.parseDouble(calculator.secondList));
        } else if (calculator.operation == '-') {
            calculator.result = calculator.subtract(Double.parseDouble(calculator.firstList), Double.parseDouble(calculator.secondList));
        } else if (calculator.operation == '*' || calculator.operation == 'x') {
            calculator.result = calculator.multiply(Double.parseDouble(calculator.firstList), Double.parseDouble(calculator.secondList));
        } else if (calculator.operation == '/') {
            calculator.result = calculator.divide(Double.parseDouble(calculator.firstList), Double.parseDouble(calculator.secondList));
        }

        System.out.println(calculator.result);
        //Should not work
        //System.out.println(calculator.result);
    }

    @Override
    public void delete() {

    }
}
