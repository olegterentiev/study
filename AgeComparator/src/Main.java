public class Main {
    public static void main(String[] args) {
        int vasyaAge = 14;
        int katyaAge = 24;
        int mishaAge = 40;

        int min ; // минимальный возраст
        int middle ; // средний возраст
        int max ; // максимальный возраст

        boolean vasyaAgeMax = vasyaAge >= katyaAge && vasyaAge >= mishaAge;
        boolean katyAgeMax = katyaAge >= vasyaAge && katyaAge >= mishaAge;
        boolean mishaAgeMax = mishaAge >= vasyaAge && mishaAge >= katyaAge;

        if (vasyaAge < 120 && vasyaAge > 0 && katyaAge < 120 && katyaAge > 0 && mishaAge < 120 && mishaAge > 0) {
            if (vasyaAgeMax) {
                max = vasyaAge;
                middle = katyaAge > mishaAge ? katyaAge : mishaAge;
                min = katyaAge > mishaAge ? mishaAge : katyaAge;
                System.out.println("Minimal age: " + min + "\n" +
                        "Middle age: " + middle + "\n" +
                        "Maximal age: " + max);
            } else if (katyAgeMax) {
                max = katyaAge;
                middle = vasyaAge > mishaAge ? vasyaAge : mishaAge;
                min = vasyaAge > mishaAge ? mishaAge : vasyaAge;
                System.out.println("Minimal age: " + min + "\n" +
                        "Middle age: " + middle + "\n" +
                        "Maximal age: " + max);
            } else if (mishaAgeMax) {
                max = mishaAge;
                middle = katyaAge > vasyaAge ? katyaAge : vasyaAge;
                min = katyaAge > vasyaAge ? vasyaAge : katyaAge;
                System.out.println("Minimal age: " + min + "\n" +
                        "Middle age: " + middle + "\n" +
                        "Maximal age: " + max);
            }
        }else {
            System.out.println("Неверный возраст");
        }
    }
}