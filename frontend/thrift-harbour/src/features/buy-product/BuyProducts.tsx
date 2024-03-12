import Rating from "@mui/material/Rating";
import Stack from "@mui/material/Stack";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import Modal from "../../components/ui-components/Modal/Modal";
import { ViewButtonContainer } from "../admin/AdminDashboardStyles";
import { Button } from "../product-listing/listed-products/ListedProductsStyles";
import UserProfile from "../user-profile/UserProfile";
import {
  Card,
  Grid,
  Header,
  Image,
  ImageContainer,
  Main,
  Name,
  NamePrice,
  Price,
  Ratings,
} from "./BuyProductsStyles";

const BuyProducts: React.FC = () => {
  const navigate = useNavigate();
  const [viewProfile, setViewProfile] = useState(false);

  const newModalStyle: React.CSSProperties = {
    width: "80%",
    height: "80%",
    maxWidth: "600px",
    maxHeight: "600px",
  };

  const toggleViewProfile = () => {
    setViewProfile(!viewProfile);
  };

  const auctionListedProducts = [
    {
      productName: "chair",
      price: 50,
      approved: true,
      productImages: [
        "https://mymitsandboxbucket.s3.ca-central-1.amazonaws.com/DIRECT/fe516a57-e098-4fdc-a7ee-371e6f911ec2/productImage1.png",
      ],
      id: "1",
    },
    {
      productName: "chair",
      price: 50,
      approved: true,
      productImages: [
        "https://mymitsandboxbucket.s3.ca-central-1.amazonaws.com/DIRECT/fe516a57-e098-4fdc-a7ee-371e6f911ec2/productImage1.png",
      ],
      id: "2",
    },
    {
      productName: "chair",
      price: 50,
      approved: true,
      productImages: [
        "https://mymitsandboxbucket.s3.ca-central-1.amazonaws.com/DIRECT/fe516a57-e098-4fdc-a7ee-371e6f911ec2/productImage1.png",
      ],
      id: "3",
    },
    {
      productName: "chair",
      price: 50,
      approved: true,
      productImages: [
        "https://mymitsandboxbucket.s3.ca-central-1.amazonaws.com/DIRECT/fe516a57-e098-4fdc-a7ee-371e6f911ec2/productImage1.png",
      ],
      id: "4",
    },
  ];

  const handleOnProductClick = (id: string) => {
    navigate(`/immediatesal-product-detail/${id}`);
  };
  return (
    <>
      <Header>Products</Header>

      <Grid>
        {auctionListedProducts.map((product) => {
          return (
            <>
              <Card>
                <ImageContainer
                  onClick={() => handleOnProductClick(product.id)}
                >
                  <Image>
                    <img
                      src={product.productImages[0]}
                      height={"100%"}
                      width={"100%"}
                    />
                  </Image>
                </ImageContainer>
                <Ratings>
                  <Stack spacing={1}>
                    <Rating
                      name="half-rating-read"
                      defaultValue={4.5}
                      precision={0.5}
                      readOnly
                    />
                  </Stack>
                </Ratings>
                <NamePrice>
                  <Name> {product.productName}</Name>
                  <Price>$ {product.price}</Price>
                </NamePrice>
                <ViewButtonContainer>
                  <Button onClick={() => setViewProfile(true)}>View</Button>
                </ViewButtonContainer>
              </Card>

              {viewProfile && (
                <Modal style={newModalStyle} onClose={toggleViewProfile}>
                  <UserProfile />
                </Modal>
              )}
            </>
          );
        })}
      </Grid>
    </>
  );
};

export default BuyProducts;
