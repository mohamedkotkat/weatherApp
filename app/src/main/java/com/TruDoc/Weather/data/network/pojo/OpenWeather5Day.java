package com.TruDoc.Weather.data.network.pojo;

import com.TruDoc.Weather.utils.ItemType;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

public class OpenWeather5Day {

        @SerializedName("cod")
        @Expose
        private String cod;
        @SerializedName("message")
        @Expose
        private double message;
        @SerializedName("cnt")
        @Expose
        private Double cnt;
        @SerializedName("list")
        @Expose
        private java.util.List<List> list = null;
        @SerializedName("city")
        @Expose
        private City city;


        public String getCod() {
            return cod;
        }

        public void setCod(String cod) {
            this.cod = cod;
        }

        public double getMessage() {
            return message;
        }

        public void setMessage(double message) {
            this.message = message;
        }

        public Double getCnt() {
            return cnt;
        }

        public void setCnt(Double cnt) {
            this.cnt = cnt;
        }

        public java.util.List<List> getList() {
            return list;
        }

        public void setList(java.util.List<List> list) {
            this.list = list;
        }

        public City getCity() {
            return city;
        }

        public void setCity(City city) {
            this.city = city;
        }

        public class City {

            @SerializedName("id")
            @Expose
            private int id;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("coord")
            @Expose
            private Coord coord;
            @SerializedName("country")
            @Expose
            private String country;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Coord getCoord() {
                return coord;
            }

            public void setCoord(Coord coord) {
                this.coord = coord;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

        }


        public class Clouds {

            @SerializedName("all")
            @Expose
            private int all;

            public int getAll() {
                return all;
            }

            public void setAll(int all) {
                this.all = all;
            }

        }


        public class Coord {

            @SerializedName("lat")
            @Expose
            private double lat;
            @SerializedName("lon")
            @Expose
            private double lon;

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLon() {
                return lon;
            }

            public void setLon(double lon) {
                this.lon = lon;
            }

        }


        public class List {

            private Integer Celltype = ItemType.Post;
            private Integer sectionPostion ;
            private String title;
            @SerializedName("dt")
            @Expose
            private Double dt;
            @SerializedName("main")
            @Expose
            private Main main;
            @SerializedName("weather")
            @Expose
            private java.util.List<Weather> weather = null;
            @SerializedName("clouds")
            @Expose
            private Clouds clouds;
            @SerializedName("wind")
            @Expose
            private Wind wind;
            @SerializedName("snow")
            @Expose
            private Snow snow;
            @SerializedName("sys")
            @Expose
            private Sys sys;
            @SerializedName("dt_txt")
            @Expose
            private String dtTxt;

            public Double getDt() {
                return dt;
            }

            public void setDt(Double dt) {
                this.dt = dt;
            }

            public Main getMain() {
                return main;
            }

            public void setMain(Main main) {
                this.main = main;
            }

            public java.util.List<Weather> getWeather() {
                return weather;
            }

            public void setWeather(java.util.List<Weather> weather) {
                this.weather = weather;
            }

            public Clouds getClouds() {
                return clouds;
            }

            public void setClouds(Clouds clouds) {
                this.clouds = clouds;
            }

            public Wind getWind() {
                return wind;
            }

            public void setWind(Wind wind) {
                this.wind = wind;
            }

            public Snow getSnow() {
                return snow;
            }

            public void setSnow(Snow snow) {
                this.snow = snow;
            }

            public Sys getSys() {
                return sys;
            }

            public void setSys(Sys sys) {
                this.sys = sys;
            }

            public String getDtTxt() {
                return dtTxt;
            }

            public void setDtTxt(String dtTxt) {
                this.dtTxt = dtTxt;
            }




            public Integer getCelltype() {
                return Celltype;
            }

            public void setCelltype(Integer celltype) {
                Celltype = celltype;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Integer getSectionPostion() {
                return sectionPostion;
            }

            public void setSectionPostion(Integer sectionPostion) {
                this.sectionPostion = sectionPostion;
            }
        }

        public class Main {

            @SerializedName("temp")
            @Expose
            private double temp;
            @SerializedName("temp_min")
            @Expose
            private double tempMin;
            @SerializedName("temp_max")
            @Expose
            private double tempMax;
            @SerializedName("pressure")
            @Expose
            private Double pressure;
            @SerializedName("sea_level")
            @Expose
            private double seaLevel;
            @SerializedName("grnd_level")
            @Expose
            private Double grndLevel;
            @SerializedName("humidity")
            @Expose
            private Double humidity;
            @SerializedName("temp_kf")
            @Expose
            private Double tempKf;




            public double getTemp() {
                return temp;
            }

            public void setTemp(double temp) {
                this.temp = temp;
            }

            public double getTempMin() {
                return tempMin;
            }

            public void setTempMin(double tempMin) {
                this.tempMin = tempMin;
            }

            public double getTempMax() {
                return tempMax;
            }

            public void setTempMax(double tempMax) {
                this.tempMax = tempMax;
            }

            public Double getPressure() {
                return pressure;
            }

            public void setPressure(Double pressure) {
                this.pressure = pressure;
            }

