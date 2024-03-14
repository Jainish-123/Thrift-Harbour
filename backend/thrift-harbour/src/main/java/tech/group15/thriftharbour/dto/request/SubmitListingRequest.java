package tech.group15.thriftharbour.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.lang.Nullable;
import tech.group15.thriftharbour.enums.SellCategoryEnum;


@Data
public class SubmitListingRequest {

    @NotBlank
    private String productName;

    @NotBlank
    private String productDescription;

    @NotBlank
    private double productPrice;

    @NotBlank
    private String productCategory;

    @NotBlank
    private SellCategoryEnum sellCategory;

    @Nullable
    private String auctionSlot;

}
