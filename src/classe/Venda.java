package classe;

public class Venda{
    String datv;
    String prodv;
    String quantv;
    int valu,valt;

    public String getDatv() {
        return datv;
    }
    public void setDatv(String datv) {
        this.datv = datv;
    }
    public String getProdv() {
        return prodv;
    }
    public void setProdv(String prodv) {
        this.prodv = prodv;
    }
    public String getQuantv() {
        return quantv;
    }
    public void setQuantv(String quantv) {
        this.quantv = quantv;
    }
    public Venda(String datv, String prodv, String quantv) {

        this.datv = datv;
        this.prodv = prodv;
        this.quantv = quantv;
    }    
    public int getValu() {
        return valu;
    }
    public void setValu(int valu) {
        this.valu = valu;
    }
    public int getValt() {
        return valt;
    }
    public void setValt(int valt) {
        this.valt = valt;
    }
    @Override
    public String toString() {
        return "Venda [datv=" + datv + ", prodv=" + prodv + ", quantv=" + quantv + "]";
    }
}
