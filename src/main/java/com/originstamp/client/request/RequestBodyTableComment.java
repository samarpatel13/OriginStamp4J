package com.originstamp.client.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Thomas on 10.01.17.
 *
 * @author Thomas Hepp
 *         the class is a DTO which is parsed to JSON by Jersey and represents a request body for POST requests
 */
@XmlRootElement(name = "body")
public class RequestBodyTableComment implements Serializable {
    @XmlElement(name = "comment")
    private String comment;
    @XmlElement(name = "offset")
    private Integer offset;
    @XmlElement(name = "records")
    private Integer records;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getRecords() {
        return records;
    }

    public void setRecords(Integer records) {
        this.records = records;
    }
}
