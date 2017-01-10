package com.originstamp.client.dto;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Thomas on 10.01.17.
 *
 * @author Thomas Hepp
 *         Entity class which is the result of a table request
 */
@XmlRootElement(name = "body")
public class OriginStampTableEntity {
    @XmlElement(name = "total_records")
    private Integer records;
    @XmlElement(name = "hashes")
    private List<Hashes> hashes;

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Hashes {
        @XmlElement(name = "date_created")
        private String dateCreated;
        @XmlElement(name = "hash_string")
        private String hashString;
        @XmlElement(name = "submit_status")
        private SubmitStatus submitStatus;

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class SubmitStatus {
            @XmlElement(name = "multi_seed")
            private Integer multiSeed;
            @XmlElement(name = "single_seed")
            private Integer singleSeed;

            public Integer getMultiSeed() {
                return multiSeed;
            }

            public void setMultiSeed(Integer multiSeed) {
                this.multiSeed = multiSeed;
            }

            public Integer getSingleSeed() {
                return singleSeed;
            }

            public void setSingleSeed(Integer singleSeed) {
                this.singleSeed = singleSeed;
            }
        }

        public String getDateCreated() {
            return dateCreated;
        }

        public void setDateCreated(String dateCreated) {
            this.dateCreated = dateCreated;
        }

        public String getHashString() {
            return hashString;
        }

        public void setHashString(String hashString) {
            this.hashString = hashString;
        }

        public SubmitStatus getSubmitStatus() {
            return submitStatus;
        }

        public void setSubmitStatus(SubmitStatus submitStatus) {
            this.submitStatus = submitStatus;
        }
    }

    public Integer getRecords() {
        return records;
    }

    public void setRecords(Integer records) {
        this.records = records;
    }

    public List<Hashes> getHashes() {
        return hashes;
    }

    public void setHashes(List<Hashes> hashes) {
        this.hashes = hashes;
    }
}
