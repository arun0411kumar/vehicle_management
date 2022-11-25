package com.ideas2It.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Manufacturer class have manufacturer attributes
 * This class contain getter and setter method for manufacturer attributes
 *
 * @version 1.0
 * @author arunkumar
 */

@Entity
@Table(name = "dealers")
public class Dealer extends BaseModel {
	
	@NotNull(message = "name should not be null or empty")
    private String company;
	
	@NotNull(message = "name should not be null or empty")
    @Column(name = "stock_available")
    private int stockAvailable;
	
	@NotBlank(message = "name should not be null or empty")
    private String city;
    
    @OneToMany(mappedBy = "dealer", 
    		fetch = FetchType.LAZY, 
    		cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TwoWheeler> twoWheelers;   
	
    public String getCompany() {
	    return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getStockAvailable() {
	    return stockAvailable;
    }

    public void setStockAvailable(int stockAvailable) {
	    this.stockAvailable = stockAvailable;
    }

    public String getCity() {
	    return city;
    }

    public void setCity(String city) {
	    this.city = city;
    }

    public List<TwoWheeler> getTwoWheelers() {
        return twoWheelers;
    } 

    public void setTwoWheelers(List<TwoWheeler> twoWheelers) {
        this.twoWheelers = twoWheelers;
    }

    public String toString() {
        return "\n--------- Dealer -------------"
               + "\nDealer Id       : " + getId() 
               + "\nCompany         : " + getCompany()
               + "\nstock available : " + getStockAvailable() 
               + "\nCity            : " + getCity()
               + "\n-------------------------------";
    } 
}