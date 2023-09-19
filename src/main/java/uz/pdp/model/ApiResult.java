package uz.pdp.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiResult {
    private boolean success;

    private String message;
}
