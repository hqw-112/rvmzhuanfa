package com.winter.model;

import java.util.Date;

public class ParseRule {
    private Long id;

    private String signalName;

    private Integer parseType;

    private String signalRuleValue;

    private Integer platformBaseId;

    private Integer vehicleTypeId;

    private String infoIndex;

    private String statusName;

    private Long createBy;

    private Date createDate;

    private Long lastUpdateBy;

    private Date lastUpdateDate;

    private Integer rowVersion;

    private Byte isValid;

    private Byte status;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSignalName() {
        return signalName;
    }

    public void setSignalName(String signalName) {
        this.signalName = signalName == null ? null : signalName.trim();
    }

    public Integer getParseType() {
        return parseType;
    }

    public void setParseType(Integer parseType) {
        this.parseType = parseType;
    }

    public String getSignalRuleValue() {
        return signalRuleValue;
    }

    public void setSignalRuleValue(String signalRuleValue) {
        this.signalRuleValue = signalRuleValue == null ? null : signalRuleValue.trim();
    }

    public Integer getPlatformBaseId() {
        return platformBaseId;
    }

    public void setPlatformBaseId(Integer platformBaseId) {
        this.platformBaseId = platformBaseId;
    }

    public Integer getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(Integer vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public String getInfoIndex() {
        return infoIndex;
    }

    public void setInfoIndex(String infoIndex) {
        this.infoIndex = infoIndex == null ? null : infoIndex.trim();
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName == null ? null : statusName.trim();
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}