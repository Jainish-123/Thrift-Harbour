import styled from "styled-components";

export const Overlay = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1;
`;

export const BodyContainer = styled.div`
  background-color: #ffffff;
  padding: 0px 20px 14px 20px;
  border-radius: 4px;
`;

export const CloseButtonContainer = styled.div`
  position: relative;
  width: 100%;
  height: 20px;
`;
export const CloseButton = styled.button`
  position: absolute;
  top: 8px;
  right: 0;
  background: none;
  border: none;
  cursor: pointer;
`;
