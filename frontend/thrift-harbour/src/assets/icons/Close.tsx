import React from "react";
import { IconComponentProps } from "./Info";

const Close: React.FC<IconComponentProps> = (props) => {
  const style = {
    width: props.width || "14px",
    height: props.height || "16px",
    fill: props.color || "currentColor",
  };
  return (
    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512" style={style}>
      {/* Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com
    License - https://fontawesome.com/license/free
    Copyright 2024 Fonticons, Inc. */}
      <path d="M64 32C28.7 32 0 60.7 0 96V416c0 35.3 28.7 64 64 64H384c35.3 0 64-28.7 64-64V96c0-35.3-28.7-64-64-64H64zm79 143c9.4-9.4 24.6-9.4 33.9 0l47 47 47-47c9.4-9.4 24.6-9.4 33.9 0s9.4 24.6 0 33.9l-47 47 47 47c9.4 9.4 9.4 24.6 0 33.9s-24.6 9.4-33.9 0l-47-47-47 47c-9.4 9.4-24.6 9.4-33.9 0s-9.4-24.6 0-33.9l47-47-47-47c-9.4-9.4-9.4-24.6 0-33.9z" />
    </svg>
  );
};

export default Close;
