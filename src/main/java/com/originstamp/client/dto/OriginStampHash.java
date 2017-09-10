package com.originstamp.client.dto;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.io.Serializable;
/**
 * Created by Thomas on 10.01.17.
 *
 * @author Thomas Hepp
 *         result entity which is returned by a rest request for detailed hash information
 */
@XmlRootElement(name = "body")
public class OriginStampHash implements Serializable{
    @XmlElement(name = "comment")
    private String comment;
    @XmlElement(name = "twitter")
    private Twitter twitter;
    @XmlElement(name = "unique_url")
    private String uniqueUrl;
    @XmlElement(name = "hash_string")
    private String hashString;
    @XmlElement(name = "email")
    private Email email;
    @XmlElement(name = "date_created")
    private Long dateCreated;
    @XmlElement(name = "single_seed")
    private SingleSeed singleSeed;
    @XmlAnyElement(lax = true)
    private List<Object> anything;
    @XmlElement(name = "multi_seed")
    private MultiSeed multiSeed;
    @XmlElement(name = "created")
    private Boolean created;
    
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class SingleSeed implements Serializable {
        @XmlElement(name = "block_depth")
        private Long blockDepth;
        @XmlElement(name = "seed_hash")
        private String seedHash;
        @XmlElement(name = "submit_status")
        private Integer submitStatus;
        @XmlElement(name = "timestamp")
        private Long timestamp;
        @XmlElement(name = "tx_hash")
        private String transactionHash;
        @XmlElement(name = "btc_address")
        private String bitcoinAddress;
        @XmlElement(name = "pub_key")
        private String publicKey;

        public Long getBlockDepth() {
            return blockDepth;
        }

        public void setBlockDepth(Long blockDepth) {
            this.blockDepth = blockDepth;
        }

        public String getSeedHash() {
            return seedHash;
        }

        public void setSeedHash(String seedHash) {
            this.seedHash = seedHash;
        }

        public Integer getSubmitStatus() {
            return submitStatus;
        }

        public void setSubmitStatus(Integer submitStatus) {
            this.submitStatus = submitStatus;
        }

        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }

        public String getTransactionHash() {
            return transactionHash;
        }

        public void setTransactionHash(String transactionHash) {
            this.transactionHash = transactionHash;
        }

        public String getBitcoinAddress() {
            return bitcoinAddress;
        }

        public void setBitcoinAddress(String bitcoinAddress) {
            this.bitcoinAddress = bitcoinAddress;
        }

        public String getPublicKey() {
            return publicKey;
        }

        public void setPublicKey(String publicKey) {
            this.publicKey = publicKey;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class MultiSeed implements Serializable {
        @XmlElement(name = "block_depth")
        private Long blockDepth;
        @XmlElement(name = "seed_hash")
        private String seedHash;
        @XmlElement(name = "submit_status")
        private Integer submitStatus;
        @XmlElement(name = "timestamp")
        private Long timestamp;
        @XmlElement(name = "tx_hash")
        private String transactionHash;
        @XmlElement(name = "btc_address")
        private String bitcoinAddress;
        @XmlElement(name = "pub_key")
        private String publicKey;

        public Long getBlockDepth() {
            return blockDepth;
        }

        public void setBlockDepth(Long blockDepth) {
            this.blockDepth = blockDepth;
        }

        public String getSeedHash() {
            return seedHash;
        }

        public void setSeedHash(String seedHash) {
            this.seedHash = seedHash;
        }

        public Integer getSubmitStatus() {
            return submitStatus;
        }

        public void setSubmitStatus(Integer submitStatus) {
            this.submitStatus = submitStatus;
        }

        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }

        public String getTransactionHash() {
            return transactionHash;
        }

        public void setTransactionHash(String transactionHash) {
            this.transactionHash = transactionHash;
        }

        public String getBitcoinAddress() {
            return bitcoinAddress;
        }

        public void setBitcoinAddress(String bitcoinAddress) {
            this.bitcoinAddress = bitcoinAddress;
        }

        public String getPublicKey() {
            return publicKey;
        }

        public void setPublicKey(String publicKey) {
            this.publicKey = publicKey;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Email implements Serializable {
        @XmlElement(name = "email_hash")
        private String emailHash;
        @XmlElement(name = "verified")
        private Integer verified;
        @XmlElement(name = "send_status")
        private Integer sendStatus;

        public String getEmailHash() {
            return emailHash;
        }

        public void setEmailHash(String emailHash) {
            this.emailHash = emailHash;
        }

        public Integer getVerified() {
            return verified;
        }

        public void setVerified(Integer verified) {
            this.verified = verified;
        }

        public Integer getSendStatus() {
            return sendStatus;
        }

        public void setSendStatus(Integer sendStatus) {
            this.sendStatus = sendStatus;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Twitter implements Serializable {
        @XmlElement(name = "tweet_id")
        private String tweetId;
        @XmlElement(name = "submit_status")
        private Integer submitStatus;

        public String getTweetId() {
            return tweetId;
        }

        public void setTweetId(String tweetId) {
            this.tweetId = tweetId;
        }

        public Integer getSubmitStatus() {
            return submitStatus;
        }

        public void setSubmitStatus(Integer submitStatus) {
            this.submitStatus = submitStatus;
        }
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Twitter getTwitter() {
        return twitter;
    }

    public void setTwitter(Twitter twitter) {
        this.twitter = twitter;
    }

    public String getUniqueUrl() {
        return uniqueUrl;
    }

    public void setUniqueUrl(String uniqueUrl) {
        this.uniqueUrl = uniqueUrl;
    }

    public String getHashString() {
        return hashString;
    }

    public void setHashString(String hashString) {
        this.hashString = hashString;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public SingleSeed getSingleSeed() {
        return singleSeed;
    }

    public void setSingleSeed(SingleSeed singleSeed) {
        this.singleSeed = singleSeed;
    }

    public MultiSeed getMultiSeed() {
        return multiSeed;
    }

    public void setMultiSeed(MultiSeed multiSeed) {
        this.multiSeed = multiSeed;
    }

    public Boolean getCreated() {
        return created;
    }

    public void setCreated(Boolean created) {
        this.created = created;
    }

    public List<Object> getAnything() {
        return anything;
    }

    public void setAnything(List<Object> anything) {
        this.anything = anything;
    }
}
