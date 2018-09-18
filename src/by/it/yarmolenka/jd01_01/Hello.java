package by.it.yarmolenka.jd01_01;

class Hello {
    //объявление члена класса, который хранит содержимое слогана
    private String slogan=("Hello World!");

    //метод установки нового значения слогана
    void setSlogan(String slogan) {
        this.slogan = slogan;
    }
    // определение метода вывода слогана на устройство
    // в даном случае - на консоль
    void printSlogan() {
        System.out.println(slogan);
    }
}
