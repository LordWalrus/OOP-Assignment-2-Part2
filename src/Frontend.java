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
// GUI was made by Sean and was beautified by James
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
    private JLabel Currency;
    private JLabel currency1;
    private JLabel ConversionRate;
    private JLabel Time;
    private JLabel Time2;
    private JLabel TImeZone;
    private JLabel TImeZone1;
    private JButton button1;
    private JTextField textField1;
    private JButton button2;

    public Frontend() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
// List of all the countries that the user can choose from to compare - Started by Chris finished by Sean
                try {
                    String country1 = list1.getSelectedValue().toString();
                    String time1 = "";
                    if( country1 == "United Kingdom"){
                        country1 = "GBP";
                        time1 = "GMT+0";
                    }
                    else if(country1 == "Spain"){
                        country1 = "EUR";
                        time1 = "GMT+1";
                    }
                    else if(country1 == "Sweden"){
                        country1 = "SEK";
                        time1 = "GMT+1";
                    }
                    else if(country1 == "Germany"){
                        country1 = "EUR";
                        time1 = "GMT+1";
                    }
                    else if(country1 == "Japan"){
                        country1 = "JPY";
                        time1 = "GMT+9";
                    }
                    else if(country1 == "Canada"){
                        country1 = "CAD";
                        time1 = "GMT-6";
                    }
                    else if(country1 == "United States of America"){
                        country1 = "USD";
                        time1 = "GMT-6";
                    }
                    else if(country1 == "Russia"){
                        country1 = "RUB";
                        time1 = "GMT+3";
                    }
                    else if(country1 == "Bulgaria"){
                        country1 = "BGN";
                        time1 = "GMT+2";
                    }
                    else if(country1 == "Croatia"){
                        country1 = "HRK";
                        time1 = "GMT+1";
                    }
                    else if(country1 == "Czech Republic"){
                        country1 = "CZK";
                        time1 = "GMT+2";
                    }
                    else if(country1 == "Denmark"){
                        country1 = "DKK";
                        time1 = "GMT+1";
                    }
                    else if(country1 == "Hungary"){
                        country1 = "HUF";
                        time1 = "GMT+1";
                    }
                    else if(country1 == "Poland"){
                        country1 = "PLN";
                        time1 = "GMT+1";
                    }
                    else if(country1 == "Romania"){
                        country1 = "RON";
                        time1 = "GMT+3";
                    }

                    String country2 = list2.getSelectedValue().toString();
                    String time2 = "";
                    if( country2 == "United Kingdom"){
                        country2 = "GBP";
                        time2 = "GMT+0";
                    }
                    else if(country2 == "Spain"){
                        country2 = "EUR";
                        time2 = "GMT+1";
                    }
                    else if(country2 == "Sweden"){
                        country2 = "SEK";
                        time2 = "GMT+1";
                    }
                    else if(country2 == "Germany"){
                        country2 = "EUR";
                        time2 = "GMT+1";
                    }
                    else if(country2 == "Japan"){
                        country2 = "JPY";
                        time2 = "GMT+9";
                    }
                    else if(country2 == "Canada"){
                        country2 = "CAD";
                        time2 = "GMT-6";
                    }
                    else if(country2 == "United States of America"){
                        country2 = "USD";
                        time2 = "GMT-6";
                    }
                    else if(country2 == "Russia"){
                        country2 = "RUB";
                        time2 = "GMT+3";
                    }
                    else if(country2 == "Bulgaria"){
                        country2 = "BGN";
                        time2 = "GMT+2";
                    }
                    else if(country2 == "Croatia"){
                        country2 = "HRK";
                        time2 = "GMT+1";
                    }
                    else if(country2 == "Czech Republic"){
                        country2 = "CZK";
                        time2 = "GMT+2";
                    }
                    else if(country2 == "Denmark"){
                        country2 = "DKK";
                        time2 = "GMT+1";
                    }
                    else if(country2 == "Hungary"){
                        country2 = "HUF";
                        time2 = "GMT+1";
                    }
                    else if(country2 == "Poland"){
                        country2 = "PLN";
                        time2 = "GMT+1";
                    }
                    else if(country2 == "Romania"){
                        country2 = "RON";
                        time2 = "GMT+3";
                    }


                    // localise the time1 and time2 by calling it from further down
                    timeZone(time1, time2);

                    // Same as the above
                    Compare(country1, country2);
                }catch(Exception error){



                }
            }
        });


        //User inputting a value to be converted. - Chris
        // Labels added to help identify what is what by James.
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    double convert = Double.parseDouble(ConversionRate.getText());
                    double userInput = Double.parseDouble(textField1.getText());
                    //Converted1 is the first value converted to the second country
                    double converted1 = (convert * userInput);
                    //Converted rounds the value to  decimal places
                    double converted = Math.round(converted1 * 100) / 100.00;
                    currency1.setText(converted + "");
                }catch(Exception error){
                    JOptionPane.showMessageDialog(null, "Input currency!");

                }



            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Frontend");
        frame.setContentPane(new Frontend().Container);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setMinimumSize(frame.getSize());
    }


        // This is what make the time work by using the computer system clock and adding or taking away by whatever amount. - Sean

        public void timeZone(String timeOne, String timeTwo){

            System.out.println(timeOne);


            Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));

            DateFormat formatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss z");
            formatter.setTimeZone(TimeZone.getTimeZone(timeOne));

            DateFormat formatter1 = new SimpleDateFormat("dd MMM yyyy HH:mm:ss z");
            formatter.setTimeZone(TimeZone.getTimeZone(timeTwo));

            String TimeOutput1 = formatter.format(calendar.getTime());
            String TimeOutput2 = formatter1.format(calendar.getTime());

            Time.setText(TimeOutput2);
            Time2.setText(TimeOutput1);



    }

    // The Yahoo api within the link it parsed by the Json to convert the currency depending on the countries selected. - Sean and James
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

    //This is the Json which runs the yahoo api for the currency converter. - Sean and James

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












