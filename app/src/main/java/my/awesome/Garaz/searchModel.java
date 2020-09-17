package my.awesome.Garaz;

public class searchModel {
    int Image;
    String text;



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

    public searchModel(int image, String text) {

        this.Image = image;
        this.text = text;
    }


}
