package app.exceptions;

public class FamilyOverflowException extends RuntimeException {

    public FamilyOverflowException(){
        super("Sorry but added new family members are prohibited because of family members limit. Maximum number of family members in every family are eight.");
    }
}
