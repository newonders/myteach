package cn.cssf.chapter5;

public class User {
    private int imageId;
    private String avatarURL;
    private String jobTitle;
    private String shortPhone;
    private String userName;
    private String workId;
    private String userNamePY;
    private String mobilePhone;
    private String departNameHeadPY;
    private String department;
    private String fixPhone;
    private String info;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getShortPhone() {
        return shortPhone;
    }

    public void setShortPhone(String shortPhone) {
        this.shortPhone = shortPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getUserNamePY() {
        return userNamePY;
    }

    public void setUserNamePY(String userNamePY) {
        this.userNamePY = userNamePY;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getDepartNameHeadPY() {
        return departNameHeadPY;
    }

    public void setDepartNameHeadPY(String departNameHeadPY) {
        this.departNameHeadPY = departNameHeadPY;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFixPhone() {
        return fixPhone;
    }

    public void setFixPhone(String fixPhone) {
        this.fixPhone = fixPhone;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "User{" +
                "imageId=" + imageId +
                ", avatarURL='" + avatarURL + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", shortPhone='" + shortPhone + '\'' +
                ", userName='" + userName + '\'' +
                ", workId='" + workId + '\'' +
                ", userNamePY='" + userNamePY + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", departNameHeadPY='" + departNameHeadPY + '\'' +
                ", department='" + department + '\'' +
                ", fixPhone='" + fixPhone + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
