import java.util.Vector;

public class Calculator {
    State ZeroState;
    State FirstInput;
    State SecondInput;
    State ResultState;

    public String firstList;
    public String secondList;
    public char operation;

    public Double result;

    State state = ZeroState;


    public Calculator(){
        ZeroState = new ZeroState(this);
        FirstInput = new FirstInput(this);
        SecondInput = new SecondInput(this);
        ResultState = new ResultState(this);
        state = ZeroState;
    }

    public void getChar(){
        state.getChar();
    }

    public void getResult(){
        state.getResult();
    }

    public void delete(){
        state.delete();
    }

    public void setState(State state){
        this.state = state;
    }

    public double add(double first, double second){
        return first+second;
    }

    public double subtract(double first, double second){
        return first-second;
    }

    public double multiply(double first, double second){
        return first*second;
    }

    public double divide(double first, double second){
        return first/second;
    }

    public double negate(double number){
        return number*-1;
    }

    public State getZeroState(){
        return ZeroState;
    }

    public State getFirstInput(){
        return FirstInput;
    }

    public State getSecondInput(){
        return SecondInput;
    }

    public State getResultState(){
        return ResultState;
    }

}
