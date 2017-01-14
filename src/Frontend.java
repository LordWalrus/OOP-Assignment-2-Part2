import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

//http://stackoverflow.com/questions/11005751/is-there-a-util-to-convert-us-state-name-to-state-code-eg-arizona-to-az/11006236#11006236
//USA - (State)
// England
//Spain

/**
 * Created by Sean on 17/12/2016.
 */
public class Frontend {
    private JList list1;
    private JList list2;
    private JPanel Container;
    private JPanel Container1;
    private JPanel Container2;
    private JPanel Container3;
    private JPanel Container4;
    private JPanel Container5;
    private JPanel Container6;
    private JPanel Container7;
    private JPanel Container8;
    private JLabel Currency;
    private JLabel currency1;
    private JLabel ConversionRate;
    private JLabel Time;
    private JLabel Time1;
    private JLabel TimeDifferences;
    private JLabel DigitalClock;
    private JLabel DigitalClock1;
    private JButton button1;
    private JTextField textField1;
    private JButton button2;

    public Frontend() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
// List of all the countries that the user can choose from to compare
                try {
                    String country1 = list1.getSelectedValue().toString();
                    if( country1 == "United Kingdom"){country1 = "GBP";}
                    else if(country1 == "Spain"){country1 = "EUR";}
                    else if(country1 == "Sweden"){country1 = "SEK";}
                    else if(country1 == "Germany"){country1 = "EUR";}
                    else if(country1 == "Japan"){country1 = "JPY";}
                    else if(country1 == "Canada"){country1 = "CAD";}
                    else if(country1 == "United States of America"){country1 = "USD";}
                    else if(country1 == "China"){country1 = "CHY";}
                    else if(country1 == "Russia"){country1 = "RUB";}
                    else if(country1 == "Bulgaria"){country1 = "BGN";}
                    else if(country1 == "Croatia"){country1 = "HRK";}
                    else if(country1 == "Czech Republic"){country1 = "CZK";}
                    else if(country1 == "Denmark"){country1 = "DKK";}
                    else if(country1 == "Hungary"){country1 = "HUF";}
                    else if(country1 == "Poland"){country1 = "PLN";}
                    else if(country1 == "Romania"){country1 = "RON";}


                    String country2 = list2.getSelectedValue().toString();
                    if( country1 == "United Kingdom"){country1 = "GBP";}
                    else if(country1 == "Spain"){country1 = "EUR";}
                    else if(country1 == "Sweden"){country1 = "SEK";}
                    else if(country1 == "Germany"){country1 = "EUR";}
                    else if(country1 == "Japan"){country1 = "JPY";}
                    else if(country1 == "Canada"){country1 = "CAD";}
                    else if(country1 == "United States of America"){country1 = "USD";}
                    else if(country1 == "China"){country1 = "CHY";}
                    else if(country1 == "Russia"){country1 = "RUB";}
                    else if(country1 == "Bulgaria"){country1 = "BGN";}
                    else if(country1 == "Croatia"){country1 = "HRK";}
                    else if(country1 == "Czech Republic"){country1 = "CZK";}
                    else if(country1 == "Denmark"){country1 = "DKK";}
                    else if(country1 == "Hungary"){country1 = "HUF";}
                    else if(country1 == "Poland"){country1 = "PLN";}
                    else if(country1 == "Romania"){country1 = "RON";}


                    Compare(country1, country2);
                }catch(Exception error){

                }
            }
        });


        //User inputting a value to be converted
        //James - place label above the currency and give a title
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double convert = Double.parseDouble(ConversionRate.getText());
                double userInput = Double.parseDouble(textField1.getText());
                //Converted1 is the first value converted to the second country
                double converted1 = (convert * userInput);
                //Converted rounds the value to  decimal places
                double converted = Math.round(converted1*100)/100.00;
                currency1.setText(converted+"");



            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Frontend");
        frame.setContentPane(new Frontend().Container);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //http://stackoverflow.com/questions/7670355/convert-date-time-for-given-timezone-java
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));

        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+13"));

        //String newZealandTime = formatter.format(calendar.getTime());

    }

    public void Compare(String CountryOne, String CountryTwo) throws Exception{

        URL url = new URL("http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22"+CountryOne+CountryTwo+"%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=");

        URLConnection con = url.openConnection();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        con.getInputStream()
                )
        );

        String inputLine;
        StringBuilder response = new StringBuilder();

        while((inputLine = in.readLine()) != null)
            response.append(inputLine);
        in.close();

        System.out.println(response);

       parseJson(response.toString());

    }

    public void parseJson(String rawJson) throws JSONException {

        JSONObject obj = new JSONObject(rawJson);
        JSONObject query = obj.getJSONObject("query");
        JSONObject results = query.getJSONObject("results");
        System.out.println(results.toString());

        JSONObject rate = results.getJSONObject("rate");
            System.out.println(rate.getString("Rate"));
        ConversionRate.setText(rate.getString("Rate"));


//        JSONObject id = rate.getJSONObject("id");
//        JSONObject Name = id.getJSONObject("Name");
//        JSONObject Rate = Name.getJSONObject("Rate");
//        JSONObject Date = Rate.getJSONObject("Date");
//        JSONObject Time = Date.getJSONObject("Time");
//        JSONObject Ask = Time.getJSONObject("Ask");
//        JSONObject Bid = Ask.getJSONObject("Bid");


//        System.out.println(query.toString());
//        System.out.println(obj.getString("Rate"));

        Currency.setText(obj.getString("Rate"));




        }



}












