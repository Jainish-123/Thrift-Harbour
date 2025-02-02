package tech.group15.thriftharbour.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import tech.group15.thriftharbour.dto.request.ListingReviewRequest;
import tech.group15.thriftharbour.dto.response.*;
import tech.group15.thriftharbour.model.AuctionSaleListing;
import tech.group15.thriftharbour.service.AdminService;
import tech.group15.thriftharbour.model.ImmediateSaleListing;
import tech.group15.thriftharbour.model.User;
import tech.group15.thriftharbour.service.ProductListingService;
import tech.group15.thriftharbour.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
@Tag(name = "Admin")
public class AdminController {
  private final ProductListingService productListingService;
  private final UserService userService;

  private final AdminService adminService;

  @GetMapping
  public ResponseEntity<String> hi() {
    return ResponseEntity.ok("Hi from admin!");
  }


  /**
   * Get all immediate sale listing for admin.
   *
   * @return A list of {@code ImmediateSaleMinifiedResponse} containing the
   * minimal details immediate sale products.
   */
  @GetMapping("/get-all-immediatesale-listing")
  public ResponseEntity<List<ImmediateSaleMinifiedResponse>> getAllImmediateSaleListings() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(productListingService.findAllImmediateSaleListing());
  }

  /**
   * Get all seller who've listed their products.
   *
   * @return A list of {@code SellerResponse}  containing the
   * details of sellers registered in application.
   */
  @GetMapping("/get-all-sellers")
  public ResponseEntity<List<SellerResponse>> getAllSellers() {
    return ResponseEntity.status(HttpStatus.OK)
            .body(userService.findAllSellers());
  }

  /**
   * Get user by id.
   *
   * @param sellerID User Id of seller.
   * @return A list of {@code User}  containing the
   * details of user with provided ID
   */
  @GetMapping("/sellers/{sellerID}")
  public ResponseEntity<User> getUserById(@PathVariable Integer sellerID) {
    return ResponseEntity.ok(userService.findUserById(sellerID));
  }


  /**
   * Get user listing by userid.
   *
   * @param sellerID User Id of seller.
   * @return A list of {@code ImmediateSaleListing}  containing the
   * details of immediate sale products listed by this seller
   */
  @GetMapping("/sellers/{sellerID}/product-listing")
  public ResponseEntity<List<ImmediateSaleListing>> getUserListingByUserId(@PathVariable Integer sellerID) {
    return ResponseEntity.ok(productListingService.findUserListingById(sellerID));
  }

  /**
   * Get single immediate sale product.
   *
   * @param id listing id of a particular listing.
   * @return A list of {@code ImmediateSaleListing}  containing the
   * details of immediate sale product
   */
  @GetMapping("/get-immediatesale-product/{id}")
  public ResponseEntity<ImmediateSaleListing> getImmediateSaleProduct
  (@PathVariable String id) {
    return ResponseEntity.status(HttpStatus.OK)
            .body(productListingService.findImmediateSaleListingByID(id));
  }

  /**
   * Approve/Deny a listing and return the status of listing.
   * @param listingReviewRequest containing the listing id, status to be updated and sell category
   * @return A {@code ListingReviewResponse} object containing the id of listing and status - Approved/Denied
   */
  @Tag(name = "Approve/Reject User Listing")
  @PostMapping("/review-request")
  public ResponseEntity<ListingReviewResponse> reviewRequest(
      @Valid @RequestHeader("Authorization") String authorizationHeader,
      @RequestBody ListingReviewRequest listingReviewRequest) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(adminService.reviewListing(authorizationHeader, listingReviewRequest));
  }

  /**
   * Retrieves a list of all approved immediate sale listings.
   *
   * @return A {@code ResponseEntity} object containing a list of
   *     ApprovedImmediateSaleListingForAdminResponse instances.
   */
  @GetMapping("/get-approved-immediatesale-listing")
  public ResponseEntity<List<ApprovedImmediateSaleListingForAdminResponse>>
      getApprovedImmediateSaleListings() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(productListingService.findAllApprovedImmediateSaleListing());
  }

  /**
   * Retrieves a list of all rejected immediate sale listings.
   *
   * @return A {@code ResponseEntity} object containing a list of
   *     DeniedImmediateSaleListingForAdminResponse instances.
   */
  @GetMapping("/get-denied-immediatesale-listing")
  public ResponseEntity<List<DeniedImmediateSaleListingForAdminResponse>>
      getDeniedImmediateSaleListings() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(productListingService.findAllDeniedImmediateSaleListing());
  }

  /**
   * Retrieves a list of all approved auction sale listings.
   *
   * @return A {@code ResponseEntity} object containing a list of
   *     ApprovedAuctionSaleListingForAdminResponse instances.
   */
  @GetMapping("/get-approved-auctionsale-listing")
  public ResponseEntity<List<ApprovedAuctionSaleListingForAdminResponse>>
      getApprovedAuctionSaleListings() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(productListingService.findAllApprovedAuctionSaleListing());
  }

  /**
   * Retrieves a list of all rejected auction sale listings.
   *
   * @return A {@code ResponseEntity} object containing a list of
   *     DeniedAuctionSaleListingForAdminResponse instances.
   */
  @GetMapping("/get-denied-auctionsale-listing")
  public ResponseEntity<List<DeniedAuctionSaleListingForAdminResponse>>
      getDeniedAuctionSaleListings() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(productListingService.findAllDeniedAuctionSaleListing());
  }

  /**
   * GET request to retrieve all auction sale listings for the admin.
   *
   * @return A list of {@code ResponseEntity} objects containing list of {@code
   *     AuctionSaleListingCreationResponse} representing all auction sale listings details.
   */
  @GetMapping("/get-all-auction-listing")
  public ResponseEntity<List<AuctionSaleListingCreationResponse>> getAllAuctionListings() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(productListingService.findAllAuctionListingForAdmin());
  }

  /**
   * GET request to retrieve auction sale listing by its id for the admin.
   *
   * @return The Object of {@code ResponseEntity} object containing {@code AuctionSaleListing}
   *     representing auction sale listing details.
   */
  @GetMapping("/get-auctionsale-product/{id}")
  public ResponseEntity<AuctionSaleProductResponse> getAuctionSaleProduct(@PathVariable String id) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(productListingService.findAuctionListingByID(id));
  }
}
