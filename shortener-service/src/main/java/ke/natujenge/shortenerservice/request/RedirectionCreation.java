package ke.natujenge.shortenerservice.request;

import com.sun.istack.NotNull;

public class RedirectionCreation {
    @NotNull
    private String redirect;
    @NotNull
    private String url;

    public RedirectionCreation(final String redirect, final String url) {
        this.redirect = redirect;
        this.url = url;
    }

    public String getRedirect() {
        return redirect;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "RedirectionCreation{" +
                "redirect='" + redirect + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
