public class Client {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println("주문: " + coffee.getDescription() + " | 가격: $" + coffee.getCost());

        coffee = new MilkDecorator(coffee);
        System.out.println("주문: " + coffee.getDescription() + " | 가격: $" + coffee.getCost());

        coffee = new ChocoDecorator(coffee);
        System.out.println("주문: " + coffee.getDescription() + " | 가격: $" + coffee.getCost());
    }
}
