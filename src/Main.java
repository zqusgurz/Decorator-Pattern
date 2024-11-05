interface Coffee {
    String getDescription(); // 커피 설명을 반환
    double getCost(); // 커피 가격을 반환
}

// 기본 커피 클래스 (ConcreteComponent)
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "기본 커피"; // 기본 커피 설명
    }

    @Override
    public double getCost() {
        return 2.0; // 기본 커피 가격
    }
}

// 데코레이터 클래스 (Decorator)
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee; // 데코레이터가 감쌀 커피 객체

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription(); // 기본 커피 설명을 반환
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost(); // 기본 커피 가격을 반환
    }
}

// 우유를 추가하는 데코레이터 (ConcreteDecorator)
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee); // 우유를 추가할 커피 객체를 초기화
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", 우유"; // 기존 설명에 "우유" 추가
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5; // 기존 가격에 우유 가격 추가
    }
}

// 초코를 추가하는 데코레이터 (ConcreteDecorator)
class ChocoDecorator extends CoffeeDecorator {
    public ChocoDecorator(Coffee coffee) {
        super(coffee); // 초코를 추가할 커피 객체를 초기화
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", 초코"; // 기존 설명에 "초코" 추가
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.7; // 기존 가격에 초코 가격 추가
    }
}

//// 클라이언트 코드
//public class Client {
//    public static void main(String[] args) {
//        Coffee coffee = new SimpleCoffee(); // 기본 커피 생성
//        System.out.println("주문: " + coffee.getDescription() + " | 가격: $" + coffee.getCost());
//
//        coffee = new MilkDecorator(coffee); // 커피에 우유 추가
//        System.out.println("주문: " + coffee.getDescription() + " | 가격: $" + coffee.getCost());
//
//        coffee = new ChocoDecorator(coffee); // 커피에 초코 추가
//        System.out.println("주문: " + coffee.getDescription() + " | 가격: $" + coffee.getCost());
//    }
//}