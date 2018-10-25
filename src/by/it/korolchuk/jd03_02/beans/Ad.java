package by.it.korolchuk.jd03_02.beans;

public class Ad {

    private long id;
    private String description;
    private String kindOfAnimal;
    private String greed;
    private String sex;
    private long age;
    private long height;
    private String qalities;
    private long usersId;

    public Ad() {
    }

    public Ad(long id, String description, String kindOfAnimal, String greed,
              String sex, long age, long height, String qalities, long usersId) {
        this.id = id;
        this.description = description;
        this.kindOfAnimal = kindOfAnimal;
        this.greed = greed;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.qalities = qalities;
        this.usersId = usersId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKindOfAnimal() {
        return kindOfAnimal;
    }

    public void setKindOfAnimal(String kindOfAnimal) {
        this.kindOfAnimal = kindOfAnimal;
    }

    public String getGreed() {
        return greed;
    }

    public void setGreed(String greed) {
        this.greed = greed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public String getQalities() {
        return qalities;
    }

    public void setQalities(String qalities) {
        this.qalities = qalities;
    }

    public long getUsersId() {
        return usersId;
    }

    public void setUsersId(long usersId) {
        this.usersId = usersId;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", kindOfAnimal='" + kindOfAnimal + '\'' +
                ", greed='" + greed + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", qalities='" + qalities + '\'' +
                ", usersId=" + usersId +
                '}';
    }
}
