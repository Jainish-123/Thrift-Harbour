export interface MenuItem {
  id: number;
  label: string;
}

export interface HamburgerMenuProps {
  menuItems: MenuItem[];
}

export interface ListingDataTypes {
  productName: string;
  productPrice: number;
  productDescription: string;
  sellCategory: string;
  images: File[];
  productCategory: string;
  auctionSlot?: string;
}

export interface TouchedFieldsType {
  productName: boolean;
  productPrice: boolean;
  productDescription: boolean;
  sellCategory: boolean;
  productCategory: boolean;
  auctionSlot?: boolean;
}
