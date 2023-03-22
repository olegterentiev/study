public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.add("bred", 50);
        basket.add("apple",60,2,30);
        basket.print("basket");
        System.out.println(basket.getTotalWeight());

        Basket basket1 = new Basket("Mango",300);
        basket1.print("basket1");
    }
}
