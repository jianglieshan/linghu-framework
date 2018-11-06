package linghu.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Area {
    @Id
    private String code;

    private String name;

    private String firstLetter;

    private Boolean isCityBlock;

    private String fullName;

    private String baiduFullName;

    private String baiduName;

    private String cityLevel;

    private BigDecimal longitude;

    private BigDecimal latitude;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter == null ? null : firstLetter.trim();
    }

    public Boolean getIsCityBlock() {
        return isCityBlock;
    }

    public void setIsCityBlock(Boolean isCityBlock) {
        this.isCityBlock = isCityBlock;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public String getBaiduFullName() {
        return baiduFullName;
    }

    public void setBaiduFullName(String baiduFullName) {
        this.baiduFullName = baiduFullName == null ? null : baiduFullName.trim();
    }

    public String getBaiduName() {
        return baiduName;
    }

    public void setBaiduName(String baiduName) {
        this.baiduName = baiduName == null ? null : baiduName.trim();
    }

    public String getCityLevel() {
        return cityLevel;
    }

    public void setCityLevel(String cityLevel) {
        this.cityLevel = cityLevel == null ? null : cityLevel.trim();
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }
}
