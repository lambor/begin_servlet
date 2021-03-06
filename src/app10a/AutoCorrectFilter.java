package app10a;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.*;

/**
 * Created by lambor on 17-5-10.
 * 将parameter中的多个连续空格简略为一个
 */

@WebFilter(
        filterName = "AutoCorrectFilter",
        urlPatterns = {"/*"}
        , asyncSupported = true
)
public class AutoCorrectFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AutoCorrectFilter inited.");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("AutoCorrectFilter doFilter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        AutoCorrectHttpServletRequestWrapper wrapper = new AutoCorrectHttpServletRequestWrapper(httpServletRequest);
        filterChain.doFilter(wrapper,servletResponse);
    }

    @Override
    public void destroy() {

    }

    class AutoCorrectHttpServletRequestWrapper extends HttpServletRequestWrapper {

        private HttpServletRequest httpServletRequest;

        public AutoCorrectHttpServletRequestWrapper(HttpServletRequest request) {
            super(request);
            this.httpServletRequest = request;
        }

        @Override
        public String getParameter(String name) {
            return autoCorrect(httpServletRequest.getParameter(name));
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            final Map<String,String[]> parameterMap = httpServletRequest.getParameterMap();

            Map<String,String[]> newMap = new Map<String, String[]>() {
                @Override
                public int size() {
                    return parameterMap.size();
                }

                @Override
                public boolean isEmpty() {
                    return parameterMap.isEmpty();
                }

                @Override
                public boolean containsKey(Object key) {
                    return parameterMap.containsKey(key);
                }

                @Override
                public boolean containsValue(Object value) {
                    return parameterMap.containsValue(value);
                }

                @Override
                public String[] get(Object key) {
                    return autoCorrect(parameterMap.get(key));
                }

                @Override
                public String[] put(String key, String[] value) {
                    return parameterMap.put(key,value);
                }

                @Override
                public String[] remove(Object key) {
                    return parameterMap.remove(key);
                }

                @Override
                public void putAll(Map<? extends String, ? extends String[]> m) {
                    parameterMap.putAll(m);
                }

                @Override
                public void clear() {
                    parameterMap.clear();
                }

                @Override
                public Set<String> keySet() {
                    return parameterMap.keySet();
                }

                @Override
                public Collection<String[]> values() {
                    return autoCorrect(parameterMap.values());
                }

                @Override
                public Set<Entry<String, String[]>> entrySet() {
                    return autoCorrect(parameterMap.entrySet());
                }
            };
            return newMap;
        }

        @Override
        public String[] getParameterValues(String name) {
            return autoCorrect(httpServletRequest.getParameterValues(name));
        }
    }

    private String autoCorrect(String value) {
        if(value == null) {
            return null;
        }

        value = value.trim();
        int length = value.length();
        StringBuilder temp = new StringBuilder();
        boolean lastCharWasSpace = false;
        for(int i=0;i<length;i++) {
            if(value.charAt(i) == ' '){
                if(!lastCharWasSpace)
                    temp.append(value.charAt(i));
                lastCharWasSpace = true;
            } else {
                temp.append(value.charAt(i));
                lastCharWasSpace = false;
            }
        }
        return temp.toString();
    }

    private String[] autoCorrect(String[] values) {
        if(values != null) {
            for(int i=0;i<values.length;i++) {
                values[i] = autoCorrect(values[i]);
            }
        }
        return values;
    }

    private Collection<String[]> autoCorrect(Collection<String[]> valueses) {
        Collection<String[]> newValues = new ArrayList<>();
        if(valueses != null) {
            for(String[] values:valueses) {
                newValues.add(autoCorrect(values));
            }
        }
        return newValues;
    }

    private Set<Map.Entry<String,String[]>> autoCorrect(Set<Map.Entry<String,String[]>> entrySet) {
        Set<Map.Entry<String,String[]>> newSet = new HashSet<>();
        for(final Map.Entry<String,String[]> entry:entrySet) {
            Map.Entry<String,String[]> newEntry = new Map.Entry<String, String[]>() {
                @Override
                public String getKey() {
                    return entry.getKey();
                }

                @Override
                public String[] getValue() {
                    return autoCorrect(entry.getValue());
                }

                @Override
                public String[] setValue(String[] value) {
                    return entry.setValue(value);
                }

                @Override
                public boolean equals(Object o) {
                    return entry.equals(o);
                }

                @Override
                public int hashCode() {
                    return entry.hashCode();
                }
            };
            newSet.add(newEntry);
        }
        return newSet;
    }
}
