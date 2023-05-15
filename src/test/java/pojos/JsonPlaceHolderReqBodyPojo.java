package pojos;

public class JsonPlaceHolderReqBodyPojo {
    //1-Tum key degerlerini class level da aldiklari
    // data turune gore private variable olarak olusturalim
    private String title;
    private String body;
    private int userId;
    private int id;
    //2-Tum variabellar icin getter sette olustur


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
//3-Parametreli constructor olustur
    public JsonPlaceHolderReqBodyPojo(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }
//4-Parametresiz constructor olustur
    public JsonPlaceHolderReqBodyPojo() {
    }
    //5-To String methodunu olustur

    @Override
    public String toString() {
        return "JsonPlaceHolderReqBodyPojo{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
