import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        System.out.println("How many hotels you want to add");
        int ch = sc.nextInt();
        for(int i = 0 ;i<ch;i++){
            addDetailsOfHotel();
        }
        displayHotels();
        //HotelBooking();
        getCheapHotel();
    }

    private static void getCheapHotel() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter date from in format yyyy-MM-dd");
        String dateFrom = sc.next();
        System.out.println("Enter date to in format yyyy-MM-dd");
        String dateTo = sc.next();
        LocalDate dateF = LocalDate.parse(dateFrom);
        LocalDate dateT = LocalDate.parse(dateTo);
        if(isWeekend(dateF) && isWeekend(dateT)){
            List<Hotel> cheapWeekendHotelLList = HotelMenu.hotels.stream().filter((hotel)->hotel.regularCustomerWeekendRate < 100).toList();
            System.out.println(cheapWeekendHotelLList);
        }else{
            List<Hotel> cheapWeekdayHotelLList = HotelMenu.hotels.stream().filter((hotel)->hotel.regularCustomerWeekendRate < 100).toList();
            System.out.println(cheapWeekdayHotelLList);
        }

    }

    private static void HotelBooking() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose hotels");
        for (int i =0; i<HotelMenu.hotels.size();i++) {
            System.out.println(i+" :"+HotelMenu.hotels.get(i).name);
        }
        int index = sc.nextInt();
        System.out.println("Enter date from in format yyyy-MM-dd");
        String dateFrom = sc.next();
        System.out.println("Enter date to in format yyyy-MM-dd");
        String dateTo = sc.next();
        LocalDate dateF = LocalDate.parse(dateFrom);
        LocalDate dateT = LocalDate.parse(dateTo);
        if(isWeekend(dateF) && isWeekend(dateT)){
            int weedEndRate = HotelMenu.hotels.get(index).getRewardCustomerWeekendRate();
            System.out.println(weedEndRate);
        }else{
            int weedDayRate =HotelMenu.hotels.get(index).getRewardCustomerWeekendRate();
            System.out.println(weedDayRate);
        }

    }
    public static boolean isWeekend(final LocalDate ld)
    {
        DayOfWeek day = DayOfWeek.of(ld.get(ChronoField.DAY_OF_WEEK));
        return day == DayOfWeek.SUNDAY || day == DayOfWeek.SATURDAY;
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
