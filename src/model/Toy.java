package model;

import java.sql.Date;
import java.text.NumberFormat;
import java.util.Locale;

public class Toy {
    // Thuộc tính: mã, id, tên, mô tả, giá, ngày nhập
    private long id;
    private String code;
    private String name;
    private double price;
    private String description;
	private Date receiptDate;

    public Toy() {
    }

    public Toy(long id, String code, String name, double price, String description, Date receiptDate) {
        super();
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.description = description;
        this.receiptDate = receiptDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    @Override
    public String toString() {
    	Locale locale = new Locale("vi", "VN");
    	NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
    	
        return "Toy [id=" + id + ", code=" + code + ", name=" + name + ", price=" + fmt.format(price) + ", description="
                + description + ", receiptDate=" + receiptDate + "]";
    }

}
