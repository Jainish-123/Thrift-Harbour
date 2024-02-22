package tech.group15.thriftharbour.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DeniedAuctionSaleListingForAdminResponse {

    private String auctionSaleListingID;

    private String productName;

    private String productDescription;

    private String category;

    private String sellerEmail;

    private List<String> imageURLs;

    private boolean active;

    private boolean isRejected;

    private String approverEmail;

    private String messageFromApprover;

    private Date dateOfApproval;

    private boolean isSold;
}
