package Q2;

class Superman extends Man {
    boolean sky;

    Superman(String name, int age, int power, boolean sky) {
        super(name, age, power);
        this.sky = sky;
    }

    void space() {
        System.out.println(name + "이(가) 우주로 날아갑니다.");
    }

    @Override
    void run() {
        System.out.println(name + "이(가) 빠르게 달립니다.");
    }

    @Override
    public String toString() {
        return "슈퍼맨 [name=" + name + ", age=" + age + ", power=" + power + ", sky=" + sky + "]";
    }
}