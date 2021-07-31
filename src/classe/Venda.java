package classe;

public class Venda{
    String datv;
    String prodv;
    String quantv;
    Double valu,valt;
    int qtvendi;
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
    public Double getValu() {
        return valu;
    }
    public void setValu(Double valu) {
        this.valu = valu;
    }
    public Double getValt() {
        return valt;
    }
    public void setValt(Double valt) {
        this.valt = valt;
    }    
    public int getQtvendi() {
        return qtvendi;
    }
    public void setQtvendi(int qtvendi) {
        this.qtvendi = qtvendi;
    }
    @Override
    public String toString() {
        return "Venda [datv=" + datv + ", prodv=" + prodv + ", quantv=" + quantv + "]";
    }
}
