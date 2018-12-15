package dropmusic.auxfunc;

public class stringFilter {

    public static String filter(String toFilter) {

        System.out.println(toFilter);

        if(toFilter.contains("<")) {
            toFilter = toFilter.replaceAll("<", "&#8249");
        }

        if(toFilter.contains(">")) {
            toFilter = toFilter.replaceAll(">", "&#8250");
        }

        if(toFilter.contains("\"")) {
            toFilter = toFilter.replaceAll("\"", "&#34");
        }

        if(toFilter.contains("/")) {
            toFilter = toFilter.replaceAll("/", "&#47");
        }

        if(toFilter.contains("%")) {
            toFilter = toFilter.replaceAll("%", "&#35");
        }

        if(toFilter.contains("'")) {
            toFilter = toFilter.replaceAll("'", "&#39");
        }

        if(toFilter.contains("(")) {
            toFilter = toFilter.replaceAll("(", "&#40");
        }

        if(toFilter.contains(")")) {
            toFilter = toFilter.replaceAll(")", "&#41");
        }

        if(toFilter.contains("*")) {
            toFilter = toFilter.replaceAll("*", "&#42");
        }

        if(toFilter.contains(";")) {
            toFilter = toFilter.replaceAll(";", "&#59");
        }

        if(toFilter.contains("|")) {
            toFilter = toFilter.replaceAll("|", "&#124");
        }

        if(toFilter.contains("_")) {
            toFilter = toFilter.replaceAll("_", "&#95");
        }

        System.out.println(toFilter);

        return toFilter;
    }

    public static String filterReverse(String toFilter) {

        System.out.println(toFilter);

        if(toFilter.contains("&#8249")) {
            toFilter = toFilter.replaceAll("&#8249", "<");
        }

        if(toFilter.contains("&#8250")) {
            toFilter = toFilter.replaceAll("&#8250", ">");
        }

        if(toFilter.contains("&#34")) {
            toFilter = toFilter.replaceAll("&#34", "\"");
        }

        if(toFilter.contains("&#47")) {
            toFilter = toFilter.replaceAll("&#47", "/");
        }

        if(toFilter.contains("&#35\"")) {
            toFilter = toFilter.replaceAll("&#35\"", "%");
        }

        if(toFilter.contains("&#39")) {
            toFilter = toFilter.replaceAll("&#39", "'");
        }

        if(toFilter.contains("&#40")) {
            toFilter = toFilter.replaceAll("&#40", "(");
        }

        if(toFilter.contains("&#41")) {
            toFilter = toFilter.replaceAll("&#41", ")");
        }

        if(toFilter.contains("&#42")) {
            toFilter = toFilter.replaceAll("&#42", "*");
        }

        if(toFilter.contains("&#59")) {
            toFilter = toFilter.replaceAll("&#59", ";");
        }

        if(toFilter.contains("&#124")) {
            toFilter = toFilter.replaceAll("&#124", "|");
        }

        if(toFilter.contains("&#95")) {
            toFilter = toFilter.replaceAll("&#95", "_");
        }

        System.out.println(toFilter);

        return toFilter;
    }
}
