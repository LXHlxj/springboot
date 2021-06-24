package org.xmldata.mode;

public class XmlDataSource {
  private String url;
  private String username="root";
  private String password;
  private String DriverClassName="com.mysql.jdbc.Driver";
  private String maxlink;
  private String dtattype;
  private String lina;

    public String getLina() {
        return lina;
    }

    public void setLina(String lina) {
        this.lina = lina;
    }

    public String getDtattype() {
        return dtattype;
    }

    public void setDtattype(String dtattype) {
        this.dtattype = dtattype;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return DriverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        DriverClassName = driverClassName;
    }

    public String getMaxlink() {
        return maxlink;
    }

    public void setMaxlink(String maxlink) {
        this.maxlink = maxlink;
    }

    @Override
    public String toString() {
        return "XmlDataSource{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", DriverClassName='" + DriverClassName + '\'' +
                ", maxlink='" + maxlink + '\'' +
                ", dtattype='" + dtattype + '\'' +
                '}';
    }
}
