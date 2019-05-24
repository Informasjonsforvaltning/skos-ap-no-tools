package no.difi.skos_ap_no.concept;

import java.util.Date;


public class Definition {

    private LanguageLiteral text;
    private LanguageLiteral scopeNote;
    private Source source;
    private LanguageLiteral audience;
    private Date modified;


    public LanguageLiteral getText() {
        return text;
    }

    public void setText(final LanguageLiteral text) {
        this.text = text;
    }

    public LanguageLiteral getScopeNote() {
        return scopeNote;
    }

    public void setScopeNote(final LanguageLiteral scopeNote) {
        this.scopeNote = scopeNote;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(final Source source) {
        this.source = source;
    }

    public LanguageLiteral getAudience() {
        return audience;
    }

    public void setAudience(final LanguageLiteral audience) {
        this.audience = audience;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(final Date modified) {
        this.modified = modified;
    }

}
