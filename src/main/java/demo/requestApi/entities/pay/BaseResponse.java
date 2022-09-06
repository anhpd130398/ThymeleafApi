package demo.requestApi.entities.pay;

import lombok.Data;

@Data
public class BaseResponse {
   private String message;
   private Object data;

    public BaseResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public BaseResponse(String message) {
        this.message = message;
    }

    public BaseResponse(Object data) {
        this.data = data;
    }
}
