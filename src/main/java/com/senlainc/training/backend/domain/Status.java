package com.senlainc.training.backend.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@JsonAutoDetect
@Getter
@ToString
public enum Status implements Serializable {
    NEW("new"),
    COMPLETED("completed"),
    CANCEL("cancel");;

    private String title;

    Status(String title) {
        this.title = title;
    }
}
