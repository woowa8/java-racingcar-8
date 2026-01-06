package racingcar.domain;

public class Car {
    private final String name;
    private int pos;
    private final String mark;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.pos = 0;
        this.mark = "-";
    }

    public String getMark() {
        return mark;
    }

    public int getPos() {
        return pos;
    }

    public String getName() {
        return name;
    }

    public void addPos(int add) {
        validatePos(this.pos + add);
        pos += add;
    }

    private void validatePos(int newPos) {
        if (this.pos < 0) {
            throw new IllegalArgumentException("[ERROR] 자동차의 위치는 음수일 수 없습니다.");
        }
    }

    private void validateName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하여야 합니다.");
        }
    }
}
