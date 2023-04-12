package veikko.vanninen.grocerylist;

public class Grocery {
    private String name;
    private String note;
    private long creationTime;

    public Grocery (String name, String note) {
        this.name = name;
        this.note = note;
        this.creationTime = System.currentTimeMillis();
    }

    public String getName() {
        return name;
    }

    public String getNote() {
        return note;
    }

    public long getCreation() {
        return creationTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
