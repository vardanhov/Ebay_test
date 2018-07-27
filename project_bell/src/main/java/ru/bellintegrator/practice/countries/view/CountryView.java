package ru.bellintegrator.practice.countries.view;

public class CountryView {
    public String name;
    public String code;

    public CountryView() {
    }

    public CountryView(String name, String code) {
        this.name = name;
        this.code = code;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "CountryView{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}