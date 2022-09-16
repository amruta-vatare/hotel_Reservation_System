public class Hotel {
    String name;
    int regularCustomerWeekdayRate;
    int regularCustomerWeekendRate;
    int rewardCustomerWeekdayRate;
    int rewardCustomerWeekendRate;
    int rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegularCustomerWeekdayRate() {
        return regularCustomerWeekdayRate;
    }

    public void setRegularCustomerWeekdayRate(int regularCustomerWeekdayRate) {
        this.regularCustomerWeekdayRate = regularCustomerWeekdayRate;
    }

    public int getRegularCustomerWeekendRate() {
        return regularCustomerWeekendRate;
    }

    public void setRegularCustomerWeekendRate(int regularCustomerWeekendRate) {
        this.regularCustomerWeekendRate = regularCustomerWeekendRate;
    }

    public int getRewardCustomerWeekdayRate() {
        return rewardCustomerWeekdayRate;
    }

    public void setRewardCustomerWeekdayRate(int rewardCustomerWeekdayRate) {
        this.rewardCustomerWeekdayRate = rewardCustomerWeekdayRate;
    }

    public int getRewardCustomerWeekendRate() {
        return rewardCustomerWeekendRate;
    }

    public void setRewardCustomerWeekendRate(int rewardCustomerWeekendRate) {
        this.rewardCustomerWeekendRate = rewardCustomerWeekendRate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "name :'" + name + '\'' +
                ",\n weekday rate for regular customer : " + regularCustomerWeekdayRate +
                ",\n weekend rate for regular customer : " + regularCustomerWeekendRate +
                ",\n Weekday rate for reward customer : " + rewardCustomerWeekdayRate +
                ",\n Weekend rate reward customer : " + rewardCustomerWeekendRate +
                ",\n rating : " + rating;
    }
}
