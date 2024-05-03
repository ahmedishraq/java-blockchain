package org.example;

import org.xml.sax.helpers.AttributesImpl;

import java.util.Date;

public class Block {
    public String hash;
    public String previousHash;
    private String data; // our data will be a simple message
    private long timestamp; // as number of miliseconds since 1/1/1970


    // Block Constructor.
    public Block(String data, String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = new Date().getTime();
        this.hash = calculateHash(); //Making sure we do this after we set the other values.
    }

    public String calculateHash(){
        String calculatedhash = StringUtil.applySha256(
                previousHash +
                        Long.toString(timestamp) +
                        data
        );
        return calculatedhash;
    }
}
