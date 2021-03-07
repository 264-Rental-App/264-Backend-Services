package edu.rentals.backend.rental;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Rental")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "storeId", nullable = false)
    private Long storeId;

    @Getter
    @Setter
    @Column(name = "userId", nullable = false)
    private Long userId;

    @Getter
    @Setter
    @SerializedName("rentalStartDate")
    @Column(name = "rentalTime", nullable = false)
    private Timestamp rentalTime;

    @Getter
    @Setter
    @SerializedName("dueDate")
    @Column(name = "returnTime", nullable = false)
    private Timestamp returnTime;

    @Getter
    @Setter
    @Column(name = "invoiceId", nullable = false)
    private Long invoiceId;

    @Getter
    @Setter
    @SerializedName("euipment")
    @OneToMany(mappedBy = "rental")
    private List<Equipment> equipment;

    public Rental( Long storeid, Long userid, Long invoiceid, Timestamp rentalTime, Timestamp returnTime){
        this.storeId = storeid;
        this.userId = userid;
        this.rentalTime = rentalTime;
        this.returnTime = returnTime;
        this.invoiceId = invoiceid;
    }

    public Rental() {

    }


}
