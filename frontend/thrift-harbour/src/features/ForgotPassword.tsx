import { FormEvent, useEffect, useState } from "react";
import { Container, InputCard } from "./ForgotPasswordStyles";
import {
  Button,
  Field,
  Form,
  Input,
  Label,
  RegisterButton,
  Title,
} from "../registration/RegistrationStyles";
import { ForgotPasswordCredentials } from "../../types/types";
import { useNavigate } from "react-router-dom";
import useAuth from "../../hooks/useAuth";
import { Auth } from "../../services/Auth";

const ForgotPassword: React.FC = () => {
  const { token } = useAuth();
  const navigate = useNavigate();
  const [isFocused, setIsFocused] = useState<boolean>(false);
  const [ForgotPasswordCredentials, setForgotPasswordCredentials] = useState(
    {} as ForgotPasswordCredentials
  );
  const auth = new Auth();

  useEffect(() => {
    if (token?.length) {
      navigate("/home");
    }
  }, [token]);

  const onSubmitForgotPassword = async (e: FormEvent) => {
    e.preventDefault();
    navigate("/newpassword");
  };

  return (
    <Container>
      <InputCard>
        <Title>Forgot Password</Title>
        <Form onSubmit={onSubmitForgotPassword}>
          <Field>
            <Label>E-mail ID</Label>
            <Input
              required={true}
              id="email"
              onFocus={() => setIsFocused(true)}
              onBlur={() => setIsFocused(false)}
              onChange={(e) =>
                setForgotPasswordCredentials({
                  ...ForgotPasswordCredentials,
                  email: e.target.value,
                })
              }
            ></Input>
          </Field>

          <Button>
            <RegisterButton type="submit">Forgot password</RegisterButton>
          </Button>
        </Form>
      </InputCard>
    </Container>
  );
};
export default ForgotPassword;
