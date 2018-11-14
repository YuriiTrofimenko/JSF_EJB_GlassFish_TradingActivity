/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.tradingactivity.bean;

import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Yurii
 */
@ManagedBean(name="locale_changer", eager=true)
@ApplicationScoped
public class LocaleChangerManagedBean {
    private Locale currentLocale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    public LocaleChangerManagedBean() {}
    public void changeLocale(String localeCode) {
        currentLocale = new Locale(localeCode);
    }
    public Locale getCurrentLocale() {
        return currentLocale;
    }
}
