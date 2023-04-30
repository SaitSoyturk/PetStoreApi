package serviceBase;

import io.restassured.response.Response;

public class ReadableResponse {
    private int statusCode;
    private String statusLine;
    private Response response;

    public ReadableResponse(Response response) {
        this.response = response;
        this.statusCode = response.getStatusCode();
        this.statusLine = response.getStatusLine();
    }

    public String getBodyMessage(String path) {
        return response.path(path).toString()
                .replace("[", "")
                .replace("]", "");
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getFullBodyMessage() {
        return response.print();
    }
}
