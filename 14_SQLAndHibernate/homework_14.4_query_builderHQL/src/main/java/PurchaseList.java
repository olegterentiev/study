import javax.persistence.*;
import java.util.Date;

@Entity
public class PurchaseList {

    public PurchaseList(CompositeKey compositeKey, int price, Date subscriptionDate) {
        this.compositeKey = compositeKey;
        this.price = price;
        this.subscriptionDate = subscriptionDate;
    }
    public PurchaseList() {
    }

    @EmbeddedId
    private CompositeKey compositeKey;

    @Column(name = "price")
    private int price;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public CompositeKey getCompositeKey() {
        return compositeKey;
    }

    public void setCompositeKey(CompositeKey compositeKey) {
        this.compositeKey = compositeKey;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

}
