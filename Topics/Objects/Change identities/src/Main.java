class Person {
    String name;
    int age;
}

class MakingChanges {
    public static void changeIdentities(Person p1, Person p2) {
        int edad1 = p1.age;
        p1.age = p2.age;
        p2.age = edad1;

        String nombre2 = p2.name;
        p2.name = p1.name;
        p1.name = nombre2;
    }
}