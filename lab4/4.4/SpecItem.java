/**
 *
 * @author khoin
 */
public class SpecItem extends Item {

    private int color;

    public SpecItem() {
    }

    public SpecItem(int color) {
        this.color = color;
    }

    public SpecItem(int color, String code, int price) {
        super(code, price);
        this.color = color;
    }

    public void setData() {
        String insertString = "-ABC-";
        int position = 2;
        StringBuffer sb = new StringBuffer(this.getCode());
        sb.insert(position, insertString);
        String newString = sb.toString();

        setCode(newString);
    }

    public int getValue() {
        if (color > 5)return getPrice() - 5;
        else return getPrice() - 3;
       
    }

    public void outputSpecItem() {
        System.out.printf("%s, %d\n%s, %d, %d\n", getCode(), getPrice(), getCode(), getPrice(), color);
    }

}
