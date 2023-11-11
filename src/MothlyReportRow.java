public class MothlyReportRow {
    String itemName;
    int quantity;
    int unitPrice;
    int price;

    public MothlyReportRow() {
        this.itemName = "unknown";
    }
    public void setFields(String[] fields) {
        this.itemName = fields[0];
        this.quantity = Integer.parseInt(fields[2]);
        this.unitPrice = Integer.parseInt(fields[3]);
        this.price = this.quantity * this.unitPrice;
    }
}