            public double getSeaLevel() {
                return seaLevel;
            }

            public void setSeaLevel(double seaLevel) {
                this.seaLevel = seaLevel;
            }

            public Double getGrndLevel() {
                return grndLevel;
            }

            public void setGrndLevel(Double grndLevel) {
                this.grndLevel = grndLevel;
            }

            public Double getHumidity() {
                return humidity;
            }

            public void setHumidity(Double humidity) {
                this.humidity = humidity;
            }

            public Double getTempKf() {
                return tempKf;
            }

            public void setTempKf(Double tempKf) {
                this.tempKf = tempKf;
            }


        }


        public class Snow {

            @SerializedName("3h")
            @Expose
            private double _3h;

            public double get3h() {
                return _3h;
            }

            public void set3h(double _3h) {
                this._3h = _3h;
            }

        }


        public class Sys {

            @SerializedName("pod")
            @Expose
            private String pod;

            public String getPod() {
                return pod;
            }

            public void setPod(String pod) {
                this.pod = pod;
            }

        }


        public class Weather {

            @SerializedName("id")
            @Expose
            private int id;
            @SerializedName("main")
            @Expose
            private String main;
            @SerializedName("description")
            @Expose
            private String description;
            @SerializedName("icon")
            @Expose
            private String icon;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMain() {
                return main;
            }

            public void setMain(String main) {
                this.main = main;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

        }


        public class Wind {

            @SerializedName("speed")
            @Expose
            private double speed;
            @SerializedName("deg")
            @Expose
            private double deg;

            public double getSpeed() {
                return speed;
            }

            public void setSpeed(double speed) {
                this.speed = speed;
            }

            public double getDeg() {
                return deg;
            }

            public void setDeg(double deg) {
                this.deg = deg;
            }

        }

        public HashMap<String, ArrayList<Main>> getMinMaxTemp() throws ParseException {

            ArrayList<List> arrayList = new ArrayList<>();
            arrayList.addAll(getList());
            return getDateWise(arrayList);

        }
    public  ArrayList<List> getDataTemp() throws ParseException {

        ArrayList<List> arrayList = new ArrayList<>();
        arrayList.addAll(getList());
        return getDateGrouped(arrayList);

    }

        private HashMap<String, ArrayList<OpenWeather5Day.Main>> getDateWise(ArrayList<OpenWeather5Day.List> arrayList) throws ParseException {
            ArrayList<Double> arrayListTemp;
            HashMap<String, ArrayList<OpenWeather5Day.Main>> tempListDateWise = new HashMap<>();
            ArrayList<OpenWeather5Day.Main> arrayList1 = new ArrayList<>();
            ArrayList<OpenWeather5Day.Main> arrayList2 = new ArrayList<>();
            ArrayList<OpenWeather5Day.Main> arrayList3 = new ArrayList<>();
            ArrayList<OpenWeather5Day.Main> arrayList4 = new ArrayList<>();
            ArrayList<OpenWeather5Day.Main> arrayList5 = new ArrayList<>();
            String dateSecondDay = "", dateFirstDay = "", dateThirdDay = "", dateFourthDay = "", dateFiveDay = "";
            for (int i = 0; i < arrayList.size(); i++) {
                arrayListTemp = new ArrayList<>();

                arrayListTemp.add(arrayList.get(i).getMain().getTemp());
                dateFirstDay = setDateFormat(Calendar.getInstance().getTime().toString());

                String dateString = arrayList.get(i).getDtTxt();
                dateString = dateString.substring(0, dateString.indexOf(" "));


                Date dateformat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(Calendar.getInstance().getTime().toString());
                Calendar c = Calendar.getInstance();
                c.setTime(dateformat);
                c.add(Calendar.DATE, 1);
                dateSecondDay = setDateFormat(c.getTime().toString());

                c.setTime(dateformat);
                c.add(Calendar.DATE, 2);
                dateThirdDay = setDateFormat(c.getTime().toString());

                c.setTime(dateformat);
                c.add(Calendar.DATE, 3);
                dateFourthDay = setDateFormat(c.getTime().toString());

                c.setTime(dateformat);
                c.add(Calendar.DATE, 4);
                dateFiveDay = setDateFormat(c.getTime().toString());


                if (dateString.equals(dateFirstDay)) {
                    arrayList1.add(arrayList.get(i).getMain());
                } else if (dateString.equals(dateSecondDay)) {
                    arrayList2.add(arrayList.get(i).getMain());
                } else if (dateString.equals(dateThirdDay)) {
                    arrayList3.add(arrayList.get(i).getMain());
                } else if (dateString.equals(dateFourthDay)) {
                    arrayList4.add(arrayList.get(i).getMain());
                } else if (dateString.equals(dateFiveDay)) {
                    arrayList5.add(arrayList.get(i).getMain());
                }
            }

            Collections.sort(arrayList1, new Comparator());
            Collections.sort(arrayList2, new Comparator());
            Collections.sort(arrayList3, new Comparator());
            Collections.sort(arrayList4, new Comparator());
            Collections.sort(arrayList5, new Comparator());


            tempListDateWise.put(dateFirstDay, arrayList1);
            tempListDateWise.put(dateSecondDay, arrayList2);
            tempListDateWise.put(dateThirdDay, arrayList3);
            tempListDateWise.put(dateFourthDay, arrayList4);
            tempListDateWise.put(dateFiveDay, arrayList5);

            return tempListDateWise;

        }


