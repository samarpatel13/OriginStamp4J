package com.originstamp.client.dto;

import javax.xml.bind.annotation.*;

/**
 * Created by Thomas on 10.01.17.
 *
 * @author Thomas Hepp
 *         result entity which is returned by a rest request for detailed hash information
 */
@XmlRootElement(name = "body")
public class OriginStampHash {
    @XmlElement(name = "comment")
    private String comment;
    @XmlElement(name = "date_created")
    private String dateCreated;
    @XmlElement(name = "hash_string")
    private String hashString;
    @XmlElement(name = "unique_url")
    private String uniqueUrl;
    @XmlElement(name = "email")
    private Mail email;
    @XmlElement(name = "twitter")
    private Twitter twitter;
    @XmlElement(name = "multi_seed")
    private MultiSeed multiSeed;
    @XmlElement(name = "single_seed")
    private SingleSeed singleSeed;

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Mail {
        @XmlElement(name = "email_hash")
        private String mailHash;
        @XmlElement(name = "verified")
        private String verified;

        public String getMailHash() {
            return mailHash;
        }

        public void setMailHash(String mailHash) {
            this.mailHash = mailHash;
        }

        public String getVerified() {
            return verified;
        }

        public void setVerified(String verified) {
            this.verified = verified;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Twitter {
        @XmlElement(name = "submit_status")
        private int submitStatus;
        @XmlElement(name = "tweet_id")
        private String tweetId;

        public int getSubmitStatus() {
            return submitStatus;
        }

        public void setSubmitStatus(int submitStatus) {
            this.submitStatus = submitStatus;
        }

        public String getTweetId() {
            return tweetId;
        }

        public void setTweetId(String tweetId) {
            this.tweetId = tweetId;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class MultiSeed {
        @XmlElement(name = "block_depth")
        private Integer blockDepth;
        @XmlElement(name = "seed_hash")
        private String seedHash;
        @XmlElement(name = "submit_status")
        private Integer submitStatus;
        @XmlElement(name = "timestamp")
        private String timestamp;
        @XmlElement(name = "tx_hash")
        private String transactionHash;
        @XmlElement(name = "btc_address")
        private String bitCoinAddress;
        @XmlElement(name = "pub_key")
        private String publicKey;

        public String getBitCoinAddress() {
            return bitCoinAddress;
        }

        public void setBitCoinAddress(String bitCoinAddress) {
            this.bitCoinAddress = bitCoinAddress;
        }

        public String getPublicKey() {
            return publicKey;
        }

        public void setPublicKey(String publicKey) {
            this.publicKey = publicKey;
        }

        public Integer getBlockDepth() {
            return blockDepth;
        }

        public void setBlockDepth(Integer blockDepth) {
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

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getTransactionHash() {
            return transactionHash;
        }

        public void setTransactionHash(String transactionHash) {
            this.transactionHash = transactionHash;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class SingleSeed {
        @XmlElement(name = "block_depth")
        private Integer blockDepth;
        @XmlElement(name = "seed_hash")
        private String seedHash;
        @XmlElement(name = "submit_status")
        private Integer submitStatus;
        @XmlElement(name = "timestamp")
        private String timestamp;
        @XmlElement(name = "tx_hash")
        private String transactionHash;
        @XmlElement(name = "btc_address")
        private String bitCoinAddress;
        @XmlElement(name = "pub_key")
        private String publicKey;

        public String getBitCoinAddress() {
            return bitCoinAddress;
        }

        public void setBitCoinAddress(String bitCoinAddress) {
            this.bitCoinAddress = bitCoinAddress;
        }

        public String getPublicKey() {
            return publicKey;
        }

        public void setPublicKey(String publicKey) {
            this.publicKey = publicKey;
        }

        public Integer getBlockDepth() {
            return blockDepth;
        }

        public void setBlockDepth(Integer blockDepth) {
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

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getTransactionHash() {
            return transactionHash;
        }

        public void setTransactionHash(String transactionHash) {
            this.transactionHash = transactionHash;
        }
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public String getUniqueUrl() {
        return uniqueUrl;
    }

    public void setUniqueUrl(String uniqueUrl) {
        this.uniqueUrl = uniqueUrl;
    }

    public Mail getEmail() {
        return email;
    }

    public void setEmail(Mail email) {
        this.email = email;
    }

    public Twitter getTwitter() {
        return twitter;
    }

    public void setTwitter(Twitter twitter) {
        this.twitter = twitter;
    }

    public MultiSeed getMultiSeed() {
        return multiSeed;
    }

    public void setMultiSeed(MultiSeed multiSeed) {
        this.multiSeed = multiSeed;
    }

    public SingleSeed getSingleSeed() {
        return singleSeed;
    }

    public void setSingleSeed(SingleSeed singleSeed) {
        this.singleSeed = singleSeed;
    }
}
