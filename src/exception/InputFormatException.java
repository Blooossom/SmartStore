package exception;

public class InputFormatException extends RuntimeException{
    public InputFormatException(){
        super("입력 형식이 잘못되었습니다. 다시 입력해주세요.");
    }
    public InputFormatException(String message){
        super(message);
    }
}
