package Interface;

import java.awt.Graphics;

/**
 *
 * @author TLiem
 */
public interface Card {
    public int tancong();
    public void phongthu(Card dame);
    public void HieuUngTruocTran();
    public void HieuUngSauTran();
    public void HieuUngGiuaTran();
    public int getsao();
    public int gethp();
    public int getat();
    public int getdf();
    public void sethp(int heat);
    public void setat(int m);
    public void setdf(int m);
}
