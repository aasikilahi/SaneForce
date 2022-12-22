package com.example.saneforceapplication.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListDataResponse {
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("DOB")
    @Expose
    private String dob;
    @SerializedName("DOW")
    @Expose
    private String dow;
    @SerializedName("Town_Code")
    @Expose
    private String townCode;
    @SerializedName("Town_Name")
    @Expose
    private String townName;
    @SerializedName("Category")
    @Expose
    private String category;
    @SerializedName("Specialty")
    @Expose
    private String specialty;
    @SerializedName("CategoryCode")
    @Expose
    private String categoryCode;
    @SerializedName("SpecialtyCode")
    @Expose
    private String specialtyCode;
    @SerializedName("SF_Code")
    @Expose
    private String sFCode;
    @SerializedName("Lat")
    @Expose
    private String lat;
    @SerializedName("Long")
    @Expose
    private String _long;
    @SerializedName("Addrs")
    @Expose
    private String addrs;
    @SerializedName("DrDesig")
    @Expose
    private String drDesig;
    @SerializedName("DrEmail")
    @Expose
    private String drEmail;
    @SerializedName("Mobile")
    @Expose
    private String mobile;
    @SerializedName("Phone")
    @Expose
    private String phone;
    @SerializedName("HosAddr")
    @Expose
    private String hosAddr;
    @SerializedName("ResAddr")
    @Expose
    private String resAddr;
    @SerializedName("MappProds")
    @Expose
    private String mappProds;
    @SerializedName("hospital_code")
    @Expose
    private String hospitalCode;
    @SerializedName("HospCodes")
    @Expose
    private String hospCodes;
    @SerializedName("hospital_name")
    @Expose
    private String hospitalName;
    @SerializedName("PlcyAcptFl")
    @Expose
    private int plcyAcptFl;
    @SerializedName("MaxGeoMap")
    @Expose
    private String maxGeoMap;
    @SerializedName("GEOTagCnt")
    @Expose
    private int gEOTagCnt;
    @SerializedName("uRwID")
    @Expose
    private String uRwID;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDow() {
        return dow;
    }

    public void setDow(String dow) {
        this.dow = dow;
    }

    public String getTownCode() {
        return townCode;
    }

    public void setTownCode(String townCode) {
        this.townCode = townCode;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getSpecialtyCode() {
        return specialtyCode;
    }

    public void setSpecialtyCode(String specialtyCode) {
        this.specialtyCode = specialtyCode;
    }

    public String getSFCode() {
        return sFCode;
    }

    public void setSFCode(String sFCode) {
        this.sFCode = sFCode;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLong() {
        return _long;
    }

    public void setLong(String _long) {
        this._long = _long;
    }

    public String getAddrs() {
        return addrs;
    }

    public void setAddrs(String addrs) {
        this.addrs = addrs;
    }

    public String getDrDesig() {
        return drDesig;
    }

    public void setDrDesig(String drDesig) {
        this.drDesig = drDesig;
    }

    public String getDrEmail() {
        return drEmail;
    }

    public void setDrEmail(String drEmail) {
        this.drEmail = drEmail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHosAddr() {
        return hosAddr;
    }

    public void setHosAddr(String hosAddr) {
        this.hosAddr = hosAddr;
    }

    public String getResAddr() {
        return resAddr;
    }

    public void setResAddr(String resAddr) {
        this.resAddr = resAddr;
    }

    public String getMappProds() {
        return mappProds;
    }

    public void setMappProds(String mappProds) {
        this.mappProds = mappProds;
    }

    public String getHospitalCode() {
        return hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

    public String getHospCodes() {
        return hospCodes;
    }

    public void setHospCodes(String hospCodes) {
        this.hospCodes = hospCodes;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public int getPlcyAcptFl() {
        return plcyAcptFl;
    }

    public void setPlcyAcptFl(int plcyAcptFl) {
        this.plcyAcptFl = plcyAcptFl;
    }

    public String getMaxGeoMap() {
        return maxGeoMap;
    }

    public void setMaxGeoMap(String maxGeoMap) {
        this.maxGeoMap = maxGeoMap;
    }

    public int getGEOTagCnt() {
        return gEOTagCnt;
    }

    public void setGEOTagCnt(int gEOTagCnt) {
        this.gEOTagCnt = gEOTagCnt;
    }

    public String getuRwID() {
        return uRwID;
    }

    public void setuRwID(String uRwID) {
        this.uRwID = uRwID;
    }

}
