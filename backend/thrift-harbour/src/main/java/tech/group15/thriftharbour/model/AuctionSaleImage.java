package tech.group15.thriftharbour.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Builder
@Data
@Entity
public class AuctionSaleImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageID;

    private int auctionSaleListingID;

    private String imageURL;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
}
