package ru.company.framework.utils;

public class Product {
    String name;
    int current;
    int edCurrent;
    String warranty;
    String description;

    public Product(){}

    public int getEdCurrent() {
        return edCurrent;
    }

    public void setEdCurrent(int edCurrent) {
        this.edCurrent = edCurrent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
