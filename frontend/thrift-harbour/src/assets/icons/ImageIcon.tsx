import React from "react";
import { IconComponentProps } from "./Info";

const ImageIcon: React.FC<IconComponentProps> = (props) => {
  const style = {
    width: props.width || "14px",
    height: props.height || "16px",
    fill: props.color || "currentColor",
  };
  return (
    <svg
      xmlns="http://www.w3.org/2000/svg"
      height="24px"
      viewBox="0 0 24 24"
      width="24px"
      fill="#000000"
      style={style}
    >
      <path d="M0 0h24v24H0z" fill="none" />
      <path d="M3 4V1h2v3h3v2H5v3H3V6H0V4h3zm3 6V7h3V4h7l1.83 2H23v16H3V10h3zm7 9c2.76 0 5-2.24 5-5s-2.24-5-5-5-5 2.24-5 5 2.24 5 5 5zm-3-5c0 1.66 1.34 3 3 3s3-1.34 3-3-1.34-3-3-3-3 1.34-3 3z" />
    </svg>
  );
};

export default ImageIcon;
