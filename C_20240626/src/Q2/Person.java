package Q2;

class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        void eat() {
            System.out.println(name + "이(가) 밥을 먹습니다.");
        }
    }
