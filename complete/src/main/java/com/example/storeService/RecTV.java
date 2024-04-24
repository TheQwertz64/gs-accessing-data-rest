package com.example.storeService;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RecTV {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
    
    protected long sid;
    protected String model;
    protected String size;
    protected String resolution;
    protected String manufacturer;
    protected int stock;
    protected float price;
    protected String priceRange;

    public RecTV(){
        this.model = null;
        this.size = null;
        this.resolution = null;
        this.manufacturer = null;
        this.stock = 0;
        this.price = 0;
    }

    public RecTV(long sid, String model, String size, String resolution, String manufacturer, int stock, float price){
        this.sid = sid;
        this.model = model;
        this.size = size;
        this.resolution = resolution;
        this.manufacturer = manufacturer;
        this.stock = stock;
        this.price = price;
    }

    public int getId() {
		return id;
	}

	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}

    public void setResolution(String res){
        this.resolution = res;
    }

    public void incrementStock(int stockChange){
        this.stock += stockChange;
    }

    public void reduceStock(int stockChange){
        this.stock -= stockChange;
    }

    public String getResolution(){
        return this.resolution;
    }

    public void setSize(String size){
        this.size = size;
    }

    public String getSize(){
        return this.size;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public int getStock(){
        return this.stock;
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getModel(){
        return this.model;
    }

    public float getPrice(){
        return this.price;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public String getManufacturer(){
        return this.manufacturer;
    }

    public void setManufacturer(String man){
        this.manufacturer = man;
    }

    @Override
    public String toString(){
        return String.format("TV[sid=%d,model='%s',size='%s',res='%s',manufacturer='%s',stock='%d',price='%f']",
        sid,model, size, resolution, manufacturer, stock, price);
    }
}
