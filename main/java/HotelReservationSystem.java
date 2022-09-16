import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Comparator;
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
        System.out.println("How many hotels you want to add");
        int ch = sc.nextInt();
        for(int i = 0 ;i<ch;i++){
            addDetailsOfHotel();
        }
        displayHotels();
        bookHotelForDate();
    }
    public static void bookHotelForDate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter date from in format yyyy-MM-dd");
        String dateFrom = sc.next();
        System.out.println("Enter date to in format yyyy-MM-dd");
        String dateTo = sc.next();
        LocalDate dateF = LocalDate.parse(dateFrom);
        LocalDate dateT = LocalDate.parse(dateTo);
        int days = dateT.getDayOfMonth()-dateF.getDayOfMonth();
        days = Math.abs(days);
        System.out.println("Total days are "+days);
        System.out.println("From "+dateF+" "+dateF.getDayOfWeek()+" to "+dateT+" "+dateT.getDayOfWeek());
        getBestHotels(dateF, days);
    }

    private static void getBestHotels(LocalDate dateF,int days) {
        int isWeekDay = 0;
        int isWeekEndDay = 0;
        for (int i = 1 ;i<=days;i++){
                isWeekDay = 0;
                isWeekEndDay = 0;
                LocalDate tempDate = dateF.plusDays(i);
                if(isWeekend(tempDate)) {isWeekEndDay++;}else { isWeekDay++;}
        }
        if(isWeekDay>isWeekEndDay) {
            getCheapHotelsOnWeekDay(days);
        }else {
            getCheapHotelsOnWeekEnd(days);
        }
    }

    public static void getCheapHotelsOnWeekDay(int days){
        Hotel cheapHotelAtWeekDay = HotelMenu.hotels.stream().min(Comparator.comparingInt(Hotel::getRegularCustomerWeekdayRate)).get();
        System.out.println("You are on weekday best hotel at cheap cost");
        System.out.println(cheapHotelAtWeekDay.name+" rate per day "+cheapHotelAtWeekDay.regularCustomerWeekdayRate+" Total rates for days "+days+" are "+cheapHotelAtWeekDay.regularCustomerWeekdayRate*days);

    }
    public static void getCheapHotelsOnWeekEnd(int days){
        Hotel cheapHotelAtWeekend = HotelMenu.hotels.stream().min(Comparator.comparingInt(Hotel::getRegularCustomerWeekendRate)).get();
        System.out.println("You are on weekend best hotel at cheap cost");
        System.out.println(cheapHotelAtWeekend.name+" rate per day "+cheapHotelAtWeekend.regularCustomerWeekendRate+" Total rates for days "+days+" are "+cheapHotelAtWeekend.regularCustomerWeekendRate*days);

    }

    public static boolean isWeekend(final LocalDate ld)
    {
        DayOfWeek day = DayOfWeek.of(ld.get(ChronoField.DAY_OF_WEEK));
        return day == DayOfWeek.SUNDAY || day == DayOfWeek.SATURDAY;
    }

    private static void displayHotels() {
        for (Hotel hotel : hotelList.hotels) {
            System.out.println(hotel);
            System.out.println("----------------------------------------------------");
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
