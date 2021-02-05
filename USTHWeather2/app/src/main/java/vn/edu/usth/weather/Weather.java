package vn.edu.usth.weather;

public class Weather {
    private String mDate;
    private String mWeather;
    private int mImage;

    public Weather(String mDate, int mImage, String mWeather) {
        this.mDate = mDate;
        this.mImage = mImage;
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

    public int getImage() {
        return mImage;
    }

    public void setImage(int mImage) {
        this.mImage = mImage;
    }
}
