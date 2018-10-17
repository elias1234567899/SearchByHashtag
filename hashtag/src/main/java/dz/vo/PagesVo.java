/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.vo;

import dz.hashtag.models.Poste;
import io.reactivex.Flowable;
import java.util.List;

/**
 *
 * @author abbasturki.elias
 */
public class PagesVo {

    private int pageCurrant;
    private int nbrPage;
    private Flowable<Poste> listes;

    public PagesVo() {
    }

    public PagesVo(int pageCurrant, int nbrPage, Flowable<Poste> listes) {
        this.pageCurrant = pageCurrant;
        this.nbrPage = nbrPage;
        this.listes = listes;
    }

    public int getPageCurrant() {
        return pageCurrant;
    }

    public void setPageCurrant(int pageCurrant) {
        this.pageCurrant = pageCurrant;
    }

    public int getNbrPage() {
        return nbrPage;
    }

    public void setNbrPage(int nbrPage) {
        this.nbrPage = nbrPage;
    }

    public Flowable<Poste> getListes() {
        return listes;
    }

    public void setListes(Flowable<Poste> listes) {
        this.listes = listes;
    }

}
