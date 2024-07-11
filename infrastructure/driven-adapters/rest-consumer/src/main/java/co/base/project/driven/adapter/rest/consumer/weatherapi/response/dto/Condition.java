package co.base.project.driven.adapter.rest.consumer.weatherapi.response.dto;

import lombok.Data;

@Data
public class Condition {
    public String text;
    public String icon;
    public int code;
}
