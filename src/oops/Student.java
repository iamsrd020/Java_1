package oops;

class Student {

    // Private fields cannot be changed directly from outside this class.
    private String name;
    private int age;

    // Setter: controlled way to change name.
    public void setName(String name) {
        this.name = name;
    }

    // Getter: controlled way to read name.
    public String getName() {
        return name;
    }

    // Setter: validates age before changing it.
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    // Getter: controlled way to read age.
    public int getAge() {
        return age;
    }
}
