package com.example.demobds.realm.object;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by hoanghiep on 7/26/17.
 */

public class ROAptItem extends RealmObject {
    @PrimaryKey
    private int itemId;
    private String sectionType;
    private String itemImage;
    private int viewType;
    private int agentId;
    private String regDate;
    private String type;
    private String grossAreaName;
    private String grossArea;
    private String netArea;
    private String agentUserName;
    private String agentName;
    private String agentTel;
    private String agentPhone;
    private String title;
    private String floor;
    private int sales;
    private int deposit;
    private int rent;
    private String aptName;
    private String dong;
    private boolean isNew;
    private int aptId;
    private int contactType;
    private int createAt;
    private int updateAt;
    private boolean isZzim;
    private boolean rewardStatus;
    private boolean reportStatus;
    private boolean soldStatus;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getSectionType() {
        return sectionType;
    }

    public void setSectionType(String sectionType) {
        this.sectionType = sectionType;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGrossAreaName() {
        return grossAreaName;
    }

    public void setGrossAreaName(String grossAreaName) {
        this.grossAreaName = grossAreaName;
    }

    public String getGrossArea() {
        return grossArea;
    }

    public void setGrossArea(String grossArea) {
        this.grossArea = grossArea;
    }

    public String getNetArea() {
        return netArea;
    }

    public void setNetArea(String netArea) {
        this.netArea = netArea;
    }

    public String getAgentUserName() {
        return agentUserName;
    }

    public void setAgentUserName(String agentUserName) {
        this.agentUserName = agentUserName;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentTel() {
        return agentTel;
    }

    public void setAgentTel(String agentTel) {
        this.agentTel = agentTel;
    }

    public String getAgentPhone() {
        return agentPhone;
    }

    public void setAgentPhone(String agentPhone) {
        this.agentPhone = agentPhone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getAptName() {
        return aptName;
    }

    public void setAptName(String aptName) {
        this.aptName = aptName;
    }

    public String getDong() {
        return dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public int getAptId() {
        return aptId;
    }

    public void setAptId(int aptId) {
        this.aptId = aptId;
    }

    public int getContactType() {
        return contactType;
    }

    public void setContactType(int contactType) {
        this.contactType = contactType;
    }

    public int getCreateAt() {
        return createAt;
    }

    public void setCreateAt(int createAt) {
        this.createAt = createAt;
    }

    public int getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(int updateAt) {
        this.updateAt = updateAt;
    }

    public boolean isZzim() {
        return isZzim;
    }

    public void setZzim(boolean zzim) {
        isZzim = zzim;
    }

    public boolean isRewardStatus() {
        return rewardStatus;
    }

    public void setRewardStatus(boolean rewardStatus) {
        this.rewardStatus = rewardStatus;
    }

    public boolean isReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(boolean reportStatus) {
        this.reportStatus = reportStatus;
    }

    public boolean isSoldStatus() {
        return soldStatus;
    }

    public void setSoldStatus(boolean soldStatus) {
        this.soldStatus = soldStatus;
    }
}
