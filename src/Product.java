import java.time.LocalDate;

public class Product {
    private String productType;
    private double price;
    private boolean setDiscount;
    private LocalDate dateCreate;
    private int productId;

    public Product(String productType, double price, boolean setDiscount, LocalDate dateCreate, int productId) {
        this.productType = productType;
        this.price = setDiscount ? price * 0.9 : price;
        this.setDiscount = setDiscount;
        this.dateCreate = dateCreate;
        this.productId = productId;
    }

    public String getProductType() {
        return productType;
    }

    public double getPrice() {
        return price;
    }

    public boolean isSetDiscount() {
        return setDiscount;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public int getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return "Product{" +
                " type='" + productType + '\'' +
                ", price=" + price +
                ", " + (setDiscount ? "discount 10%" : "no discount") +
                ", dateCreate=" + dateCreate +
                ", product id=" + productId +
                '}';
    }
}
