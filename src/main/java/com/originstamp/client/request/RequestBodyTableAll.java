package com.originstamp.client.request;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Thomas on 10.01.17.
 */
@XmlRootElement(name = "body")
public class RequestBodyTableAll implements Serializable {
    private Integer offset;
    private Integer records;

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
