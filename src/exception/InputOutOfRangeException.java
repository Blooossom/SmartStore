package exception;

public class InputOutOfRangeException extends RuntimeException{
    public InputOutOfRangeException(){
    super("입력값이 범위를 벗어났습니다. 다시 입력해주세요");
    }
    public InputOutOfRangeException(String message){
        super(message);
    }
}
