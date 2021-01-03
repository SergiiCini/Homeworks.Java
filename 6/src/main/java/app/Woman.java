package app;

public final class Woman extends Human {
    private Family family;

    public Woman(String name, String surname, int year){
        super(name, surname, year);
    }

    @Override
    public void greetPet() {
        System.out.printf("Привет, %s", family.getPet().getNickname());
    }

    public void makeup(){
        System.out.println("Сегодня особый день, пойдука я в салон красоты...");
    }
}
