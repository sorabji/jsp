/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author laptop
 */
public class WeatherBean implements Serializable{
  public static Map<String,String> images = new HashMap<String,String>();
  private double temp,humidity,pressure;
  private String image;

  private static void fillMap(){
    images.put("rain", "/WeatherApp/media/rain2.jpg");
    images.put("pleasant", "/WeatherApp/media/sunny.jpg");
    images.put("heavyWind", "/WeatherApp/media/windy.jpg");
  }

  public WeatherBean() {
    temp = 0;
    humidity = 0;
    pressure = 0;
    image = "";
    fillMap();
  }

  public WeatherBean(double temp, double humidity, double pressure) {
    this.temp = temp;
    this.humidity = humidity;
    this.pressure = pressure;
    fillMap();

    if (this.humidity > 90){
      this.image = images.get("rain");
    } else if (this.humidity < 90 && (this.temp > 65 && this.temp < 75)){
      this.image = images.get("pleasant");
    } else if (this.pressure > 15){
      this.image = images.get("heavyWind");
    }
  }

  public double getHumidity() {
    return humidity;
  }

  public void setHumidity(double humidity) {
    this.humidity = humidity;
  }

  public double getPressure() {
    return pressure;
  }

  public void setPressure(double pressure) {
    this.pressure = pressure;
  }

  public double getTemp() {
    return temp;
  }

  public void setTemp(double temp) {
    this.temp = temp;
  }

  public String getImage() {
    return image;
  }




}
