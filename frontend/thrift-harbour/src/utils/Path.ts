export class Path {
  environment: string;
  constructor(environment: string) {
    this.environment = environment;
  }

  getBaseUrl() {
    if (this.environment === "development") {
      return "http://172.17.1.50:8080/api/v1";
    } else {
      return "/thrift/api/v1";
    }
  }

  getAuthUrl(service: string) {
    if (service === "signup") {
      return "/auth/signup";
    }
    if (service === "signin") {
      return "/auth/signin";
    }
    if (service === "getUser") {
      return "/user";
    }
    if (service === "forgot-password") {
      return "/auth/forgot-password";
    }
    if (service === "reset-password") {
      return "/auth/reset-password";
    }
  }

  getListingUrl(service: string) {
    if (service === "immediate-listing") {
      return "/listing/create-immediatesale-listing";
    }
  }
}
