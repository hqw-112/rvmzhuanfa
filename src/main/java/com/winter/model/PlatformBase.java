package com.winter.model;

import java.util.Date;

public class PlatformBase {
    private Long id;

    private String code;

    private String socketIp;

    private Integer socketPort;

    private String description;

    private Long createBy;

    private Date createDate;

    private Long lastUpdateBy;

    private Date lastUpdateDate;

    private Integer rowVersion;

    private Byte isValid;

    private Integer status;

    private Long frequency;

    private String uniqueSymbol;

    private Long sendFrequency;

    private String encryptionRule;

    private String platformName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getSocketIp() {
        return socketIp;
    }

    public void setSocketIp(String socketIp) {
        this.socketIp = socketIp == null ? null : socketIp.trim();
    }

    public Integer getSocketPort() {
        return socketPort;
    }

    public void setSocketPort(Integer socketPort) {
        this.socketPort = socketPort;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(Long lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getRowVersion() {
        return rowVersion;
    }

    public void setRowVersion(Integer rowVersion) {
        this.rowVersion = rowVersion;
    }

    public Byte getIsValid() {
        return isValid;
    }

    public void setIsValid(Byte isValid) {
        this.isValid = isValid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getFrequency() {
        return frequency;
    }

    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }

    public String getUniqueSymbol() {
        return uniqueSymbol;
    }

    public void setUniqueSymbol(String uniqueSymbol) {
        this.uniqueSymbol = uniqueSymbol == null ? null : uniqueSymbol.trim();
    }

    public Long getSendFrequency() {
        return sendFrequency;
    }

    public void setSendFrequency(Long sendFrequency) {
        this.sendFrequency = sendFrequency;
    }

    public String getEncryptionRule() {
        return encryptionRule;
    }

    public void setEncryptionRule(String encryptionRule) {
        this.encryptionRule = encryptionRule == null ? null : encryptionRule.trim();
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName == null ? null : platformName.trim();
    }


}