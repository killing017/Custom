package my.awesome.Garaz;

public class searchModel {
    int Image;
    String text;
    String sch_service_id;
    String service_id;
    String price;
    String img;

    public searchModel(int image, String text, String sch_service_id, String service_id, String price, String img) {
        Image = image;
        this.text = text;
        this.sch_service_id = sch_service_id;
        this.service_id = service_id;
        this.price = price;
        this.img = img;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        this.Image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSch_service_id() {
        return sch_service_id;
    }

    public void setSch_service_id(String sch_service_id) {
        this.sch_service_id = sch_service_id;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    //    public searchModel(int image, String text) {
//
//        this.Image = image;
//        this.text = text;
//    }


}
