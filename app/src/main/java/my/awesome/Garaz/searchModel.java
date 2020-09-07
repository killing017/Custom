package my.awesome.Garaz;

public class searchModel {
    int pic;
    String text;



    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public searchModel(int pic, String text) {

        this.pic = pic;
        this.text = text;
    }


}
