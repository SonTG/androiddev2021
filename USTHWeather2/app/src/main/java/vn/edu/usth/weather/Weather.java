package vn.edu.usth.weather;

public class Weather {
    private String mDate;
    private String mWeather;

    public Weather(String mDate, String mWeather) {
        this.mDate = mDate;
        this.mWeather = mWeather;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }

    public String getWeather() {
        return mWeather;
    }

    public void setWeather(String mWeather) {
        this.mWeather = mWeather;
    }
}
