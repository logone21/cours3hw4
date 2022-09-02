package com.example.a3_monthhw4;

public class Country {
    private String name;
    private int image;

    public Country( String name, int image) {
        this.name = name;
        this.image = image;
    }

    private Integer keyId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }


    public Country(String name, int image, Integer keyId) {
        this.name = name;
        this.image = image;
        this.keyId = keyId;
    }
}

