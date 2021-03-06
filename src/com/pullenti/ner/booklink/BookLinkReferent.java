/*
 * Copyright (c) 2013, Pullenti. All rights reserved. Non-Commercial Freeware.
 * This class is generated using the converter UniSharping (www.unisharping.ru) from Pullenti C#.NET project (www.pullenti.ru).
 * See www.pullenti.ru/downloadpage.aspx.
 */

package com.pullenti.ner.booklink;

/**
 * Ссылка на внешний литературный источник (статью, книгу и пр.)
 */
public class BookLinkReferent extends com.pullenti.ner.Referent {

    public static final String OBJ_TYPENAME = "BOOKLINK";

    public static final String ATTR_AUTHOR = "AUTHOR";

    public static final String ATTR_NAME = "NAME";

    public static final String ATTR_YEAR = "YEAR";

    public static final String ATTR_LANG = "LANG";

    public static final String ATTR_GEO = "GEO";

    public static final String ATTR_URL = "URL";

    public static final String ATTR_MISC = "MISC";

    public static final String ATTR_TYPE = "TYPE";

    public BookLinkReferent() {
        super(OBJ_TYPENAME);
        setInstanceOf(com.pullenti.ner.booklink.internal.MetaBookLink.globalMeta);
    }

    @Override
    public String toString(boolean shortVariant, com.pullenti.morph.MorphLang _lang, int lev) {
        StringBuilder res = new StringBuilder();
        Object a = this.getSlotValue(ATTR_AUTHOR);
        if (a != null) {
            for (com.pullenti.ner.Slot s : getSlots()) {
                if (com.pullenti.unisharp.Utils.stringsEq(s.getTypeName(), ATTR_AUTHOR)) {
                    if (a != s.getValue()) 
                        res.append(", ");
                    if (s.getValue() instanceof com.pullenti.ner.Referent) 
                        res.append((((com.pullenti.ner.Referent)com.pullenti.unisharp.Utils.cast(s.getValue(), com.pullenti.ner.Referent.class))).toString(true, _lang, lev + 1));
                    else if (s.getValue() instanceof String) 
                        res.append((String)com.pullenti.unisharp.Utils.cast(s.getValue(), String.class));
                }
            }
            if (getAuthorsAndOther()) 
                res.append(" и др.");
        }
        String nam = getName();
        if (nam != null) {
            if (res.length() > 0) 
                res.append(' ');
            if (nam.length() > 200) 
                nam = nam.substring(0, 0 + 200) + "...";
            res.append("\"").append(nam).append("\"");
        }
        com.pullenti.ner.uri.UriReferent uri = (com.pullenti.ner.uri.UriReferent)com.pullenti.unisharp.Utils.cast(this.getSlotValue(ATTR_URL), com.pullenti.ner.uri.UriReferent.class);
        if (uri != null) 
            res.append(" [").append(uri.toString()).append("]");
        if (getYear() > 0) 
            res.append(", ").append(this.getYear());
        return res.toString();
    }

    public String getName() {
        return this.getStringValue(ATTR_NAME);
    }

    public String setName(String value) {
        this.addSlot(ATTR_NAME, value, true, 0);
        return value;
    }


    public String getLang() {
        return this.getStringValue(ATTR_LANG);
    }

    public String setLang(String value) {
        this.addSlot(ATTR_LANG, value, true, 0);
        return value;
    }


    public String getTyp() {
        return this.getStringValue(ATTR_TYPE);
    }

    public String setTyp(String value) {
        this.addSlot(ATTR_TYPE, value, true, 0);
        return value;
    }


    public com.pullenti.ner.uri.UriReferent getUrl() {
        return (com.pullenti.ner.uri.UriReferent)com.pullenti.unisharp.Utils.cast(this.getSlotValue(ATTR_URL), com.pullenti.ner.uri.UriReferent.class);
    }


    public int getYear() {
        int _year;
        com.pullenti.unisharp.Outargwrapper<Integer> wrapyear412 = new com.pullenti.unisharp.Outargwrapper<Integer>();
        boolean inoutres413 = com.pullenti.unisharp.Utils.parseInteger((String)com.pullenti.unisharp.Utils.notnull(this.getStringValue(ATTR_YEAR), ""), 0, null, wrapyear412);
        _year = (wrapyear412.value != null ? wrapyear412.value : 0);
        if (inoutres413) 
            return _year;
        else 
            return 0;
    }

    public int setYear(int value) {
        this.addSlot(ATTR_YEAR, ((Integer)value).toString(), true, 0);
        return value;
    }


    public boolean getAuthorsAndOther() {
        return this.findSlot(ATTR_MISC, "и др.", true) != null;
    }

    public boolean setAuthorsAndOther(boolean value) {
        this.addSlot(ATTR_MISC, "и др.", false, 0);
        return value;
    }


    @Override
    public boolean canBeEquals(com.pullenti.ner.Referent obj, com.pullenti.ner.Referent.EqualType _typ) {
        BookLinkReferent br = (BookLinkReferent)com.pullenti.unisharp.Utils.cast(obj, BookLinkReferent.class);
        if (br == null) 
            return false;
        int eq = 0;
        if (getYear() > 0 && br.getYear() > 0) {
            if (getYear() == br.getYear()) 
                eq++;
            else 
                return false;
        }
        if (getTyp() != null && br.getTyp() != null) {
            if (com.pullenti.unisharp.Utils.stringsNe(getTyp(), br.getTyp())) 
                return false;
        }
        boolean eqAuth = false;
        if (this.findSlot(ATTR_AUTHOR, null, true) != null && br.findSlot(ATTR_AUTHOR, null, true) != null) {
            boolean ok = false;
            for (com.pullenti.ner.Slot a : getSlots()) {
                if (com.pullenti.unisharp.Utils.stringsEq(a.getTypeName(), ATTR_AUTHOR)) {
                    if (br.findSlot(ATTR_AUTHOR, a.getValue(), true) != null) {
                        eq++;
                        ok = true;
                        eqAuth = true;
                    }
                }
            }
            if (!ok) 
                return false;
        }
        if (com.pullenti.unisharp.Utils.stringsNe(br.getName(), getName())) {
            if (getName() == null || br.getName() == null) 
                return false;
            if (getName().startsWith(br.getName()) || br.getName().startsWith(this.getName())) 
                eq += 1;
            else if (eqAuth && com.pullenti.ner.core.MiscHelper.canBeEquals(this.getName(), br.getName(), false, true, false)) 
                eq += 1;
            else 
                return false;
        }
        else 
            eq += 2;
        return eq > 2;
    }
}
