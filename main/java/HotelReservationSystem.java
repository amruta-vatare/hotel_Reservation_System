import java.util.Scanner;

public class HotelReservationSystem {
    static Hotel hotel;
    static HotelMenu hotelList = new HotelMenu();
    /*private void BuildHotels() {
        final Hotel lakewood = new Hotel("Lakewood",3,110,80,90,80);
        final Hotel bridgeWood = new Hotel("BridgeWood",4,160,110,60,50);
        final Hotel ridgeWood = new Hotel("RidgeWood",2,220,100,150,40);
    }*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        addDetailsOfHotel();
        displayHotels();
    }

    private static void displayHotels() {
        for (Hotel hotel : hotelList.hotels) {
            System.out.println(hotel);
        }
    }

    private static void addDetailsOfHotel() {
        Scanner sc = new Scanner(System.in);
        hotel = new Hotel();
        System.out.println("Enter hotel Name");
        hotel.setName(sc.next());
        System.out.println("Enter rating");
        hotel.setRating(sc.nextInt());
        System.out.println("Enter week day rate for regular customer");
        hotel.setRegularCustomerWeekdayRate(sc.nextInt());
        System.out.println("Enter week day rate for reward customer");
        hotel.setRewardCustomerWeekdayRate(sc.nextInt());
        System.out.println("Enter week end rate for regular customer");
        hotel.setRegularCustomerWeekendRate(sc.nextInt());
        System.out.println("Enter week end rate for reward customer");
        hotel.setRewardCustomerWeekendRate(sc.nextInt());
        hotelList.hotels.add(hotel);
    }


}