    public   ArrayList<OpenWeather5Day.List> getDateGrouped(ArrayList<OpenWeather5Day.List> arrayList) throws ParseException {
        ArrayList<Double> arrayListTemp;

        ArrayList<OpenWeather5Day.List> arrayList1 = new ArrayList<>();
        ArrayList<OpenWeather5Day.List> arrayList2 = new ArrayList<>();
        ArrayList<OpenWeather5Day.List> arrayList3 = new ArrayList<>();
        ArrayList<OpenWeather5Day.List> arrayList4 = new ArrayList<>();
        ArrayList<OpenWeather5Day.List> arrayList5 = new ArrayList<>();
        String dateSecondDay = "", dateFirstDay = "", dateThirdDay = "", dateFourthDay = "", dateFiveDay = "";
        for (int i = 0; i < arrayList.size(); i++) {
            arrayListTemp = new ArrayList<>();

            arrayListTemp.add(arrayList.get(i).getMain().getTemp());
            dateFirstDay = setDateFormat(Calendar.getInstance().getTime().toString());

            String dateString = arrayList.get(i).getDtTxt();
            dateString = dateString.substring(0, dateString.indexOf(" "));


            Date dateformat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(Calendar.getInstance().getTime().toString());
            Calendar c = Calendar.getInstance();
            c.setTime(dateformat);
            c.add(Calendar.DATE, 1);
            dateSecondDay = setDateFormat(c.getTime().toString());

            c.setTime(dateformat);
            c.add(Calendar.DATE, 2);
            dateThirdDay = setDateFormat(c.getTime().toString());

            c.setTime(dateformat);
            c.add(Calendar.DATE, 3);
            dateFourthDay = setDateFormat(c.getTime().toString());

            c.setTime(dateformat);
            c.add(Calendar.DATE, 4);
            dateFiveDay = setDateFormat(c.getTime().toString());


            if (dateString.equals(dateFirstDay)) {
                arrayList1.add(arrayList.get(i));
            } else if (dateString.equals(dateSecondDay)) {
                arrayList2.add(arrayList.get(i));
            } else if (dateString.equals(dateThirdDay)) {
                arrayList3.add(arrayList.get(i));
            } else if (dateString.equals(dateFourthDay)) {
                arrayList4.add(arrayList.get(i));
            } else if (dateString.equals(dateFiveDay)) {
                arrayList5.add(arrayList.get(i));
            }
        }


        ArrayList<OpenWeather5Day.List> allItems = new ArrayList<>();
        List objHeader= new List();
        objHeader.setCelltype(ItemType.Header);
        objHeader.setSectionPostion(allItems.size());
        objHeader.setTitle(dateFirstDay);
        for (List item : arrayList1) {
            item.setSectionPostion(allItems.size());
        }
        allItems.add(objHeader);

        allItems.addAll(arrayList1);

        List objHeader2= new List();
        objHeader2.setCelltype(ItemType.Header);
        objHeader2.setTitle(dateSecondDay);
        objHeader2.setSectionPostion(allItems.size());
        for (List item : arrayList2) {
            item.setSectionPostion(allItems.size());
        }
        allItems.add(objHeader2);

        allItems.addAll(arrayList2);

        List objHeader3= new List();
        objHeader3.setCelltype(ItemType.Header);
        objHeader3.setTitle(dateThirdDay);
        objHeader3.setSectionPostion(allItems.size());
        for (List item : arrayList3) {
            item.setSectionPostion(allItems.size());
        }
        allItems.add(objHeader3);
        allItems.addAll(arrayList3);


        List objHeader4= new List();
        objHeader4.setCelltype(ItemType.Header);
        objHeader4.setTitle(dateFourthDay);
        objHeader4.setSectionPostion(allItems.size());
        for (List item : arrayList4) {
            item.setSectionPostion(allItems.size());
        }
        allItems.add(objHeader4);
        allItems.addAll(arrayList4);


        List objHeader5= new List();
        objHeader5.setCelltype(ItemType.Header);
        objHeader5.setTitle(dateFiveDay);
        objHeader5.setSectionPostion(allItems.size());
        for (List item : arrayList5) {
            item.setSectionPostion(allItems.size());
        }
        allItems.add(objHeader5);
        allItems.addAll(arrayList5);



        return allItems;

    }


        private class Comparator implements java.util.Comparator<OpenWeather5Day.Main> {

            @Override
            public int compare(OpenWeather5Day.Main t1, OpenWeather5Day.Main t2) {
                return (int) (t1.getTempMax() - t2.getTempMax());
            }
        }

        private String setDateFormat(String unformattedDate) throws ParseException {
            Date dateformat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(unformattedDate);
            return (new SimpleDateFormat("yyyy-MM-dd")).format(dateformat);
        }
    }

